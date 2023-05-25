package org.example.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable @Data
public class DistanciaPK implements Serializable {
    @ManyToOne
    private Cidade cidDestino;
    @ManyToOne
    private Cidade cidOrigem;
}
