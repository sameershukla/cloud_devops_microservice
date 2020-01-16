package com.example.demoservice.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ControllerTest {

	private Controller controllerSpy;
	
	@Before
	public void setUp() {
		controllerSpy = new Controller();
	}
	
	@Test
	public void testEndpoint() {
		assertEquals("Hello World", controllerSpy.endpoint());
	}
}
