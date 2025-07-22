package br.com.challenge.productapi.controller;

import br.com.challenge.productapi.entity.ProductEntity;
import br.com.challenge.productapi.exception.ProductNotFoundException;
import br.com.challenge.productapi.facade.ProductFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductFacade productFacade;  // This will be the mocked bean from TestConfig

    @Autowired
    private ObjectMapper objectMapper;

    @TestConfiguration
    static class TestConfig {
        @Bean
        @Primary  // Override the real ProductFacade bean with this mock
        public ProductFacade productFacade() {
            return Mockito.mock(ProductFacade.class);
        }
    }

    @BeforeEach
    void resetMocks() {
        Mockito.reset(productFacade);
    }

    @Test
    void shouldReturnProduct_whenIdIsValid() throws Exception {
        ProductEntity product = new ProductEntity();
        product.setId(1L);
        product.setTitle("Sample Product");

        given(productFacade.getProductWithResources(1L)).willReturn(product);

        mockMvc.perform(get("/v1/products/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Sample Product"));
    }

    @Test
    void shouldReturn404_whenProductNotFound() throws Exception {
        given(productFacade.getProductWithResources(999L))
                .willThrow(new ProductNotFoundException("Product with id 999 not found"));

        mockMvc.perform(get("/v1/products/999")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Product with id 999 not found"));
    }

    @Test
    void shouldReturn500_whenUnexpectedExceptionOccurs() throws Exception {
        given(productFacade.getProductWithResources(1L))
                .willThrow(new RuntimeException("Unexpected error"));

        mockMvc.perform(get("/v1/products/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Unexpected error: Unexpected error"));
    }
}
