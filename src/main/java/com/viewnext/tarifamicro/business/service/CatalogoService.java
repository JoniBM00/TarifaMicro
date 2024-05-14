package com.viewnext.tarifamicro.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viewnext.tarifamicro.business.model.Catalogo;
import com.viewnext.tarifamicro.business.model.MapaCatalogos;
import com.viewnext.tarifamicro.business.model.MapaTarifas;
import com.viewnext.tarifamicro.business.model.Tarifa;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CatalogoService {

	private CatalogoService() {
	}

	/**
	 * Mete los Catalogos en un Mapa de la clase {@link MapaCatalogos} y mete los
	 * atributos de las tarifas al catalogo correspondiente
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
		log.info("Catalogos añadidos al mapa y atributos de las tarifas implementados a los catalogos");
		return lCatalogo;
	}

}
