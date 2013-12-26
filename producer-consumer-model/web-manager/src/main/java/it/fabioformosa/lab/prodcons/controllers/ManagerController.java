package it.fabioformosa.lab.prodcons.controllers;

import it.fabioformosa.lab.prodcons.dto.ProdConsSetting;
import it.fabioformosa.lab.prodcons.model.SimpleManager;
import it.fabioformosa.lab.prodcons.service.LoggingEventService;
import it.fabioformosa.lab.prodcons.service.TaskRegistry;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@Resource
	private ApplicationContext coreContext;

	@Resource
	private LoggingEventService loggingEventService;

	@RequestMapping(method = RequestMethod.GET, value = "/panel")
	public ModelAndView showPanel() {
		ModelAndView mav = new ModelAndView("panel");
		//		loggingEventService.resetLogs();
		mav.addObject("settings", new ProdConsSetting());
		return mav;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/panel")
	public ModelAndView startWorkers(
			@Valid @ModelAttribute("settings") ProdConsSetting settings,
			BindingResult bindingResult) {

		ModelAndView mav = new ModelAndView("panel");

		if (bindingResult.hasErrors()) {
			mav.addObject(bindingResult);
			return mav;
		}

		//		loggingEventService.resetLogs();

		SimpleManager manager = (SimpleManager) coreContext.getBean("manager");
		manager.setTaskId(TaskRegistry.getNewTaskId());
		manager.setConsumerNum(settings.getConsumerNumber());
		manager.setProducerNum(settings.getProducerNumber());
		manager.setProducerCycleNum(settings.getProdCycleNumber());

		TaskRegistry.register(manager);

		Thread managerThread = new Thread(manager);
		managerThread.start();
		
		mav.addObject("taskId", manager.getTaskId());

		return mav;
	}
}
