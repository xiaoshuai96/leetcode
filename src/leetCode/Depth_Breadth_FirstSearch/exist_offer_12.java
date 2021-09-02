package leetCode.Depth_Breadth_FirstSearch;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入这个格子。
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],
 *               ["S","F","C","S"],
 *               ["A","D","E","E"]
 *              ],
 * word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 提示：
 *
 *     1 <= board.length <= 200
 *     1 <= board[i].length <= 200
 */
public class exist_offer_12 {
    public static void main(String[] args) {

    }

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了76.35% 的用户
     * 内存消耗：40.3 MB, 在所有 Java 提交中击败了86.34% 的用户
     * @param board
     * @param word
     */
    public boolean exist(char[][] board,String word){
        int bx = board.length;
        int by = board[0].length;
        int p = 0;
        for (int i = 0; i < bx; i++) {
            for (int j = 0;j < by;j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean b = dfs(board, word, i, j, 0);
                    if(b) return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,String word,int x,int y,int p){
        //如果边界到头或者地图中的字符和当前遍历的word中的字符不同，返回false
        if (x >= board.length || x < 0 || y >= board[0].length  || y < 0 || word.charAt(p) != board[x][y]) {
            return false;
        }
        if (p == word.length() - 1) return true;
        //先用临时保存下当前字符
        char temp = board[x][y];
        //标为已遍历
        board[x][y] = '?';
        //只要有一条路径正确即可
        boolean res = dfs(board,word,x-1,y,p + 1) || dfs(board,word,x+1,y,p + 1)
                || dfs(board,word,x,y - 1,p + 1) || dfs(board,word,x,y + 1,p + 1);
        //恢复原值
        board[x][y] = temp;
        return res;
    }
}
