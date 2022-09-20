package org.tektutor;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class FrontendTest {

	private String expectedOutput;
	private String actualOutput;
	private Frontend fe;

	@Before
	public void init() {
		fe = new Frontend();
	}

	@After
	public void cleanUp() {
		fe = null;
	}

	@Test
	public void testGetModuleName() {
		actualOutput = fe.getModuleName();
		expectedOutput = "Frontend";

		assertEquals ( expectedOutput, actualOutput );
	}


}
