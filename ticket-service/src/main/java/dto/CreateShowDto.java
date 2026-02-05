package dto;
import java.util.List;

public record CreateShowDto(
        String showName,
        String venue,
        List<CreateTicketKindDto> ticketKind
) {
}
