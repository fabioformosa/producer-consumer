package it.fabioformosa.lab.prodcons.controllers;

import it.fabioformosa.lab.prodcons.model.LoggingEvent;
import it.fabioformosa.lab.prodcons.service.LoggingEventService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
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

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<LoggingEvent> getLogs() {
		return loggingEventService.listLoggingEvent();
	}

}
