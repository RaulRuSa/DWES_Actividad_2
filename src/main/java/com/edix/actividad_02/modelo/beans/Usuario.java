package com.edix.actividad_02.modelo.beans;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//Atributos de Usuario
	private int id_Usuario;
	private String username;
	private String password;
	private String email;
	private String nombre;
	private String direccion;
	private int enabled;
	private Date fecha_Registro;
	
	//Constructores con y sin parametros
	public Usuario(int id_Usuario, String username, String password, String email, String nombre, String direccion,
			int enable, Date fecha_Registro) {
		super();
		this.id_Usuario = id_Usuario;
		this.username = username;
		this.password = password;
		this.email = email;
		this.nombre = nombre;
		this.direccion = direccion;
		this.enabled = enable;
		this.fecha_Registro = fecha_Registro;
	}

	public Usuario() {
		super();
	}
	
	//Getters and Setters
	public int getId_Usuario() {
		return id_Usuario;
	}

	public void setId_Usuario(int id_Usuario) {
		this.id_Usuario = id_Usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEnable() {
		return enabled;
	}

	public void setEnable(int enable) {
		this.enabled = enable;
	}

	public Date getFecha_Registro() {
		return fecha_Registro;
	}

	public void setFecha_Registro(Date fecha_Registro) {
		this.fecha_Registro = fecha_Registro;
	}

	//Sobreescribo hasCode y equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Usuario))
			return false;
		Usuario other = (Usuario) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	//Sobreescribo toString
	@Override
	public String toString() {
		return "Usuario [id_Usuario=" + id_Usuario + ", username=" + username + ", password=" + password + ", email="
				+ email + ", nombre=" + nombre + ", direccion=" + direccion + ", enable=" + enabled + ", fecha_Registro="
				+ fecha_Registro + "]";
	}

	

}


