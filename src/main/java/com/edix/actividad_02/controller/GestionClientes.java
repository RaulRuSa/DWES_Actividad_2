package com.edix.actividad_02.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

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
import com.edix.actividad_02.modelo.beans.Reserva;
import com.edix.actividad_02.modelo.beans.Usuario;
import com.edix.actividad_02.modelo.repository.EventoDaoImpl;
import com.edix.actividad_02.modelo.repository.IntEventoDao;
import com.edix.actividad_02.modelo.repository.IntReservaDao;
import com.edix.actividad_02.modelo.repository.IntUsuarioDao;

@Controller
@RequestMapping("/GestionClientes")
public class GestionClientes {

	@Autowired
	private IntUsuarioDao iUsuarioDao;

	@Autowired
	private IntEventoDao iEventos;
	
	@Autowired
	private IntReservaDao iReserva;
	
	@InitBinder
	public void initBinder (WebDataBinder webdataBinder) {
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		webdataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}


	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login")
	public String login(Model model, Usuario usuario, HttpSession sesion) {
		Usuario aux = iUsuarioDao.comprobarLogin(usuario.getUsername(), usuario.getPassword());
		if(aux != null) {
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
	
	@GetMapping("/registrarse")
	public String registrarse() {
		
		return "registro";
	}
	
	@PostMapping("/registrarse")
	public String registrarse(Usuario usuario, RedirectAttributes attr) {
		
		usuario.setId_Usuario(iUsuarioDao.findLastId()+1);
		usuario.setFecha_Registro(new Date());
		if(iUsuarioDao.registrarUsuario(usuario) != 0) {
			attr.addFlashAttribute("mensaje", "Usuario registrado");
		}
			
		else 
			attr.addFlashAttribute("mensaje", "Ha ocurrido un error al registrar el usuario");
		return "redirect:/GestionClientes/login";
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
	public String detalle(Model model, @PathVariable("id") int id_Evento, HttpSession sesion) {
		model.addAttribute("evento", iEventos.findById(id_Evento));
		model.addAttribute("listaReservas", iReserva.findBynombre((String)sesion.getAttribute("nombreUsuario")));
		return "detalle";
	}
	
	@PostMapping("/reservar/{id}")
	public String detalle(Model model, @RequestParam ("cantidad") int cantidad, @PathVariable("id") int idEvento, HttpSession sesion, RedirectAttributes rattr) {
		
		Reserva reserva = new Reserva();
		Usuario usuario = new Usuario();

		//como maximo puede reservar 10 plazas
		if (cantidad>10) {
			rattr.addFlashAttribute("mensaje", "Puedes reservar un máximo de 10 plazas");
			return "redirect:/GestionClientes/detalle/"+idEvento;
		}
		
		//compruebo que en el evento solicitado tengo disponibles la cantidad plazas que se quiere reservar
		//para ello miro la cantidad total de plaza que ya tenia reservada en ese evento y la cantidad que se quiere
		//reserva ahora y compruebo que no se supere el aforo maximo del evento
		else if((iReserva.cantidadReservadaEnEvento(idEvento) + cantidad) > iEventos.findById(idEvento).getAforo_maximo()) {
			rattr.addFlashAttribute("mensaje", "Problemas al dar de alta, reserva no realizada. Plazas disponibles en el evento:" + 
					(iEventos.findById(idEvento).getAforo_maximo()-iReserva.cantidadReservadaEnEvento(idEvento)));
			return "redirect:/GestionClientes/detalle/"+idEvento;
		}
		
		//compruebo si ya tenia reservas previas de ese evento para que no supere la cantidad de 10 plazas
		else if(iReserva.findByIdEventoYNombreUsuario(idEvento, (String)sesion.getAttribute("nombreUsuario")) != null){
			reserva = iReserva.findByIdEventoYNombreUsuario(idEvento, (String)sesion.getAttribute("nombreUsuario"));
			if((reserva.getCantidad()+cantidad)>10) {
				rattr.addFlashAttribute("mensaje", "Puedes reservar un máximo de 10 plazas por evento");
				return "redirect:/GestionClientes/detalle/"+idEvento;
			}
			else {
				reserva.setCantidad(reserva.getCantidad()+cantidad);
				return "redirect:/GestionClientes/detalle/"+idEvento;
			}
		}
		else {
			reserva.setIdReserva(iReserva.findLastId()+1);
			reserva.setEvento(iEventos.findById(idEvento));		
			usuario= iUsuarioDao.findByUsername((String)sesion.getAttribute("nombreUsuario"));
			reserva.setUsuario(usuario);
			reserva.setPrecioVenta(iEventos.findById(idEvento).getPrecio_decimal()*cantidad);
			reserva.setCantidad(cantidad);
			rattr.addFlashAttribute("mensaje", "Reserva realizada con exito");
			iReserva.insertarReserva(reserva);
			return "redirect:/GestionClientes/detalle/"+idEvento;
		}
				
	}
	
	@GetMapping("/misreservas")
	public String misrervas(Model model, HttpSession sesion) {
		model.addAttribute("nombreUsuario", sesion.getAttribute("nombreUsuario"));
		model.addAttribute("listaReservas", iReserva.findBynombre((String)sesion.getAttribute("nombreUsuario")));
		return("/misReservas");
	}
}
