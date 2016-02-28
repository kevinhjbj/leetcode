public class Solution {
	public int minCost(int[][] costs) {
		int n = costs.length;
		if (n == 0) {
			return 0;
		}
		int[][] sum = new int[n][3];
		sum[0][0] = costs[0][0];
		sum[0][1] = costs[0][1];
		sum[0][2] = costs[0][2];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				switch(j) {
					case 0: sum[i][j] = costs[i][j] + Math.min(sum[i - 1][1], sum[i - 1][2]);
						break;
					case 1: sum[i][j] = costs[i][j] + Math.min(sum[i - 1][0], sum[i - 1][2]);
						break;
					case 2: sum[i][j] = costs[i][j] + Math.min(sum[i - 1][0], sum[i - 1][1]);
						break;
				}
			}
		}
		
		return Math.min(Math.min(sum[n - 1][0], sum[n - 1][1]), sum[n - 1][2]);
	}
}
