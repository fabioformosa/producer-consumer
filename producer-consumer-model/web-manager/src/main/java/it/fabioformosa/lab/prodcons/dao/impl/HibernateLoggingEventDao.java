package it.fabioformosa.lab.prodcons.dao.impl;

import it.fabioformosa.lab.prodcons.dao.LoggingEventDAO;
import it.fabioformosa.lab.prodcons.model.LoggingEvent;
import it.fabioformosa.lab.prodcons.utils.PaginatedList;
import it.fabioformosa.lab.prodcons.utils.PaginatedListFetcher;
import it.fabioformosa.lab.prodcons.utils.PaginatedListRequest;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<LoggingEvent> listLoggingEvents(int taskId) {
		Query query = entityManager
				.createQuery("from LoggingEvent where callerClass like 'it.fabioformosa%' and threadName like 'Task-"
						+ taskId + "%'");
		return query.getResultList();
	}

	@Override
	public PaginatedList<LoggingEvent> listPaginatedLoggingEvents(int taskId,
			PaginatedListRequest paginatedListRequest) {
		
		LoggingEventFetcher fetcher = new LoggingEventFetcher(LoggingEvent.class);

		LoggingEventPaginatedRequest loggingEventPaginatedRequest = paginatedListRequestConvertion(
				taskId, paginatedListRequest);
		
		return fetcher.fetch(entityManager, loggingEventPaginatedRequest);
	}

	private LoggingEventPaginatedRequest paginatedListRequestConvertion(
			int taskId, PaginatedListRequest paginatedListRequest) {
		LoggingEventPaginatedRequest loggingEventPaginatedRequest = new LoggingEventPaginatedRequest(taskId, paginatedListRequest.getCurrPage(), paginatedListRequest.getPageSize());
		loggingEventPaginatedRequest.setFirstItem(paginatedListRequest.getFirstItem());
		loggingEventPaginatedRequest.setFilters(paginatedListRequest.getFilters());
		loggingEventPaginatedRequest.setOrdering(paginatedListRequest.getOrderCriterion());
		return loggingEventPaginatedRequest;
	}
}
