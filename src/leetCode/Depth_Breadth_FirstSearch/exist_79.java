package leetCode.Depth_Breadth_FirstSearch;

import com.sun.corba.se.impl.presentation.rmi.StubFactoryFactoryProxyImpl;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * 提示：
 *
 *     board 和 word 中只包含大写和小写英文字母。
 *     1 <= board.length <= 200
 *     1 <= board[i].length <= 200
 *     1 <= word.length <= 10^3
 */
public class exist_79 {

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了74.01% 的用户
     * 内存消耗：40.8 MB, 在所有 Java 提交中击败了54.64% 的用户
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board,String word){
        int bx = board.length;
        int by = board[0].length;
        for (int i = 0; i < bx; i++) {
            for (int j = 0; j < by; j++) {
                //每次找到和目标word头字母相同的就开始遍历
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board,word,i,j,0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,String word,int x,int y,int p){
        /**
         * 1.如果横坐标大于边界或者小于0
         * 2.如果纵坐标大于边界或者小于0
         * 3.如果矩阵中的当前字符不等于单词中的当前字符
         * return false；
         */
        if (x >= board.length || x < 0 ||
                y >= board[0].length || y < 0 || board[x][y] != word.charAt(p)) {
            return false;
        }
        //这说明矩阵中已经匹配到了和word相匹配的单词，直接返回即可
        if (p == word.length() - 1) {
            return true;
        }
        //因为不能访问已经遍历过的字符，所以在遍历之后的时候先将它置为已访问，
        //然后等到这次的递归结束，再恢复它
        char temp = board[x][y];
        board[x][y] = '/';
        //只要四个方向有一个可走就行
        boolean res = dfs(board,word,x+1,y,p+1) || dfs(board, word, x-1, y, p+1)
                   || dfs(board, word, x, y+1, p+1) || dfs(board,word,x,y-1,p+1);
        //恢复操作
        board[x][y] = temp;
        return res;
    }
}
