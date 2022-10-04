package com.ysingh.mockito.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;


public class ListMockTest {

	@Test
	public void testListSize_usingAMock() {
		List<?> listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);
		assertEquals(2, listMock.size());
	}

	@Test
	public void testListSize_usingAMock_ReturnMultipleValues() {
		List<?> listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}
	
	@Test
	public void testListGetMethod_usingAMock() {
		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("ysingh");
		assertEquals("ysingh", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}
	
	@Test
	public void testListGetMethod_usingAMock_ArgumentMatcher() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenReturn("ysingh");
		assertEquals("ysingh", listMock.get(0));
		assertEquals("ysingh", listMock.get(1));
	}
	
	@Test(expected = RuntimeException.class)
	public void testListGetMethod_usingAMock_ThrowException() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something failed!!!"));
		listMock.get(0);
	}
	
	@Test(expected = RuntimeException.class)
	public void testListGetMethod_usingAMock_Mixing_Matchers_And_HardCoded() {
		List listMock = mock(List.class);
		when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something failed!!!"));
		listMock.get(0);
	}
}
