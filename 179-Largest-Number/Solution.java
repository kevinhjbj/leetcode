public class Solution {
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}

		mergeSort(nums, 0, nums.length - 1);
		StringBuilder sb = new StringBuilder();
        
        if (nums[nums.length - 1] == 0) {
            return "0";
        }
		for (int i = nums.length - 1; i >= 0; i--) {
			sb.append(nums[i]);
		}
        return sb.toString();
	}

	private void mergeSort(int[] nums, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int mid = lo + (hi - lo) / 2;
		mergeSort(nums, lo, mid);
		mergeSort(nums, mid + 1, hi);
		merge(nums, lo, hi);
	}

	private void merge(int nums[], int lo, int hi) {
		int[] aux = new int[hi - lo + 1];
		for (int k = 0; k < hi - lo + 1; k++) {
			aux[k] = nums[lo + k];
		}
		
		int mid = (aux.length - 1) / 2;
		int i = 0, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				nums[k] = aux[j++];
			} else if (j >= aux.length) {
				nums[k] = aux[i++];
			} else if (less(aux[i], aux[j])) {
				nums[k] = aux[i++];
			} else {
				nums[k] = aux[j++];
			}
		}
	}

	private boolean less (int a, int b) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb1.append(a).append(b);
		sb2.append(b).append(a);
		
		for (int i = 0; i < sb1.length(); i++) {
		    Character c1 = sb1.charAt(i);
			Character c2 = sb2.charAt(i);
			if (c1.equals(c2)) {
				continue;
			}
			return c1 < c2;
		}
		return true;
	}
}
