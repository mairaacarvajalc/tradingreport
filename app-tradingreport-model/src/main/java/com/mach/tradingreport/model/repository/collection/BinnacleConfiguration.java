package com.mach.tradingreport.model.repository.collection;

import com.mach.tradingreport.api.dto.BinnacleConfigurationDto;

import java.util.List;

public interface BinnacleConfiguration {

    List<BinnacleConfigurationDto> find(String typeParam);

    void insert(BinnacleConfigurationDto binnacle);
}
