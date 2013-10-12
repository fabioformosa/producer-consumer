package it.fabioformosa.lab.prodcons.dao;

import it.fabioformosa.lab.prodcons.model.LoggingEvent;

import java.util.List;

public interface LoggingEventDAO {

	List<LoggingEvent> listLoggingEvents();

	List<LoggingEvent> listLoggingEvents(int taskId);

}
