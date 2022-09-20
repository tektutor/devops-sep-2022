package org.tektutor;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class MainTest {

	private String expectedOutput;
	private String actualOutput;
	private Main mainObj;

	@Before
	public void init() {
		mainObj = new Main();
	}

	@After
	public void cleanUp() {
		mainObj = null;
	}

	@Test
	public void testGetModuleName() {
		actualOutput = mainObj.getModuleName();
		expectedOutput = "Main";

		assertEquals ( expectedOutput, actualOutput );
	}


}
