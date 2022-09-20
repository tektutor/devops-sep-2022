package org.tektutor;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class HelloTest {

	private Hello hello;
	private String actualOutput;
	private String expectedOutput;

	@Before
	public void init() {
		hello = new Hello();
	}

	@After
	public void cleanUp() {
		hello = null;
	}

	@Test
	public void testSayHello() {
		actualOutput = hello.sayHello();
		expectedOutput = "Hello Maven !";

		assertEquals ( expectedOutput, actualOutput );	
	}

}
