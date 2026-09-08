# Equivalence Partitioning Analysis

## Black-Box Testing Using Equivalence Partitioning

### 1. Score Input

The `letterGrade(score)` function accepts scores from 0 to 100 and converts them into letter grades. Scores outside this range are invalid.

| Class ID | Equivalence Class | Input Range | Representative | Expected Result          |
| -------- | ----------------- | ----------- | -------------: | ------------------------ |
| S1       | Invalid-low       | `< 0`       |            -10 | IllegalArgumentException |
| S2       | F grade           | 0–59        |             45 | F                        |
| S3       | D grade           | 60–69       |             65 | D                        |
| S4       | C grade           | 70–79       |             75 | C                        |
| S5       | B grade           | 80–89       |             85 | B                        |
| S6       | A grade           | 90–100      |             95 | A                        |
| S7       | Invalid-high      | `> 100`     |            150 | IllegalArgumentException |

EP assumes that values within the same class should produce the same type of result. Therefore, one representative value is selected from each class instead of testing every possible score.

---

### 2. Number of Scores

The business rule requires a student to have between 1 and 6 scores.

| Class ID | Equivalence Class | Input Range      | Representative | Expected Result          |
| -------- | ----------------- | ---------------- | -------------: | ------------------------ |
| SC1      | Invalid-low       | 0 scores         |              0 | IllegalArgumentException |
| SC2      | Valid             | 1–6 scores       |              3 | Accepted                 |
| SC3      | Invalid-high      | 7 or more scores |              8 | IllegalArgumentException |

The valid class contains all students with 1 through 6 scores. A representative value of 3 is selected. Zero scores and eight scores represent the two invalid classes.

---

### 3. Student Name

The business rule requires a student name to be a non-empty string of no more than 50 characters. Only letters, spaces, and hyphens are permitted.

| Class ID | Equivalence Class  | Description                                    | Representative      | Expected Result          |
| -------- | ------------------ | ---------------------------------------------- | ------------------- | ------------------------ |
| N1       | Valid typical name | Non-empty name containing permitted characters | `Ali Khan`          | Accepted                 |
| N2       | Empty name         | Empty string                                   | `""`                | IllegalArgumentException |
| N3       | Over-length name   | More than 50 characters                        | 51-character string | IllegalArgumentException |
| N4       | Digits             | Name contains numeric characters               | `Ali123`            | IllegalArgumentException |
| N5       | Symbols            | Name contains disallowed symbols               | `Ali@Khan`          | IllegalArgumentException |

Names containing spaces and hyphens are valid because both characters are explicitly permitted by the business rule.

---

### EP Limitation

Equivalence Partitioning reduces the number of test cases by selecting representative values from groups of inputs expected to behave similarly. However, EP can miss defects at the exact boundaries between classes, such as 59/60 or 69/70. Therefore, Boundary Value Analysis will be used in Lab 6 to test values at and around these boundaries.
