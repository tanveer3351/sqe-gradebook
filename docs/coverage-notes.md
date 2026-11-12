# Lab 11 – Automated Test Coverage

## Task 1: Measure Baseline Test Coverage

### 1. Objective

The objective of this task is to measure the existing test coverage of the Java GradeBook application using JaCoCo. The baseline report helps identify how much of the application code is executed by the existing JUnit test cases.

### 2. Tools and Technologies

- Java 21
- JUnit 5
- JaCoCo 0.8.13
- VS Code
- PowerShell

### 3. Procedure

**Step 1: Execute the existing JUnit test suite with JaCoCo.**

Command used:

```powershell
java -javaagent:lib/org.jacoco.agent-0.8.13-runtime.jar=destfile=coverage.exec,append=false -cp "out;lib/*" org.junit.platform.console.ConsoleLauncher execute --scan-class-path
```

**Result:** All 36 JUnit tests passed successfully, with zero failures. JaCoCo generated the `coverage.exec` execution data file.

**Step 2: Generate the initial HTML coverage report.**

```powershell
java -jar lib/org.jacoco.cli-0.8.13-nodeps.jar report coverage.exec --classfiles out --sourcefiles src --html coverage-report --name "Java GradeBook Coverage"
```

**Step 3: Generate the application-only coverage report.**

```powershell
java -jar lib/org.jacoco.cli-0.8.13-nodeps.jar report coverage.exec --classfiles out/gradebook --sourcefiles src/gradebook --html coverage-report-app --name "GradeBook Application Coverage"
```

The application-only report was used for the baseline analysis to exclude test classes from the application coverage results.

### 4. Baseline Coverage Results

| Metric | Total | Missed | Coverage |
|---|---:|---:|---:|
| Instructions | 441 | 63 | 85.71% |
| Lines | 119 | 18 | 84.87% |
| Branches | 58 | 8 | 86.21% |

Additional information:
- Application classes: 5
- Successful tests: 36
- Failed tests: 0


### 4.1 Individual Class Coverage Summary

The JaCoCo report was also inspected at the individual class level to understand how effectively each Java source file was tested.

| Java Class | Instruction Coverage | Branch Coverage | Line Coverage |
|---|---:|---:|---:|
| GradeBook | 89% | 88% | 90.24% |
| Student | 69% | 50% | 55.56% |
| DefaultGradeBookFileWriter | 23% | N/A | 33.33% |
| Roster | 94% | 100% | 92.86% |
| GradeBookIOError | 100% | N/A | 100% |

**Observation:** The results show that coverage varies between individual classes. DefaultGradeBookFileWriter and Student have comparatively low coverage and require further investigation.

### 5. Analysis

The baseline report shows that approximately 84.87% of executable application lines are covered by the existing tests. Branch coverage is approximately 86.21%.

Although the existing tests cover most of the application code, 18 lines and 8 branches remain uncovered. These gaps indicate that some statements and conditional paths are not exercised by the current test suite.

Additional test cases will be required to improve coverage.

### 6. Conclusion

The baseline coverage of the Java GradeBook application was successfully measured using JaCoCo. The initial line coverage is 84.87%, and branch coverage is 86.21%.

These results will be used as a reference to identify testing gaps and measure improvements in the upcoming tasks.

### 7. Evidence

1. `task1-junit-results.png` – Terminal screenshot showing 36 successful JUnit tests.
2. `task1-baseline-coverage.png` – JaCoCo application-only HTML report showing baseline coverage results.


## Task 2: Identify Weak Coverage Areas

### Objective

Analyze the baseline JaCoCo report to identify three application classes with weak coverage. Inspect their methods, uncovered lines, and conditional branches to determine where additional tests are required.

### Finding 1: DefaultGradeBookFileWriter.java

**Observed coverage:**
- Instruction coverage: 23%
- Line coverage: 33.33%
- Missed executable lines: 2 out of 3
- Branch coverage: N/A

**Analysis:**

The existing `TestSaveToFile` class uses Mockito to mock the `GradeBookFileWriter` interface. It verifies that `GradeBook` calls the writer with the expected filename and content and tests exception handling.

However, these tests do not execute the actual `DefaultGradeBookFileWriter.write()` implementation.

The real implementation uses `Path.of()` and `Files.writeString()` to write content to a file.

**Identified gap:**

Actual file creation and content writing are not adequately tested.

**Proposed improvement:**

Add a JUnit test using a temporary file and the real `DefaultGradeBookFileWriter`. Verify that the file is created and contains the expected content.

### Finding 2: Student.java

**Observed coverage:**
- Instruction coverage: 69%
- Line coverage: 55.56%
- Branch coverage: 50%
- Missed executable lines: 8 out of 18

**Analysis:**

The method-level JaCoCo report identified the following weak methods:

| Method | Instruction Coverage | Branch Coverage |
|---|---:|---:|
| setName() | 0% | N/A |
| setRollNo() | 0% | N/A |
| clearScores() | 0% | N/A |
| addScore() | 75% | 50% |

The existing score-related tests mainly call `GradeBook.addScore()` rather than directly testing `Student.addScore()`.

**Identified gaps:**

- No test verifies updating a student's name using `setName()`.
- No test verifies updating a student's roll number using `setRollNo()`.
- No test verifies removing scores using `clearScores()`.
- Direct score validation in `Student.addScore()` has incomplete branch coverage.

**Proposed improvement:**

Create focused JUnit tests for the setters, score-clearing operation, and remaining score-validation branches.

### Finding 3: GradeBook.java

**Observed coverage:**
- Instruction coverage: 89%
- Line coverage: 90.24%
- Branch coverage: 88%
- Missed executable lines: 8 out of 82

**Analysis:**

The method-level JaCoCo report identified these weak methods:

| Method | Instruction Coverage | Branch Coverage |
|---|---:|---:|
| addStudent() | 39% | 33% |
| getStudents() | 0% | N/A |
| avgScores() | 91% | 50% |
| addScore() | 86% | 83% |

The existing tests call `addStudent()` during test setup, but they do not specifically verify its validation behavior.

**Identified gaps:**

- `addStudent()` needs dedicated tests for null input, duplicate roll numbers, and successful registration.
- `getStudents()` has no test directly verifying its returned student list.
- `avgScores()` has incomplete branch coverage.
- `addScore()` has one uncovered branch outcome according to JaCoCo.

**Proposed improvement:**

Add focused tests for student registration, retrieving registered students, empty/non-empty score averages, and the remaining uncovered score-validation branch.

### Task 2 Conclusion

The baseline coverage analysis identified three classes requiring additional testing: `DefaultGradeBookFileWriter`, `Student`, and `GradeBook`.

The analysis also demonstrated that executing a method indirectly during test setup does not necessarily verify its expected behavior. Additional tests should target uncovered lines, conditional branches, and important error-handling paths.

These findings will guide the test improvements in Task 3.
