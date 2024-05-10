package com.viewnext.tarifamicro.business.model;

import java.util.HashMap;
import java.util.Map;

public class MapaTarifas {

	private MapaTarifas() {
	}

	private static Map<Long, Tarifa> mTarifas = new HashMap<>();

	public static void addTarifa(Long id, Tarifa tarifa) {
		mTarifas.put(tarifa.getId(), tarifa);
	}

	public static Map<Long, Tarifa> getTarifas() {
		return mTarifas;
	}

	public static Tarifa getTarifa(Long id) {
		return mTarifas.get(id);
	}

}
