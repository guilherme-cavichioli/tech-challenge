package br.com.challenge.productapi.repository.product;


import br.com.challenge.productapi.entity.ProductEntity;

import java.util.Optional;

public interface ProductRepository {
    Optional<ProductEntity> findById(Long id);
}