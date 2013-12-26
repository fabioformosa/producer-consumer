package it.fabioformosa.lab.prodcons.controllers;

import javax.annotation.Resource;

import it.fabioformosa.lab.prodcons.service.LoggingEventService;

public class LogInitializer {

	@Resource
	private LoggingEventService loggingEventService;
	
	public void resetLogs(){
		loggingEventService.resetLogs();
	}
	
}
