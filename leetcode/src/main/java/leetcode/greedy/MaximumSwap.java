package leetcode.greedy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MaximumSwap {
    public int maximumSwap(int num) {
        Deque<Integer> q = new ArrayDeque<>();

        char[] chs = String.valueOf(num).toCharArray();

        for (int i = 0; i < chs.length; i++) {
            while (!q.isEmpty() && chs[i] >= chs[q.peekLast()]) {
                q.pollLast();
            }

            q.add(i);
        }

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == chs[q.peekFirst()]) {
                if (i == q.peek()) {
                    q.pollFirst();
                }
            } else {
                char c = chs[i];
                chs[i] = chs[q.peek()];
                chs[q.peek()] = c;
                return Integer.parseInt(String.valueOf(chs));
            }
        }

        return num;

    }
}
