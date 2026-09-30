# Unit Testing Notes

## Task 5 — Test Output Comparison

This project uses Java with JUnit 5. The JUnit Console Launcher is used to execute the test suite.

### 1. Detailed Test Output

Command used:

```text
java -jar lib\junit-platform-console-standalone-1.10.2.jar execute --class-path out --scan-class-path
```

The detailed output displays the test classes, individual test methods, and their execution status.

**When to use:**
Detailed output is useful during development and debugging because it helps identify exactly which test case passed or failed.

### 2. Short Test Output

The JUnit test summary provides a concise overview of the test execution, including the number of tests found, started, successful, and failed.

Example summary:

```text
Test run finished
[ tests found ]
[ tests started ]
[ tests successful ]
[ tests failed ]
```

**When to use:**
Short output is useful for quickly checking the overall result of the test suite and is suitable for CI environments where the main requirement is to determine whether the tests passed or failed.

### 3. Comparison

Detailed output provides more information about individual test cases and is preferred when investigating failures.

Short output provides a quick summary of the overall test result and is preferred for routine verification and continuous integration.

### 4. Test Naming Convention

The project follows a consistent Java test-class naming convention using the `Test` prefix, for example:

* `TestClassAverage.java`
* `TestSaveToFile.java`
* `TestScoreCount.java`
* `TestAddScoreParameterized.java`

This makes test classes easy to identify and maintain.

### Conclusion

Using consistent test execution and naming practices improves the maintainability of the test suite and makes the project easier to integrate with a CI pipeline.
