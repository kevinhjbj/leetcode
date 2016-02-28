public class Solution {
	int[] dx = {1, -1, 0, 0};
	int[] dy = {0, 0, 1, -1};
	public void wallsAndGates(int[][] rooms) {
		int m = rooms.length;
		if (m == 0) {
			return;
		}
		int n = rooms[0].length;
		if (n == 0) {
			return;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) {
					bfs(rooms, i, j);
				}
			}
		}
	}

	private void bfs(int[][] rooms, int i, int j) {
		int m = rooms.length;
		int n = rooms[0].length;
		boolean[][] visited = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == -1 || rooms[i][j] == 0) {
					visited[i][j] = true;
				}
			}
		}

		Queue<Integer> row = new LinkedList<>();
		Queue<Integer> col = new LinkedList<>();
		Queue<Integer> dis = new LinkedList<>();

		row.offer(i);
		col.offer(j);
		dis.offer(0);

		while (!row.isEmpty()) {
			int size = row.size();
			for (int k = 0; k < size; k++) {
				int x = row.poll();
				int y = col.poll();
				int distance = dis.poll();
				for (int dir = 0; dir < 4; dir++) {
					x += dx[i];
					y += dy[i];
					if (x < m && y < n && !visited[x][y]) {
						if (rooms[x][y] > 0) {
							rooms[x][y] = Math.min(rooms[x][y], distance + 1);
							row.offer(x);
							col.offer(y);
							dis.offer(rooms[x][y]);
							visited[x][y] = true;
						}
					}
				}
			}
		}
	}
}
