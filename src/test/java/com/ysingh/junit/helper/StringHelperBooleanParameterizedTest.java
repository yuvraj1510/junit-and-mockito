package com.ysingh.junit.helper;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StringHelperBooleanParameterizedTest {
	
	StringHelper helper = new StringHelper();
	
	private String input;
	private boolean expectedOutput;
	
	public StringHelperBooleanParameterizedTest(String input, boolean expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}

	@Parameters
	public static Collection<Object[]> testConditions() {
		Object expectedOutputs[][] = { { "ABCD", false }, { "ABAB", true }, { "AB", true }, { "A", false } };
		return Arrays.asList(expectedOutputs);
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame() {
		assertEquals(expectedOutput, helper.areFirstAndLastTwoCharactersTheSame(input));
	}
}
