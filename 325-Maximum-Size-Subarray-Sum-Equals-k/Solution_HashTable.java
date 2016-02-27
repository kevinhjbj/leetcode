public class Solution {
	public int maxSubArrayLen(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		map.put(sum[0], 0);

		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i != 0) {
				sum[i] = nums[i] + sum[i - 1];
			}
			if (sum[i] == k) {
				result = Math.max(result, i + 1);
				continue;
			}
			if (!map.containsKey(sum[i])) {
				map.put(sum[i], i);
			}
			if (map.containsKey(sum[i] - k)) {
				int index = map.get(sum[i] - k);
				result = Math.max(result, i - index);
			}
		}

		return result;
	}
}
