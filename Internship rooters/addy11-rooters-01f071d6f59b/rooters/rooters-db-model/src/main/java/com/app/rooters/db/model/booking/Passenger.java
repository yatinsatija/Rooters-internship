package com.app.rooters.db.model.booking;

import com.app.rooters.db.model.converter.ContactConverter;
import com.app.rooters.db.model.converter.StripHtmlConverter;
import com.app.rooters.db.model.misc.audit.AuditedEntity;
import com.app.rooters.db.model.route.Route;
import com.app.rooters.db.model.user.Contact;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Entity(name = "passenger")
@Accessors(fluent = true)
@Setter
@Getter
@ToString(of = {"firstName"})
public class Passenger extends AuditedEntity {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @Id
    @Setter(AccessLevel.NONE)
    private UUID passengerId;

    @NotNull
    @Pattern(regexp = "(?U)\\p{Print}+")
    @Convert(converter = StripHtmlConverter.class)
    private String firstName;

    @Pattern(regexp = "(?U)\\p{Print}+")
    @Convert(converter = StripHtmlConverter.class)
    private String lastName;

    @Email
    @NotNull(message = "Email can not be null")
    private String email;

    @Convert(converter = ContactConverter.class)
    private Contact contact;

    @NotNull(message = "Gender can not be null")
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @ManyToOne(cascade = CascadeType.DETACH)
    @NotNull(message = "Route details can not be null")
    @JoinColumn(name = "route_id")
    private Route route;
}
