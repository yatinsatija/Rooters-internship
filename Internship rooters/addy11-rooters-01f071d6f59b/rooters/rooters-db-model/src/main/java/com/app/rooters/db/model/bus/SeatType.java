package com.app.rooters.db.model.bus;

import lombok.Getter;
import lombok.experimental.Accessors;

public enum SeatType {

    SEATER("Seater"),

    SEMI_SLEEPER("Semi-Sleeper"),

    SLEEPER("Sleeper"),

    SEATER_SLEEPER("Seater-Sleeper"),

    SLEEPER_SEMI_SLEEPER("Semi-Sleeper + Sleeper");

    @Accessors(fluent = true)
    @Getter
    private String type;

    SeatType(String type) {
        this.type = type;
    }
}
