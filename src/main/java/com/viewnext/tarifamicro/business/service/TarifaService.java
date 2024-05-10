package com.viewnext.tarifamicro.business.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.viewnext.tarifamicro.business.model.MapaTarifas;
import com.viewnext.tarifamicro.business.model.Tarifa;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TarifaService {

	@Bean
	public static void readCsv() {
		// Lee el fichero tarifas.csv y lo mete en el mapa de MapaTarifas
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("tarifas.csv"));

			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(";");
				Tarifa t = new Tarifa();
				t.setId(Long.valueOf(values[0]));
				t.setTipo(values[1]);
				t.setPrecio(Double.valueOf(values[2]));

				MapaTarifas.addTarifa(t.getId(), t);
			}
			log.info("Tarifas leidas del csv: " + MapaTarifas.getTarifas().size());
		} catch (IOException | NumberFormatException e) {
			log.error(e.toString());
			e.printStackTrace();
		}

	}

}
