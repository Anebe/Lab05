package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
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
    private Set<ItemFrete> itensFrete = new LinkedHashSet<>();

    @OneToOne
    private Cidade cidadeOrigem;
    @OneToOne
    private Cidade cidadeDestino;
    @OneToOne
    private CategoriaFrete categoriaFrete;

    public void adiciona(ItemFrete item){
        if(Objects.isNull(itensFrete)){
            itensFrete = new LinkedHashSet<>();
        }

        itensFrete.add(item);
    }
}
