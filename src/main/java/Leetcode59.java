import org.junit.Test;

public class Leetcode59 {
    //给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int mid = n / 2, loop = n / 2, count = 1, startx = 0, starty = 0, offset = 1;
        int i, j;
        while (loop != 0) {
            loop--;
            for (j = starty; j < starty + n - offset; j++) {
                res[startx][j] = count++;
            }
            for (i = startx; i < startx + n - offset; i++) {
                res[i][j] = count++;
            }
            for (; j > starty; j--) {
                res[i][j] = count++;
            }
            for (; i > startx; i--) {
                res[i][j] = count++;
            }
            startx++;
            starty++;
            offset += 2;
        }
        if (n % 2 == 1) {
            res[mid][mid] = n * n;
        }
        return res;
    }

    @Test
    public void test() {
        int[][] test = generateMatrix(5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(test[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
