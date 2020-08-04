package com.app.rooters.db.model.user;

import lombok.Getter;
import lombok.experimental.Accessors;

public enum RootersRole {

    SUPER_ADMIN("Super Admin"),

    ADMIN("Admin"),

    USER("User"),

    ANONYMOUS_USER("Anonymous User");

    @Getter
    @Accessors(fluent = true)
    private String text;

    RootersRole(String text) {
        this.text = text;
    }
}
