# Boundary Value Analysis — `letter_grade()`

## Task 1: Enumerate All Boundaries

The `letter_grade()` function accepts scores from **0 to 100** and assigns a letter grade based on the following ranges:

| Score Range | Expected Grade |
|---|---|
| 0–59 | F |
| 60–69 | D |
| 70–79 | C |
| 80–89 | B |
| 90–100 | A |
| < 0 or > 100 | Invalid / Exception |

### Boundary Pairs

| Boundary | Value - 1 | Expected | Boundary Value | Expected | Value + 1 | Expected |
|---:|---:|---|---:|---|---:|---|
| 0 | -1 | Invalid / Exception | 0 | F | 1 | F |
| 59/60 | 58 | F | 59 | F | 60 | D |
| 69/70 | 68 | D | 69 | D | 70 | C |
| 79/80 | 78 | C | 79 | C | 80 | B |
| 89/90 | 88 | B | 89 | B | 90 | A |
| 100 | 99 | A | 100 | A | 101 | Invalid / Exception |

## BVA Test Values

The complete set of boundary test values is:

```text
-1, 0, 1
58, 59, 60
68, 69, 70
78, 79, 80
88, 89, 90
99, 100, 101
```



# Boundary Value Analysis — `Roster` Score-Count Rule

## Task 3: Enumerate All Boundaries

The `Roster` accepts a score count from **1 to 6**. A score count below 1 or above 6 is considered invalid.

| Score Count Range | Expected Result |
|---|---|
| 1–6 | Valid / Accepted |
| < 1 or > 6 | Invalid / Rejected |

### Boundary Pairs

| Boundary | Value - 1 | Expected | Boundary Value | Expected | Value + 1 | Expected |
|---:|---:|---|---:|---|---:|---|
| 1 | 0 | Invalid / Rejected | 1 | Valid / Accepted | 2 | Valid / Accepted |
| 6 | 5 | Valid / Accepted | 6 | Valid / Accepted | 7 | Invalid / Rejected |

## BVA Test Values

The complete set of boundary test values is:

```text
0, 1, 2
5, 6, 7
```


# Boundary Value Analysis — `Name` Length Rule

## Task 4: Boundary Tests for Name Length

The `validate_name()` function accepts a name with a length from **1 to 50 characters**. A name with length below 1 or above 50 is considered invalid.

| **Name Length Range** | **Expected Result** |
| --------------------- | ------------------- |
| 1–50                  | Valid / Accepted    |
| < 1 or > 50           | Invalid / Rejected  |

### Boundary Pairs

| **Boundary** | **Value - 1** | **Expected**       | **Boundary Value** | **Expected**     | **Value + 1** | **Expected**       |
| ------------ | ------------- | ------------------ | ------------------ | ---------------- | ------------- | ------------------ |
| 1            | 0             | Invalid / Rejected | 1                  | Valid / Accepted | 2             | Valid / Accepted   |
| 50           | 49            | Valid / Accepted   | 50                 | Valid / Accepted | 51            | Invalid / Rejected |

## BVA Test Values

The complete set of boundary test values is:

```text
0, 1, 2
49, 50, 51
```

