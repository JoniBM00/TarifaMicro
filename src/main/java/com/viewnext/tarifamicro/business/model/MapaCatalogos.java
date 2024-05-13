package com.viewnext.tarifamicro.business.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase para guardar las catalogos del fichero catalogos.csv
 */
public class MapaCatalogos {

	private MapaCatalogos() {
	}

	private static Map<Long, Catalogo> mCatalogos = new HashMap<>();

	public static void addCatalogo(Long id, Catalogo catalogo) {
		mCatalogos.put(catalogo.getId(), catalogo);
	}

	public static Map<Long, Catalogo> getCatalogos() {
		return mCatalogos;
	}

	public static Catalogo getCatalogo(Long id) {
		return mCatalogos.get(id);
	}

}
