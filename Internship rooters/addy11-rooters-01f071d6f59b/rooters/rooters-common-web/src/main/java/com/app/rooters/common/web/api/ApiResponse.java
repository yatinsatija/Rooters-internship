package com.app.rooters.common.web.api;

import com.app.rooters.common.web.exception.ApiErrorResponse;
import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Map;

/**
 * Wrapper around ResponseEntity so that Rooters APIs can return standard OK/error responses.
 */
@Slf4j
public class ApiResponse {

    /**
     * 201 - resource/entity was created and id is returned.
     */
    public static ResponseEntity<Map> created(Object id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ImmutableMap.of("id", id));
    }

    /**
     * 200 - OK w/ no body.
     */
    public static ResponseEntity ok() {
        return ResponseEntity.ok().build();
    }

    /**
     * 200 - OK w/ body.
     */
    public static <T> ResponseEntity<T> ok(T body) {
        return ResponseEntity.ok(body);
    }

    /**
     * 403 - Forbidden.
     */
    public static ResponseEntity accessDenied() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorResponse("AccessDenied", "Access Denied"));
    }

    /**
     * 404 - Not found.
     */
    public static ResponseEntity notFound() {
        return notFound("Item Not Found");
    }

    /**
     * 404 not found with custom message.
     */
    public static ResponseEntity notFound(@NonNull String message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("NotFound", message));
    }

    /**
     * Validation failed for the request (400 bad request).
     */
    public static ResponseEntity badRequest(ErrorResponse errors) {
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * Validation failed for the request (400 bad request).
     */
    public static ResponseEntity badRequest(String errors) {
        ErrorResponse errorResponse = new ErrorResponse("BadRequest", errors);
        return ResponseEntity.badRequest().body(errorResponse);
    }

    public static ResponseEntity badRequest(ApiErrorResponse errorResponse) {
        return ResponseEntity.badRequest().body(errorResponse);
    }

    /**
     * General unknown error.  We use 400 bad request instead of 500 since infosec people don't like seeing 500s.
     */
    public static ResponseEntity genericBadRequest(Throwable throwable) {
        ErrorResponse errorResponse = new ErrorResponse("BadRequest", "Bad Request");
        log.warn("{}", errorResponse.toString(), throwable);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * General unknown error.  We use 400 bad request instead of 500 since infosec people don't like seeing 500s.
     */
    public static ResponseEntity badRequest(Throwable throwable) {
        ErrorResponse errorResponse = new ErrorResponse("BadRequest", throwable.getMessage());
        log.debug("{}", errorResponse.toString(), throwable);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

    }

    public static ResponseEntity errorRequest(String code, Collection<?> errorObject) {
        ErrorResponse errorResponse = new ErrorResponse(code, errorObject);
        return ResponseEntity.badRequest().body(errorResponse);
    }
}

