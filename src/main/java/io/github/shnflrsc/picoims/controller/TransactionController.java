package io.github.shnflrsc.picoims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.shnflrsc.picoims.dto.TransactionResponseDto;
import io.github.shnflrsc.picoims.repository.TransactionRepository;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {
    
    @Autowired
    private TransactionRepository transactionRepository;

    @GetMapping
    public ResponseEntity<List<TransactionResponseDto>> getAllTransactions() {
        List<TransactionResponseDto> transactions = transactionRepository.findAll().stream()
            .map(TransactionResponseDto::fromEntity)
            .toList();

        return ResponseEntity.ok(transactions);
    }
    
}
