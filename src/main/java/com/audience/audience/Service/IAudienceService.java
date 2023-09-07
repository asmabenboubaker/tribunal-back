package com.audience.audience.Service;

import com.audience.audience.Entities.Audience;

import java.util.List;

public interface IAudienceService {

    Audience addAudience(Audience audience);
    List<Audience> listAudiences();
   void deleteAudience(int id);
   List<Audience> getFilteredAppointmentsByLocation(int location);
   List<Audience> getFilteredAppointmentByRoom(String room);

}
