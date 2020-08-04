package com.app.rooters.common.web.api.common.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@Accessors(fluent = true)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class IdNameListModel<T extends Serializable> {

    private T id;

    private String name;

    public IdNameListModel() {}


    public IdNameListModel(T id, String name) {
        this.id = id;
        this.name = name;
    }

}
