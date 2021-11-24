package com.edix.actividad_02.modelo.repository;

import java.util.List;

import com.edix.actividad_02.modelo.beans.Reserva;

public interface IntReservaDao {
	
	//Interface con las funciones que usaremos para la clase Reserva
	//Estas funciones se implementan en ReservaDaoImpl
		
	Reserva findById(int id_Reserva);
	List<Reserva> findAll();
	int insertarReserva(Reserva reserva);
		
}
