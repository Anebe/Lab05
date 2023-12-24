package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable @Data
public class DistanciaPK implements Serializable {
    @ManyToOne
    private Cidade cidDestino;
    @ManyToOne
    private Cidade cidOrigem;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistanciaPK that = (DistanciaPK) o;
        return Objects.equals(cidDestino, that.cidDestino) && Objects.equals(cidOrigem, that.cidOrigem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cidDestino, cidOrigem);
    }
}
