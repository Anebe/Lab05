package org.example.service;

import lombok.Builder;
import org.example.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Objects;

public class FreteService {
    private EntityManager gerenciador;
    private Frete frete;
    public FreteService(EntityManager gerenciador, Frete frete) {
        this.frete = frete;
        this.gerenciador = gerenciador;
    }

    public void cadastrarFrete(){

        gerenciador.getTransaction().begin();
        gerenciador.persist(frete);
        gerenciador.getTransaction().commit();
        System.out.println("Valor Total: " + calcularFrete());
    }
    private BigDecimal calcularFrete(){
        BigDecimal result = BigDecimal.ZERO;

        if(Objects.isNull(frete)){
            throw new EntityNotFoundException();
        }

        DistanciaPK distanciaPK = new DistanciaPK();
        distanciaPK.setCidOrigem(frete.getCidadeOrigem());
        distanciaPK.setCidDestino(frete.getCidadeDestino());

        Distancia distancia = gerenciador.find(Distancia.class, distanciaPK);

        BigDecimal km = BigDecimal.valueOf(distancia.getKilometros());
        BigDecimal valorKm = frete.getValorKmRodado();
        BigDecimal percentAdicional = BigDecimal.valueOf(frete.getCategoriaFrete().getPercentualAdicional());
        percentAdicional.add(BigDecimal.ONE);

        result = km.multiply(valorKm).multiply(percentAdicional);

        return result;
    }
}
