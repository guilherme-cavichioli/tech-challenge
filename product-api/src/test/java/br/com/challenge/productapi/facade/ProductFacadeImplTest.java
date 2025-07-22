package br.com.challenge.productapi.facade;

import br.com.challenge.productapi.entity.ProductEntity;
import br.com.challenge.productapi.exception.ProductNotFoundException;

import br.com.challenge.productapi.service.product.ProductService;
import br.com.challenge.productapi.service.resource.ResourceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductFacadeImplTest {

    private ProductService productService;
    private ResourceService resourceService;
    private ProductFacadeImpl productFacade;

    @BeforeEach
    void setUp() {
        productService = mock(ProductService.class);
        resourceService = mock(ResourceService.class);
        productFacade = new ProductFacadeImpl(productService, resourceService);
    }

    @Test
    void shouldReturnProductWithResourcesWhenProductExists() {
        // given
        Long productId = 1L;
        ProductEntity mockProduct = new ProductEntity();

        when(productService.findById(productId)).thenReturn(Optional.of(mockProduct));

        // when
        ProductEntity result = productFacade.getProductWithResources(productId);

        // then
        assertEquals(mockProduct, result);
        verify(productService).findById(productId);
        verify(resourceService).fetchProductResources(mockProduct);
    }

    @Test
    void shouldThrowExceptionWhenProductDoesNotExist() {
        // given
        Long productId = 999L;
        when(productService.findById(productId)).thenReturn(Optional.empty());

        // when + then
        ProductNotFoundException ex = assertThrows(
                ProductNotFoundException.class,
                () -> productFacade.getProductWithResources(productId)
        );

        assertEquals("Product with id 999 not found", ex.getMessage());
        verify(productService).findById(productId);
        verifyNoInteractions(resourceService);
    }
}