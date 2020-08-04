package com.app.rooters.db.model.user;

import com.app.rooters.db.model.converter.CryptoConverter;
import com.app.rooters.db.model.user.User;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.UUID;

/**
 * Store password for the user.
 *
 * @author aadgupta
 */
@Entity
@Setter
@Getter
@Accessors(fluent = true)
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
public final class Password {

    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    @Id
    @Setter(AccessLevel.NONE)
    private UUID id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    private String hash;

    @Convert(converter = CryptoConverter.class)
    private String code;

    @NotNull
    private Instant created = Instant.now();

    private boolean expired;

}
