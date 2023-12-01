public class BuySellStocks {
    

    public static int buyAndSellStocks(int prices[]){
           int buyPrice = Integer.MAX_VALUE;
           int maxProfit = 0;
           for(int i=0; i<prices.length; i++){
            if(buyPrice < prices[i]){// Selling Price = prices[i]
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
           } else{
            buyPrice = prices[i];
           }
    }
    return maxProfit;
    }
    public static void main(String args[]){
          int arr[] = {1, 4, 5, 8,2,0};
          System.out.println("Maximum Profit is : "+ buyAndSellStocks(arr));
    }
}
