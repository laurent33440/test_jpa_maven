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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static com.silibre.test_jpa_maven.entity.Evaluation.EVALUATION;

/**
 *
 * @author laurent
 */
@Entity
@Table( name=EVALUATION,
            uniqueConstraints={ // les deux colonnes citées ne doivent pas avoir de doublons 
                @UniqueConstraint(name="identite_unique",columnNames={"Intitule"})
            }
)
@Access(AccessType.FIELD)
public class Evaluation implements Serializable {
    public static final String EVALUATION="Evaluation";
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="Intitule", length=50)
    private String intitule;
    
    //bidirectionnal
    @ManyToOne
    @JoinColumn(name="id_professeur", referencedColumnName = "id")
    private Professeur source;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Professeur getSource() {
        return source;
    }

    public void setSource(Professeur source) {
        this.source = source;
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
        if (!(object instanceof Evaluation)) {
            return false;
        }
        Evaluation other = (Evaluation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "laurent.Evaluation[ id=" + id + " ]";
    }
    
}
