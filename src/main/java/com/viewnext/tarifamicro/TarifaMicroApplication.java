package com.viewnext.tarifamicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viewnext.tarifamicro.business.service.TarifaService;

@SpringBootApplication
public class TarifaMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarifaMicroApplication.class, args);
		TarifaService.readCsv(); // Lee 1 vez el csv de tarifas
	}

}
