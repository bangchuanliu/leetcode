# algorithm-examples

A multi-module collection of broader algorithm practice, folded into this
repo's history (previously its own separate git repository). Each module is
an independent Maven project aggregated by the root `pom.xml`.

## Modules

- **`algorithms-stanford`** — exercises from Stanford's "Algorithms
  Specialization" (Coursera), organized by `courseN/assignmentM` (course1 =
  divide & conquer/sorting, course2 = graph search/shortest paths, course3 =
  greedy/MST/DP, course4 = NP-complete problems).
- **`algorithms-princeton`** — exercises from Princeton's "Algorithms" course
  / Sedgewick & Wayne's book, organized by `chapterN_M_topic` (sorting,
  stacks/queues, union-find, BSTs, graphs, etc).
- **`algorithms-contest`** — solutions from a competitive-programming book,
  organized by `chapterN`.
- **`algotithm-perls`** — exercises from "Programming Pearls", organized by
  chapter (`pearls2`, `pearls8`) plus some `basic` warm-ups.
- **`algorithm-hackrank`** — a couple of HackerRank practice problems.

The `leetcode` and `interview-questions` modules that used to live here have
been merged into the top-level repo: the tagged LeetCode solutions are now
part of `src/main/java/leetcode/<topic>` (duplicates of problems already
solved there were dropped, keeping the top-level version), and the
interview-prep content now lives under the root-level
`interview-questions/src/main/java/<company>` plus a few topic-based files
folded into `src/main/java/leetcode` (`unionfind/UF.java`,
`stackqueue/MonoStack.java`, `concurrency/TwoThread.java`,
`design/IPCalculator.java`). See the top-level [`README.md`](../README.md)
for details.

Unlike the top-level `leetcode` project, several of these modules declare a
real (test-only) dependency on JUnit, so building/testing the whole suite
still uses Maven:

```bash
cd algorithm-examples
mvn test
```

## Running a single file

You can still use the top-level `jrun` script (from the repo root) to
compile and run one file here without Maven — it searches this directory's
modules too:

```bash
./jrun ClosestNumber                   # errors if ambiguous, listing every match
./jrun algorithms-stanford/.../FileName methodName arg1  # disambiguate with a path suffix
```

