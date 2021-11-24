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
		lista.add(new Reserva(21, eventoDao.findById(3), usuarioDao.findById(1), eventoDao.findById(3).getPrecio_decimal()*7, "reserva de ejemplo 1", 7));
	}

	@Override
	public Reserva findById(int id_Reserva) {
		Reserva aux = new Reserva();
		aux.setId_Reserva(id_Reserva);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
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
