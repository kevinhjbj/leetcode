public class Solution {
	public boolean isPowerOfTwo(int n) {
		// 11:23 - 
		int remainder;
		while (n % 2 == 0 && n > 1) {
			n = n / 2;
		}

		if (n == 1) {
			return true;
		} else {
			return false;
		}
	}
}
