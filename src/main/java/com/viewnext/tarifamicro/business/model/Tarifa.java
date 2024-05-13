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

}
