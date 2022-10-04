package com.ysingh.junit.helper;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ StringHelperBooleanParameterizedTest.class, StringHelperParameterizedTest.class,
		StringHelperTest.class })
public class StringHelperTests {

}
