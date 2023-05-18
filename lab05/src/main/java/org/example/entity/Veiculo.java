package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veiculo {
    @Id
    private int id;
    private String numeroPlaca;

    //////////////////////////

    @OneToOne
    private TipoVeiculo tipoVeiculo;
}
