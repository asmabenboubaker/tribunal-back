package com.audience.audience.Repository;

import com.audience.audience.Entities.Audience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAudienceRepo extends CrudRepository<Audience, Integer> {

    List<Audience> findAllByTribunal(int tribunal);
    List<Audience> findAllByRooms(String room);
}
