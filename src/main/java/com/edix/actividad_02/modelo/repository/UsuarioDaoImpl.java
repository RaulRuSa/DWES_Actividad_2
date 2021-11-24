package com.edix.actividad_02.modelo.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

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
	public Usuario findByUsername(String username) {
		Usuario aux = new Usuario();
		aux.setUsername(username);
		int pos = lista.indexOf(aux);
		if (pos == -1) 
			return null;
		else 
			return lista.get(pos);
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
		Usuario aux = new Usuario();
		aux.setUsername(userName);
		aux.setPassword(password);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}
}
