package org.danika.DanikaDB;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.danika.DanikaDB.model.Producto;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;




@SpringBootTest
@AutoConfigureMockMvc
class EcommercedbApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@Disabled("Deshabilitado temporalmente")
	public void pruebaPost() throws Exception {
		Producto p = new Producto();
		p.setNombre("Taller prueba");
		p.setDescripcion("Taller para prueba mockito");
		p.setURL_imagen("taller.jpg");
		p.setPrecio(650);
		p.setCategoria("Taller");
		
		this.mockMvc.perform( post("/api/productos/")//.header("Authorization", "Bearer ")
			.contentType(MediaType.APPLICATION_JSON)
			.content(asJsonString(p))).andExpect(status().isOk());
	}//pruebaPost
	
	public static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
 } // asJsonString


	
	
	@Test
	@Disabled ("Desabilitado temporalmente")

	public void pruebaGets() throws Exception {
		
		this.mockMvc.perform(get("/api/productos/4"))
		.andDo(print()) 
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Psicoterapia de pareja")));
		
				
	}//pruebaGets
	
	@Test
	@Disabled ("Desabilitado temporalmente")
	public void pruebaPut() throws Exception {
		
		
		this.mockMvc.perform(put("/api/productos/4").queryParam("nombre", "Taller prueba put")
				.header("Authorization", "Bearer "))
				.andDo(print()) 
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Taller prueba put")));
				
	}//pruebaPut
	
	@Test
	//@Disabled ("Desabilitado temporalmente")
	public void pruebaDelete() throws Exception {
		
		this.mockMvc.perform(delete("/api/productos/4").header("Authorization", "Bearer "))
		.andDo(print()) 
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Taller prueba put")));
			
	}//pruebaDelete
	
	
	
	
	@Test
	@Disabled("Deshabilitado temporalmente")
	public void prueba404() throws Exception {
		this.mockMvc.perform(get("/api/producto/20"))
		.andExpect(status().isNotFound());
	}//prueba404
	
	@Test
	@Disabled ("Desabilitado temporalmente")
	public void prueba500() throws Exception {
		this.mockMvc.perform(get("/api/producto/2"))
		.andExpect(status().isInternalServerError());
	}//prueba500

}//class
