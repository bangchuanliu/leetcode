package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int dis = Integer.MAX_VALUE;
        int pos = -1;
        int count = map.size();
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            map.put(c, map.getOrDefault(c, 0) - 1);

            if (map.get(c) == 0) count--;

            while (i <= j && map.get(s.charAt(i)) < 0) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                i++;
            }

            if (count == 0 && j - i + 1 < dis) {
                dis = j - i + 1;
                pos = i;
            }
        }

        return dis == Integer.MAX_VALUE ? "" : s.substring(pos, pos + dis);
    }

    public String minWindow2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int count = map.size();
        int min = Integer.MAX_VALUE;
        String ans = "";

        for (int j = 0; j < s.length(); j++) {
            char cur = s.charAt(j);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) {
                    count--;
                }
            }

            while (i <= j && count == 0) {
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    ans = s.substring(i, j + 1);
                }

                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if (map.get(s.charAt(i)) == 1) {
                        count++;
                    }
                }
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        System.out.println(minimumWindowSubstring.minWindow("BAACAAAAAAACB", "ABC"));
    }
}
