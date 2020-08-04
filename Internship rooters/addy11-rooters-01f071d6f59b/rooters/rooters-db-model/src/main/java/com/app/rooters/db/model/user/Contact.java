package com.app.rooters.db.model.user;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.logging.log4j.util.Strings;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@Accessors(fluent = true)
@EqualsAndHashCode(of = {"value"})
public class Contact {

    private String locale = Strings.EMPTY;

    @NonNull
    private String value;

    @Override
    public String toString() {
        if (Strings.isEmpty(locale)) {
            return value;
        }
        return locale + "-" + value;
    }

    public static Contact fromString(String contact) {
        return Strings.isNotEmpty(contact) ? getFromString(contact) : null;
    }

    private static Contact getFromString(@NotNull String contact) {
        String[] num = contact.split("-");
        if (num.length == 1) {
            return new Contact().locale(Strings.EMPTY).value(num[0]);
        }
        return new Contact().locale(num[0]).value(num[1]);
    }
}
