package com.edix.actividad_02.modelo.repository;

import com.edix.actividad_02.modelo.beans.Usuario;

public interface IntUsuarioDao {
	
	//Interface con las funciones que usaremos para la clase Usuario
	//Estas funciones se implementaran en UsuarioDaoImpl
	
	int registrarUsuario(Usuario usuario);
	Usuario findByUsername(String username);
	Usuario findById(int id_Usuario);
	Usuario comprobarLogin(String userName, String password);

}
