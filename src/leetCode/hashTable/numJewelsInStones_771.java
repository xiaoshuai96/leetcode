package leetCode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，
 *  你想知道你拥有的石头中有多少是宝石。
 *
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *
 * 示例 1:
 *
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 *
 * 示例 2:
 *
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 *
 * 注意:
 *
 *     S 和 J 最多含有50个字母。
 *      J 中的字符不重复。
 *
 */
public class numJewelsInStones_771 {
    public static void main(String[] args) {
        String J = "ebd";
        String S = "bbb";
        int i = numJewelsInStones02(J, S);
        System.out.println(i);
    }
    //version 1.0
    public static int numJewelsInStones01(String J, String S) {
        String[] j = J.split("");
        String[] s = S.split("");
        int count = 0;
        for (int i = 0;i < j.length;i++) {
            for (int l = 0;l < s.length; l++) {
                if(j[i].equals(s[l])) count++;
            }
        }
        return count;
    }
    //version 2.0
    public static int numJewelsInStones02(String J,String S){
        int Jz = 0,res = 0;
        while (Jz < J.length()) {
            for (int i = 0;i < S.length();i++) {
                if(J.charAt(Jz) == S.charAt(i)) res++;
            }
            Jz++;
        }
        return res;
    }

    //version 3.0  时间复杂度都要优于上面的两个版本
    public static int numJewelsInStones03(String J,String S){
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : J.toCharArray()) {
            if (map.containsKey(c)) {
                count += map.get(c);
            }
        }
        return count;
    }
}
