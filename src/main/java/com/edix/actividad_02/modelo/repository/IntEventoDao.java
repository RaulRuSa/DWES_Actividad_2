package com.edix.actividad_02.modelo.repository;

import com.edix.actividad_02.modelo.beans.Evento;
import java.util.List;


public interface IntEventoDao {
	
	//Interface con las funciones que usaremos para la clase Evento
	//Estas funciones se implementan en EventoDaoImpl
	Evento findById(int id_Evento);
	List<Evento> findAll();
	List<Evento> findActivos();
	List<Evento> findDestacados();
	int insertarEvento(Evento evento);
	int modificarEvento(Evento evento);
	int modificarEstadoEvento(int id_Evento);
	int eliminarEvento(int id_Evento);
	int eliminarEvento(Evento evento);
	int cancelarEvento(int id_Evento);	
}
