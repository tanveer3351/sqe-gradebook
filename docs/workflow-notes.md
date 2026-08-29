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