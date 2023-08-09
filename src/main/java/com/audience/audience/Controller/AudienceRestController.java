package com.audience.audience.Controller;

import com.audience.audience.Entities.Audience;
import com.audience.audience.Repository.IAudienceRepo;
import com.audience.audience.Service.IAudienceService;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import java.util.List;

@RestController

@RequiredArgsConstructor
@RequestMapping("/api/schedule")
public class AudienceRestController {

    @Autowired
    private final IAudienceService iAudienceService;
    @Autowired
    private IAudienceRepo iAudienceRepo;



    @RequestMapping(value="/addAudience", method= RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Audience> addAudience(@RequestBody Audience audience) {
        Audience createdAudience = iAudienceService.addAudience(audience);
        System.out.println("aaaaaaaaaaaa"+createdAudience.getEndDate());
        return new ResponseEntity<>(createdAudience, HttpStatus.CREATED);
    }
    @GetMapping("/loadData")
    public ResponseEntity<List<Audience>> loadData() {
        List<Audience> data = iAudienceService.listAudiences();
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/deleteAudience/{id}")
    public ResponseEntity<String> deleteAudience(@PathVariable int id) {
        try {
            iAudienceRepo.deleteById(id);
            return ResponseEntity.ok("Audience deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
    @PutMapping("/updateAudience/{id}")
    public ResponseEntity<Audience> updateAudience(@PathVariable int id, @RequestBody Audience updatedAudience) {
        Audience existingAudience = iAudienceRepo.findById(id).get();

        if (existingAudience == null) {
            return ResponseEntity.notFound().build();
        }
        existingAudience.setText(updatedAudience.getText());
        existingAudience.setStartDate(updatedAudience.getStartDate());
        existingAudience.setEndDate(updatedAudience.getEndDate());

        Audience updated = iAudienceService.addAudience(existingAudience);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/updateData")
    public ResponseEntity<List<Audience>> updateData(@RequestBody EditParams param) {


        try {
        if (param.getAction().equals("insert") || (param.getAction().equals("batch") && param.getAdded() != null && !param.getAdded().isEmpty())) {
            System.out.println("addeddd not empty11111");
            Audience value = (param.getAction().equals("insert")) ? param.getValue() : param.getAdded().get(0);
            // Insert new ScheduleEventData into the database
            iAudienceService.addAudience(value);
        }
        if (param.getAction().equals("update") || (param.getAction().equals("batch") && param.getChanged() != null  && !param.getChanged().isEmpty())) {
            System.out.println("update not empty222");
            Audience value = (param.getAction().equals("update")) ? param.getValue() : param.getChanged().get(0);
            System.out.println("DATA"+value);
            // Update existing ScheduleEventData in the database based on the ID
            if (iAudienceRepo.existsById(value.getIdAudience())) {
                iAudienceRepo.save(value);
            }
        }
        if (param.getAction().equals("remove") || (param.getAction().equals("batch") && param.getDeleted() != null )) {
            if (param.getAction().equals("remove")) {
                int key = Integer.parseInt(param.getKey());
                // Delete ScheduleEventData from the database based on the ID
                iAudienceRepo.deleteById(key);
            } else {
                for (Audience apps : param.getDeleted()) {
                    int key = apps.getIdAudience();
                    // Delete ScheduleEventData from the database based on the ID
                    iAudienceRepo.deleteById(key);
                }
            }
        }
        List<Audience> data = (List<Audience>) iAudienceRepo.findAll();
        return ResponseEntity.ok(data);
        } catch (Exception e) {
            e.printStackTrace(); // Add this line to print the exception details to the console

            throw e;
        }
    }


    public static class EditParams {
        private String key;
        private String action;
        private List<Audience> added;
        private List<Audience> changed;
        private List<Audience> deleted;
        private Audience value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public List<Audience> getAdded() {
            return added;
        }

        public void setAdded(List<Audience> added) {
            this.added = added;
        }

        public List<Audience> getChanged() {
            return changed;
        }

        public void setChanged(List<Audience> changed) {
            this.changed = changed;
        }

        public List<Audience> getDeleted() {
            return deleted;
        }

        public void setDeleted(List<Audience> deleted) {
            this.deleted = deleted;
        }

        public Audience getValue() {
            return value;
        }

        public void setValue(Audience value) {
            this.value = value;
        }
    }
}


