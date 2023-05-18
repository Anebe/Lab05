package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory fabricador = Persistence.createEntityManagerFactory("lab05");
        EntityManager gerenciador = fabricador.createEntityManager();

        gerenciador.close();
        fabricador.close();
    }
}