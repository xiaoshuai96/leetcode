package leetCode;

/**
 *给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 *
 * */
public class generateMatrix_unfinished {
    public static void main(String[] args) {
        int[][] o = new int[5][2];
        int[][] xy= generateMatrix_(3);
        for (int i = 0;i < xy.length;i++) {
            for (int j = 0;j < xy[i].length;j++) {
                System.out.print(xy[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix_(int x){
        int[][] box = new int[x][x];
        for (int i = 0;i < box.length;i++) {

        }
        return box;
    }
}
