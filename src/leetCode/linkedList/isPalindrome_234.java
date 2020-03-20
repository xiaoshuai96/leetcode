package leetCode.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 */
public class isPalindrome_234 {
    public static void main(String[] args) {

    }
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        //通过遍历将各个结点的值加入list中
        while (head != null) {
            list.add(head.value);
            head = head.next;
        }
        //该数组用于将添加value值
        int[] arr = new int[list.toArray().length];
        //该变量用于记录数组的下标
        int temp = 0;
        for (int a : list) {
            arr[temp++] = a;
        }
        //将上面的temp变量置零，用于下面的次数记录
        temp = 0;
        for (int i = 0;i < arr.length/2;i++) {
            if (arr[i] == arr[arr.length-i-1]) {
                temp++;
            }
        }
        //如果记录的次数为数组长度的一半，那么就说明是回文数，否则不是
        if(temp == arr.length/2) return true;
        return false;
    }
}
