package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veiculo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String numeroPlaca;

    //////////////////////////

    @OneToOne
    private TipoVeiculo tipoVeiculo;

    @OneToOne
    private Filial filial;
}
