package com.audience.audience.Repository;

import com.audience.audience.Entities.Audience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAudienceRepo extends CrudRepository<Audience, Integer> {
}
