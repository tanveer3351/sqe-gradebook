# GradeBook Test Plan

## 1. Introduction

The purpose of this test plan is to verify the functionality and reliability of the GradeBook module. Testing will focus on student management, score management, score calculation, validation, and boundary conditions. The test plan follows an IEEE 829-style structure.

## 2. Test Items

The following GradeBook components will be tested:

- Student class
- GradeBook class
- addScore()
- addStudent()
- sumScores()
- avgScores()
- Score validation
- Duplicate roll number validation

## 3. Features to be Tested

The following features will be tested:

- Adding valid scores
- Rejecting negative scores
- Handling invalid score input
- Calculating total scores
- Calculating average scores
- Handling empty score lists
- Handling a single score
- Rejecting duplicate roll numbers
- Score boundary values such as 0 and 100
- Student name comparison
- Grade-letter conversion

## 4. Features Not to be Tested

Graphical user interface testing is out of scope because the current GradeBook is a Java library/module without a graphical user interface. Performance testing and database testing are also excluded because the current implementation does not use a database or external services.

## 5. Test Approach

Testing will be performed manually using the current Java GradeBook code. Positive, negative, boundary, functional, and regression-oriented test cases will be used. Each test case will have clear preconditions, steps, and expected results.

## 6. Pass/Fail Criteria

Testing will be considered successful if at least 95% of the planned test cases pass and there are zero Critical defects remaining open. Any failed test must be investigated and documented through a GitHub Issue.

## 7. Test Deliverables

The test deliverables are:

- Test Plan
- 12 Test Cases
- Requirements Traceability Matrix
- Test execution results
- GitHub Issues for identified defects

## 8. Environmental Needs

Testing will be performed using:

- Windows operating system
- Java Development Kit (JDK)
- Visual Studio Code
- Git
- GitHub
- GradeBook source code

## 9. Schedule

The planned testing activities are:

- Test Plan preparation
- Test case preparation
- Requirements traceability
- Manual test execution
- Defect reporting

## 10. Risks

Potential risks include incorrect expected results, incomplete requirements, missing GradeBook functionality, and defects discovered during execution. Tests for functionality that is not implemented may be marked Blocked rather than incorrectly marked as Passed.
