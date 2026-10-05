# courses-and-books

Exercises worked through while following algorithm courses and books (this
folder was previously named `algorithm-examples`). Each module is an
independent Maven project aggregated by this folder's `pom.xml`.

## Modules

- **`stanford-algorithms`** — exercises from Stanford's "Algorithms
  Specialization" (Coursera), organized by `courseN/assignmentM` (course1 =
  divide & conquer/sorting, course2 = graph search/shortest paths, course3 =
  greedy/MST/DP, course4 = NP-complete problems).
- **`princeton-algorithms`** — exercises from Princeton's "Algorithms" course
  / Sedgewick & Wayne's book, organized by `chapterN_M_topic` (sorting,
  stacks/queues, union-find, BSTs, graphs, etc).
- **`competitive-programming`** — solutions from a competitive-programming
  book (算法竞赛入门经典, UVa problems), organized by `chapterN`.
- **`programming-pearls`** — exercises from "Programming Pearls", organized by
  chapter (`pearls2`, `pearls8`) plus some `basic` warm-ups.
- **`hackerrank`** — a couple of HackerRank practice problems.

The LeetCode solutions and company interview questions that used to live
here have moved to the top-level [`leetcode/`](../leetcode) and
[`company-interviews/`](../company-interviews) folders.

Unlike `leetcode/`, several of these modules declare a real (test-only)
dependency on JUnit, so building/testing the whole suite still uses Maven:

```bash
cd courses-and-books
mvn test
```

## Running a single file

Use the top-level `jrun` script to compile and run one file without Maven:

```bash
./jrun ClosestNumber                   # errors if ambiguous, listing every match
./jrun Knapsack                        # data files in src/main/resources are on the classpath
./jrun chapter2/Permutation            # disambiguate with a path suffix
```

