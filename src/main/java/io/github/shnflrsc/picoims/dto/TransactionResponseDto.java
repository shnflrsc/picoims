package io.github.shnflrsc.picoims.dto;

import java.time.Instant;
import java.util.UUID;

import io.github.shnflrsc.picoims.model.Transaction;
import io.github.shnflrsc.picoims.model.TransactionType;

public record TransactionResponseDto(
    UUID transactionId,
    UUID productId,
    UUID userId,
    TransactionType transactionType,
    int quantity,
    String note,
    Instant timestamp
    
) {
    public static TransactionResponseDto fromEntity(Transaction transaction) {
        return new TransactionResponseDto(
            transaction.getTransactionId(),
            transaction.getProduct().getProductId(),
            transaction.getUser().getUserId(),
            transaction.getTransactionType(),
            transaction.getQuantity(),
            transaction.getNote(),
            transaction.getTimestamp()
        );
    }
}
