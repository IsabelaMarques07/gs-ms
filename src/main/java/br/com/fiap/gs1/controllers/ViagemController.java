package br.com.fiap.gs1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ViagemController {
	
	@GetMapping("/viagem")
	public ModelAndView index() {
		ModelAndView modelView = new ModelAndView("XXX");
	
	
		return modelView;
	}
	
	@PostMapping("/viagem")
	public ModelAndView Criar(/*obj*/) {
		ModelAndView modelView = new ModelAndView("XXX");
	
	
		return modelView;
	}
}
