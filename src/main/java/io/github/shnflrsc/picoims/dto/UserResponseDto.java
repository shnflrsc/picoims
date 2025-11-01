package io.github.shnflrsc.picoims.dto;

import java.time.Instant;
import java.util.UUID;

import io.github.shnflrsc.picoims.model.User;

public record UserResponseDto(
    UUID userId,
    String username,
    String passwordHash,
    Instant lastLogin,
    Instant joinedAt,
    Instant deletedAt
) {
    public static UserResponseDto fromEntity(User user) {
        return new UserResponseDto(
            user.getUserId(),
            user.getUsername(),
            user.getPasswordHash(),
            user.getLastLogin(),
            user.getJoinedAt(),
            user.getDeletedAt()
        );
    }
}
