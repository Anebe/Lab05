package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dependente {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        private String nome;
        private LocalDate dataNascimento;
        ///////////////////////

        @OneToOne
        private Funcionario funcionario;
}
