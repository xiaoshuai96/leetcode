package leetCode.math;

public class stoneGame_877_unfinished {
    public static void main(String[] args){
        int[] shitou = {5,7,3,5};//石头堆的堆数和各个堆数中的石子的个数
        int smith_number = 0;//亚力克斯拿到的石子数
        int lee_number = 0;//李拿到的的石子数
        int max1 = shitou[0];//假定数组中最大的值是第一个元素
        int max2 = shitou[0];
        int sd = 0;//记录s数组元素最大值的下标
        int ld = 0;//记录l数组元素的最大值下标
        //这层循环用于记录该谁拿石子
        for(int a = 1;a < shitou.length+1 ;a++) {
            //如果a是奇数则轮到亚力克斯选择
            if (a%2==1){
                System.out.println("123");
                //这个循环的目的是为了在数组中找到最大的元素并且将它赋给亚力克斯
                //并且将最大值设置为0
                for (int i = 0; i < shitou.length; i++){
                    if (shitou[i] > max1) {
                        max1 = shitou[i];
                        sd = i;
                        System.out.println("亚力克斯选择的石头堆是："+sd);
                    }
                    else continue;
                }
                smith_number += shitou[sd];
                shitou[sd] = 0;
            }
            //如果是a是偶数则该LEE了
            else if (a%2==0){
                System.out.println("456");
                 for (int j = 0; j < shitou.length; j++) {
                    if (shitou[j] > max2){
                        max2 = shitou[j];
                        ld = j;
                        System.out.println("Lee选择的石头堆是："+ld);
                    }
                    else {
                        max2 = max2;
                    }
                }
                lee_number += shitou[ld];
                shitou[ld] = 0;
            }

        }
        System.out.println(smith_number);
        System.out.println(lee_number);
        //打印当前数组中的元素
        for(int b = 0;b<shitou.length;b++){
            System.out.print("\t"+shitou[b]);
        }



    }
}
