package com.edix.actividad_02.modelo.repository;

import com.edix.actividad_02.modelo.beans.Evento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class EventoDaoImpl implements IntEventoDao {
	
	//Creo un Arraylist donde guardar los eventos y guardo algunos eventos
	private List<Evento> lista;
	
	public EventoDaoImpl() {
		lista = new ArrayList<Evento>();
		cargarDatos();	
	}
	//Aqu� es donde guardo algunos evento en el Arraylist creado
	private void cargarDatos() {
		IntTipoDao iTipo = new TipoDaoImpl();
		
		lista.add(new Evento(1,"evento 1","es el evento111", new Date(), 20,"c/Bermuda", "activo", 's' ,11, 2, 9.1, iTipo.finById(2)));
		lista.add(new Evento(2,"evento 2","es el evento123", new Date(), 20,"c/Catalejo", "inactivo", 'n' ,14, 5, 17.3, iTipo.finById(4)));
		lista.add(new Evento(3,"evento 3","es el evento71", new Date(), 20,"c/Reloj", "activo", 'n' ,134, 25, 107.3, iTipo.finById(2)));
		lista.add(new Evento(4,"evento 4","es el evento72", new Date(), 20,"c/Catalejo", "inactivo", 's' ,33, 51, 717.3, iTipo.finById(1)));
		lista.add(new Evento(5,"evento 5","es el evento73", new Date(), 20,"c/Catalejo", "activo", 's' ,456, 67, 457.3, iTipo.finById(3)));
	}
	
	//Implemento las funciones definidas en el Interface IntEventoDao
	@Override
	public Evento findById(int id_Evento) {
		Evento aux = new Evento();
		aux.setId_Evento(id_Evento);
		int pos = lista.indexOf(aux);
		if (pos == -1) 
			return null;
		else
			 return lista.get(pos);
	}

	@Override
	public List<Evento> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}
	
	@Override
	public List<Evento> findActivos() {
		List<Evento> aux = new ArrayList<Evento>();
		for (Evento ele: this.findAll()) {
			if(ele.getEstado()=="activo") {
				aux.add(ele);
			}
		}
		return aux;
	}
	
	@Override
	public List<Evento> findDestacados(){
		List<Evento> aux = new ArrayList<Evento>();
		for (Evento ele: this.findAll()) {
			if(ele.getDestacado()=='s')
				aux.add(ele);
		}
		return aux;
	}
	
	@Override
	public int insertarEvento(Evento evento) {
		if (lista.contains(evento))
			return 0;
		else
			return lista.add(evento)?1:0;
	}

	@Override
	public int modificarEvento(Evento evento) {
		int pos = lista.indexOf(evento);
		if(pos == -1)
			return 0;
		else
			return (lista.set(pos, evento)!=null)?1:0;
	}
	
	@Override
	public int modificarEstadoEvento(int id_Evento) {
		Evento aux = new Evento(); 
		aux.setId_Evento(id_Evento);
		int pos = lista.indexOf(aux);
		if (pos == -1) {
			return 0;
		}
		else {
			if(lista.get(pos).getEstado() == "activo")
				lista.get(pos).setEstado("inactivo");
			else
				lista.get(pos).setEstado("activo");
		}
		return 1;
	}

	@Override
	public int eliminarEvento(int id_Evento) {
		Evento aux = new Evento();
		aux.setId_Evento(id_Evento);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return 0;
		else
			return (lista.remove(pos)!=null)?1:0;
	}

	@Override
	public int eliminarEvento(Evento evento) {
		return lista.remove(evento)?1:0;
	}

	@Override
	public int cancelarEvento(int  id_Evento) {
		Evento aux = new Evento();
		aux.setId_Evento(id_Evento);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return 0;
		else {
			if(lista.get(pos).getEstado() == "activo")
				lista.get(pos).setEstado("inactivo");
			else
				lista.get(pos).setEstado("activo");
		}		
		return 1;
	}
}
