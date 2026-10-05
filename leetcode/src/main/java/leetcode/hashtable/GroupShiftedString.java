package leetcode.hashtable;

public class GroupShiftedString {

    public static char shiftLetter(int c, int shift) {
        return (char) ((c - shift + 26) % 26 + 'a');
    }

    public static String getHashKey(String s) {

        char[] chs = s.toCharArray();
        int shift = chs[0];

        for (int i = 0; i < chs.length; i++) {
            chs[i] = shiftLetter(s.charAt(i), shift);
        }

        return String.valueOf(chs);
    }

    public static void main(String[] args) {
        System.out.println(getHashKey("agi"));
        System.out.println(getHashKey("aer"));
        System.out.println(getHashKey("anw"));
    }
}
