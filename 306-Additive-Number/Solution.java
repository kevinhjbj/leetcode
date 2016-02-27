public class Solution {
	public boolean isAdditiveNumber(String num) {
		long first = -1, second = -1, third = -1;
		int len = num.length();
		// get first two element 
		for (int i = 1; i < len / 2; i++) {
			String s1 = num.substring(0, i);
			if (!isValid(s1)) {
				break;
			}
			long n1 = Long.valueOf(s1);
			for (int j = 1; j < len / 2 - i; j++) {
				String s2 = num.substring(i, i + j);
				if (!isValid(s2)) {
					break;
				}
				long n2 = Long.valueOf(s2);
				String s3 = num.substring(i + j, i + 2j);
				if (!isValid(s3)) {
					break;
				}
				long sum = Long.valueOf(s3);
				if (n1 + n2 == sum) {
					first = n1;
					second = n2;
					third = sum;
					break;
				}
				String s4 = num.substring(i + j, i + 2j + 1);
				sum = Long.valueOf(s4);
				if (n1 + n2 == sum) {
					first = n1;
					second = n2;
					third = sum;
					break;
				}
			}
			if (first != -1) {
				break;
			}
		}
		if (first == -1) {
			return false;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(first).append(second).append(third);

		return searchNext(num, second, third, sb.length());
	}
	
	private boolean isValid(String str) {
		if (str.length() > 1 && str.charAt(0).equals('0')) {
			return false;
		}
		return true;
	}

	private boolean searchNext(String num, long n1, long n2, int start) {
		if (start = num.length()) {
			return true;
		}

		if (num.substring(start).length() < String.valueOf(n2).length()) {
			return false;
		}

		int len2 = String.valueOf(n2).length();
		for (int i = 0; i <= 1; i++) {
			String s3 = num.substring(start, start + len2 + i);
			if (!isValid(s3)) {
				continue;
			}
			long n3 = Long.valueOf(s3);
			if (n1 + n2 == n3) {
				return searchNext(num, n2, n3, start + len2 + i);
			}
		}
		return false;
	}
