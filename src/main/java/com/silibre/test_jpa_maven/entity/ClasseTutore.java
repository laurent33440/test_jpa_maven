/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silibre.test_jpa_maven.entity;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static com.silibre.test_jpa_maven.entity.ClasseTutore.CLASSE_TUTORE;

/**
 *
 * @author laurent
 */
@Entity(name=CLASSE_TUTORE)
@Table( name=CLASSE_TUTORE,
            uniqueConstraints={ // les deux colonnes citées ne doivent pas avoir de doublons 
                @UniqueConstraint(name="identite_unique_classePP",columnNames={"Nom_classe"})
            }
)
@Access(AccessType.FIELD)
public class ClasseTutore implements Serializable {
    public static final String CLASSE_TUTORE="Classe_tutore";
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nom_classe", length=50)
    private String nomClasse;
    
    //bidirectionnal one to one
    @OneToOne(mappedBy="classeTutore")
    private Professeur professeur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClasseTutore)) {
            return false;
        }
        ClasseTutore other = (ClasseTutore) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "laurent.ClasseProfesseurPrincipal[ id=" + id + " ]";
    }
    
}
