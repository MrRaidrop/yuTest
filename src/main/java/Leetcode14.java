import org.junit.Test;

public class Leetcode14 {
    //编写一个函数来查找字符串数组中的最长公共前缀。
    //如果不存在公共前缀，返回空字符串 ""

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while(!strs[i].startsWith(s)) {
                s = s.substring(0, s.length()-1);
            }
        }
        return s;
    }

    @Test
    public void test() {
        String[] test = {"flover", "flow", "flaav"};
        System.out.println(longestCommonPrefix(test));
    }
}
