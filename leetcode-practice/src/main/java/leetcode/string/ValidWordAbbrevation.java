package leetcode.string;

public class ValidWordAbbrevation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        int i = 0;
        int j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++;
                j++;
                continue;
            }

            // must be a digit and not zero
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }

            int start = j;
            while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                j++;
            }

            int num = Integer.parseInt(abbr.substring(start, j));
            i += num;

        }

        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(validWordAbbreviation("apple", "a2e"));
    }
}
