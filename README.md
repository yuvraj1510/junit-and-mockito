# JUnit and Mockito
## JUnit
JUnit is a unit testing open-source framework for the Java programming language. Java Developers use this framework to write and execute automated tests. In Java, there are test cases that have to be re-executed every time a new code is added. This is done to make sure that nothing in the code is broken.

### Basic JUnit annotation
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

### Parameterized Tests Steps
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
### Organize JUnits into Suites
* Create a new class and Annotate with **@RunWith(Suite.class)** and **@SuiteClasses({ test1.class, test2.class, test3.class})** - add all the Tests classes in the SuiteClasses array.
```
@RunWith(Suite.class)
@SuiteClasses({ StringHelperBooleanParameterizedTest.class, StringHelperParameterizedTest.class,
		StringHelperTest.class })
public class StringHelperTests {

}
```