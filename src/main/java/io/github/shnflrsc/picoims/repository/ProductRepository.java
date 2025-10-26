package io.github.shnflrsc.picoims.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.shnflrsc.picoims.model.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findBySku(String sku);
}
