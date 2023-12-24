package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cidade{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)@EqualsAndHashCode.Include
    private Integer id;
    private String uf;
    private String nome;
    private String estado;
    ////////////////////////////////

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id.cidOrigem")
    private Set<Distancia> destinos = new LinkedHashSet<>();

    public void adiciona(Distancia distancia){
        destinos.add(distancia);
    }
}
