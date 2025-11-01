package io.github.shnflrsc.picoims.dto;

import java.time.Instant;
import java.util.UUID;

import io.github.shnflrsc.picoims.model.Product;

public record ProductResponseDto(
    UUID productId,
    String sku,
    String name,
    String description,
    double price,
    int quantity,
    Instant updatedAt,
    Instant deletedAt
) {
    public static ProductResponseDto fromEntity(Product product) {
        return new ProductResponseDto(
            product.getProductId(),
            product.getSku(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getQuantity(),
            product.getUpdatedAt(),
            product.getDeletedAt()
        );
    }
}
