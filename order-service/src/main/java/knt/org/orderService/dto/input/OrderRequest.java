package knt.org.orderService.dto.input;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderRequest (
    @NotNull String cpfClient,
    @NotNull String showName,
    @Positive @NotNull Integer quantity,
    @Positive @NotNull Double price){ }
