package br.com.challenge.productapi.service.product;

import br.com.challenge.productapi.entity.ProductEntity;

import java.util.Optional;

public interface ProductService {
    Optional<ProductEntity> findById(Long id);
}
