package com.edix.actividad_02.modelo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edix.actividad_02.modelo.beans.Evento;
import com.edix.actividad_02.modelo.beans.Reserva;
import com.edix.actividad_02.modelo.beans.Usuario;

@Repository
public class UsuarioDaoImpl implements IntUsuarioDao{
	
	private List<Usuario> lista;
	
	public UsuarioDaoImpl() {
		lista= new ArrayList<Usuario>();
		cargarDatos();
	}
	
	public void cargarDatos() {
		lista.add(new Usuario(1,"JoseRC","abc123","abc@gmail.com","Jose","c/Lepanto 2",1,new Date()));
		lista.add(new Usuario(2,"Laur22","12345","laura@gmail.com","Laura","c/Corinto 11",1,new Date()));
	}

	@Override
	public int registrarUsuario(Usuario usuario) {
		if(lista.contains(usuario))
			return 0;
		else
			return lista.add(usuario)?1:0;
	}
	
	@Override
	public int findLastId() {
		int lastId=0;
		for(Usuario ele: lista) 
			if(ele.getId_Usuario()>lastId)
				lastId=ele.getId_Usuario();
		return lastId;
	}
	
	@Override
	public Usuario findByUsername(String nombre) {
		for(Usuario ele: this.findAll()){
			if(ele.getNombre().equals(nombre))
				return ele;
		}
		return null;
	}
	
	@Override
	public List<Usuario> findAll() {
		return lista;
	}
	
	@Override
	public Usuario findById(int id_Usuario) {
		Usuario aux = new Usuario();
		aux.setId_Usuario(id_Usuario);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}
	
	@Override
	public Usuario comprobarLogin(String userName, String password) {
		/*
		 * Usuario aux = new Usuario(); aux.setUsername(userName);
		 * aux.setPassword(password); int pos = lista.indexOf(aux); if (pos == -1)
		 * return null; else return lista.get(pos);
		 */
		
		//List<Usuario> aux = new ArrayList<Usuario>();
		for(Usuario ele: this.findAll()){
			if(ele.getUsername().equals(userName)&&ele.getPassword().equals(password))
				return ele;
		}
		return null;
	}
	
}
