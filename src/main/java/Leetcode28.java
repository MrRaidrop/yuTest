import org.junit.Test;

public class Leetcode28 {
    //给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
    // 如果needle 不是 haystack 的一部分，则返回 -1 。
    //kmp算法

    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;
        int res = 0;
        if (needle.length() == 1) {
            for (int k = 0; k < haystack.length(); k++) {
                if (needle.charAt(0)==haystack.charAt(k)) {
                    return k;
                }
            }
            return -1;
        }
        int[] next = getNext(needle);
        while (i < haystack.length()) {
            while (haystack.charAt(i) != needle.charAt(j) && j > 0) {
                j = next[j - 1];
            }
            if (j == needle.length() - 1) {
                res = i - j;
                return res;
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }  else {
                i++;
            }
        }
        return -1;
    }

    public int[] getNext(String nee) {
        int[] next = new int[nee.length() + 1];
        int i = 1;
        int j = 0;
        next[0] = 0;
        while (i < nee.length()) {
            while (j > 0 && nee.charAt(j) != nee.charAt(i)
                    && next[i - 1] != 0) {
                j = next[j - 1];
            }
            if (nee.charAt(j) == nee.charAt(i)) {
                next[i] = j + 1;
                j++;
                i++;
            } else {
                next[i] = 0;
                i++;
            }
        }
        return next;
    }

    @Test
    public void test() {
        String hay = "abc";
        String nee = "c";
        int[] next = getNext(nee);
        for (int i = 0; i < next.length; i++) {
            int i1 = next[i];
            System.out.println(i1);
        }
        System.out.println(strStr(hay, nee));
    }

}
