package dto;
import java.math.BigDecimal;

public record CreateTicketKindDto(
        Long showId,
        String ticketKind,
        Integer amountLeft,
        BigDecimal price
) {
}
