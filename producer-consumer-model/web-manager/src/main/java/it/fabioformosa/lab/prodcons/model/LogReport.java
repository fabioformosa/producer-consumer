package it.fabioformosa.lab.prodcons.model;

import it.fabioformosa.lab.prodcons.model.SimpleManager.TaskStatus;

import java.util.ArrayList;
import java.util.List;

public class LogReport {

	private List<LoggingEvent> logs;
	private TaskStatus taskStatus;

	public LogReport() {
		logs = new ArrayList<LoggingEvent>();
		taskStatus = TaskStatus.UNDEFINED;
	}

	public LogReport(List<LoggingEvent> logs) {
		this.logs = logs;
	}

	public List<LoggingEvent> getLogs() {
		return logs;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setLogs(List<LoggingEvent> logs) {
		this.logs = logs;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

}
