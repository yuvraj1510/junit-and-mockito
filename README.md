# JUnit and Mockito

## JUnit
JUnit is a unit testing open-source framework for the Java programming language. Java Developers use this framework to write and execute automated tests. In Java, there are test cases that have to be re-executed every time a new code is added. This is done to make sure that nothing in the code is broken.

### Basic JUnit annotation and methods:
* **@Test** - To represent a method/function as test case.
* **assertEquals** - Compare two object if they are equal.
* **assertTrue** - Asserts that a condition is true.
* **assertFalse** - Asserts that a condition is false.
* **@Before** - When writing tests, it is common to find that several tests need similarobjects created before they can run. Annotating a public void method with @Before causes that method to be run before the Test method.
* **@After** - If you allocate external resources in a Before method you need to release them after the test runs. Annotating a public void method with @After causes that method to be run after the Test method.
* **@BeforeClass** - Sometimes several tests need to share computationally expensive setup(like logging into a database). While this can compromise the independence oftests, sometimes it is a necessary optimization. Annotating a public static void no-arg method with @BeforeClass causes it to be run once before any ofthe test methods in the class.
* **@AfterClass** - If you allocate expensive external resources in a BeforeClass method you need to release them after all the tests in the class have run. Annotating a public static void methodwith @AfterClass causes that method to be run after all the tests in the class have been run. All @AfterClassmethods are guaranteed to run even if a BeforeClass method throws anexception.
* **@assertArrayEquals** - Asserts that two arrays are equal.
* **@Test(expected=\<? extends Throwable\>)** - Optionally specify expected, a Throwable, to cause a test method to succeed if and only if an exception of the specified class is thrown by the method.
* **@Test(timeout = \<long\>)** - Optionally specify timeout in milliseconds to cause a test method to fail if it takes longer than that number of milliseconds. 

### Parameterized Tests Steps:
* Annotate the class with **@RunWith(Parameterized.class)**.
```
@RunWith(Parameterized.class)
public class StringHelperParameterizedTest {}
```
* Add a static method having all the conditions and annotate with **@Parameters**:
```
@Parameters
public static Collection<String[]> testConditions() {
	String expectedOutputs[][] = { { "AACD", "CD" }, { "ACD", "CD" }, { "CDEF", "CDEF" }, { "CDAA", "CDAA" } };
	return Arrays.asList(expectedOutputs);
}
```
* Create the instance variable and constructor to set the instance variables.
```
private String input;
private String expectedOutput;

public StringHelperParameterizedTest(String input, String expectedOutput) {
	this.input = input;
	this.expectedOutput = expectedOutput;
}
```
* Now use the instance variables in the Tests.
```
@Test
public void testTruncateAInFirst2Positions() {
	assertEquals(expectedOutput, helper.truncateAInFirst2Positions(input));
}
```
### Organize JUnits into Suites:
* Create a new class and Annotate with **@RunWith(Suite.class)** and **@SuiteClasses({ test1.class, test2.class, test3.class})** - add all the Tests classes in the SuiteClasses array.
```
@RunWith(Suite.class)
@SuiteClasses({ StringHelperBooleanParameterizedTest.class, StringHelperParameterizedTest.class,
		StringHelperTest.class })
public class StringHelperTests {

}
```

## Mockito
Mockito is an open source testing framework for Java. The framework allows the creation of test double objects in automated unit tests for the purpose of test-driven development or behavior-driven development.

### Maven Dependency:
```
<dependency>
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.12</version>
	<scope>test</scope>
</dependency>
<dependency>
	<groupId>org.mockito</groupId>
	<artifactId>mockito-all</artifactId>
	<version>1.10.19</version>
	<scope>test</scope>
</dependency>
```
### Basic Mockito methods:
* **mock(Class<?> theClass)** - Creates mock object of given class or interface.
```
TodoService todoServiceMock = mock(TodoService.class);
``` 
* **when(\<Method to mock\>).thenReturn(\<Returned mock values\>)** - Enables stubbing methods. Use it when you want the mock to return particular value when particular method is called.
```
List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
```
* **anyInt()** - Any int, Integer or null.
```
List listMock = mock(List.class);
when(listMock.get(anyInt())).thenReturn("ysingh");
``` 
* **when(\<Method to mock\>).thenThrow(\<Returned Exception\>)** - Sets Throwable objects to be thrown when the method is called.
```
List listMock = mock(List.class);
when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something failed!!!"));
```
* Mockito doesn't allowed combination of Matchers and hardcoded values.
```
when(listMock.subList(anyInt(), 5)) //Invalid
```
* **assertThat** - Asserts that actual satisfies the condition specified by matcher.
```
assertThat(filteredTodos.size(), is(2));
```
* **verify()** - Verifies certain behavior happened.
```
verify(todoServiceMock).deleteTodo("Learn to Dance");
```
* **never()** - Verifies that interaction did not happen.
```
verify(todoServiceMock, never()).deleteTodo("Learn to Dance");
```
* **times()** - Allows verifying exact number of invocations.
```
verify(todoServiceMock, times(1)).deleteTodo("Learn to Dance");
```

### BDD Style methods:
* **given(\<Method to mock\>).willReturn(\<Returned mock values\>)**
```
List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
```
* **then()/should()** - Bdd style verification of mock behavior
```
then(todoServiceMock).should().deleteTodo("Learn to Dance");
then(todoServiceMock).should(never()).deleteTodo("Learn Spring");
then(todoServiceMock).should(times(1)).deleteTodo("Learn to Dance");
```

### Argument Capture:
* Declare Argument Captor
```
ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
```
* Capture the Argument on the method
```
then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());
```
* Verify the Captured values
```
assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));
```


