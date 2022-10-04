package com.ysingh.junit.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StringHelperTest {
	
	StringHelper helper = null;
	
	@Before
	public void setup() {
		helper = new StringHelper();
	}
	
	@Test
	public void testTruncateAInFirst2Positions_Ainfirst2Position() {
		assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions2_AinfirstPosition() {
		assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions2_Anotinfirst2Position() {
		assertEquals("CDEF", helper.truncateAInFirst2Positions("CDEF"));
	}
	
	@Test
	public void testTruncateAInFirst2Positions2_Ainlast2Position() {
		assertEquals("CDAA", helper.truncateAInFirst2Positions("CDAA"));
	}

	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegative() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositive() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_Exact2CharLengthString() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_Exact1CharLengthString() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("A"));
	}
}
