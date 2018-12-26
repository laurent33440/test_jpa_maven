/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silibre.test_jpa_maven.main;

import com.silibre.test_jpa_maven.entity.Civilite;
import com.silibre.test_jpa_maven.entity.ClasseTutore;
import com.silibre.test_jpa_maven.entity.Evaluation;
import com.silibre.test_jpa_maven.entity.Professeur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author laurent
 */
public class TestJpa {

    private static EntityManager em;
    private static Professeur prof;
    private static ClasseTutore classeTutore;
    private static Evaluation eval1;
    private static Evaluation eval2;
    private static Evaluation eval3;

    /**
     *
     * @param args
     */
    public static void main(String... args) {
        em = JpaUtil.getEntityManager("com.silibre_test_jpa_maven_testingH2");
        try {
            em.getTransaction().begin() ;
            buildProfesseurEtRelations();
            em.persist(prof) ; // cascade on persist
            em.getTransaction().commit() ;
            checkDb();
        } catch (Exception e) {
            JpaUtil.close();
        } finally {
            JpaUtil.close();
        }
    }

    private static void buildProfesseurEtRelations() {
        prof =  new Professeur() ;
        classeTutore = new ClasseTutore(); // lien 1,1 avec Professeur
        eval1 = new Evaluation();// lien 1,n avec Professeur
        eval2 = new Evaluation();
        eval3 = new Evaluation();

        prof.setCivilite(Civilite.Monsieur);
        prof.setNom("toto");
        prof.setPrenom("titi");
        prof.setDiscipline("français");
        prof.setAge(32);
        classeTutore.setNomClasse("2sen-"+ LocalDate.now().toString());
        // lien 1,1
        prof.setClasseTutore(classeTutore);
        //optionel, bidirectionnel 1,1
        classeTutore.setProfesseur(prof); // voir entite "esclave" ClasseTutore

        Collection<Evaluation> coll = new ArrayList();
        eval1.setIntitule("evaluation 1");
        eval2.setIntitule("evalutaion 2");
        eval3.setIntitule("evalutaion 3");
        coll.add(eval1);
        coll.add(eval2);
        coll.add(eval3);
        //lien 1,n
        prof.setEvaluationList(coll);
        //optionnel bidirectionnel n,1
//        eval1.setSource(prof);
//        eval2.setSource(prof);
//        eval3.setSource(prof);
    }

    private static void checkDb() {
//        prof.getEvaluationList().forEach(ev->{
//            System.out.println("Evaluation  : "+ev.getIntitule()+" id : "+ev.getId()+" -> associee au prof "+ev.getSource().getNom()); // bidir
//        });

//        System.out.println("Id Prof = " + prof.getId()) ;
//        System.out.println("Id Classe tutore = " + classeTutore.getId()) ;
//        System.out.println("ALL DONE WELL !!");
        List<Professeur> professeurList = em.createQuery("select p from Professeur p").getResultList();
        System.out.println("************** Professeur(s) enregistré(s) : ");
        professeurList.forEach(p-> {
            System.out.println("Professeur : "+p.getCivilite() + " "+p.getPrenom() + " "+p.getNom()+" -> id : "+p.getId());
        });
        professeurList.forEach(p->{
            p.getEvaluationList().forEach(e-> {
                System.out.println("Evaluation  : "+e.getIntitule()+" id : "+e.getId()+ " -> associee au prof : "+ p.toString());
            });
        });
    }
}
