package br.com.challenge.productapi.facade;

import br.com.challenge.productapi.entity.ProductEntity;

public interface ProductFacade {
    ProductEntity getProductWithResources(Long id);
}
