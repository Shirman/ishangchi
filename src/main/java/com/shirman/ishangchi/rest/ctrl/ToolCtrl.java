package com.shirman.ishangchi.rest.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/tool")
public class ToolCtrl extends BaseCtrl{
	@RequestMapping(value="/toolMain")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("tool/toolMain");
		setCurrentUser(modelAndView);
		return modelAndView;
	}
}
