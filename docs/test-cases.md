# GradeBook Test Cases

| ID | Title | Requirement | Preconditions | Steps | Expected | Priority | Type |
|---|---|---|---|---|---|---|---|
| TC-001 | Add valid score | REQ-1 | Student exists with empty scores list | Call `addScore(80)` | Score 80 is added to the student's scores | High | Positive / Functional |
| TC-002 | Reject negative score | REQ-2 | Student exists with empty scores list | Call `addScore(-5)` | `IllegalArgumentException` is raised and no score is added | High | Negative / Functional |
| TC-003 | Reject non-numeric score | REQ-2 | Student exists | Attempt to provide a non-numeric value such as `"abc"` | Non-numeric input is not accepted as a score | Medium | Negative / Error-path |
| TC-004 | Calculate average with multiple scores | REQ-3 | Student has scores 70, 80, 90 | Call `avgScores(student)` | Average is 80.00 | High | Positive / Functional |
| TC-005 | Calculate average with empty list | REQ-4 | Student has no scores | Call `avgScores(student)` | Method returns 0 | High | Boundary / Functional |
| TC-006 | Calculate average with one score | REQ-3 | Student has one score of 75 | Call `avgScores(student)` | Average is 75.00 | Medium | Positive / Functional |
| TC-007 | Reject duplicate roll number | REQ-5 | GradeBook contains student with roll number 101 | Add another student with roll number 101 | `IllegalArgumentException` is raised and duplicate is not added | High | Negative / Functional |
| TC-008 | Case-insensitive name comparison | REQ-7 | Student named "Ali" exists | Compare/search using "ali" | "Ali" and "ali" are treated as the same name | Medium | Functional |
| TC-009 | Accept maximum score | REQ-6 | Student exists | Call `addScore(100)` | Score 100 is accepted | High | Boundary / Functional |
| TC-010 | Accept minimum score | REQ-6 | Student exists | Call `addScore(0)` | Score 0 is accepted | High | Boundary / Functional |
| TC-011 | Mid-range grade conversion | REQ-7 | A valid score is available | Provide score 75 and request its grade letter | Correct grade letter is returned | Medium | Functional |
| TC-012 | Grade conversion boundary | REQ-7 | Score at a grade boundary is available | Provide a boundary score and request its grade letter | Correct grade letter is returned | Medium | Boundary / Functional |



| ID |    Result     |         Note                                                                                                              |
| ------------ | ------- | --------------------------------------------------------------------------------------------------------------------- |
| TC-001       | PASS    | Score 80 was successfully added                                                                                       |
| TC-002       | PASS    | Negative score is not accepted                                                                                        |
| TC-003       | BLOCKED | `addScore()` accepts only double                                                                                      |
| TC-004       | PASS    | Average calculated correctly                                                                                           |
| TC-005       | PASS    | Empty list returned 0                                                                                                  |
| TC-006       | PASS    | Single score returned correctly                                                                                        |
| TC-007       | FAIL    | Duplicate roll number accepted                                                                                         |
| TC-008       | BLOCKED | No name comparison method exists                                                                                       |
| TC-009       | PASS    | Score 100 accepted                                                                                                     |
| TC-010       | PASS    | Score 0 accepted                                                                                                       |
| TC-011       | BLOCKED | No grade-letter conversion implemented                                                                                 |
| TC-012       | BLOCKED | No grade-letter conversion implemented                                                                                 |
