public class Solution {
	public int maxProduct(String[] words) {
		if (words == null || words.length == 0) {
			return 0;
		}
		
		// store each word's bit-representation
		int[] map = new int[words.length];

		// Sort all words from long to short
		Arrays.sort(words, new Comparator<String>() {
				public int compare(String s1, String s2) {
					return s2.length() - s1.length();
				}
			});

		// create bit-form of each word
		for (int i = 0; i < words.length; i++) {
			int bits = 0;
			for (int j = 0; j < words[i].length(); j++) {
				char c = words[i].charAt(j);
				bits |= 1 << (c - 'a');
			}
			map[i] = bits;
		}
		
		int max = 0;
		for (int i = 0; i < words.length; i++) {
			int l1 = words[i].length();
			if (l1 * l1 <= max) {
				// all words after words[i] is shorter. no need to proceed
				break;
			}
			for (int j = i + 1; j < words.length; j++) {
				int l2 = words[j].length();
				if (l1 * l2 <= max) {
					break;
				}
				if ((map[i] & map[j]) == 0) {
					max = Math.max(max, l1 * l2);
					break;
				}
			}
		}
		return max;
	}
}
