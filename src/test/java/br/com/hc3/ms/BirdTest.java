package br.com.hc3.ms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBootWebApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
public class BirdTest {

	@Autowired
	private MockMvc mock;

	@Test
	public void createBirdSucess() throws Exception {
		MvcResult result = mock.perform( MockMvcRequestBuilders.get("/v1/bird")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		String content = result.getResponse().getContentAsString();
		
		System.out.println("CONTEUDO DO REQUEST: "+content);
	}
}
