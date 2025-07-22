package br.com.challenge.productapi.service.resource;

import br.com.challenge.productapi.entity.*;
import br.com.challenge.productapi.repository.resource.ResourceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ResourceServiceImplTest {

    private ResourceRepository resourceRepository;
    private ResourceServiceImpl resourceService;

    @BeforeEach
    void setUp() {
        resourceRepository = mock(ResourceRepository.class);
        resourceService = new ResourceServiceImpl(resourceRepository);
    }

    @Test
    void shouldSetUrlsForProductAndRelatedResources() {
        // Arrange
        ResourceEntity productResource = new ResourceEntity();
        productResource.setId(1L);

        ResourceEntity sellerResource = new ResourceEntity();
        sellerResource.setId(2L);

        ResourceEntity paymentResource = new ResourceEntity();
        paymentResource.setId(3L);

        PaymentMethodEntity paymentMethod = new PaymentMethodEntity();
        paymentMethod.setResources(Set.of(paymentResource));

        SellerEntity seller = new SellerEntity();
        seller.setResource(sellerResource);
        seller.setPaymentMethods(List.of(paymentMethod));

        ProductEntity product = new ProductEntity();
        product.setResources(Set.of(productResource));
        product.setSeller(seller);

        when(resourceRepository.findResourceUrl("product", 1L)).thenReturn("product-url");
        when(resourceRepository.findResourceUrl("seller", 2L)).thenReturn("seller-url");
        when(resourceRepository.findResourceUrl("paymentmethod", 3L)).thenReturn("payment-url");

        // Act
        resourceService.fetchProductResources(product);

        // Assert
        assertEquals("product-url", productResource.getUrl());
        assertEquals("seller-url", sellerResource.getUrl());
        assertEquals("payment-url", paymentResource.getUrl());
    }

    @Test
    void shouldReturnResourceUrl() {
        when(resourceRepository.findResourceUrl("product", 99L)).thenReturn("mocked-url");
        String url = resourceService.getResourceUrl("product", 99L);
        assertEquals("mocked-url", url);
    }
}