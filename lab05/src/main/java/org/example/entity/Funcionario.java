package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.util.List;

@Entity  @Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends PessoaFisica{
    private int matricula;
    ////////////////////////

    @OneToOne
    private Filial filial;

    @Embedded
    List<Dependente> dependente;

}
