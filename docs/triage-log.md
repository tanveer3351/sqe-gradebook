# Triage Log

## Sprint Issue Ranking

The following issues are ranked in the order they should be fixed during the sprint.

### 1. Duplicate Roll Numbers Are Allowed

* **Severity:** High
* **Priority:** High
* **Decision:** Fix this sprint
* **Reason:** Roll numbers should uniquely identify students. Allowing duplicates can cause incorrect student identification and data-integrity problems. This has a high impact on the system and should be fixed first.

### 2. Negative Scores Are Accepted Without Validation

* **Severity:** Medium
* **Priority:** Medium
* **Decision:** Fix this sprint
* **Reason:** Negative scores are invalid and can affect the student's total and average. Input validation should prevent invalid data from entering the system.

### 3. Incorrect Rounding of Average Scores

* **Severity:** Medium
* **Priority:** Medium
* **Decision:** Fix this sprint
* **Reason:** Incorrect rounding can produce inaccurate displayed grades. It affects the correctness of grade calculations, so it should be addressed during the sprint.

### 4. Negative Roll Numbers Are Accepted Without Validation

* **Severity:** Medium
* **Priority:** Low
* **Decision:** Won't fix this sprint
* **Label:** `status:wontfix`
* **Reason:** Negative roll numbers are invalid, but this issue has lower impact than duplicate roll numbers and incorrect grade calculations. It can be addressed in a future sprint after higher-impact issues are resolved.

**Severity vs Priority Trade-off:**
Although this issue has medium severity because it allows invalid student data, its priority is lower because it does not create the same data-integrity risk as duplicate roll numbers. Therefore, it is deferred for this sprint.

### 5. Empty Score List in `avgScores()`

* **Severity:** Medium
* **Priority:** Low
* **Decision:** Won't fix this sprint
* **Label:** `status:wontfix`
* **Reason:** An empty score list is an edge case and has relatively low impact if students normally have scores before their average is calculated. The issue can be handled in a future sprint.

**Severity vs Priority Trade-off:**
The issue has medium severity because attempting to calculate an average from an empty list can cause an incorrect result or division-by-zero problem. However, its priority is low because it is an edge case and does not affect students who already have scores. Higher-impact issues will be fixed first.

## Sprint Decision

Following issues will be fixed in this sprint:

1. Duplicate roll numbers
2. Negative scores
3. Incorrect average rounding

Following issues will be fixed in this sprint:

4. Negative roll numbers — `status:wontfix`
5. Empty score list — `status:wontfix`

