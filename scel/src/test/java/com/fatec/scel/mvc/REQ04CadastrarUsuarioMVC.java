package com.fatec.scel.mvc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.ModelResultMatchers;
import org.springframework.test.web.servlet.result.ViewResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class REQ04CadastrarUsuarioMVC {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void status0() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/cadastrar"));
		resultActions.andExpect(MockMvcResultMatchers.status().isOk());
		resultActions.andExpect(MockMvcResultMatchers.status().is(200));
	}

	@Test
	public void verificaView0() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/cadastrar"));
		ViewResultMatchers view = MockMvcResultMatchers.view();
		resultActions.andExpect(view.name("CadastrarUsuario"));
	}

	@Test // verifica o model
	public void verificaModel0() throws Exception {
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/cadastrar"));
		ModelResultMatchers model = MockMvcResultMatchers.model();
		resultActions.andExpect(model.attributeExists("usuario"));
	}

}
