package com.ysingh.mockito.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.Test;


public class ListBDDMockTest {

	@Test
	public void testListGetMethod_usingABDDMock_ArgumentMatcher() {
		//Given
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("ysingh");
		
		//When
		String firstElement = listMock.get(0);
		
		//Then
		assertThat(firstElement, is("ysingh"));
	}
	
}
