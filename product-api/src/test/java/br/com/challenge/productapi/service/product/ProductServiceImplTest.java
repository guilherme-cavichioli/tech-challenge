package br.com.challenge.productapi.service.product;

import br.com.challenge.productapi.entity.ProductEntity;
import br.com.challenge.productapi.repository.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceImplTest {

    private ProductRepository productRepository;
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductServiceImpl(productRepository);
    }

    @Test
    void shouldReturnProductWhenItExists() {
        // given
        Long id = 1L;
        ProductEntity product = new ProductEntity();
        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        // when
        Optional<ProductEntity> result = productService.findById(id);

        // then
        assertTrue(result.isPresent());
        assertEquals(product, result.get());
        verify(productRepository).findById(id);
    }

    @Test
    void shouldReturnEmptyWhenProductDoesNotExist() {
        // given
        Long id = 999L;
        when(productRepository.findById(id)).thenReturn(Optional.empty());

        // when
        Optional<ProductEntity> result = productService.findById(id);

        // then
        assertFalse(result.isPresent());
        verify(productRepository).findById(id);
    }
}

