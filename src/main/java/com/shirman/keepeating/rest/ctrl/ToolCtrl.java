package com.shirman.keepeating.rest.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/tool")
public class ToolCtrl {
	@RequestMapping(value="/toolMain")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("tool/toolMain");
		return modelAndView;
	}
}
