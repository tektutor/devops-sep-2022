package org.tektutor;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class BusinessLayerTest {

	private String expectedOutput;
	private String actualOutput;
	private BusinessLayer bl;

	@Before
	public void init() {
		bl = new BusinessLayer();
	}

	@After
	public void cleanUp() {
		bl = null;
	}

	@Test
	public void testGetModuleName() {
		actualOutput = bl.getModuleName();
		expectedOutput = "BusinessLayer";

		assertEquals ( expectedOutput, actualOutput );
	}


}
