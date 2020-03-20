package leetCode.airthmetic;
/**
 * 求m的n次方的值，要求不使用pow函数
 * 例如：n = 13 ,则n的二进制表示为1101，那么m的13次方可以拆解为：
 *  m^1101 = m^1000 * m^0100 * m^0001
 * 通过 &1 和 >>1 的方式逐位读取n
 * 1.先判断n是否为0，为0的话直接返回sum
 * 2.n不为0，判断n是否为1，如果为1，直接返回m的值
 * 3.n不为1，将m*m的值存入临时变量tmp中，且n右移1位
 *
 *
 * */
public class m_n {
    public static void main(String[] args){
        int a = pow(2,5);
        System.out.println(a);
    }
    public static int pow(int m,int n){
        int sum = 1;
        int tmp = m;
        while (n != 0) {
            if ((n&1) == 1) {
                sum *= tmp;
            }
            tmp *= tmp;
            n = n>>1;
        }
        return sum;
    }

}
