package com.audience.audience.Service;

import com.audience.audience.Entities.Audience;
import com.audience.audience.Repository.IAudienceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AudienceService implements IAudienceService{

@Autowired
    private IAudienceRepo audienceRepo;

    @Override
    public Audience addAudience(Audience audience) {
        return  audienceRepo.save(audience);
    }

    @Override
    public List<Audience> listAudiences() {
        return (List<Audience>) audienceRepo.findAll();
    }

    @Override
    public void deleteAudience(int id) {
        audienceRepo.deleteById(id);
    }

    @Override
    public List<Audience> getFilteredAppointmentsByLocation(int location) {

            return audienceRepo.findAllByTribunal(location);

    }

    @Override
    public List<Audience> getFilteredAppointmentByRoom(String room) {
        return audienceRepo.findAllByRooms(room);
    }

}
