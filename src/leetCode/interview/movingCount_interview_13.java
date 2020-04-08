package leetCode.interview;

/**
 *地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 1：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 *
 * 提示：
 *
 *     1 <= n,m <= 100
 *     0 <= k <= 20
 *
 *
 */
public class movingCount_interview_13 {
    public static void main(String[] args) {
        int i = movingCount(7, 2, 3);
        System.out.println(i);
    }

    /**
     *  该方法不通，因为只考虑了每个方格的值与k的大小关系，但是实际上是要考虑它能“走到”的地方
     * @param m 行
     * @param n 列
     * @param k
     * @return
     */
    public static int movingCount(int m, int n, int k) {
        int res = 0,count1 = 0,count2 = 0;
        for (int i = 0; i < m; i++) {
            count1 = 0;
            if (i > 9) {
                int temp = i;
                while (temp != 0) {
                    count1 += (temp % 10);
                    temp /= 10;
                }
            }else{
                count1 += i;
            }
            for (int j = 0; j < n; j++) {
                if (j > 9) {
                    while (j != 0) {
                        count2 += (j % 10);
                        j /= 10;
                    }
                } else {
                    count2 += j;
                }
                //转换完成之后判断他们的和是否大于k
                if ((count1+count2) <= k) {
                    res++;
                }
                count2 = 0;
            }
        }
        return res;
    }
    //统计到达的数量
    static int counts=0;
    public static int movingCount02(int m, int n, int k) {
        //辅助数组 用来标记是否统计过
        int[][] visited = new int[m][n];
        //从 0,0位置开始统计
        helper(visited,0,0,m-1,n-1,k);
        return counts;
    }

    /**
     *传入i,j两点 判断当前点是否符合规则 符合规则下继续对上下左右四个点递归判断
     */
    private static void helper(int[][] visited,int i,int j,int m,int n,int k){
        // System.out.println("i:"+i+"   j:"+j);
        if(i>=0&&j>=0&&i<=m&&j<=n&&visited[i][j]!=1&&(indexSum(i)+indexSum(j))<=k){
            // System.out.println("if  i:"+i+"   j:"+j);
            counts++;
            visited[i][j]=1;
            helper(visited,i-1,j,m,n,k);
            helper(visited,i+1,j,m,n,k);
            helper(visited,i,j-1,m,n,k);
            helper(visited,i,j+1,m,n,k);
        }
    }

    /**
     *根据传入的数 求出各位上的数字累加和
     */
    private static int indexSum(int index){
        int sum = index%10;
        int tmp = index/10;
        while(tmp>0){
            sum+=tmp%10;
            tmp/=10;
        }
        // System.out.println("indexSum  index:"+index+"   sum:"+sum);
        return sum;
    }
}
