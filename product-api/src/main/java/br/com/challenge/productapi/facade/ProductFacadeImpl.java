package br.com.challenge.productapi.facade;

import br.com.challenge.productapi.entity.ProductEntity;
import br.com.challenge.productapi.repository.resource.ResourceRepository;
import br.com.challenge.productapi.service.product.ProductService;
import br.com.challenge.productapi.service.resource.ResourceService;
import org.springframework.stereotype.Component;

@Component
public class ProductFacadeImpl implements ProductFacade {

    private final ProductService productService;
    private final ResourceService resourceService;

    public ProductFacadeImpl(ProductService productService, ResourceService resourceService) {
        this.productService = productService;
        this.resourceService = resourceService;
    }

    @Override
    public ProductEntity getProductWithResources(Long id) {
        var opProduct = productService.findById(id);
        if (opProduct.isPresent()) {
            ProductEntity product = opProduct.get();
            resourceService.fetchProductResources(product);
            return product;
        } else {
            throw new RuntimeException(String.format("Product with id %s not found", id));
        }
    }
}
