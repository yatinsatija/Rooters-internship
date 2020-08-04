package com.app.rooters.db.model.converter;

import com.app.rooters.db.model.user.RootersRole;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Converter
public class RootersRoleEnumConverter implements AttributeConverter<Set<Enum>, String> {

    @Override
    public String convertToDatabaseColumn(Set<Enum> enums) {
        return String.join(",", enums.stream().map(Enum::toString).collect(Collectors.toList()));
    }

    @Override
    public Set<Enum> convertToEntityAttribute(String strs) {
        return Strings.isNotEmpty(strs)
                ? Arrays.stream(strs.split(",")).map(RootersRole::valueOf)
                .collect(Collectors.toSet()) : Collections.EMPTY_SET;
    }
}
