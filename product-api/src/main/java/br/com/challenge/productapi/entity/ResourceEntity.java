package br.com.challenge.productapi.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class ResourceEntity extends BaseEntity {
    private String url;
    private Boolean isCover;
    private ProductEntity product;
}
