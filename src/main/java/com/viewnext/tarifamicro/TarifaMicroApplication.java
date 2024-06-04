package com.viewnext.tarifamicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.viewnext.tarifamicro.business.service.TarifaService;

@SpringBootApplication
@EnableDiscoveryClient
public class TarifaMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarifaMicroApplication.class, args);
		TarifaService.readCsv(); // Lee 1 vez el csv de tarifas
	}

}
