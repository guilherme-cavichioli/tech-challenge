package br.com.challenge.productapi.entity;

import br.com.challenge.productapi.entity.enums.PaymentMethodTypeEnum;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
public class PaymentMethodEntity extends BaseEntity {
    private PaymentMethodTypeEnum type;
    private String friendlyName;
    private Set<ResourceEntity> resources;
}