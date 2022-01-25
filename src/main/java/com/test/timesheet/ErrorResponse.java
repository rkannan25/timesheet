package com.test.timesheet;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ErrorResponse {

    HttpStatus httpStatus;
    List<String> details;
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

    public ErrorResponse() {

    }
    public ErrorResponse(HttpStatus httpStatus, List<String> details) {
        this.httpStatus = httpStatus;
        this.details = details;
    }
}
