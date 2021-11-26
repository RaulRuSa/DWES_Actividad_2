package com.edix.actividad_02.modelo.repository;

import java.util.List;

import com.edix.actividad_02.modelo.beans.Usuario;

public interface IntUsuarioDao {
	
	//Interface con las funciones que usaremos para la clase Usuario
	//Estas funciones se implementaran en UsuarioDaoImpl
	
	int registrarUsuario(Usuario usuario);
	int findLastId();
	Usuario findByUsername(String username);
	Usuario findById(int id_Usuario);
	List<Usuario> findAll();
	Usuario comprobarLogin(String userName, String password);

}
