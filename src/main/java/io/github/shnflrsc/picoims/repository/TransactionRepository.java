package io.github.shnflrsc.picoims.repository;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.shnflrsc.picoims.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
    @Query("SELECT u.transactions FROM User u WHERE u.id = :userId")
    Set<Transaction> findTransactionsByUserId(@Param("userId") UUID userId);
}
