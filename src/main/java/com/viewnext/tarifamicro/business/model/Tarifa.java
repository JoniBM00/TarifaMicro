package com.viewnext.tarifamicro.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarifa {

	private Long id;
	private String tipo;
	private double precio;
	private int iva;

	public Tarifa(Tarifa t) {
		this.id = t.getId();
		this.tipo = t.getTipo();
		this.precio = t.getPrecio();
		this.iva = t.getIva();
	}

}
