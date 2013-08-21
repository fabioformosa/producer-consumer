package it.fabioformosa.lab.prodcons.dao.impl;

import it.fabioformosa.lab.prodcons.dao.LoggingEventDAO;
import it.fabioformosa.lab.prodcons.model.LoggingEvent;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class HibernateLoggingEventDao extends BaseDaoImpl implements
		LoggingEventDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<LoggingEvent> listLoggingEvents() {
		Query query = entityManager
				.createQuery("from LoggingEvent where callerClass like 'it.fabioformosa%'");
		return query.getResultList();
	}

}
