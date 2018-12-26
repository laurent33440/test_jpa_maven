package com.silibre.test_jpa_maven.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Evaluation.class)
public abstract class Evaluation_ {

	public static volatile SingularAttribute<Evaluation, Long> id;
	public static volatile SingularAttribute<Evaluation, Professeur> source;
	public static volatile SingularAttribute<Evaluation, String> intitule;

}

