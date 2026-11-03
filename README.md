# SQE GradeBook

**SQE GradeBook** is a Java-based project developed for the Software Quality Engineering (SQE) course. It provides basic student grade management functionality and serves as a practical project for applying software quality engineering concepts, testing techniques, and defect management practices.

## Project Objectives

- Manage student records and scores.
- Calculate total and average scores.
- Assign letter grades based on student scores.
- Validate student information and score inputs.
- Apply software testing techniques to improve software quality.
- Document defects, test cases, and test results.

## Technologies Used

- **Programming Language:** Java
- **Java Version:** JDK 17 or later
- **Testing Framework:** JUnit 5
- **Mocking Framework:** Mockito
- **Version Control:** Git
- **Repository Hosting:** GitHub
- **IDE:** Visual Studio Code / IntelliJ IDEA

## Project Structure

```text
sqe-gradebook/
│
├── .github/
│   ├── ISSUE_TEMPLATE/
│   └── pull_request_template.md
│
├── docs/
│   ├── test-plan.md
│   ├── test-cases.md
│   ├── rtm.md
│   ├── ep-analysis.md
│   ├── bva-analysis.md
│   ├── triage-log.md
│   ├── unit-testing-notes.md
│   └── workflow-notes.md
│
├── src/
│   └── gradebook/
│       ├── GradeBook.java
│       ├── Student.java
│       ├── Roster.java
│       ├── GradeBookFileWriter.java
│       ├── DefaultGradeBookFileWriter.java
│       └── GradeBookIOError.java
│
├── tests/
│   ├── TestAddScoreParameterized.java
│   ├── TestClassAverage.java
│   ├── TestLetterGrade.java
│   ├── TestNameLengthBVA.java
│   ├── TestSaveToFile.java
│   ├── TestScoreCount.java
│   ├── TestScoreCountBVA.java
│   ├── TestValidateName.java
│   └── testLetterGradeBVA.java
│
├── .gitignore
├── CONTRIBUTING.md
├── LICENSE
└── README.md
```

## Getting Started

### Prerequisites

Before working with this project, make sure you have:

- Java Development Kit (JDK) 17 or later.
- Git installed on your system.
- Visual Studio Code or IntelliJ IDEA.
- JUnit 5 standalone console launcher for running tests.

### Clone the Repository

```bash
git clone https://github.com/tanveer3351/sqe-gradebook.git
```

Navigate to the project directory:

```bash
cd sqe-gradebook
```

## Running Tests

This project uses JUnit 5 for unit testing.

The JUnit standalone console launcher can be used to execute the test classes.

After compiling the source and test classes into the appropriate output directory, run:

```bash
java -jar lib/junit-platform-console-standalone-1.10.2.jar execute --class-path out --scan-class-path
```

The command scans the compiled classes and executes the discovered JUnit tests.

## Software Quality Engineering Practices

The project demonstrates the following SQE concepts:

| Lab | Topic |
|---|---|
| Lab 1 | GitHub Repository and SQE Setup |
| Lab 2 | Git Branching and Pull Requests |
| Lab 3 | Defect Management |
| Lab 4 | Test Planning |
| Lab 5 | Equivalence Partitioning |
| Lab 6 | Boundary Value Analysis |
| Lab 7 | Unit Testing |
| Lab 8 | Test-Driven Development |
| Lab 9 | Code Review |

## Documentation

The `docs/` directory contains project documentation, including:

- **Test Plan:** Defines the testing scope, objectives, and approach.
- **Test Cases:** Documents test scenarios and expected results.
- **Requirements Traceability Matrix (RTM):** Maps requirements to test cases.
- **Equivalence Partitioning:** Documents valid and invalid input classes.
- **Boundary Value Analysis:** Identifies and tests boundary conditions.
- **Triage Log:** Records identified defects and their status.
- **Unit Testing Notes:** Documents unit testing activities and execution.
- **Workflow Notes:** Describes the GitHub-based development workflow.

## GitHub Workflow

The project uses Git and GitHub to manage development activities.

The general workflow is:

1. Create or select a GitHub issue.
2. Create a separate branch for the task.
3. Implement the required changes.
4. Test the changes.
5. Create a Pull Request.
6. Review the changes.
7. Merge the approved Pull Request.

## Contribution

Contributions and improvements are managed through GitHub issues, branches, and pull requests.

Please read [CONTRIBUTING.md](CONTRIBUTING.md) before contributing.

## License

This project is available under the license specified in the [LICENSE](LICENSE) file.

---

**Developed as part of the Software Quality Engineering (SQE) course.**