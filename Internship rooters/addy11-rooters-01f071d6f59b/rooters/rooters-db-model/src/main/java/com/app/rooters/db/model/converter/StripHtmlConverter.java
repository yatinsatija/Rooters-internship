package com.app.rooters.db.model.converter;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class StripHtmlConverter implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String str) {
        return strip(str);
    }

    @Override
    public String convertToEntityAttribute(String str) {
        return str;
    }


    static String strip(String raw) {
        if (StringUtils.isBlank(raw)) {
            return raw;
        }
        String stripped = Jsoup.clean(raw, Whitelist.none());
        if (StringUtils.isBlank(stripped)) {
            stripped = "invalid";
        }
        return stripped;
    }
}
