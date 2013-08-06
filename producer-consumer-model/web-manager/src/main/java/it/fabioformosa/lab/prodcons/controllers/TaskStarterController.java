package it.fabioformosa.lab.prodcons.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/job")
public class TaskStarterController {

	@Autowired
	@RequestMapping("/start")
	public ModelAndView starter() {
		ModelAndView mav = new ModelAndView("taskStarter");

		return mav;
	}

}
