package com.viewnext.tarifamicro.presentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.tarifamicro.business.model.Catalogo;
import com.viewnext.tarifamicro.business.model.MapaCatalogos;
import com.viewnext.tarifamicro.business.model.MapaTarifas;
import com.viewnext.tarifamicro.business.model.Tarifa;
import com.viewnext.tarifamicro.business.service.CatalogoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/tarifa")
public class MainController {

	private static final String MOSTRANDO = "Mostrando ";

	/**
	 * Muestra las tarifas sin aplicar el catalogo
	 * 
	 * @return Un ResponseEntity de una lista de tarifas
	 */
	@GetMapping("/getAllTarifas")
	public ResponseEntity<List<Tarifa>> getAllTarifas() {
		ArrayList<Tarifa> lTarifas = new ArrayList<>(MapaTarifas.getTarifas().values());
		log.info(MOSTRANDO + lTarifas.size() + " tarifas.");
		return ResponseEntity.ok(lTarifas);
	}

	@GetMapping("/getAllCatalogos")
	public ResponseEntity<List<Catalogo>> getAllCatalogos() {
		ArrayList<Catalogo> lCatalogos = new ArrayList<>(MapaCatalogos.getCatalogos().values());
		log.info(MOSTRANDO + lCatalogos.size() + " catalogos.");
		return ResponseEntity.ok(lCatalogos);
	}

	/**
	 * Recibe un json de catalogos, los actualiza con las tarifas del csv y luego
	 * retorna los catalogos ya actualizados con el precio y el tipo
	 * 
	 * @param lCatalogo
	 * @return Un ResponseEntity de una Lista de Catalogos con el tipo y el precio
	 *         de la tarifa aplicados
	 */
	@PostMapping("/addCatalogos")
	public ResponseEntity<List<Catalogo>> addCatalogos(@RequestBody List<Catalogo> lCatalogo) {

		List<Catalogo> lCatalogoProcesado = CatalogoService.processAndAddCatalogo(lCatalogo);
		log.info(MOSTRANDO + lCatalogoProcesado.size() + " catalogos.");
		return ResponseEntity.ok(lCatalogoProcesado);
	}

}
