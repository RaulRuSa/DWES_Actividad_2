package com.edix.actividad_02.modelo.repository;

import java.util.List;

import com.edix.actividad_02.modelo.beans.Reserva;

public interface IntReservaDao {
	
	//Interface con las funciones que usaremos para la clase Reserva
	//Estas funciones se implementan en ReservaDaoImpl
	
	//devuelve una reserva a partir de su id de reserva
	Reserva findById(int id_Reserva);
	//devuelve todas las reservas que incluyan ese evento con idEvento
	List<Reserva> findByIdEvento (int idEvento);
	List<Reserva> findBynombre(String nombre);
	int cantidadReservadaEnEvento (int evento);
	Reserva findByIdEventoYNombreUsuario(int idEvento, String nombreUsuario);
	int findLastId(); 
	List<Reserva> findAll();
	int insertarReserva(Reserva reserva);
		
}
