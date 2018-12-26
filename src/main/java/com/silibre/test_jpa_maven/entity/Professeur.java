/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silibre.test_jpa_maven.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

import static com.silibre.test_jpa_maven.entity.Professeur.PROFESSEUR;

/**
 *
 * @author laurent
 */
@Entity(name=PROFESSEUR)
//@Table( name=PROFESSEUR,
//            uniqueConstraints={ // les deux colonnes citées ne doivent pas avoir de doublons 
//                @UniqueConstraint(name="identite_unique",columnNames={"Nom","Prenom"})
//            }
//)
@Table( name=PROFESSEUR
)
@Access(AccessType.FIELD) //accès sur les champs de l'entité
@NamedQueries(value = {
    @NamedQuery(name = "Professeur.getAll", query = "SELECT b FROM Professeur b")
})
public class Professeur implements Serializable {
    public static final String PROFESSEUR="Professeur";
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="Nom", length=50)
    private String nom;
    
    @Column(name="Prenom", length=50)
    private String prenom;
    
    @Column(name="Age")
    private Integer age;
    
    @Column(name="Civilite", length=15)
    @Enumerated(EnumType.STRING)
    private Civilite civilite;
    
    @Column(name="Date_naissance", length=15)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    
    @Column(name="Discipline", length=50)
    private String discipline;
    
    @OneToOne(cascade = CascadeType.PERSIST) // save related entity
    @JoinColumn( name="id_classe_turore", referencedColumnName="id")
    private ClasseTutore classeTutore;
    
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="source")
    private Collection<Evaluation> evaluationList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Civilite getCivilite() {
        return civilite;
    }

    public void setCivilite(Civilite civilite) {
        this.civilite = civilite;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public ClasseTutore getClasseTutore() {
        return classeTutore;
    }

    public void setClasseTutore(ClasseTutore classeTutore) {
        this.classeTutore = classeTutore;
    }  

    public Collection<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(Collection<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
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
        if (!(object instanceof Professeur)) {
            return false;
        }
        Professeur other = (Professeur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return prenom+ " "+nom+"[ id=" + id + " ]";
    }

    
}
