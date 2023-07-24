package com.audience.audience.Controller;

import com.audience.audience.Entities.Audience;
import com.audience.audience.Service.IAudienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequiredArgsConstructor
public class AudienceRestController {
    private final IAudienceService iAudienceService;

    @PostMapping("/add")
    public Audience addContrat(@RequestBody Audience audience) {
        return iAudienceService.addAudience(audience);

    }
    @GetMapping("/list")
    public List<Audience> getAllAudiences() {
        return iAudienceService.listAudiences();
    }
}

