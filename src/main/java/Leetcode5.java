import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Leetcode5 {


    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] cs = s.toCharArray();
        int[] range = new int[2];
        int[] temp = range;
        int count = 0;
        for (double i = 0.5; i < cs.length; i = i + 0.5) {
            range = helper(cs, i);
            if (range[1] - range[0] > count) {
                count = range[1] - range[0];
                temp[1] = range[1];
                temp[0] = range[0];
            }
        }
        String res = s.substring(temp[0]+1, temp[1]);
        return res;
    }

    private int[] helper(char[] cs, double mid) {
        int left, right;
        if (mid % 1 > 0.4) {
            left = (int) mid;
            right = left + 1;
        } else {
            left = (int) mid - 1;
            right = left + 2;
        }
        while (left >= 0 && right <= cs.length-1 && cs[left] == cs[right]) {
            left--;
            right++;
        }
        return new int[]{left, right};
    }

    @Test
    public void test() {
        String s1 = "babad";
        String s2 = "xabbaxy";
        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));
    }
}
