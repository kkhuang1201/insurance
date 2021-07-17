package com.accenture.controllerTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CalendarControllerTest extends AbstractControllerTest {
	
	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	@Test
	public void testGetToken() throws Exception{
		
		String uri = "/insurance/calendars/refresh-token";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		assertEquals(200,status);
		assertTrue(content != null);	
	}
	
	@Test
	public void getCalendar() throws Exception{
		
		String uri = "/insurance/calendars/calendar";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200,status);
		
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content != null);	
	}
	
	@Test
	public void getEvents() throws Exception{
		
		String uri = "/insurance/calendars/events";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200,status);
		
		String content = mvcResult.getResponse().getContentAsString();
		assertTrue(content!=null);	
	}
	

}
