public class Solution {
	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();

		help(res, word, 0, 0, "");

		return res;
	}

	private void help(List<String> res, String word, int pos, int count, String cur) {
		if (pos >= word.length()) {
			if (count > 0) {
				cur += count;
			}
			res.add(cur);
		} else {
			help(res, word, pos + 1, count + 1, cur); // abbreviate current character
			// not abbreviate current char
			if (count > 0) {
				cur += count;
			}
			help(res, word, pos + 1, 0, cur + word.charAt(pos));
		}
	}
}