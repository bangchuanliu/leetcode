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
- `backtracking` — backtracking/DFS search problems
- `binarysearch` — binary search problems
- `bit` — bit manipulation
- `design` — design-style problems (e.g. LRU cache)
- `divideconquer` — divide and conquer
- `dp` — dynamic programming
- `greedy` — greedy algorithms
- `hashtable` — hash table based problems
- `heap` — heap / priority queue problems
- `math` — math problems
- `stackqueue` — stack and queue problems
- `topologicalsort` — topological sort problems
- `trie` — trie (prefix tree) problems
- `twopointer` — two pointer / sliding window problems
- `unionfind` — union-find (disjoint set) problems

Shared helper classes (`TreeNode`, `ListNode`, etc.) live in `src/main/java/common`.

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
searches every module under `algorithm-examples/*/src/main/java` (see
[`algorithm-examples/README.md`](algorithm-examples/README.md)), so it works
there too. If a file name exists in more than one place, `jrun` lists every
match — rerun with a path suffix to disambiguate, e.g.
`./jrun tag/dp/CoinChange`.

## algorithm-examples

`algorithm-examples/` is a separate, larger collection of algorithm practice
(Stanford/Princeton course exercises, "Programming Pearls", interview-prep
questions, and a second tagged LeetCode set). It's actually its own nested
git repository rather than part of this one — see
[`algorithm-examples/README.md`](algorithm-examples/README.md) for details
on its modules and how to build/run it.
