package org.example.entity;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class Dependente {
        private String nome;
        private LocalDate dataNascimento;
}
