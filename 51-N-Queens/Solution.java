public class Solution {
	private List<String> drawBoard(ArrayList<Integer> cols) {
		List<String> result = new ArrayList(String);
		int size = cols.size();

		for (int i = 0; i < size; i++) {
			String line = new String();
			for (int j = 0; j < size; j++) {
				if (j == cols.get(i)) {
					line += "Q";
				} else {
					line += ".";
				}
			}
			result.add(line);
		}

		return result;
	}

	private boolean isValid(ArrayList<Integer> cols, int col) {
		int row = cols.size(); // newly added queen's positon is (row, col)
		
		/* if at the same column */
		if (cols.contains(col)) {
			return false;
		}

		/* left-top to right-bottom */
		for (int i = 0; i < row; i++) {
			if (row - i != col - cols.get(i)) {
				return false;
			}
		}

		/* left-bottom to right-top */
		for (int i = 0; i < row; i++) {
			if (row + col != i + cols.get(i)) {
				return false;
			}
		}

		return true;
	}

	private void search(int n, ArrayList<Integer> cols,
			    List<List<String>> result) {
		if (cols.size() == n) {
			result.add(drawBoard(cols));
			return;
		}

		for (int i = 0; i < n; i++) {
			/* check valid first, if valid add, if not don't add */
			/* always check validity first in all enumeration problems */
			if (!isValid(cols, i)) {
				continue;
			}
			cols.add(i);
			search(n, cols, result);
			cols.remove(cols.size() - 1);
		}
	}
    
	public List<List<String>> solveNQueens(int n) {
		if (n <= 0) {
			return null;
		}

		List<List<String>>  result = new ArrayList<List<String>>();
		/* col[i] stands for column number of the queen's position at row i */
		List<Integer> 	cols   = new ArrayList<Integer>();
		search(n, cols, result);

		return result;
	}
}
