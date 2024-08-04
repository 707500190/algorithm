package practice;

public class Fibonacci {


    static int f(int n) {
        if (n == 1 || n ==0) {
            return 1;
        }
        return f(n-1) + n;
    }

    public static void main(String[] args) {
        System.out.print(f(5));
    }

    /**
     * 买卖股票最佳时机
     * 找出数组中最大差值（在数组中的位置最大值不能在最小值前面）
     *
     *
     * @param prices 输入一段数组，
     * @return 最大利润
     */
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }


}
