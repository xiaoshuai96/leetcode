package leetCode.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 *n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，
 * 并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，
 * 该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 示例：
 *
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * 提示：
 *
 *     皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 */
public class solveNQueens_51 {
    public static void main(String[] args) {
        List<List<String>> list = new solveNQueens_51().solveNQueens(4);
        for (List<String> stringList : list) {
            for (String s : stringList) {
                System.out.println(s);
            }
            System.out.println("--------------------------------");
        }
    }

    /**
     * 执行用时：15 ms, 在所有 Java 提交中击败了7.17% 的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了81.90% 的用户
     */
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int[] array = new int[n];
        putQueens(0,n,array);
        return list;

    }

    /**
     * 放棋子
     * @param n1
     * @param n
     * @param array
     */
    public void putQueens(int n1,int n,int[] array){
        if(n == n1){
            print(array);
            return;
        }
        for(int i = 0;i < n;i++){
            array[n1] = i;
            if(judge(n1,array)){
                putQueens(n1+1,n,array);
            }
        }
    }
    //判断当前放置的皇后是否和前面的皇后位置冲突
    public boolean judge(int n,int[] array){
        for(int i = 0;i < n;i++){
            if(array[n] == array[i] || Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }
    //添加到结果集合
    public void print(int[] array){
        List<String> list1 = new ArrayList<>();
        String c = "";
        for(int i = 0;i < array.length;i++){
            for (int j = 0;j < array.length;j++) {
                c+=".";
            }
            char[] ch = c.toCharArray();
            ch[array[i]] = 'Q';
            String str = "";
            for (char c1 : ch) {
                str+=c1;
            }
            list1.add(str);
            str = "";
            //list1.add(ch.toString());
            c="";
        }
        list.add(list1);

    }
}

