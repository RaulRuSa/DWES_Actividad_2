package com.edix.actividad_02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edix.actividad_02.modelo.repository.IntEventoDao;
@Controller
public class HomeController {
	@Autowired
	private IntEventoDao iEventos;
	@GetMapping("/inicio")
	public String inicio(Model model) {
		
		model.addAttribute("listaEventos", iEventos.findAll());
		return "index";
	}

}
