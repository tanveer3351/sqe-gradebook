# Lab 1 — Software Development Workflow and QA Involvement

## Purpose

This document explains the software development workflow used in the GradeBook project and identifies where the Quality Assurance (QA) engineer contributes at each stage.

## Workflow

**Idea → Issues → Branch → Pull Request (PR) → Review → Merge → Continuous Integration (CI) → Release**

## Workflow Stages and QA Responsibilities

### 1. Idea
A feature request, improvement, or defect is identified.

**QA involvement:** Help clarify requirements, identify possible edge cases, and determine how the feature can be tested.

### 2. Issues
The idea is recorded as a GitHub issue with a clear description, requirements, and acceptance criteria.

**QA involvement:** Check that requirements are understandable, specific, and testable. Apply relevant labels such as `bug`, `enhancement`, or `testing`.

### 3. Branch
A separate Git branch is created for the feature or bug fix, keeping changes isolated from `main`.

**QA involvement:** Review the planned change and identify relevant test scenarios before implementation begins.

### 4. Pull Request (PR)
The developer submits a pull request to propose merging the branch into `main` and links the related issue.

**QA involvement:** Check the linked issue, confirm that appropriate tests are included, and verify that the change meets its acceptance criteria.

### 5. Review
Team members examine the code, tests, and documentation and provide feedback.

**QA involvement:** Review test coverage, look for missing edge cases, and report potential defects or quality risks.

### 6. Merge
After the required approvals and checks, the pull request is merged into `main`.

**QA involvement:** Confirm that review feedback has been addressed and required checks have passed before the change is accepted.

### 7. Continuous Integration (CI)
Automated workflows run configured checks, such as compiling the Java code and executing tests.

**QA involvement:** Examine test results, investigate failures, and help ensure that changes do not break existing functionality.

### 8. Release
A tested and approved version is prepared for delivery or use.

**QA involvement:** Verify that the planned release checks have passed, review known defects, and confirm that the delivered version meets the agreed requirements.

## Conclusion

QA contributes throughout the development workflow, not only after coding is complete. Early involvement helps prevent defects, improve test coverage, and maintain the quality of the GradeBook project.
