package unitTest;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class ProductsTest extends startUnitTest{
@Autowired
WebApplicationContext webApplicationContex;
private MockMvc mockMvc;
@Before
public void setup() {
	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContex).build();
	
}
	@Test
	public void testProducts() throws Exception {
		mockMvc.perform(get("/products")).andExpect(status().isOk());
		//.andExpect(jsonPath("$.prodName").value("coffe"));
				
	}

}
