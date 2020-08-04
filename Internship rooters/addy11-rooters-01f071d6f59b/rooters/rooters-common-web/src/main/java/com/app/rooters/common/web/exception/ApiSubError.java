package com.app.rooters.common.web.exception;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Setter
@Getter
abstract class ApiSubError {

    private String message;

    private String debugMessage;

    private String fieldName;

}
