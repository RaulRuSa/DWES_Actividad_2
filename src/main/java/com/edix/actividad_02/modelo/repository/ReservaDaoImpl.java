package com.edix.actividad_02.modelo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.actividad_02.modelo.beans.Evento;
import com.edix.actividad_02.modelo.beans.Reserva;
import com.edix.actividad_02.modelo.beans.Usuario;

@Repository
public class ReservaDaoImpl implements IntReservaDao{
	
	private List<Reserva> lista;
	
	public ReservaDaoImpl() {
		lista = new ArrayList<Reserva>();
		cargarDatos();
	}
	
	private void cargarDatos() {
		IntUsuarioDao usuarioDao = new UsuarioDaoImpl();
		IntEventoDao eventoDao = new EventoDaoImpl();
		
		lista.add(new Reserva(1, eventoDao.findById(1), usuarioDao.findById(1), eventoDao.findById(1).getPrecio_decimal()*5, "reserva de ejemplo 1", 5));
		lista.add(new Reserva(2, eventoDao.findById(3), usuarioDao.findById(1), eventoDao.findById(3).getPrecio_decimal()*7, "reserva de ejemplo 1", 7));
	}
	
	@Override
	public int findLastId() {
		int lastId=0;
		for(Reserva ele: lista) 
			if(ele.getIdReserva()>lastId)
				lastId=ele.getIdReserva();
		return lastId;
	}
	
	//le paso una lista de reservas y me devuelve las que contengan ese idEvento
	@Override
	public List<Reserva> findByIdEvento(int idEvento) {
		List<Reserva> aux = new ArrayList<Reserva>();
		for(Reserva ele: lista) {
			if(ele.getEvento().getId_Evento() == idEvento) {
				aux.add(ele);
			}	
		}	
		return aux;
	}
	//devuelve la cantidad de plazas reservada para un evento
	@Override
	public int cantidadReservadaEnEvento (int idEvento) {
		int cantidadReservada=0;
		List<Reserva> aux = new ArrayList<Reserva>();
		aux = findByIdEvento(idEvento);
		for(Reserva ele: aux)
			cantidadReservada += ele.getCantidad();
		return cantidadReservada;
	}

	@Override
	public Reserva findById(int idReserva) {
		Reserva aux = new Reserva();
		aux.setIdReserva(idReserva);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}
	
	//devuelve las reservas hechas por un usuario buscando por el nombre del usuario
	@Override
	public List<Reserva> findBynombre(String nombre) {
		List<Reserva> aux = new ArrayList<Reserva>();
		for(Reserva ele: lista) {
			if(ele.getUsuario().getNombre().equals(nombre))
				aux.add(ele);
		}
		return aux;
	}
	
	@Override
	public Reserva findByIdEventoYNombreUsuario(int idEvento, String nombreUsuario) {
		List<Reserva> listaAux = new ArrayList<Reserva>();
		listaAux = findBynombre(nombreUsuario);
		for(Reserva ele: listaAux) {
			if(ele.getEvento().getId_Evento()==idEvento)
				return ele;
		}
		return null;
	}
	
	@Override
	 public List<Reserva> findAll(){
		return lista;
	}
	
	@Override
	public int insertarReserva(Reserva reserva) {
		if (lista.contains(reserva))
			return 0;
		else
			return lista.add(reserva)?1:0;
	}
}
