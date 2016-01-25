package com.shirman.ishangchi.rest.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/game")
public class GameCtrl extends BaseCtrl{
	@RequestMapping(value="/gameMain")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("game/gameMain");
		setCurrentUser(modelAndView);
		return modelAndView;
	}
	
	@RequestMapping(value="/numberBoom")
	public ModelAndView numberBoom() {
		ModelAndView modelAndView = new ModelAndView("game/numberBoom");
		setCurrentUser(modelAndView);
		return modelAndView;
	}
}
