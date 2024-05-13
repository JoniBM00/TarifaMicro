package com.viewnext.tarifamicro.business.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalogo {

	private Long id;
	private String lugar;
	private int stock;
	private int stockReal;
	private int stockVirtual;
	private Long codigo;
	private String nombre;
	private String tipo;
	private double precio;

	public Catalogo(Long id, String lugar, int stock, int stockReal, int stockVirtual, Long codigo, String nombre) {
		this.id = id;
		this.lugar = lugar;
		this.stock = stock;
		this.stockReal = stockReal;
		this.stockVirtual = stockVirtual;
		this.codigo = codigo;
		this.nombre = nombre;
	}

}
