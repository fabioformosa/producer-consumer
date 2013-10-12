package it.fabioformosa.lab.prodcons.controllers;

import it.fabioformosa.lab.prodcons.model.LogReport;
import it.fabioformosa.lab.prodcons.model.LoggingEvent;
import it.fabioformosa.lab.prodcons.model.SimpleManager;
import it.fabioformosa.lab.prodcons.service.LoggingEventService;
import it.fabioformosa.lab.prodcons.service.TaskRegistry;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/logs")
public class LogController {

	@Resource
	private ApplicationContext coreContext;

	@Resource
	private LoggingEventService loggingEventService;

	@RequestMapping(value = "/{taskId}", method = RequestMethod.GET)
	public @ResponseBody
	LogReport getLogs(@PathVariable int taskId) {

		LogReport report = new LogReport();

		List<LoggingEvent> loggingEvents = new ArrayList<LoggingEvent>();
		if (taskId > 0) {
			loggingEvents = loggingEventService.listLoggingEvent(taskId);
			report.setLogs(loggingEvents);

			SimpleManager manager = (SimpleManager) TaskRegistry
					.lookupManager(taskId);
			if (manager != null)
				report.setTaskStatus(manager.getTaskStatus());
		}

		return report;
	}
}
