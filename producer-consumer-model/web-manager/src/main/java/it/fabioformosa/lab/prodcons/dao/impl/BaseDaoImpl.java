package it.fabioformosa.lab.prodcons.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDaoImpl {

	@PersistenceContext(unitName = "prodConsModel")
	protected EntityManager entityManager;

}
