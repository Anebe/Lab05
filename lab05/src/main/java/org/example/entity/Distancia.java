package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Distancia {
    @EmbeddedId
    private DistanciaPK Id = new DistanciaPK();

    private int kilometros;
    private BigDecimal adicionalKmRodado;
}
