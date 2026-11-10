# SQE GradeBook

SQE GradeBook is a Java-based student grade management project developed as part of the **Software Quality Engineering (SQE)** course. The project focuses on managing student information and scores while applying software quality engineering practices, testing techniques, and defect management.

## Project Objectives

- Manage student records and scores.
- Calculate student and class averages.
- Assign letter grades.
- Validate student information and score inputs.
- Apply software testing techniques.
- Identify, document, and manage software defects.
- Use Git and GitHub for version control and collaboration.

## Technologies Used

| Technology | Purpose |
|---|---|
| Java | Application development |
| JUnit 5 | Unit testing |
| Mockito | Mocking dependencies during testing |
| Git | Version control |
| GitHub | Repository hosting and collaboration |
| GitHub Actions | Automated test workflow |

## Project Structure

```text
sqe-gradebook/
│
├── .github/
│   ├── ISSUE_TEMPLATE/
│   │   ├── bug_report.md
│   │   └── feature_request.md
│   ├── workflows/
│   │   └── java-tests.yml
│   └── pull_request_template.md
│
├── docs/
│   ├── bva-analysis.md
│   ├── ep-analysis.md
│   ├── rtm.md
│   ├── test-cases.md
│   ├── test-plan.md
│   ├── triage-log.md
│   ├── unit-testing-notes.md
│   └── workflow-notes.md
│
├── lib/
│   ├── junit-platform-console-standalone-1.10.2.jar
│   ├── mockito-core-5.18.0.jar
│   ├── byte-buddy-1.15.11.jar
│   ├── byte-buddy-agent-1.15.11.jar
│   └── objenesis-3.3.jar
│
├── src/
│   └── gradebook/
│       ├── DefaultGradeBookFileWriter.java
│       ├── GradeBook.java
│       ├── GradeBookFileWriter.java
│       ├── GradeBookIOError.java
│       ├── Roster.java
│       └── Student.java
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
├── README.md
└── requirements.txt
```

**Note:** `out/` contains compiled output and is not included in the project source structure above.

## Prerequisites

- Java Development Kit (JDK) 21 or compatible version.
- Git.
- Visual Studio Code or IntelliJ IDEA.

JUnit 5 and Mockito dependencies are included in the `lib/` directory.

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/tanveer3351/sqe-gradebook.git
```

### 2. Open the Project Directory

```bash
cd sqe-gradebook
```

### 3. Compile the Source and Test Files

On Windows PowerShell:

```powershell
javac -d out -cp "lib/*" src/gradebook/*.java tests/*.java
```

### 4. Run the Unit Tests

```powershell
java -jar lib/junit-platform-console-standalone-1.10.2.jar execute --class-path "out;lib/mockito-core-5.18.0.jar;lib/byte-buddy-1.15.11.jar;lib/byte-buddy-agent-1.15.11.jar;lib/objenesis-3.3.jar" --scan-class-path
```

The JUnit console launcher discovers and executes the compiled test classes.

## Software Quality Engineering Practices

This project applies the following SQE concepts:

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

The `docs/` directory contains project documentation:

- **Test Plan:** Defines testing objectives, scope, and approach.
- **Test Cases:** Documents test scenarios and expected results.
- **RTM:** Maps requirements to corresponding test cases.
- **Equivalence Partitioning:** Documents input partitions.
- **Boundary Value Analysis:** Documents boundary conditions and test cases.
- **Triage Log:** Records defects and their management.
- **Unit Testing Notes:** Documents unit testing activities.
- **Workflow Notes:** Describes the development workflow.

## GitHub Workflow

The project uses GitHub for source control and collaboration.

The general workflow is:

1. Create or select an issue.
2. Create a feature or bug-fix branch.
3. Implement the changes.
4. Run the relevant tests.
5. Create a Pull Request.
6. Review the proposed changes.
7. Merge the approved Pull Request.

GitHub Actions is used to support automated testing.

## Contribution

Please read [CONTRIBUTING.md](CONTRIBUTING.md) before contributing to the project.

## License

This project is distributed under the terms specified in the [LICENSE](LICENSE) file.

---

**Developed as part of the Software Quality Engineering (SQE) course.**