package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Filial {
    @Id
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
}
