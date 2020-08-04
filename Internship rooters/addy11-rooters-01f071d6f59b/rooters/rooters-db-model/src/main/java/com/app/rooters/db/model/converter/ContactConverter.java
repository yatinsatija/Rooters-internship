package com.app.rooters.db.model.converter;

import com.app.rooters.db.model.user.Contact;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ContactConverter implements AttributeConverter<Contact, String> {

    @Override
    public String convertToDatabaseColumn(Contact contact) {
        return contact != null ? contact.toString() : null;
    }

    @Override
    public Contact convertToEntityAttribute(String contact) {
        return Contact.fromString(contact);
    }
}
