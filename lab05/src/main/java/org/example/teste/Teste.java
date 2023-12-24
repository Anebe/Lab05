package org.example.teste;

import org.example.entity.*;
import org.example.service.FreteService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.LinkedHashSet;

public class Teste {
    public static void main(String[] args) {
        EntityManagerFactory fabricador = Persistence.createEntityManagerFactory("lab05");
        EntityManager gerenciador = fabricador.createEntityManager();

        testCadastroFrete(gerenciador);

        gerenciador.close();
        fabricador.close();
    }

    public static void testCadastroFrete(EntityManager gerenciador){
        Cliente cliente = Cliente.builder()
                .contato("(98)91234-4567")
                .status(true)
                .build();
        cliente.setNome("gabriel");
        cliente.setEmail("gabriel@gmail.com");
        cliente.setTelefone("1234-5678");
        cliente.setCpf("123.456.789-0");


        Filial filial = Filial.builder()
                .endereco("Bairro. Rua. CEP")
                .nome("Frete Rápido")
                .telefone("1111-2222")
                .build();

        TipoVeiculo tpVeiculo = TipoVeiculo.builder()
                .descricao("Carga pesada")
                .pesoMaximo(2000)
                .build();

        Veiculo veiculo = Veiculo.builder()
                .numeroPlaca("1234-ABCD")
                .filial(filial)
                .tipoVeiculo(tpVeiculo)
                .build();

        CategoriaFrete categoriaFrete = CategoriaFrete.builder()
                .descricao("Categoria de peso")
                .nome("nome Peso")
                .percentualAdicional(0.3f)
                .build();

        ItemFrete itemFrete1 = ItemFrete.builder()
                .descricao("Mesa")
                .peso(35)
                .build();

        Cidade cidOrigem = new Cidade();
        cidOrigem.setUf("MA");
        cidOrigem.setEstado("Maranhão");
        cidOrigem.setNome("São Luís");

        Cidade cidDestino = new Cidade();
        cidDestino.setUf("São Jose de Ribamar");
        cidDestino.setEstado("Maranhão");
        cidDestino.setNome("MA");

        Distancia distanciaOD = new Distancia();
        distanciaOD.getId().setCidOrigem(cidOrigem);
        distanciaOD.getId().setCidDestino(cidDestino);
        distanciaOD.setAdicionalKmRodado(BigDecimal.valueOf(5.5));
        distanciaOD.setKilometros(456);

        Distancia distanciaDO = new Distancia();
        distanciaDO.getId().setCidOrigem(cidDestino);
        distanciaDO.getId().setCidDestino(cidOrigem);
        distanciaDO.setAdicionalKmRodado(BigDecimal.valueOf(5.5));
        distanciaDO.setKilometros(456);


        gerenciador.getTransaction().begin();
        gerenciador.persist(cliente);
        gerenciador.persist(filial);
        gerenciador.persist(tpVeiculo);
        gerenciador.persist(veiculo);
        gerenciador.persist(categoriaFrete);
        gerenciador.persist(itemFrete1);
        gerenciador.persist(cidOrigem);
        gerenciador.persist(cidDestino);
        gerenciador.getTransaction().commit();

        gerenciador.getTransaction().begin();
        cidOrigem.adiciona(distanciaOD);
        cidDestino.adiciona(distanciaDO);
        gerenciador.getTransaction().commit();

        Frete frete = new Frete();
        frete.setCategoriaFrete(gerenciador.createQuery("from CategoriaFrete where id = 1", CategoriaFrete.class).getSingleResult());
        frete.setCidadeOrigem(gerenciador.createQuery("from Cidade where id = 1", Cidade.class).getSingleResult());
        frete.setCidadeDestino(gerenciador.createQuery("from Cidade where id = 2", Cidade.class).getSingleResult());
        frete.setCodigo(900);
        frete.setVeiculo(gerenciador.createQuery("from Veiculo where id = 1", Veiculo.class).getSingleResult());
        frete.setCliente(gerenciador.createQuery("from Cliente where id = 1", Cliente.class).getSingleResult());
        frete.setValorKmRodado(BigDecimal.valueOf(3.55));

        frete.adiciona(itemFrete1);


        FreteService fs = new FreteService(gerenciador, frete);
        fs.cadastrarFrete();
    }
}
