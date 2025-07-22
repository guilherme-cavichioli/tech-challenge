package br.com.challenge.productapi.controller;

import br.com.challenge.productapi.entity.ProductEntity;
import br.com.challenge.productapi.facade.ProductFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductFacade productFacade;

    public ProductController(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    @CrossOrigin(origins = "*") // allow any origin
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProduct(@PathVariable Long id) {
        ProductEntity product = productFacade.getProductWithResources(id);
        return ResponseEntity.ok(product);
    }
}