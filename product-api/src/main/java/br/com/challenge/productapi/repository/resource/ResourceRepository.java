package br.com.challenge.productapi.repository.resource;

public interface ResourceRepository {
    String findResourceUrl(String resourceType, Long resourceId);
}
