#!/usr/bin/env bash
# Simple build script: no external dependencies, so plain javac is enough.
set -euo pipefail

cd "$(dirname "$0")/.."

SRC_DIR="leetcode-practice/src/main/java"
OUT_DIR="scripts/target/build"

rm -rf "$OUT_DIR"
mkdir -p "$OUT_DIR"

find "$SRC_DIR" -name '*.java' > /tmp/leetcode-sources.txt
javac -d "$OUT_DIR" @/tmp/leetcode-sources.txt
rm -f /tmp/leetcode-sources.txt

echo "Build OK -> $OUT_DIR"
echo "Run a solution with: java -cp $OUT_DIR leetcode.<topic>.<ClassName>"
