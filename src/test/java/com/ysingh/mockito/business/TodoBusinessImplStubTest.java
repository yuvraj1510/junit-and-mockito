package com.ysingh.mockito.business;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.ysingh.mockito.data.api.TodoService;
import com.ysingh.mockito.data.api.TodoServiceStub;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpring_usingAStub_sizeCheck() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAStub_contentCheck() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		String expected[] = {"Learn Spring MVC", "Learn Spring"};
		assertArrayEquals(expected, filteredTodos.toArray(new String[0]));
	}

}
