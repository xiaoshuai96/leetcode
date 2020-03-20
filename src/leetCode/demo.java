package leetCode;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class demo {
    public static void main(String[] args) {
        String str = "BEA";
        new demo().modify(str);
    }
    public static void modify(String str){
        str.replace('A','E');
        str.toLowerCase();
        str += 'B';
    }

}
