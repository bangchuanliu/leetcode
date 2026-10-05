# leetcode

A collection of LeetCode (and related algorithm) practice solutions written
in Java, organized by topic so problems of the same kind stay together for
focused practice. Each solution is a small, self-contained class under
`src/main/java/leetcode/<topic>` — most expose their solution as a public
method (e.g. `coinChange(...)`), and many also include a `main` method for
quick manual testing.

## Structure

Solutions live under `src/main/java/leetcode/<topic>` and are grouped by
algorithm/data-structure topic so related practice problems stay together:

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

Shared helper classes (`TreeNode`, `ListNode`, etc.) live in `src/main/java/common`.

There's also a root-level `interview-questions/src/main/java/<company>` tree
(e.g. `airbnb`, `facebook`, `google`) for company-tagged practice questions
that don't fit a single algorithm topic — see below.

## Build

There are no external/3rd-party dependencies, so a full Maven build isn't
needed — plain `javac`/`java` is enough.

### Build everything

```bash
./build.sh                             # compiles every .java file into out/
java -cp out leetcode.dp.CoinChange    # run a specific solution (if it has a main method)
```

### Run a single file with `jrun`

The `jrun` script is the easy way to try out one solution without building
the whole project or writing any extra code:

```bash
./jrun FileName                        # compiles FileName.java and runs its main(...)
./jrun FileName methodName             # compiles FileName.java and calls methodName() on it
./jrun FileName methodName arg1 arg2   # ...passing arguments to the method
```

Examples:

```bash
./jrun CoinChange                      # runs CoinChange's main(String[]) method
./jrun CoinChange coinChange 1,2,5 11  # calls coinChange(int[], int) directly, prints 3
```

Array arguments are comma-separated (e.g. `1,2,5` for `int[]`). `jrun` also
searches `interview-questions/src/main/java` and every module under
`algorithm-examples/*/src/main/java` (see
[`algorithm-examples/README.md`](algorithm-examples/README.md)), so it works
there too. If a file name exists in more than one place, `jrun` lists every
match — rerun with a path suffix to disambiguate, e.g.
`./jrun leetcode/dp/CoinChange`.

## interview-questions

`interview-questions/src/main/java/<company>` holds company-tagged practice
questions (currently `airbnb`, `facebook`, `google`) that are more about a
specific interview experience than a single reusable algorithm topic, so
they're kept separate from `src/main/java/leetcode`. Run them with `jrun`
just like any other file, e.g. `./jrun AlienDictionary`.

## algorithm-examples

`algorithm-examples/` is a separate, larger collection of algorithm practice
(Stanford/Princeton course exercises, "Programming Pearls", algorithm
contest/hackerrank solutions). It used to be its own nested git repository;
it's now folded into this repo's history. Its former `leetcode` and
`interview-questions` modules have been merged into the root
`src/main/java/leetcode` and `interview-questions` trees described above —
see [`algorithm-examples/README.md`](algorithm-examples/README.md) for
details on the remaining modules and how to build/run them.
