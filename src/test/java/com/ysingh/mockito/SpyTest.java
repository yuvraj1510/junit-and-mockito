package com.ysingh.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
		List arrayListSpy = spy(ArrayList.class);
		assertEquals(0, arrayListSpy.size());
		arrayListSpy.add("Dummy");
		assertEquals(1, arrayListSpy.size());
		arrayListSpy.remove("Dummy");
		assertEquals(0, arrayListSpy.size());
	}

}
