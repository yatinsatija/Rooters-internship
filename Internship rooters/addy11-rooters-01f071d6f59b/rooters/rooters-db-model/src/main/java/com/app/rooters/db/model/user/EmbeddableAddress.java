package com.app.rooters.db.model.user;

import com.app.rooters.db.model.converter.StripHtmlConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Address stored for the users registered.
 */
@Embeddable
@Setter
@Getter
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddableAddress {

    @NotNull
    @Pattern(regexp = "(?U)\\p{Print}+")
    @Convert(converter = StripHtmlConverter.class)
    private String streetAddress;

    @NotNull
    @Pattern(regexp = "(?U)\\p{Print}+")
    @Convert(converter = StripHtmlConverter.class)
    private String state;

    @NotNull
    @Pattern(regexp = "(?U)\\p{Print}+")
    @Convert(converter = StripHtmlConverter.class)
    private String city;

    @NotNull
    @Pattern(regexp = "(?U)\\p{Print}+")
    @Convert(converter = StripHtmlConverter.class)
    private String country;

    @NotNull
    @Pattern(regexp = "(?U)\\p{Print}+")
    @Convert(converter = StripHtmlConverter.class)
    @Size(max = 6, message = "Zip code should be less than 6 characters")
    private String zipCode;

}

