package com.viewnext.tarifamicro.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viewnext.tarifamicro.business.model.Catalogo;
import com.viewnext.tarifamicro.business.model.MapaCatalogos;
import com.viewnext.tarifamicro.business.model.MapaTarifas;
import com.viewnext.tarifamicro.business.model.Tarifa;

@Service
public class CatalogoService {

	private CatalogoService() {
	}

	/**
	 * Añade las tarifas por id a los Catalogos
	 * 
	 * @param lCatalogo
	 * @return Una lista de Catalogos con las tarifas añadidas
	 */
	public static List<Catalogo> processAndAddCatalogo(List<Catalogo> lCatalogo) {
		Tarifa t;
		for (Catalogo catalogo : lCatalogo) {

			t = MapaTarifas.getTarifa(catalogo.getId());
			if (t != null) {
				catalogo.setTipo(t.getTipo());
				catalogo.setPrecio(t.getPrecio());
				MapaCatalogos.getCatalogos().put(catalogo.getId(), catalogo);
			}
		}

		return lCatalogo;
	}

}
