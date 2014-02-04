package it.fabioformosa.lab.prodcons.dao.impl;

import it.fabioformosa.lab.prodcons.model.LoggingEvent;
import it.fabioformosa.lab.prodcons.utils.PaginatedListFetcher;

public class LoggingEventFetcher extends PaginatedListFetcher<LoggingEvent, LoggingEventPaginatedRequest> {

	public LoggingEventFetcher(Class<LoggingEvent> clazz) {
		super(clazz);
	}
	
	@Override
	protected String generateWhereClause(LoggingEventPaginatedRequest request) {
		return " callerClass like 'it.fabioformosa%' and threadName like 'Task-" + request.getTaskId() + "%'";
	}
	

}
