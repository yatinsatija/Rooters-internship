package com.app.rooters.db.model.booking;

import lombok.Getter;
import lombok.experimental.Accessors;

public enum GenderType {

    MALE ("Male"),

    FEMALE ("Female");

    @Accessors(fluent = true)
    @Getter
    private String genderType;

    GenderType(String genderType) {
        this.genderType = genderType;
    }
}
