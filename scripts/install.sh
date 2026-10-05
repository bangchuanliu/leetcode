#!/usr/bin/env bash
# Adds a `jrun` alias (and a JDK on PATH, if needed) to ~/.zshrc so jrun works
# from any folder. Safe to re-run: it replaces its previous block.
set -euo pipefail

SCRIPTS_DIR="$(cd "$(dirname "$0")" && pwd)"
RC_FILE="${ZDOTDIR:-$HOME}/.zshrc"
BEGIN="# >>> leetcode jrun >>>"
END="# <<< leetcode jrun <<<"

# The macOS /usr/bin/javac is only a stub unless a JDK is installed, so check it really works.
JDK_BIN=""
if ! javac -version >/dev/null 2>&1; then
  for d in /opt/homebrew/opt/openjdk*/bin /usr/local/opt/openjdk*/bin; do
    if [ -x "$d/javac" ] && "$d/javac" -version >/dev/null 2>&1; then
      JDK_BIN="$d"
      break
    fi
  done
  if [ -z "$JDK_BIN" ]; then
    echo "No working JDK found. Install one first, e.g.: brew install openjdk" >&2
    exit 1
  fi
fi

touch "$RC_FILE"
# Drop any previous block, then append a fresh one.
tmp="$(mktemp)"
awk -v b="$BEGIN" -v e="$END" '$0==b{skip=1} !skip{print} $0==e{skip=0}' "$RC_FILE" > "$tmp"
cat "$tmp" > "$RC_FILE"
rm -f "$tmp"

{
  echo "$BEGIN"
  [ -n "$JDK_BIN" ] && echo "export PATH=\"$JDK_BIN:\$PATH\""
  echo "alias jrun='$SCRIPTS_DIR/jrun'"
  echo "$END"
} >> "$RC_FILE"

echo "Added jrun to $RC_FILE${JDK_BIN:+ (with JDK from $JDK_BIN)}."
echo "Run 'source $RC_FILE' or open a new terminal, then e.g.: jrun dp/CoinChange coinChange 1,2,5 11"
