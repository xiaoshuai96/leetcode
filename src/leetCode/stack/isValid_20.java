package leetCode.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

     有效字符串需满足：

         1.左括号必须用相同类型的右括号闭合。
         2.左括号必须以正确的顺序闭合。

     注意空字符串可被认为是有效字符串。

 示例 1:              示例 2:               示例 3:           示例 4:           示例 5:

 输入: "()"           输入: "()[]{}"        输入: "(]"        输入: "([)]"      输入: "{[]}"
 输出: true           输出: true            输出: false       输出: false       输出: true


 算法1的思路：
    1.创建list集合，将三种括号"[]"、"()"、"{}"依次加入list集合中
    2.创建栈，提前加入一个字符防止空栈异常
    3.在循环中判断，如果当前栈顶的元素与要加入的元素组成的字符在list中存在的话就将栈顶的元素弹出，并跳出本次循环
        如果不存在，就push进栈中。
    4.在循环结束的时候，如果栈的大小为1，那么该括号字符串匹配成功，否则不成功。
 *
 * */
public class isValid_20 {
    public static void main(String[] args){
        boolean b = isValid1("{}()[]");
        System.out.println(b);
    }
    public static boolean isValid1(String s) {
        List<String> list = new ArrayList<>();
        list.add("()");
        list.add("{}");
        list.add("[]");
        Stack<String> stack = new Stack<>();
        stack.push("&");//这里提前加入一个特殊字符的含义是为了避免空栈异常
        for (int i = 0;i < s.length();i++) {
                if (!list.contains((stack.peek() + s.charAt(i)))) {
                    stack.push(String.valueOf(s.charAt(i)));
                } else {
                    stack.pop();
                    continue;
                }
        }
        return stack.size() == 1;

    }
}

