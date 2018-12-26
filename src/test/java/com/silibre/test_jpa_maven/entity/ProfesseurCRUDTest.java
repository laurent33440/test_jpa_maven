/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silibre.test_jpa_maven.entity;

import java.util.List;
//import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author laurent_a
 */
public class ProfesseurCRUDTest extends BaseJPATest {
    
    @Test
    public void testPersist_success() {
        em.getTransaction().begin();
        Professeur professeur  = new Professeur();
        professeur.setNom("laurent");
        em.persist(professeur);
        em.getTransaction().commit();

        List<Professeur> profs = em.createNamedQuery("Professeur.getAll", Professeur.class).getResultList();

        assertNotNull(profs);
        assertEquals(2, profs.size());
    }
    
//    @Test 
//    public void testCreateObject() {
//        Professeur professeur  = new Professeur();
//        professeur.setNom("laurent");
//        em.persist(professeur);
//    }
    
//    @Test
//    public void testGetObjectById_success() {
//        Professeur professeur = em.find(Professeur.class, 1);
//        assertNotNull(professeur);
//    }
    
}
