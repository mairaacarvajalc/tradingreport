package com.mach.tradingreport.api.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BinnacleConfigurationDto {

    private String user;

    private String typeParam;

    private String valueParam;

    private LocalDateTime dateStart;

    private LocalDateTime dateEnd;

}
