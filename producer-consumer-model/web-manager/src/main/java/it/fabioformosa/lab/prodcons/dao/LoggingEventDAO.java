package it.fabioformosa.lab.prodcons.dao;

import it.fabioformosa.lab.prodcons.model.LoggingEvent;
import it.fabioformosa.lab.prodcons.utils.PaginatedList;
import it.fabioformosa.lab.prodcons.utils.PaginatedListRequest;

import java.util.List;

public interface LoggingEventDAO {

	List<LoggingEvent> listLoggingEvents();

	List<LoggingEvent> listLoggingEvents(int taskId);

	PaginatedList<LoggingEvent> listPaginatedLoggingEvents(int taskId,
			PaginatedListRequest paginatedListRequest);

}
