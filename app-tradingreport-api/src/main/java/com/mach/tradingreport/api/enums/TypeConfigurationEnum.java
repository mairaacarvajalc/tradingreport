package com.mach.tradingreport.api.enums;

import java.util.Arrays;
import java.util.Objects;

public enum TypeConfigurationEnum {

    ACTION("action"),
    TYPE_TRADE("type_trade"),
    TIME("time");

    private String type;
    TypeConfigurationEnum(String type) {
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static TypeConfigurationEnum of(String value){
        return Arrays.stream(values())
                .filter(c-> Objects.equals(c.getType(),value))
                .findFirst()
                .orElse(null);
    }
}
