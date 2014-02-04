package it.fabioformosa.lab.prodcons.dao.impl;

import it.fabioformosa.lab.prodcons.utils.PaginatedListRequest;

public class LoggingEventPaginatedRequest extends PaginatedListRequest {

	private int taskId;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public LoggingEventPaginatedRequest(int taskId, int currPage, int pageSize) {
		super(currPage, pageSize);
		this.taskId = taskId;
	}

}
