package leetCode.array;

import com.sun.javafx.scene.control.skin.ComboBoxPopupControl;

import javax.jnlp.IntegrationService;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 *     每组都有 X 张牌。
 *     组内所有的牌上都写着相同的整数。
 *
 * 仅当你可选的 X >= 2 时返回 true。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 *
 * 示例 2：
 *
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 *
 * 示例 3：
 *
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 *
 * 示例 4：
 *
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 *
 * 示例 5：
 *
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 *
 *
 * 提示：
 *
 *     1 <= deck.length <= 10000
 *     0 <= deck[i] < 10000
 *
 */
public class hasGroupsSizeX_914 {
    public static void main(String[] args) {
        int[] deck = {1,1,1,2,2,2,3,3};
        boolean b = hasGroupsSizeX01(deck);
        System.out.println(b);
    }

    /**
     * 执行用时 :5 ms, 在所有 Java 提交中击败了57.19% 的用户
     * 内存消耗 :41.8 MB, 在所有 Java 提交中击败了5.64%的用户
     * @param deck
     * @return
     */
    public static boolean hasGroupsSizeX01(int[] deck) {
        int[] count = new int[10000];
        for (int i : deck) {
            count[i]++;
        }
        int tmp = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (tmp == -1) {
                    tmp = count[i];
                } else {
                    tmp = gcd(tmp,count[i]);
                }
            }
        }
        return tmp >= 2;
    }
    //求公约数
    public static int gcd(int a,int b){
        return b == 0? a : gcd(b,a%b);
    }


    /**
     * 执行用时 :12 ms, 在所有 Java 提交中击败了47.35% 的用户
     * 内存消耗 :42.2 MB, 在所有 Java 提交中击败了5.64%的用户
     * @param deck
     * @return
     */
    public static boolean hasGroupsSizeX02(int[] deck) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : deck) map.put(i,map.getOrDefault(i,0)+1);
        int[] count = new int[map.size()];
        int temp = 0;
        for (int key : map.keySet()) {
            count[temp++] = map.get(key);
        }
        temp = count[0];
        for (int i = 1; i < count.length; i++) {
            temp = gcd(temp,count[i]);
        }
        return temp >= 2;
    }
}
