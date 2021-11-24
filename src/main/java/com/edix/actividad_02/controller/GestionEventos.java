package com.edix.actividad_02.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.actividad_02.modelo.beans.Evento;
import com.edix.actividad_02.modelo.repository.IntEventoDao;
import com.edix.actividad_02.modelo.repository.IntTipoDao;

@Controller
@RequestMapping("/GestionEventos")
public class GestionEventos {
	@Autowired 
	private IntEventoDao iEventoDao;
	
	@InitBinder
		public void initBinder (WebDataBinder webdataBinder) {
			SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
			webdataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}
	
	@GetMapping("/altaEvento")
	public String altaEvento() {
		return "altaEvento";
	}
	
	@PostMapping("/altaEvento")
	public String altaEvento(Evento evento, RedirectAttributes rattr) {
		int msg = iEventoDao.insertarEvento(evento);
		if (msg == 0) 
			rattr.addFlashAttribute("mensaje", "No se ha podido dar de alta el producto");
		else 
			rattr.addFlashAttribute("mensaje", "Producto dado de alta");
		return "redirect:/inicio";
	}
	
	@GetMapping("/editar")
	public String editar(Model model, @RequestParam("id") int id_Evento) {
		Evento evento = iEventoDao.findById(id_Evento);
		model.addAttribute("evento", evento);
		return "editarEvento";	
	}
	
	@GetMapping("/eliminar")
	public String eliminar(Model model, @RequestParam("id") int id_Evento) {
		int i = iEventoDao.eliminarEvento(id_Evento);
		if (i == 0)
			model.addAttribute("mensaje", "No ha sido posible eliminar el producto");
		else {
			model.addAttribute("mensaje", "Producto eliminado");
			model.addAttribute("listaEventos", iEventoDao.findAll());
		}
		return "index";
	}
	
	@GetMapping("/cancelar/{id}")
	public String cancelar(Model model, @PathVariable("id") int id_Evento) {
		int i = iEventoDao.cancelarEvento(id_Evento);
		if (i == 0)
			model.addAttribute("mensaje", "No ha sido posible cancelar el evento");
		else {
			model.addAttribute("mensaje", "Evento cancelado");
			model.addAttribute("listaEventos", iEventoDao.findAll());
		}
			
		return "index";
	}
}
