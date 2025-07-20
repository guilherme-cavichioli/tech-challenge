package br.com.challenge.productapi.repository.product;

import br.com.challenge.productapi.entity.PaymentMethodEntity;
import br.com.challenge.productapi.entity.ProductEntity;
import br.com.challenge.productapi.entity.ResourceEntity;
import br.com.challenge.productapi.entity.SellerEntity;
import br.com.challenge.productapi.entity.enums.PaymentMethodTypeEnum;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public Optional<ProductEntity> findById(Long id) {
        ResourceEntity resourceOne = ResourceEntity.builder()
                .id(1L)
                .isCover(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        ResourceEntity resourceTwo = ResourceEntity.builder()
                .id(2L)
                .isCover(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        ResourceEntity resourceThree = ResourceEntity.builder()
                .id(3L)
                .isCover(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        ResourceEntity resourceFour = ResourceEntity.builder()
                .id(4L)
                .isCover(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        ResourceEntity resourcePaymentOne = ResourceEntity.builder()
                .id(1L)
                .isCover(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        ResourceEntity resourcePaymentTwo = ResourceEntity.builder()
                .id(2L)
                .isCover(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        ResourceEntity resourcePaymentThree = ResourceEntity.builder()
                .id(3L)
                .isCover(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        ResourceEntity resourcePaymentFour = ResourceEntity.builder()
                .id(4L)
                .isCover(false)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        ResourceEntity resourceSeller = ResourceEntity.builder()
                .id(1L)
                .isCover(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        PaymentMethodEntity payment1 = PaymentMethodEntity.builder()
                .id(1L)
                .type(PaymentMethodTypeEnum.CARD)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .friendlyName("Credit Card")
                .resources(Set.of(resourcePaymentOne, resourcePaymentTwo))
                .build();

        PaymentMethodEntity payment2 = PaymentMethodEntity.builder()
                .id(2L)
                .type(PaymentMethodTypeEnum.PIX)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .friendlyName("Pix")
                .resources(Set.of(resourcePaymentThree))
                .build();

        PaymentMethodEntity payment3 = PaymentMethodEntity.builder()
                .id(3L)
                .type(PaymentMethodTypeEnum.MERCADO_PAGO)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .resources(Set.of(resourcePaymentFour))
                .friendlyName("Mercado Pago")
                .build();

        SellerEntity seller = SellerEntity.builder()
                .id(1L)
                .name("Apple")
                .subtitle("Official Store")
                .isOfficial(true)
                .totalSales(5000)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .paymentMethods(List.of(payment1, payment2, payment3))
                .resource(resourceSeller)
                .build();

        Map<String, String> features = new HashMap<>();
        features.put("Display", "6.1 inch AMOLED");
        features.put("Battery", "4500 mAh");
        features.put("OS", "IOS 17");
        features.put("Camera", "48 Mpx");

        ProductEntity product = ProductEntity.builder()
                .id(id)
                .title("Apple iPhone 16 (128 GB)")
                .description("iPhone 16 is built for Apple Intelligence and features the power of the A18 chip*. " +
                        "Capture stunning photos with the 48MP Fusion camera. And enjoy more time for texting, " +
                        "browsing, and more with its super-charged battery.")
                .color("Black")
                .features(features)
                .resources(Set.of(resourceOne, resourceTwo, resourceThree, resourceFour))
                .seller(seller)
                .price("600.00")
                .totalStock(10)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return Optional.of(product);
    }
}
