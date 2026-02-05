package exception.handler;

import exception.TicketSoldOutException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

import java.time.Instant;
import java.util.Map;

@Provider // <--- Registers this class with Quarkus/RESTEasy
public class TicketSoldOutHandler implements ExceptionMapper<TicketSoldOutException> {

    private static final Logger LOG = Logger.getLogger(TicketSoldOutHandler.class);

    @Override
    public Response toResponse(TicketSoldOutException exception) {

        // Log it as INFO or WARN (it's a business rule, not a system crash)
        LOG.warn("Business Logic Rejection: " + exception.getMessage());

        // Return a clean JSON error response
        return Response.status(Response.Status.CONFLICT) // HTTP 409
                .entity(Map.of(
                        "error", "Ticket Sold Out",
                        "message", exception.getMessage(),
                        "timestamp", Instant.now().toString()
                ))
                .build();
    }
}