package com.mach.tradingreport.api.service;

import com.mach.tradingreport.api.dto.BinnacleConfigurationDto;
import com.mach.tradingreport.api.enums.TypeConfigurationEnum;

import java.util.List;

public interface BinnacleConfigurationService {

    List<BinnacleConfigurationDto> findBinnacleConfig(TypeConfigurationEnum typeConfigurationEnum);
    BinnacleConfigurationDto insertBinnacleConfig(BinnacleConfigurationDto binnacle);
}
