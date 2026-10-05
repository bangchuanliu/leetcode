package leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {

    // Time limit exceeded
    public List<Integer> findSubstring2(String s, String[] words) {
        Map<String, Integer> m1 = new HashMap<>();

        for (String ss : words) {
            m1.put(ss, m1.getOrDefault(ss, 0) + 1);
        }

        int wLen = words[0].length();
        List<Integer> ret = new ArrayList<>();
        Map<String, Integer> map;
        String temp = "";

        for (int i = 0; i < wLen; i++) {
            map = new HashMap<>(m1);
            int count = m1.size();
            int start = i;

            for (int j = i; j + wLen <= s.length(); j = j + wLen) {
                temp = s.substring(j, j + wLen);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) - 1);

                    if (map.get(temp) == 0) {
                        count--;
                    }

                    while(map.get(temp) < 0) {
                        String w = s.substring(start, start + wLen);
                        map.put(w, map.get(w) + 1);
                        if (map.get(w) == 1) {
                            count++;
                        }
                        start = start + wLen;
                    }

                    if (count == 0) {
                        ret.add(start);
                    }
                } else {
                    map = new HashMap<>(m1);
                    count = m1.size();
                    start = j + wLen;
                }
            }
        }

        return ret;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        int wordlength = words[0].length();
        int wordcount = words.length;
        int windowsize = wordlength * wordcount;
        int slength = s.length();

        if (wordcount == 0 || slength == 0) {
            return result;
        }
        Map<String, Integer> wordfreq = new HashMap<>();
        for (String word : words) {
            wordfreq.put(word, wordfreq.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordlength; i++) {
            Map<String, Integer> currentfreq = new HashMap<>();
            int start = i;
            int count = 0;
            for (int j = i; j + wordlength <= slength; j += wordlength) {
                String word = s.substring(j, j + wordlength);
                if (wordfreq.containsKey(word)) {
                    currentfreq.put(word, currentfreq.getOrDefault(word, 0) + 1);
                    count++;

                    while (currentfreq.get(word) > wordfreq.get(word)) {
                        String leftword = s.substring(start, start + wordlength);
                        currentfreq.put(leftword, currentfreq.get(leftword) - 1);
                        count--;
                        start += wordlength;
                    }
                    if (count == wordcount) {
                        result.add(start);
                    }
                } else {
                    count = 0;
                    start = j + wordlength;
                    currentfreq.clear();
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        SubstringwithConcatenationofAllWords substringwithConcatenationofAllWords = new SubstringwithConcatenationofAllWords();
        String s = "wordwordword";
        String[] words = {"word", "good", "best", "good"};
        String s2 = "barfoothefoobarman";
        String[] words2 = {"foo", "bar"};
//        System.out.println(Arrays.toString(substringwithConcatenationofAllWords.findSubstring2(s, words).toArray()));
//        System.out.println(Arrays.toString(substringwithConcatenationofAllWords.findSubstring(s2, words2).toArray()));
        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar", "foo", "the"};
        System.out.println(Arrays.toString(substringwithConcatenationofAllWords.findSubstring2(s3, words3).toArray()));
    }
}
