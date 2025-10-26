package io.github.shnflrsc.picoims.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @Column(length = 32, nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String passwordHash;

    @CurrentTimestamp
    @Column(name = "last_login", nullable = false)
    private Instant lastLogin;

    @CreationTimestamp
    @Column(name = "joined_at", nullable = false)
    private Instant joinedAt;

    private Instant deletedAt;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;
}
