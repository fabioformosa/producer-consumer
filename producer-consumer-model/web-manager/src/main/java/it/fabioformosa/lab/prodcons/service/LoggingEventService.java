package it.fabioformosa.lab.prodcons.service;

import it.fabioformosa.lab.prodcons.model.LoggingEvent;

import java.util.List;

public interface LoggingEventService {
	List<LoggingEvent> listLoggingEvent();

	List<LoggingEvent> listLoggingEvent(int taskId);

	void resetLogs();
}
