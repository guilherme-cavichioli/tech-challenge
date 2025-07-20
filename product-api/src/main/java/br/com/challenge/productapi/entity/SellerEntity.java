package br.com.challenge.productapi.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class SellerEntity extends BaseEntity {
    private String name;
    private String subtitle;
    private Boolean isOfficial;
    private Integer totalSales;
    @Builder.Default
    private List<PaymentMethodEntity> paymentMethods = new ArrayList<>();
    private ResourceEntity resource;
}