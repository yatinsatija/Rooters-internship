package com.app.rooters.db.model.bus;

import lombok.Getter;
import lombok.experimental.Accessors;

public enum BusType {

    AC_TWO_PLUS_TWO("AC", "2+2"),

    AC_TWO_PLUS_ONE("AC", "2+1"),

    NON_AC_TWO_PLUS_TWO("Non-AC", "2+2"),

    NON_AC_TWO_PLUS_ONE("Non-AC", "2+1");


    @Getter
    @Accessors(fluent = true)
    private String seatDetail;

    @Getter
    @Accessors(fluent = true)
    private String type;

    BusType(String type, String busType) {
        this.seatDetail = busType;
        this.type = type;
    }
}
