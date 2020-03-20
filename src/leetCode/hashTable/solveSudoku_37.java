package leetCode.hashTable;

import java.util.Arrays;

public class solveSudoku_37 {
    public static void main(String[] args) {
        char[][] arr = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void solveSudoku(char[][] board) {
        // 创建直接寻址表 记录某数字存放的位置 空间换时间
        boolean[][] address = new boolean[9][27];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '1'; // board数组保存的是字符，需换成相应的整数
                    // 宫格的索引
                    int k = i / 3 * 3 + j / 3;
                    // 记录某数字存放的位置
                    address[index][i] = true;
                    address[index][j + 9] = true;
                    address[index][k + 18] = true;
                }
            }
        }
        // 回溯算法，和dfs类似，dfs一般做遍历，没有回溯
        track(board, address, 0, 0);
    }

    private static boolean track(char[][] board, boolean[][] address, int i, int j) {
        // 找寻空位置
        while (board[i][j] != '.') {
            if (++j >= 9) {
                i++;
                j = 0;
            }
            if (i >= 9) return true; // 到这里说明数独已填入的数字是有解的
        }
        for (int index = 0; index < 9; index++) {
            // 宫格索引
            int k = i / 3 * 3 + j / 3;
            if (!address[index][i] && !address[index][j + 9] && !address[index][k + 18]) {
                // index 与 行 列 宫格索引不冲突
                // 填入 index，要注意换成对应字符
                board[i][j] = (char) (index + '1');
                address[index][i] = true;
                address[index][j + 9] = true;
                address[index][k + 18] = true;
                // 递归
                if (track(board, address, i, j))
                    return true;
                // 回溯
                board[i][j] = '.';
                address[index][i] = false;
                address[index][j + 9] = false;
                address[index][k + 18] = false;
            }
        }
        return false; // 当前位置与所有index数字冲突，直接返回false，回到上一个空格
    }
}
