# leetcode

Java algorithm practice, organized so problems of the same kind stay
together. Each solution is a small, self-contained class — most expose their
solution as a public method (e.g. `coinChange(...)`), and many also include a
`main` method for quick manual testing.

## Layout

| Folder | What's inside |
|---|---|
| [`leetcode/`](leetcode) | LeetCode solutions grouped by topic: `leetcode/src/main/java/leetcode/<topic>` (+ shared helpers in `.../common`) |
| [`company-interviews/`](company-interviews) | Company-tagged interview questions: `company-interviews/src/main/java/<company>` (`airbnb`, `facebook`, `google`) |
| [`courses-and-books/`](courses-and-books) | Exercises from algorithm courses and books (Stanford, Princeton, Programming Pearls, competitive programming, HackerRank) — see its [README](courses-and-books/README.md) |
| [`scripts/`](scripts) | `jrun` (run a single file), `build.sh` (build everything), `tools/` (runner helper), `target/` (build output, gitignored) |

## leetcode topics

Under `leetcode/src/main/java/leetcode/`:

- `array` / `string` — array and string manipulation
- `linkedlist` — linked list problems
- `tree` — binary tree / BST problems
- `graph` — graph traversal and algorithms
- `bfs` / `dfs` — breadth-first / depth-first search problems
- `backtracking` — backtracking search problems
- `binarysearch` — binary search problems
- `binaryindextree` — binary indexed tree (Fenwick tree) problems
- `segmenttree` — segment tree problems
- `bit` — bit manipulation
- `brainteaser` — brainteaser / logic puzzles
- `concurrency` — multithreading problems
- `design` — design-style problems (e.g. LRU cache)
- `divideconquer` — divide and conquer
- `dp` — dynamic programming
- `geometry` — geometry problems
- `greedy` — greedy algorithms
- `hashtable` — hash table based problems
- `heap` — heap / priority queue problems
- `math` — math problems
- `random` — randomization / reservoir sampling problems
- `stackqueue` — stack and queue problems
- `topologicalsort` — topological sort problems
- `trie` — trie (prefix tree) problems
- `twopointer` — two pointer / sliding window problems
- `unionfind` — union-find (disjoint set) problems

Shared helper classes (`TreeNode`, `ListNode`, etc.) live in
`leetcode/src/main/java/common`.

## Build

There are no external/3rd-party dependencies, so a full Maven build isn't
needed — plain `javac`/`java` is enough.

### Build everything

```bash
scripts/build.sh                                     # compiles everything under leetcode/ into scripts/target/build
java -cp scripts/target/build leetcode.dp.CoinChange # run a specific solution (if it has a main method)
```

### Run a single file with `jrun`

The `scripts/jrun` script is the easy way to try out one solution without building
the whole project or writing any extra code:

```bash
scripts/jrun FileName                        # compiles FileName.java and runs its main(...)
scripts/jrun FileName methodName             # compiles FileName.java and calls methodName() on it
scripts/jrun FileName methodName arg1 arg2   # ...passing arguments to the method
```

Examples:

```bash
scripts/jrun dp/CoinChange                   # runs CoinChange's main(String[]) method
scripts/jrun dp/CoinChange coinChange 1,2,5 11  # calls coinChange(int[], int) directly, prints 3
```

Array arguments are comma-separated (e.g. `1,2,5` for `int[]`). `jrun`
searches `leetcode/`, `company-interviews/` and every module in
`courses-and-books/`, and can be invoked from any directory (e.g.
`~/projects/leetcode/scripts/jrun CoinChange`). If a file name exists in more than
one place, `jrun` lists every match — rerun with a path suffix to
disambiguate, e.g. `scripts/jrun leetcode/dp/CoinChange` or
`scripts/jrun airbnb/CoinChange`.

Tip: add an alias so you can just type `jrun` anywhere:

```bash
alias jrun=~/projects/leetcode/scripts/jrun
```
