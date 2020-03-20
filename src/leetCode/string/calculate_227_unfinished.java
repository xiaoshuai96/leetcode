package leetCode.string;
import java.util.Stack;
/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 *
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 *
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 *
 */
public class calculate_227_unfinished {
    public static void main(String[] args){
        String s = "1*2-3/4+5*6-7*8+9/10";
        int res = calculate(s);
        System.out.println(res);
    }
    public static int calculate(String s){
        Stack<String> dataS = new Stack<>();//数据栈
        Stack<String> symbolS = new Stack<>();//符号栈
        String[] str = s.split("");
        //将字符串中的各个数据压入按照规则压入栈中
        for (int i = 0; i < str.length; i++) {
            if (str[i] != " ") {
                //如果该字符串是0~9，直接压入栈中
                if (judgeNum(str[i])) {
                    dataS.push(str[i]);
                //扫描到的是符号
                }else if (judgeOper(str[i])) {
                    //先判断此时的符号栈中是否存在符号，如果没有直接存进去，如果有，判断优先级
                    if (symbolS.isEmpty()) {
                        symbolS.push(str[i]);
                    }else{
                        String high = judge(str[i], symbolS.peek());
                        //如果这里的条件成立，说明新的运算符等级高，直接压入即可
                        if (high.equals(str[i])) {
                            symbolS.push(str[i]);
                        } else if (high.equals(symbolS.peek())) {//否则就从数据栈中pop出两个数字，在符号栈中pop出顶层的符号，进行运算
                            String s1 = calResult(dataS.pop(), dataS.pop(), symbolS.pop());
                            symbolS.push(str[i]);
                            dataS.push(s1);
                        }else{
                            System.out.println("error");
                        }
                    }
                }else{
                    continue;
                }
            }else continue;
        }

        while (!symbolS.isEmpty()) {
            String s1 = calResult(dataS.pop(), dataS.pop(), symbolS.pop());
            dataS.push(s1);
        }
        return Integer.parseInt(dataS.pop());
    }
    //判断两个运算符的优先级,返回优先级高的运算符
    public static String judge(String s1,String s2){
        if ((s1.equals("+") || s1.equals("-")) && (s2.equals("*") || s2.equals("/"))) return s2;
        if ((s1.equals("*") || s1.equals("/")) && (s2.equals("+") || s2.equals("-"))) return s1;
        if ((s1.equals("+") || s1.equals("-")) && (s2.equals("+") || s2.equals("-"))) return s1;
        if ((s1.equals("*") || s1.equals("/")) && (s2.equals("*") || s2.equals("/"))) return s2;
        return "";
    }
    //两个数的运算
    public static String calResult(String s1,String s2,String sy){
        int i = Integer.parseInt(s1);
        int j = Integer.parseInt(s2);
        int res = 0;
        switch (sy){
            case "+" :res = j + i;
                break;
            case "-" :res = j - i;
                break;
            case "*" :res = j * i;
                break;
            case "/" :res = j / i;
                break;
            default:
                System.out.println("error");
                break;
        }
        return res+"";
    }
    //判断是否是运算符
    public static boolean judgeOper(String s){
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }
    //判断是否是数字
    public static boolean judgeNum(String s){
        return (s.equals("0") || s.equals("1") || s.equals("2") || s.equals("3") ||
                s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7") ||
                s.equals("8") || s.equals("9"));
    }

}
