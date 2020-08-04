package com.app.rooters.db.model.user;

import com.app.rooters.db.model.converter.ContactConverter;
import com.app.rooters.db.model.converter.CryptoConverter;
import com.app.rooters.db.model.converter.RootersRoleEnumConverter;
import com.app.rooters.db.model.converter.StripHtmlConverter;
import com.app.rooters.db.model.misc.audit.AuditedEntity;
import com.google.common.base.MoreObjects;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.GenericGenerator;

import javax.annotation.Nullable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Users that are logged in.
 *
 * @author aadgupta
 */
@Entity
@Accessors(fluent = true)
@Getter
@Setter
@EqualsAndHashCode(of = {"email"}, callSuper = false)
public class User extends AuditedEntity {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @Id
    @Setter(AccessLevel.NONE)
    private UUID userId;

    @NotNull
    @Pattern(regexp = "(?U)\\p{Print}+")
    @Convert(converter = StripHtmlConverter.class)
    private String firstName;

    @NotNull
    @Pattern(regexp = "(?U)\\p{Print}+")
    @Convert(converter = StripHtmlConverter.class)
    private String lastName;

    @Email
    @NotNull(message = "Email can not be null")
    private String email;

    @NonNull
    @Enumerated(EnumType.STRING)
    private AuthType authType = AuthType.INTERNAL;

    @Nullable
    @Convert(converter = CryptoConverter.class)
    private String password;

    @NotNull
    private boolean deleted = false;

//    @Transient
//    private Address address;

    @Convert(converter = ContactConverter.class)
    private Contact contact;

    private String referralCode;

    @NotNull
    @Convert(converter = RootersRoleEnumConverter.class)
    private Set<RootersRole> role = new HashSet<>();

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Authority> authorities = new ArrayList<>();

    public String name() {
        return StringUtils.trim(StringUtils.trimToEmpty(firstName)
                + " "
                + StringUtils.trimToEmpty(lastName));
    }

    @Override
    public String toString() {

        return MoreObjects.toStringHelper(this)
                .add("userId", this.userId)
                .add("name", this.name())
                .add("authType", this.authType)
                .add("email", this.email())
                .toString();
    }

}
