# leetcode

Java algorithm practice, organized so problems of the same kind stay
together. Each solution is a small, self-contained class — most expose their
solution as a public method (e.g. `coinChange(...)`), and many also include a
`main` method for quick manual testing.

## Layout

| Folder | What's inside |
|---|---|
| [`leetcode-practice/`](leetcode-practice) | LeetCode solutions grouped by topic: `leetcode-practice/src/main/java/leetcode/<topic>` (+ shared helpers in `.../common`) |
| [`interview-practice/`](interview-practice) | Company-tagged interview questions: `interview-practice/src/main/java/<company>` (`airbnb`, `facebook`, `google`) |
| [`algorithm-practice/`](algorithm-practice) | Exercises from algorithm courses and books (Stanford, Princeton, Programming Pearls, competitive programming, HackerRank) — see its [README](algorithm-practice/README.md) |
| [`scripts/`](scripts) | `jrun` (run a single file), `install.sh` (add `jrun` alias to `~/.zshrc`), `build.sh` (build everything), `tools/` (runner helper), `target/` (build output, gitignored) |

## leetcode topics

Under `leetcode-practice/src/main/java/leetcode/`:

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
`leetcode-practice/src/main/java/common`.

## Build

There are no external/3rd-party dependencies, so a full Maven build isn't
needed — plain `javac`/`java` is enough.

### Build everything

```bash
scripts/build.sh                                     # compiles everything under leetcode-practice/ into scripts/target/build
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
scripts/jrun CoinChange                      # runs CoinChange's main(String[]) method
scripts/jrun CoinChange coinChange 1,2,5 11  # calls coinChange(int[], int) directly, prints 3
```

Array arguments are comma-separated (e.g. `1,2,5` for `int[]`). `jrun`
searches `leetcode-practice/`, `interview-practice/` and every module in
`algorithm-practice/`, and can be invoked from any directory.

Just use the file name — class names are unique across the whole repo.
When the same problem appears in more than one folder, the copy outside
`leetcode-practice` is prefixed with its source, e.g. `AirbnbCoinChange`,
`PrincetonTwoSum`, `PearlsQuickSort`, `ContestPermutation`,
`StanfordUtil`. (If a duplicate name is ever added again, jrun shows a numbered list of
the matches to pick from.)

### Use `jrun` from any folder

Run the installer once to add a `jrun` alias to `~/.zshrc` (it also puts a
Homebrew JDK on `PATH` if no working JDK is found):

```bash
scripts/install.sh
source ~/.zshrc
jrun CoinChange coinChange 1,2,5 11   # works from any directory
```

Re-running `scripts/install.sh` is safe — it replaces its previous block.
