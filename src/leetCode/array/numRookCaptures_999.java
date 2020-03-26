package leetCode.array;

import com.sun.javaws.exceptions.BadVersionResponseException;

/**
 * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。
 * 也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
 * 它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 *
 * 车按国际象棋中的规则移动：
 * 它选择四个基本方向中的一个（北，东，西和南），
 * 然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。
 * 另外，车不能与其他友方（白色）象进入同一个方格。
 *
 * 返回车能够在一次移动中捕获到的卒的数量。
 *
 * 提示：
 *
 *     board.length == board[i].length == 8
 *     board[i][j] 可以是 'R'，'.'，'B' 或 'p'
 *     只有一个格子上存在 board[i][j] == 'R'
 *
 *
 */
public class numRookCaptures_999 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
             {'.','.','.','.','.','.','.','.'},
             {'.','.','.','p','.','.','.','.'},
             {'.','.','.','p','.','.','.','.'},
             {'p','p','.','R','.','p','B','.'},
             {'.','.','.','.','.','.','.','.'},
             {'.','.','.','B','.','.','.','.'},
             {'.','.','.','.','.','.','.','.'},
             {'.','.','.','.','.','.','.','.'}};
        numRookCaptures(board);
    }

    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00% 的用户
     * 内存消耗 :37 MB, 在所有 Java 提交中击败了5.40%的用户
     *
     * 这种办法也是最笨的办法，但是也是最容易理解的
     * @param board
     * @return
     */
    public static int numRookCaptures(char[][] board){
        int count = 0,row = 0,col = 0;
        //1.先找到车的位置
        A:for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    row = i;
                    col = j;
                    break A;
                }
            }
        }
        //2.既然找到了车的位置，现在就可以开车去当前位置的四个方向寻找卒，
        //一旦找到某个方向的卒，该次寻找就结束了；如果碰到的是B，表示不能前进了，直接结束即可
        //up
        for (int i = row-1; i >= 0; i--) {
            if (board[i][col] == 'p') {
                count++;
                break;
            } else if (board[i][col] == 'B') {
                break;
            }
        }

        //down
        for (int i = row+1; i < board.length; i++) {
            if (board[i][col] == 'p') {
                count++;
                break;
            } else if (board[i][col] == 'B') {
                break;
            }
        }

        //left
        for (int i = col-1; i >= 0; i--) {
            if (board[row][i] == 'p') {
                count++;
                break;
            } else if (board[row][i] == 'B') {
                break;
            }
        }

        //right
        for (int i = col+1; i < board.length; i++) {
            if (board[row][i] == 'p') {
                count++;
                break;
            } else if (board[row][i] == 'B') {
                break;
            }
        }
        return count;
    }
}
