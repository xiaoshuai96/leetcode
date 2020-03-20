package leetCode.math;

import org.w3c.dom.ls.LSInput;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个
 * 数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 1 + 81 = 82
 * 64 + 4 = 68
 * 36 + 64 = 100
 * 1 + 0 + 0 = 1
 *
 */
public class isHappy_202 {
    public static int count = 0;
    public static void main(String[] args) {
        //System.out.println(isHappy(536));
        System.out.println(isHappy2(536));
    }

    public static boolean isHappy(int n) {
        int nLength = (n + "").length();
        ArrayList<Integer> list = new ArrayList<>();
        while (nLength != 0) {
            int temp = n;
            list.add(temp % 10);
            n /= 10;
            nLength--;
        }
        int res = squarePlus(list);
        count++;
        if(count == 10) return false;//防止stackOverFlow
        if(res == 1) return true;
        return isHappy(res);
    }

    //将集合中的数的平方相加
    public static int squarePlus(ArrayList<Integer> list) {
        int res = 0;
        for (int i : list) {
            res += (i*i);
        }
        System.out.println(res);
        return res;
    }

    public static boolean isHappy2(int n) {
        if (n == 1) return true;
        //当n循环到这些数的时候，就表明该数不是快乐数
        if((n == 4) || (n == 16) || (n == 37) || ( n == 58) || (n == 89) || (n == 145) || (n ==42) || (n == 20)) return false;
        int sum = 0;
        do {
            int temp = n % 10;
            sum += temp * temp;
            n = n / 10;
        } while (n > 0);
        return isHappy(sum);
    }

}
