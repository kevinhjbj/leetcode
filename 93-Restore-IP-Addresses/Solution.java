public class Solution {
	public List<String> restoreIpAddresses(String s) {
		// 10:27 - 10:48 
		List<String> result = new ArrayList<String>();
		String list = new String();

		if (s.length() == 0) {
			return result;
		}

		search(s, result, list, 0);

		return result;
	}

	private void search(String s, List<String> result, String list, int cut) {
		if (s.length() == 0) {
			return;
		}

		
		if (cut == 3) {
		    if (s.length() < 4) {
		        int curVal = Integer.parseInt(s);
		        if (isValid(s)) {
		            list += s;
			        result.add(new String(list));
		        }
		    }
		    return;
		}

		for (int i = 0; i < Math.min(s.length(), 3); i++) {
			String prefix = s.substring(0, i + 1);
			if (!isValid(prefix)) {
				continue;
			}

			list += prefix + ".";
			String suffix = s.substring(i + 1);
			search(suffix, result, list, cut + 1);
			list = list.substring(0, list.length() - prefix.length() - 1);
		}
	}
	
	private boolean isValid(String s){
        if(s.charAt(0) == '0')
            return s.equals("0"); // to eliminate cases like "00", "10"
        int digit = Integer.valueOf(s);
        return (digit >= 0 && digit <= 255);
    }
}
