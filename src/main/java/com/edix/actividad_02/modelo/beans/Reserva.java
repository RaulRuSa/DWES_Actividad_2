package com.edix.actividad_02.modelo.beans;

import java.io.Serializable;

public class Reserva implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Atributos de Reserva
	private int id_Reserva;
	private Evento evento;
	private Usuario usuario;
	private double precio_venta;
	private String observaciones;
	private int cantidad;
	
	//Constructores con y sin parametros
	public Reserva(int id_Reserva, Evento evento, Usuario usuario, double precio_venta, String observaciones,
			int cantidad) {
		super();
		this.id_Reserva = id_Reserva;
		this.evento = evento;
		this.usuario = usuario;
		this.precio_venta = precio_venta;
		this.observaciones = observaciones;
		this.cantidad = cantidad;
	}

	public Reserva() {
		super();
	}
	
	//Getters y Setters
	public int getId_Reserva() {
		return id_Reserva;
	}

	public void setId_Reserva(int id_Reserva) {
		this.id_Reserva = id_Reserva;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	//Sobreescribo hasCode y equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_Reserva;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Reserva))
			return false;
		Reserva other = (Reserva) obj;
		if (id_Reserva != other.id_Reserva)
			return false;
		return true;
	}

	//Sobreescribo toString
	@Override
	public String toString() {
		return "Reserva [id_Reserva=" + id_Reserva + ", evento=" + evento + ", usuario=" + usuario + ", precio_venta="
				+ precio_venta + ", observaciones=" + observaciones + ", cantidad=" + cantidad + "]";
	}
	
	

}
