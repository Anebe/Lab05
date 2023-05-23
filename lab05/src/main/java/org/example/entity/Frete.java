package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  int codigo;
    private  int numeroNotaFiscal;
    private BigDecimal valorKmRodado;

    ///////////////////////////////
    @OneToOne
    private Veiculo veiculo;
    @OneToOne
    private  Cliente cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Set<ItemFrete> itensFrete;

    @OneToOne
    private Cidade cidadeOrigem;
    @OneToOne Cidade cidadeDestino;

}
