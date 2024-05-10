package com.viewnext.tarifamicro.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viewnext.tarifamicro.business.model.Catalogo;
import com.viewnext.tarifamicro.business.model.MapaTarifas;
import com.viewnext.tarifamicro.business.model.Tarifa;

@Service
public class CatalogoService {

	private CatalogoService() {
	}

	public static List<Catalogo> processCatalogo(List<Catalogo> lCatalogo) {
		Tarifa t;
		for (Catalogo catalogo : lCatalogo) {

			t = MapaTarifas.getTarifa(catalogo.getId());
			if (t != null) {
				catalogo.setTipo(t.getTipo());
				catalogo.setPrecio(t.getPrecio());
			}
		}
		return lCatalogo;
	}

}
