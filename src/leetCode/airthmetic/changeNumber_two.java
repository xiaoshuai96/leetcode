package leetCode.airthmetic;
/**
 * 交换两个数：
 *  平时的做法都是通过一个中间临时变量来进行交换
 *  下面的做法是使用位运算来进行两个数的交换(不使用中间变量)：两个相同的数异或之后结果为0，并且任何数与0异或都等于它本身。
 *  一个数连续异或相同的一个数两次会得到它本身
 * */
public class changeNumber_two {
    public static void main(String[] args){
        change(10,5);
    }
    public static void change(int x,int y){
        System.out.println("初始值  x : "+x+"\t y : "+y);
        x = x ^ y;//得到新x
        y = x ^ y;//新x再次与y异或得到旧x，赋值给新y
        x = x ^ y;//新的x与新y异或得到旧y，赋值给新x
        System.out.println("交换之后的值  x : "+x+"\t y : "+y);
    }
}
