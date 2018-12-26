/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silibre.test_jpa_maven.entity;

/**
 *
 * @author laurent
 */
public enum Civilite {
    Mademoiselle("Mlle"), Madame("Mme"), Monsieur("Mr");
    
    private String abreviation;
    
    private Civilite(String abreviation){
        this.abreviation = abreviation;
    }
    
    public String getAbreviation(){
        return this.abreviation;
    }
}
