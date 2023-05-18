package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  @Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente extends PessoaFisica{
    private String contato;
    private boolean status;

    ///////////////////


}
