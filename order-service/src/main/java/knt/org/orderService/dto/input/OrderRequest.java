package knt.org.orderService.dto.input;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderRequest (
    @NotNull String cpfClient,
    @NotNull String showName,
    @NotNull String ticketKind,
    @Positive @NotNull Integer ticketQuantity,
    @Positive @NotNull Double price){ }
