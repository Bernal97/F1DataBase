package com.app.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.web.entity.Persona;
import com.app.web.repository.PersonaRepository;
import com.app.web.service.PersonaServiceImpl;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class CruDconSql1ApplicationTests {

	
	private static PersonaRepository dbUtility;
	
	@Mock
	private PersonaServiceImpl servicio;
	
	private static Persona per1 = new Persona("mick", "schumacher", false);
	private static Persona per2 = new Persona("sebastian", "vettel", true);

	
	@Test
	void contextLoads() {
	}

}
