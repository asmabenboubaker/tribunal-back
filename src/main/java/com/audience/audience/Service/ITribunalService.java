package com.audience.audience.Service;

import com.audience.audience.Entities.Tribunal;

import java.util.List;

public interface ITribunalService {
    List<Tribunal> listTribunal();
    Tribunal addTribunal(Tribunal tribunal);
}
