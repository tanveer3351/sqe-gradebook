## Merge Conflict — Task 3 (Lab 2)

**What happened:**
Two branches (`feature/rename-field-a` and `feature/rename-field-b`) were both created from `main` at the same point, and both modified the same line in `gradebook.py` — the `roll_no` field — but renamed it differently:
- `feature/rename-field-a` renamed it to `student_id`
- `feature/rename-field-b` renamed it to `id_number`

When `feature/rename-field-a` was merged into `main` first, `main` picked up the `student_id` name. When I then tried to merge `feature/rename-field-b`, Git could not automatically reconcile the two conflicting renames of the same line, so it flagged a merge conflict.

**How I resolved it:**
I ran `git checkout feature/rename-field-b` followed by `git merge main`, which surfaced the conflict markers (`<<<<<<<`, `=======`, `>>>>>>>`) around the field name. I reviewed both versions and kept `student_id` (since it had already been merged into `main` and was more descriptive/consistent with common naming conventions), removed the conflict markers, and discarded the `id_number` version. I then staged the resolved file with `git add`, committed the merge with `git commit`, and pushed with `git push` before completing the PR merge on GitHub.

**Takeaway:**
This illustrates why two branches editing the same line for unrelated purposes should coordinate early, or why a rename like this should ideally happen in a single branch/PR rather than being duplicated across parallel work.

task 4 
04b7b38 Added description of conflict
a6ce161 rename field to id_number (#8)
0855f7e rename feild as roll_no (#7)
6c7b2a7 updated code
6193d1b Merge the work improved
67d02d3 feat(student): add score-adding capability (#6)
18ef457 Feature/add student (#4)
28f6598 Feature/add student (#2)
a6eb589 student.java file updated
(END)

### Rewritten commit messages

**Original:** `6c7b2a7 updated code`
**Rewritten:** `refactor(gradebook): consolidate field rename after merge conflict`
**Why it's better:** "updated code" gives no indication of what was changed, why, or which file/module was affected. The rewritten version specifies the type (`refactor`), scope (`gradebook`), and the actual intent — making it possible to understand the change from the log alone, without opening the diff.

**Original:** `6193d1b Merge the work improved`
**Rewritten:** `merge: resolve rename conflict between student_id and id_number branches`
**Why it's better:** The original is grammatically unclear and doesn't say what was merged or why the merge was needed. The rewritten version follows a clear `<type>: <description>` pattern and explicitly names the conflict being resolved, which is exactly the kind of context a teammate (or future you) needs when scanning history.