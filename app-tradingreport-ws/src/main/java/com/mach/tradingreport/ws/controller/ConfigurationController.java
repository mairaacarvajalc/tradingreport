package com.mach.tradingreport.ws.controller;


import com.mach.tradingreport.api.dto.BinnacleConfigurationDto;
import com.mach.tradingreport.api.enums.TypeConfigurationEnum;
import com.mach.tradingreport.api.service.BinnacleConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

    private BinnacleConfigurationService binnacleConfigurationService;

    @Autowired
    public ConfigurationController(BinnacleConfigurationService binnacleConfigurationService) {
        this.binnacleConfigurationService = binnacleConfigurationService;
    }

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<BinnacleConfigurationDto>> findConfiguration(@RequestParam("type") String type){
        TypeConfigurationEnum typeEnum = TypeConfigurationEnum.of(type);
        return new ResponseEntity<>(this.binnacleConfigurationService.findBinnacleConfig(typeEnum),null,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BinnacleConfigurationDto> insertConfiguration(@RequestBody BinnacleConfigurationDto binnacle){
        return new ResponseEntity<>(this.binnacleConfigurationService.insertBinnacleConfig(binnacle),null, HttpStatus.CREATED);
    }


}