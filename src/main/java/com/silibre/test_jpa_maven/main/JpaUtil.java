/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silibre.test_jpa_maven.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author laurent_a
 */
public class JpaUtil {
    
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;
    
    private JpaUtil() {
    }
    
    public static EntityManagerFactory getEntityManagerfactory(String unitName) {
        createEntityManagerFactory(unitName);
        return emf;
    }
    
    public static EntityManager getEntityManager(String unitName) {
        createEntityManagerFactory(unitName);
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }
    
    public static void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }
    
    private static void createEntityManagerFactory(String unitName) {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(unitName);
        }
    }
}
