package com.mach.tradingreport.model.service;

import com.mach.tradingreport.api.dto.BinnacleConfigurationDto;
import com.mach.tradingreport.api.enums.TypeConfigurationEnum;
import com.mach.tradingreport.api.service.BinnacleConfigurationService;
import com.mach.tradingreport.model.repository.collection.BinnacleConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BinnacleConfigurationServiceImpl implements BinnacleConfigurationService {

    private BinnacleConfiguration binnacleConfiguration;

    @Autowired
    public BinnacleConfigurationServiceImpl(BinnacleConfiguration binnacleConfiguration) {
        this.binnacleConfiguration = binnacleConfiguration;
    }

    public List<BinnacleConfigurationDto> findBinnacleConfig(TypeConfigurationEnum typeConfigurationEnum) {
        return this.binnacleConfiguration.find(typeConfigurationEnum.getType());
    }

    public BinnacleConfigurationDto insertBinnacleConfig(BinnacleConfigurationDto binnacle) {
        binnacle.setDateStart(LocalDateTime.now());
        binnacle.setUser("userDesTradingReport");
        this.binnacleConfiguration.insert(binnacle);
        return binnacle;
    }
}

