package com.app.rooters.common.web.api.user.model;

import com.app.rooters.common.web.api.common.AuditedEntityModel;
import com.app.rooters.db.model.converter.StripHtmlConverter;
import com.app.rooters.db.model.user.RootersRole;
import com.app.rooters.db.model.user.User;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Nullable;
import javax.persistence.Convert;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

/**
 * UserEditModel.
 *
 * @author aadgupta
 */
@Setter
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Accessors(fluent = true)
@NoArgsConstructor
public class UserEditModel extends AuditedEntityModel {

    @Pattern(regexp = "(?U)\\p{Print}+")
    @Convert(converter = StripHtmlConverter.class)
    @NotNull(message = "User first name cannot be empty")
    private String firstName;

    @Nullable
    @Convert(converter = StripHtmlConverter.class)
    private String lastName;

    @Email(message = "Email format is required")
    @NotNull(message = "Email cannot ne null")
    @Pattern(regexp = "(?U)\\p{Print}+")
    @Convert(converter = StripHtmlConverter.class)
    private String email;

    private boolean allowPasswordChange = false;

    private Set<RootersRole> role;

    @Convert(converter = StripHtmlConverter.class)
    private String contact;

    /**
     * Constructor.
     */
    public UserEditModel(User user) {
        super(user, user.userId());
        this.role(user.role());
        if (user.contact() != null) {
            this.contact(user.contact().toString());
        }
        this.firstName(user.firstName());
        this.lastName(user.lastName());
        this.email(user.email());
        if (user.contact() != null) {
            this.contact = user.contact().toString();
        }
    }

}
