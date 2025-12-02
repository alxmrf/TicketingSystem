package knt.org.orderService.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import knt.org.orderService.dto.input.ErrorResponse;

import java.time.Instant;

@Provider
public class InvalidOrderMapper implements ExceptionMapper<InvalidOrderException> {
    @Override
    public Response toResponse(InvalidOrderException exception) {
        // Cria o objeto JSON de erro
        ErrorResponse error = new ErrorResponse(
                "VALIDATION_ERROR",
                exception.getMessage(),
                400, // Bad Request
                Instant.now()
        );

        // Retorna a resposta HTTP com status 400 e o JSON
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(error)
                .build();
    }

}
