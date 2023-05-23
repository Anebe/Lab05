package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity  @Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Funcionario extends PessoaFisica{
    private int matricula;
    ////////////////////////

    @OneToOne
    private Filial filial;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id")
    List<Dependente> dependente;

}
