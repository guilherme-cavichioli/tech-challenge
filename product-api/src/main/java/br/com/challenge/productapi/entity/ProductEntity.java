package br.com.challenge.productapi.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class ProductEntity extends BaseEntity {
    private String title;
    private String description;
    private Map<String, String> features;
    @Builder.Default
    private Set<ResourceEntity> resources = new HashSet<>();
    private String price;
    private SellerEntity seller;
    private Integer totalStock;
    private String color;
    private String ratingStar;
    private String ratingValue;
    private String rating;
}
