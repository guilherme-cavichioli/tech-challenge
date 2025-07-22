package br.com.challenge.productapi.controller;

import br.com.challenge.productapi.entity.ProductEntity;
import br.com.challenge.productapi.exception.ProductNotFoundException;
import br.com.challenge.productapi.facade.ProductFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ProductControllerTest {

    private ProductFacade productFacade;
    private ProductController productController;

    @BeforeEach
    void setUp() {
        productFacade = mock(ProductFacade.class);
        productController = new ProductController(productFacade);
    }

    @Test
    void shouldReturnProductWhenFound() {
        // given
        Long productId = 1L;
        ProductEntity product = new ProductEntity(); // or mock(ProductEntity.class)
        when(productFacade.getProductWithResources(productId)).thenReturn(product);

        // when
        ResponseEntity<ProductEntity> response = productController.getProduct(productId);

        // then
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(product, response.getBody());
        verify(productFacade, times(1)).getProductWithResources(productId);
    }

    @Test
    void shouldThrowProductNotFoundExceptionWhenProductIsMissing() {
        // given
        Long productId = 999L;
        when(productFacade.getProductWithResources(productId))
                .thenThrow(new ProductNotFoundException("Product not found"));

        // when + then
        try {
            productController.getProduct(productId);
        } catch (ProductNotFoundException e) {
            assertEquals("Product not found", e.getMessage());
            verify(productFacade, times(1)).getProductWithResources(productId);
        }
    }
}
