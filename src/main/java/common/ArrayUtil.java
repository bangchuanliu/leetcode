package common;

import java.util.Arrays;
import java.util.List;

public class ArrayUtil {

    public static void print(String[] strs) {
        System.out.println(Arrays.deepToString(strs));
    }

    public static void println(List<List<Integer>> numberList) {
        System.out.println(Arrays.deepToString(numberList.toArray()));
    }
}
