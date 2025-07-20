package br.com.challenge.productapi.service.resource;

import br.com.challenge.productapi.entity.ProductEntity;
import br.com.challenge.productapi.repository.resource.ResourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public String getResourceUrl(String resourceType, Long resourceId) {
        return resourceRepository.findResourceUrl(resourceType, resourceId);
    }

    @Override
    public void fetchProductResources(ProductEntity product) {
        if (product.getResources() != null) {
            product.getResources().forEach(resource ->
                    resource.setUrl(getResourceUrl("product", resource.getId()))
            );
        }

        if (product.getSeller() != null && product.getSeller().getResource() != null) {
            product.getSeller().getResource().setUrl(getResourceUrl("seller", product.getSeller().getResource().getId()));
        }

        if (product.getSeller() != null && product.getSeller().getResource() != null) {
            product.getSeller().getPaymentMethods().forEach(paymentMethod -> {
                if (paymentMethod.getResources() != null) {
                    paymentMethod.getResources().forEach(resource ->
                            resource.setUrl(getResourceUrl("paymentmethod", resource.getId()))
                    );
                }
            });
        }
    }
}
