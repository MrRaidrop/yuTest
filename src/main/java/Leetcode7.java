
import org.junit.Test;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;


public class Leetcode7 {
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        if (x < 0) {
            while (x != 0) {
                temp.add(x % 10);
                x = x / 10;
            }
            int res = 0, count = 0;

            while (temp.size() != 0) {
                int cur = temp.remove(0);
                res = res * 10 + cur;
                count++;
                if ((count == 9 && temp.size() >= 1 && res < -214748364)
                        || (count == 9 && temp.size() > 1)) {
                    return 0;
                }
            }
            return res;
        }

        while (x != 0) {
            temp.add(x % 10);
            x = x / 10;
        }
        int res = 0, count = 0;

        while (temp.size() != 0) {
            int cur = temp.remove(0);
            res = res * 10 + cur;
            count++;
            if ((count == 9 && temp.size() >= 1 && res > 214748364)
                    || (count == 9 && temp.size() > 1)) {
                return 0;
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(reverse(-2147483648));
        System.out.println(reverse(-321));
    }

}
