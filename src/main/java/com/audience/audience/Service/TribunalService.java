package com.audience.audience.Service;

import com.audience.audience.Entities.Tribunal;
import com.audience.audience.Repository.ITribunalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TribunalService implements ITribunalService{
    @Autowired
    private ITribunalRepo iTribunalRepo;
    @Override
    public List<Tribunal> listTribunal() {
        return (List<Tribunal>) iTribunalRepo.findAll();
    }

    @Override
    public Tribunal addTribunal(Tribunal tribunal) {
       return iTribunalRepo.save(tribunal);
    }
}
