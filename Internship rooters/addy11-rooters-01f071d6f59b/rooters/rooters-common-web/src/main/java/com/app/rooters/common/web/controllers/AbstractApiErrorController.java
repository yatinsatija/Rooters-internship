package com.app.rooters.common.web.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * An abstract base class for default Error Controller behavior.  Subclasses can override and set request mappings.
 */
@Slf4j
public class AbstractApiErrorController implements ErrorController {

    public void handleError(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setStatus(HttpStatus.OK.value());
            request.getRequestDispatcher("/index.html").forward(request, response);
        } catch (Exception e) {
            log.error("Failed to forward to index", e);
        }
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
