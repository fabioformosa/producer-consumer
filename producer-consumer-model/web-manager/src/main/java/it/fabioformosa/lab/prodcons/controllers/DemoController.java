package it.fabioformosa.lab.prodcons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

	@RequestMapping("/demo.html")
	public ModelAndView demo() {
		ModelAndView mav = new ModelAndView("standardLayout");
		return mav;
	}

}
