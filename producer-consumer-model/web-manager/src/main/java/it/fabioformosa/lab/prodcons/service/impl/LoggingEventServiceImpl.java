package it.fabioformosa.lab.prodcons.service.impl;

import it.fabioformosa.lab.prodcons.dao.LoggingEventDAO;
import it.fabioformosa.lab.prodcons.dao.LoggingEventHelper;
import it.fabioformosa.lab.prodcons.model.LoggingEvent;
import it.fabioformosa.lab.prodcons.service.LoggingEventService;
import it.fabioformosa.lab.prodcons.utils.PaginatedList;
import it.fabioformosa.lab.prodcons.utils.PaginatedListRequest;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class LoggingEventServiceImpl implements LoggingEventService {

	@Resource
	private LoggingEventDAO dao;

	@Resource
	private LoggingEventHelper helper;

	@Override
	public List<LoggingEvent> listLoggingEvent() {
		return dao.listLoggingEvents();
	}

	@Override
	public List<LoggingEvent> listLoggingEvent(int taskId) {
		return dao.listLoggingEvents(taskId);
	}

	@Override
	public void resetLogs() {
		helper.resetLogs();
	}

	@Override
	public PaginatedList<LoggingEvent> listPaginatedLoggingEvents(int taskId,
			PaginatedListRequest paginatedListRequest) {
		return dao.listPaginatedLoggingEvents(taskId, paginatedListRequest);
	}


}
