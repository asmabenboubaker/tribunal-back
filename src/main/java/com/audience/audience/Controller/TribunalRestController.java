package com.audience.audience.Controller;

import com.audience.audience.Entities.Audience;
import com.audience.audience.Entities.Tribunal;
import com.audience.audience.Service.ITribunalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequiredArgsConstructor
@RequestMapping("/api/tribunal")
public class TribunalRestController {


    private final ITribunalService iTribunalService;


    @GetMapping("/listTribunal")
    public List<Tribunal> loadData() {
       return iTribunalService.listTribunal();
    }
    @RequestMapping(value="/addTribunal", method= RequestMethod.POST)
    @ResponseBody
    public Tribunal addTribunal(@RequestBody Tribunal tribunal) {
        Tribunal createdtribunal = iTribunalService.addTribunal(tribunal);

        return createdtribunal;
    }
}
