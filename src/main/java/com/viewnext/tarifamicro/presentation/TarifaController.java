package com.viewnext.tarifamicro.presentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.tarifamicro.business.model.Catalogo;
import com.viewnext.tarifamicro.business.model.MapaTarifas;
import com.viewnext.tarifamicro.business.model.Tarifa;
import com.viewnext.tarifamicro.business.service.CatalogoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/tarifa")
public class TarifaController {

	// SOLO MUESTRA LAS TARIFAS SIN APLICAR EL CATALOGO
	@GetMapping("/getAllTarifas")
	public ResponseEntity<List<Tarifa>> getAllTarifas() {
		ArrayList<Tarifa> lTarifas = new ArrayList<>(MapaTarifas.getTarifas().values());
		log.info("Mostrando " + lTarifas.size() + " tarifas.");
		return ResponseEntity.ok(lTarifas);
	}

	/**
	 * Recibe un json de catalogos, los actualiza con las tarifas del csv y luego
	 * retorna los catalogos ya actualizados con el precio y el tipo
	 * 
	 * @param lCatalogo
	 * @return Un ResponseEntity de una Lista de Catalogos con el tipo y el precio
	 *         de la tarifa aplicados
	 */
	@GetMapping("/getTarifas")
	public ResponseEntity<List<Catalogo>> getAll(@RequestBody List<Catalogo> lCatalogo) {
		List<Catalogo> lCatalogoProcesado = CatalogoService.processCatalogo(lCatalogo);
		log.info("Mostrando " + lCatalogoProcesado.size() + " tarifas.");
		return ResponseEntity.ok(lCatalogoProcesado);
	}

}
