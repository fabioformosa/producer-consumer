package it.fabioformosa.lab.prodcons.service;

import it.fabioformosa.lab.prodcons.model.LoggingEvent;
import it.fabioformosa.lab.prodcons.utils.PaginatedList;
import it.fabioformosa.lab.prodcons.utils.PaginatedListRequest;

import java.util.List;

public interface LoggingEventService {
	List<LoggingEvent> listLoggingEvent();

	List<LoggingEvent> listLoggingEvent(int taskId);

	void resetLogs();

	PaginatedList<LoggingEvent> listPaginatedLoggingEvents(int taskId,
			PaginatedListRequest paginatedListRequest);
}
