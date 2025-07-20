package br.com.challenge.productapi.repository.resource;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ResourceRepositoryImpl implements ResourceRepository {

    private static final Map<Long, String> productsMap = Map.of(
            1L, "https://raw.githubusercontent.com/guilherme-cavichioli/tech-challenge/refs/heads/main/fake-storage/resources/product/iphone-cover.jpg",
            2L, "https://raw.githubusercontent.com/guilherme-cavichioli/tech-challenge/refs/heads/main/fake-storage/resources/product/iphone-back.jpg",
            3L, "https://raw.githubusercontent.com/guilherme-cavichioli/tech-challenge/refs/heads/main/fake-storage/resources/product/iphone-03.jpg",
            4L, "https://raw.githubusercontent.com/guilherme-cavichioli/tech-challenge/refs/heads/main/fake-storage/resources/product/iphone-04.jpg"
    );

    private static final Map<Long, String> paymentMethodsMap = Map.of(
            1L, "https://raw.githubusercontent.com/guilherme-cavichioli/tech-challenge/refs/heads/main/fake-storage/resources/payment-methods/mastercard-logo.png",
            2L, "https://raw.githubusercontent.com/guilherme-cavichioli/tech-challenge/refs/heads/main/fake-storage/resources/payment-methods/visa-logo.png",
            3L, "https://raw.githubusercontent.com/guilherme-cavichioli/tech-challenge/refs/heads/main/fake-storage/resources/payment-methods/pix-logo.png",
            4L, "https://raw.githubusercontent.com/guilherme-cavichioli/tech-challenge/refs/heads/main/fake-storage/resources/payment-methods/mercado-pago-logo.png"
    );

    private static final Map<Long, String> sellerMap = Map.of(
            1L, "https://raw.githubusercontent.com/guilherme-cavichioli/tech-challenge/refs/heads/main/fake-storage/resources/seller/apple-banner.png"
    );

    @Override
    public String findResourceUrl(String resourceType, Long resourceId) {
        return switch (resourceType.toLowerCase()) {
            case "product" -> productsMap.get(resourceId);
            case "paymentmethod" -> paymentMethodsMap.get(resourceId);
            case "seller" -> sellerMap.get(resourceId);
            default -> null;
        };
    }


}