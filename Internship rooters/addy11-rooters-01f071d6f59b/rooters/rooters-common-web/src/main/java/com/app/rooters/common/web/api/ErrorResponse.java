package com.app.rooters.common.web.api;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Errors container for API responses.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@ToString
public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    /**
     * Error code.
     */
    @Getter
    @Setter
    private String code;

    /**
     * Default user friendly (English) description of error.
     */
    @Getter @Setter
    private String message;

    @Getter @Setter
    private Collection<?> errorObject;

    /**
     * A request id that can be logged.
     */
    @Getter
    private UUID requestId = UUID.randomUUID();

    public ErrorResponse() {
        timestamp = LocalDateTime.now();
    }

    public ErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorResponse(String code, Collection<?> errorObject) {
        this.code = code;
        this.errorObject = errorObject;
    }


    /**
     * Returns true if there is a global error or any fields errors.
     */
    @JsonIgnore
    public boolean hasError() {
        return null != code || (null != fieldErrors && !fieldErrors.isEmpty());
    }

    /**
     * Optional per field errors.
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Setter(AccessLevel.NONE)
    private Map<String, List<String>> fieldErrors = null;

    /**
     * Add an error for the given field.
     */
    public synchronized ErrorResponse addFieldError(String field, String error) {
        if (null == fieldErrors) {
            fieldErrors = new HashMap<>();
        }
        List<String> errors = fieldErrors.getOrDefault(field, new ArrayList<>());
        errors.add(error);
        fieldErrors.put(field, errors);

        if (null == code) {
            code = "ValidationFailed";
            message = "Request is invalid";
        }

        return this;
    }

}
