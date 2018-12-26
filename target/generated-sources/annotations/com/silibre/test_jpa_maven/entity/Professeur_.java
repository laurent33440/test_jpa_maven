package com.silibre.test_jpa_maven.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Professeur.class)
public abstract class Professeur_ {

	public static volatile SingularAttribute<Professeur, Date> dateNaissance;
	public static volatile SingularAttribute<Professeur, ClasseTutore> classeTutore;
	public static volatile CollectionAttribute<Professeur, Evaluation> evaluationList;
	public static volatile SingularAttribute<Professeur, Long> id;
	public static volatile SingularAttribute<Professeur, String> discipline;
	public static volatile SingularAttribute<Professeur, String> nom;
	public static volatile SingularAttribute<Professeur, String> prenom;
	public static volatile SingularAttribute<Professeur, Integer> age;
	public static volatile SingularAttribute<Professeur, Civilite> civilite;

}

