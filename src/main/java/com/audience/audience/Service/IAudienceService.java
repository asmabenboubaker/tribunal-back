package com.audience.audience.Service;

import com.audience.audience.Entities.Audience;

import java.util.List;

public interface IAudienceService {

    Audience addAudience(Audience audience);
    List<Audience> listAudiences();
   void deleteAudience(int id);
}
