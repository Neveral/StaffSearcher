package com.solanteq;

import com.solanteq.controller.EmployeeController;
import com.solanteq.model.Employee;
import com.solanteq.repository.JdbcEmployeeRepository;
import com.solanteq.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class StaffManagerApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeService employeeService;


	@Test
	public void testReturnedStatus() throws Exception {
		this.mvc.perform(get("/employees").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void testForBadParameters() throws Exception {
		this.mvc.perform(get("/employees?firstName=1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError());
	}

	@Test
	public void testForGoodParameters() throws Exception {
		this.mvc.perform(get("/employees?firstName=ivan&lastName=ivaniv&middleName=ivanovich&position=chief&birthday=1994-10-03").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is2xxSuccessful());
	}
}
