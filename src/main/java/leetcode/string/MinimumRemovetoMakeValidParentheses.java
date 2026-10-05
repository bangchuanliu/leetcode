package leetcode.string;

public class MinimumRemovetoMakeValidParentheses {
    public static String minRemoveToMakeValid(String s) {
        char[] chs = s.toCharArray();

        int count = 0;

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                count++;
            } else if (chs[i] == ')') {
                count--;
                if (count < 0) {
                    chs[i] = '0';
                    count = 0;
                }

            }
        }
        count = 0;
        for (int i = chs.length - 1; i >= 0; i--) {
            if (chs[i] == ')') {
                count++;
            } else if (chs[i] == '(') {
                count--;
                if (count < 0) {
                    chs[i] = '0';
                    count = 0;
                }

            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chs.length; i++) {
            if (chs[i] != '0') {
                sb.append(chs[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    }
}
