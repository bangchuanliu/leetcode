package leetcode.dp;

import java.util.Arrays;

public class MinimumCost {
    private static final int INF = Integer.MAX_VALUE / 2;

    public String minCostGoodCaption(String caption) {
        int n = caption.length();
        if (n < 3)
            return "";

        char[] arr = caption.toCharArray();
        int[][] prefixCost = new int[n + 1][26];

        for (int i = 0; i < n; i++) {
            int orig = arr[i] - 'a';
            for (int c = 0; c < 26; c++) {
                prefixCost[i + 1][c] = prefixCost[i][c] + Math.abs(orig - c);
            }
        }

        int[] dp = new int[n + 1];
        String[] strs = new String[n + 1];
        strs[0] = "";
        Arrays.fill(dp, INF);
        dp[0] = 0;


        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) {
                continue;
            }
            for (int blockLen = 3; blockLen <= 5; blockLen++) {
                if (i + blockLen > n) {
                    break;
                }
                String blockStr = "";
                int bestBlockCost = INF;
                for (char c = 'a'; c <= 'z'; c++) {
                    int blockCost = prefixCost[i + blockLen][c - 'a'] - prefixCost[i][c - 'a'];
                    if (blockCost < bestBlockCost) {
                        bestBlockCost = blockCost;
                        blockStr = String.valueOf(c).repeat(blockLen);
                    }
                }

                int costCandidate = dp[i] + bestBlockCost;
                if (costCandidate < dp[i + blockLen]) {
                    dp[i + blockLen] = costCandidate;
                    strs[i + blockLen] = strs[i] + blockStr;
                } else if (costCandidate == dp[i + blockLen]) {
                    String curStr = strs[i + blockLen];
                    String newStr = strs[i] + blockStr;

                    if (newStr.compareTo(curStr) < 0) {
                        strs[i + blockLen] = strs[i] + blockStr;
                    }
                }
            }
        }

        return dp[n] >= INF ? "" : strs[n];
    }
}
