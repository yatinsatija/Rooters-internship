package com.app.rooters.common.web.api.user.model;


import com.app.rooters.common.web.api.common.model.IdNameListModel;
import com.app.rooters.db.model.user.RootersRole;
import com.app.rooters.db.model.user.User;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Accessors(fluent = true)
public class UserListModel extends IdNameListModel {

    private String firstName;

    private String lastName;

    private String email;

    private String contact;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Instant created;

    private List<RootersRole> role = new ArrayList<>();


    /**
     * Constructor.
     */
    public UserListModel(User user) {
        super(user.userId(), user.name());
        this.firstName = user.firstName();
        this.lastName = user.lastName();
        this.email = user.email();
        this.contact = user.contact() != null ? user.contact().toString() : "";
        this.created = user.created();
        this.role.addAll(user.role());
    }
}
