package leetCode.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，
 * 并且使皇后彼此之间不能相互攻击。
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
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
 *
 * 提示：
 *     皇后，是国际象棋中的棋子，意味着国王的妻子。
 *     皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，
 *     就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N-1 步，
 *     可进可退。（引用自 百度百科 - 皇后 ）
 */
public class totalNQueens_52 {
    public static void main(String[] args) {
        int num = 14;
        System.out.println("loading……");
        int n = new totalNQueens_52().totalNQueens(num);
        System.out.println(num+"皇后共有"+n+"种排法");
    }

    /**
     * 执行用时：25 ms, 在所有 Java 提交中击败了5.18% 的用户
     * 内存消耗：38.1 MB, 在所有 Java 提交中击败了5.01% 的用户
     */
    public int count;
    public int totalNQueens(int n) {
        int[] array = new int[n];
        putQueens(0,n,array);
        return count;

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
            c="";
        }
        count++;
    }
}
