package io.github.shnflrsc.picoims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.shnflrsc.picoims.dto.ProductResponseDto;
import io.github.shnflrsc.picoims.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {
    
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<ProductResponseDto> products = productRepository.findAll().stream()
            .map(ProductResponseDto::fromEntity)
            .toList();
        
        return ResponseEntity.ok(products);
    }
}
