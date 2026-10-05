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

### Build and run everything

```bash
./build.sh                             # compiles every .java file into out/
java -cp out leetcode.dp.CoinChange    # run a specific solution (if it has a main method)
```

`build.sh` just runs `javac` over all sources in `src/main/java` and puts the
compiled classes in `out/` (ignored by git).

### Compile and run a single file

You don't need to build the whole project to try out one solution. Use
`-sourcepath` so `javac` automatically pulls in any `common` helper classes
(e.g. `TreeNode`, `ListNode`) the file depends on:

```bash
javac -d out -sourcepath src/main/java src/main/java/leetcode/tree/InvertBinaryTree.java
java -cp out leetcode.tree.InvertBinaryTree
```

Replace the path/class name with the solution you want to run. If the class
doesn't have a `main` method, add one temporarily (or write a quick throwaway
test) to call its solution method with sample input.
