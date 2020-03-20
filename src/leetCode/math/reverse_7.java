package leetCode.math;


/**
        给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

        示例 1:

        输入: 123
        输出: 321

        示例 2:

        输入: -123
        输出: -321

        示例 3:

        输入: 120
        输出: 21

        注意:

        假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
        2^31 = 2147483648‬
 */
public class reverse_7 {
    public static void main(String[] args){
        /*int i = 1534236460;
        System.out.println("输入的数字为："+i);
        calculate_227_unfinished(i);*/
        System.out.println(test2(123));

    }
    public static int test(int x){
        int tmp = x;
        int i = 0;//用于将循环出来的数字依次存入数组中
        int j = 0;//用于记录用户传输进来的数字的长度，方便放入数组中
        while (tmp!=0) {
            int a = tmp%10;
            tmp = (tmp - a)/10;
            j++;
        }
        tmp = x;

        int[] arr = new int[j];
        while(tmp!=0){
            int a = tmp%10;
            tmp = (tmp - a)/10;
            arr[i] = a;
            i++;
        }
        //将数组中的数字还原回来
        long newx = 0;
        if (arr[0]!=0) {
            for (int a = 0;a<arr.length;a++) {
                newx += (arr[a]*(Math.pow(10,arr.length-1-a)));
            }
        }else{
            for(int p = 0;p < arr.length-1;p++){
                arr[p] = arr[p+1];
            }
            arr[arr.length-1]=0;
        }

        if ((Math.pow(-2,31))<=newx&&newx<=(Math.pow(2,31)-1)) {
            return (int)newx;
        }else{
            return 0;
        }
    }

    public static int test2(int x){
        //int p = 0;
        int tmp = x;
        while (tmp!=0) {
            int p = 0;
             p = p*10 + tmp%10;
            tmp = (tmp-p)/10;
        }
        return tmp;

    }

}
