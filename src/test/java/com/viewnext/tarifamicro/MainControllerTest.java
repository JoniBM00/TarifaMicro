package com.viewnext.tarifamicro;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.viewnext.tarifamicro.business.model.Catalogo;
import com.viewnext.tarifamicro.business.service.TarifaService;
import com.viewnext.tarifamicro.presentation.MainController;

@WebMvcTest(controllers = MainController.class)
class MainControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@MockBean
	TarifaService tarifaService;

	private List<Catalogo> lCatalogoC;

	private List<Catalogo> lCatalogo;

	private Catalogo catalogoC1;
	private Catalogo catalogoC2;
	private Catalogo catalogoC3;
	private Catalogo catalogoC4;

	private Catalogo catalogo1;
	private Catalogo catalogo2;
	private Catalogo catalogo3;
	private Catalogo catalogo4;

	@BeforeEach
	public void init() {
		initMocks();
	}

	@Test
	void getAllTarifas() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/tarifa/getAllTarifas"));

		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(5)));
	}

	@Test
	void addCatalogos() throws Exception {
		MvcResult mvcResult = mockMvc
				.perform(post("/tarifa/addCatalogos").contentType("application/json")
						.content(new Gson().toJson(lCatalogo)).characterEncoding("utf-8"))
				.andExpect(status().isOk()).andReturn();
	}

	@Test
	void getAllCatalogos() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/tarifa/getAllCatalogos"));

		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.size()", is(0)));

	}

	/**
	 * 
	 * 
	 * PRIVATE METHODS
	 * 
	 * 
	 */

	public void initMocks() {
		TarifaService.readCsv();
		lCatalogo = new ArrayList<Catalogo>();
		lCatalogoC = new ArrayList<Catalogo>();

		catalogo1 = new Catalogo(55555L, "PENINSULA", 1, 1, 0, 55555L, "GT Alcatel Pixie 3");
		catalogo2 = new Catalogo(33333L, "PENINSULA", 5, 5, 0, 33333L, "samsung galaxy 3 3");
		catalogo3 = new Catalogo(11111L, "PENINSULA", 5, 5, 0, 11111L, "Samsung Galaxy 1");
		catalogo4 = new Catalogo(44444L, "PENINSULA", 5, 5, 0, 44444L, "Huawei Media Pag 11");

		lCatalogo.add(catalogo1);
		lCatalogo.add(catalogo2);
		lCatalogo.add(catalogo3);
		lCatalogo.add(catalogo4);

		catalogoC1 = new Catalogo(55555L, "PENINSULA", 1, 1, 0, 55555L, "GT Alcatel Pixie 3", "Enterprise", 99.99);
		catalogoC2 = new Catalogo(33333L, "PENINSULA", 5, 5, 0, 33333L, "samsung galaxy 3 3", "Avanzado", 29.99);
		catalogoC3 = new Catalogo(11111L, "PENINSULA", 5, 5, 0, 11111L, "Samsung Galaxy 1", "Básico", 9.99);
		catalogoC4 = new Catalogo(44444L, "PENINSULA", 5, 5, 0, 44444L, "Huawei Media Pag 11", "Pro", 49.99);

		lCatalogo.add(catalogoC1);
		lCatalogo.add(catalogoC2);
		lCatalogo.add(catalogoC3);
		lCatalogo.add(catalogoC4);

	}

}
