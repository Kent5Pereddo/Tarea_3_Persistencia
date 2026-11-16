package com.foodpacking.foodpackingentidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FoodPackingEntidades {

    public static void main(String[] args) {
        try {
            // Inicializa la unidad de persistencia configurada en persistence.xml
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("FoodPackingPU");
            EntityManager em = emf.createEntityManager();
            
            System.out.println("¡Conexión exitosa! Las tablas se han sincronizado correctamente en la base de datos.");
            
            // Cierra los recursos de conexión
            em.close();
            emf.close();
            
        } catch (Exception e) {
            System.err.println("Error al conectar con la base de datos:");
            e.printStackTrace();
        }
    }
}