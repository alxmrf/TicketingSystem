package knt.org.orderService.dto.input;

import java.time.Instant;

public record ErrorResponse(
        String type,
        String message,
        int status,
        Instant timestamp
) {
}
