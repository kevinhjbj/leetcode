public class Solution {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) {
			return 0;
		}

		// sum[i]: sell stock on i day and max profit it can get
		int[] sum = new int[prices.length];
		int result = 0;
		sum[0] = 0, sum[1] = Math.max(0, prices[1] - prices[0]);
		// at least two elements in prices[]
		for (int i = 2; i < prices.length; i++) {
			int curProfit = 0;
			int max = 0;
			for (int j = 0; j < i - 2; j++) {
				curProfit = prices[i] - prices[j + 2];
				if (curProfit <= 0) {
					continue;
				}
				max = Math.max(max, sum[j] + curProfit);
			}
		
		}

		for (int i = 0; i < prices.length; i++) {
			result = Math.max(result, sum[i]);
		}
        	return result;
	}
}
