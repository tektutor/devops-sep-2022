package org.tektutor;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class DataAccessLayerTest {

	private String expectedOutput;
	private String actualOutput;
	private DataAccessLayer dal;

	@Before
	public void init() {
		dal = new DataAccessLayer();
	}

	@After
	public void cleanUp() {
		dal = null;
	}

	@Test
	public void testGetModuleName() {
		actualOutput = dal.getModuleName();
		expectedOutput = "DataAccessLayer";

		assertEquals ( expectedOutput, actualOutput );
	}


}
