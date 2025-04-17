package com.bookstore.application.bookstore_api.exception;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {

    private Response createErrorResponse(String message, int status) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", status);
        errorResponse.put("error", Response.Status.fromStatusCode(status).getReasonPhrase());
        errorResponse.put("message", message);

        return Response.status(status)
                .entity(errorResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @Override
    public Response toResponse(Throwable exception) {
        if (exception instanceof BookNotFoundException) {
            return createErrorResponse(exception.getMessage(), Response.Status.NOT_FOUND.getStatusCode());
        } else if (exception instanceof AuthorNotFoundException) {
            return createErrorResponse(exception.getMessage(), Response.Status.NOT_FOUND.getStatusCode());
        } else if (exception instanceof CustomerNotFoundException) {
            return createErrorResponse(exception.getMessage(), Response.Status.NOT_FOUND.getStatusCode());
        } else if (exception instanceof InvalidInputException) {
            return createErrorResponse(exception.getMessage(), Response.Status.BAD_REQUEST.getStatusCode());
        } else if (exception instanceof OutOfStockException) {
            return createErrorResponse(exception.getMessage(), Response.Status.BAD_REQUEST.getStatusCode());
        } else if (exception instanceof OrderNotFoundException) {
            return createErrorResponse(exception.getMessage(), Response.Status.NOT_FOUND.getStatusCode());
        } else if (exception instanceof CartNotFoundException) {
            return createErrorResponse(exception.getMessage(), Response.Status.NOT_FOUND.getStatusCode());
        } else if (exception instanceof IllegalArgumentException) {
            return createErrorResponse(exception.getMessage(), Response.Status.BAD_REQUEST.getStatusCode());
        } else if (exception instanceof WebApplicationException) {
            return createErrorResponse("An unexpected error occurred", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        } else {
            return createErrorResponse("An unexpected error occurred", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
        }
    }
}
