package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cidade {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uf;
    private String nome;
    private String estado;
    ////////////////////////////////

    @OneToMany
    private Set<Frete> freteOrigem;
    @OneToMany
    private Set<Frete> freteDestino;



}
