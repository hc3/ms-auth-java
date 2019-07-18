package br.com.hc3.ms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ContainerTest.class)
@TestPropertySource(locations="classpath:application-test.properties")
@AutoConfigureMockMvc
public class ContainerTest {
	
	@Test
	public void contextLoads() { }
}
