package com.viewnext.tarifamicro.business.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Service;

import com.viewnext.tarifamicro.business.model.MapaTarifas;
import com.viewnext.tarifamicro.business.model.Tarifa;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TarifaService {

	private TarifaService() {
	}

	/**
	 * Lee el fichero tarifas.csv y mete las tarifas en una mapa en la clase
	 * MapaTarifas
	 */
	@Bean
	public static void readCsv() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new PathResource("./../ficheroEntrada/tarifas.csv").getFile()));

			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				Tarifa t = new Tarifa();
				t.setId(Long.valueOf(values[0]));
				t.setTipo(values[1]);
				t.setPrecio(Double.valueOf(values[2]));
				t.setIva(Integer.valueOf(values[3]));

				MapaTarifas.addTarifa(t);
			}
			log.info("Tarifas leidas del csv: " + MapaTarifas.getTarifas().size());
		} catch (IOException | NumberFormatException e) {
			log.error(e.toString());
			e.printStackTrace();
		}

	}

	/**
	 * Recoge la lista de Tarifas del Mapa de Tarifas, recorre la lista copiando
	 * cada una de las tarifas para que al modificar el precio no cambie en las del
	 * Mapa y retorna la lista de Tarifas copiadas con el iva añadido
	 * 
	 * @return Una lista de Tarifas con el Iva aplicado
	 */
	public static List<Tarifa> conIva() {
		List<Tarifa> lTarifas = MapaTarifas.getTarifas().values().stream().toList();
		List<Tarifa> lTarifasIva = new ArrayList<>();
		Tarifa t;
		double totalIva;

		for (Tarifa tarifa : lTarifas) {
			t = new Tarifa(tarifa);
			totalIva = (t.getIva()) / 100f + 1f;
			BigDecimal bigDecimal = BigDecimal.valueOf((t.getPrecio() * totalIva)).setScale(2, RoundingMode.HALF_UP);
			t.setPrecio(bigDecimal.doubleValue());
			lTarifasIva.add(t);
		}
		log.info("Iva aplicado a las tarifas");
		return lTarifasIva;
	}

}
