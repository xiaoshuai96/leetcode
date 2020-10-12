package leetCode.hashTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说，
 * orders[i]=[customerNamei,tableNumberi,foodItemi] ，
 * 其中 customerNamei 是客户的姓名，tableNumberi 是客户所在餐桌的桌号，
 * 而 foodItemi 是客户点的餐品名称。
 *
 * 请你返回该餐厅的 点菜展示表 。
 * 在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，
 * 后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，
 * 第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 *
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：orders = [["David","3","Ceviche"],["Corina","10","Beef Burrito"],
 *      ["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],
 *      ["Rous","3","Ceviche"]]
 * 输出：[["Table","Beef Burrito","Ceviche","Fried Chicken","Water"],
 *      ["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]]
 * 解释：
 * 点菜展示表如下所示：
 * Table,Beef Burrito,Ceviche,  Fried Chicken,Water
 * 3        ,0           ,2        ,1          ,0
 * 5        ,0           ,1        ,0          ,1
 * 10       ,1           ,0        ,0          ,0
 * 对于餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
 * 而餐桌 5：Carla 点了 "Water" 和 "Ceviche"
 * 餐桌 10：Corina 点了 "Beef Burrito"
 *
 * 示例 2：
 *
 * 输入：orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried Chicken"],
 * ["Amadeus","12","Fried Chicken"],["Adam","1","Canadian Waffles"],
 * ["Brianna","1","Canadian Waffles"]]
 * 输出：[["Table","Canadian Waffles","Fried Chicken"],
 * ["1","2","0"],["12","0","3"]]
 * 解释：
 * 对于餐桌 1：Adam 和 Brianna 都点了 "Canadian Waffles"
 * 而餐桌 12：James, Ratesh 和 Amadeus 都点了 "Fried Chicken"
 *
 * 示例 3：
 *
 * 输入：orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef Burrito"],
 * ["Melissa","2","Soda"]]
 * 输出：[["Table","Bean Burrito","Beef Burrito","Soda"],["2","1","1","1"]]
 *
 *
 *
 * 提示：
 *
 *     1 <= orders.length <= 5 * 10^4
 *     orders[i].length == 3
 *     1 <= customerNamei.length, foodItemi.length <= 20
 *     customerNamei 和 foodItemi 由大小写英文字母及空格字符 ' ' 组成。
 *     tableNumberi 是 1 到 500 范围内的整数。
 *
 *
 */
public class displayTable_5389 {
    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        ArrayList<String> list01 = new ArrayList<>();
        ArrayList<String> list02 = new ArrayList<>();
        ArrayList<String> list03 = new ArrayList<>();
        ArrayList<String> list04 = new ArrayList<>();
        ArrayList<String> list05 = new ArrayList<>();
        list01.add("David");
        list01.add("3");
        list01.add("Ceviche");
        list02.add("Corina");
        list02.add("10");
        list02.add("Beef Burrito");
        list03.add("Tom");
        list03.add("3");
        list03.add("Fried Chicken");
        list04.add("Jack");
        list04.add("5");
        list04.add("Water");
        list05.add("Peter");
        list05.add("5");
        list05.add("Ceviche");
        lists.add(list01);
        lists.add(list02);
        lists.add(list03);
        lists.add(list04);
        lists.add(list05);
        displayTable(lists);
    }
    public static List<List<String>> displayTable(List<List<String>> orders){
        List<List<String>> res = new ArrayList<>();
        List<String> number = new ArrayList<>();//桌号
        List<String> tod = new ArrayList<>();//菜品种类
        for (List<String> list : orders) {
            if (!number.contains(list.get(1))) {
                number.add(list.get(1));
            }
            if (!tod.contains(list.get(2))) {
                tod.add(list.get(2));
            }
        }
        Collections.sort(number);
        Collections.sort(tod);
        tod.add(0,"Table");
        res.add(tod);
        return res;
    }
}