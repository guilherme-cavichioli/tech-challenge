package br.com.challenge.productapi.service.resource;

import br.com.challenge.productapi.entity.ProductEntity;

public interface ResourceService {
    String getResourceUrl(String resourceType, Long resourceId);
    void fetchProductResources(ProductEntity product);
}
