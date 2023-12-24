package org.example.entity;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Distancia{
    @EmbeddedId @EqualsAndHashCode.Include
    private DistanciaPK id = new DistanciaPK();

    private int kilometros;
    private BigDecimal adicionalKmRodado;

}
