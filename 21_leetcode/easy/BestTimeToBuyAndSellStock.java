package easy;

public class BestTimeToBuyAndSellStock {
    public int maxProfitBruteForce(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }

        return res;
    }
    public int maxProfileBetterApproach(int[] prices){
        int minSoFar = prices[0];
        int res = 0;
        for(int i = 0; i < prices.length-1; i++){
            minSoFar = Math.min(minSoFar, prices[i]);
            res = Math.max(res, prices[i] - minSoFar);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices2 = new int[]{7, 6, 4, 3, 1};
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfileBetterApproach(prices));
        System.out.println(bestTimeToBuyAndSellStock.maxProfileBetterApproach(prices2));
    }
}
