package com.edix.actividad_02.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edix.actividad_02.modelo.beans.Usuario;
import com.edix.actividad_02.modelo.repository.IntEventoDao;
import com.edix.actividad_02.modelo.repository.IntUsuarioDao;

@Controller
@RequestMapping("/GestionClientes")
public class GestionClientes {

	@Autowired
	private IntUsuarioDao iUsuarioDao;

	@Autowired
	private IntEventoDao iEventos;

	/*
	 * @Autowired private IntEventoDao iEventos;
	 */

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(Model model, Usuario usuario, HttpSession sesion) {
		/*
		 * if (iUsuarioDao.findByUsername(usuario.getUsername()) != null ) {
		 * if(iUsuarioDao.findByUsername(usuario.getUsername()).getPassword().equals(
		 * usuario.getPassword())) { sesion.setAttribute("nombreUsuario",
		 * usuario.getUsername()); model.addAttribute("nombreUsuario",
		 * usuario.getNombre()); return "redirect:/GestionUsuarios/cliente"; }
		 * 
		 * else model.addAttribute("mensaje", "La contraseña es incorrecta"); } else
		 * model.addAttribute("mensaje", "El usuario es incorrecto"); return "/login";
		 */
		Usuario aux = iUsuarioDao.comprobarLogin(usuario.getUsername(), usuario.getPassword());
		if(aux != null) {
			aux.setPassword(""); //oculto la password de usuario
			sesion.setAttribute("nombreUsuario", aux.getNombre());
			return "redirect:/GestionClientes/destacados";
		}
			
		else {
			model.addAttribute("mensaje","Usuario o contraseña incorrecto");
			return "/login";
		}	
	}
	
	@GetMapping("/cerrarSesion")
	public String cerrarSesion(HttpSession sesion) {
		sesion.removeAttribute("nombreUsuario");
		return ("/login");
	}
	
	@GetMapping("/eventos")
	public String eventos(Model model) {
		model.addAttribute("listaEventos", iEventos.findAll());
		model.addAttribute("titulo", "");
		return "clientes";
	}

	@GetMapping("/destacados")
	public String destacados(Model model) {
		model.addAttribute("listaEventos", iEventos.findDestacados());
		model.addAttribute("titulo", "Destacados");
		return "clientes";
	}
	
	@GetMapping("/activos")
	public String activos(Model model) {
		model.addAttribute("listaEventos", iEventos.findActivos());
		model.addAttribute("titulo", "Activos");
		return "clientes";
	}
	
	@GetMapping("/detalle/{id}")
	public String detalle(Model model, @PathVariable("id") int id_Evento) {
		model.addAttribute("evento", iEventos.findById(id_Evento));
		return "detalle";
	}
	
	@PostMapping
	public String detalle() {
		if()
	}
	
}
