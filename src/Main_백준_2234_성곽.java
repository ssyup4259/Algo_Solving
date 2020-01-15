import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_2234_성곽 {
	static final int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
	static int n, m;
	static int[][] map;
	static boolean[][][] visit;
	static int maxZ, maxB;

	static class Info {
		int r, c, k;

		public Info(int r, int c, int k) {
			this.r = r;
			this.c = c;
			this.k = k;
		}

	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= m || c < 0 || c >= n) {
			return false;
		}
		return true;
	}

	static void solve(int r, int c) {
		Queue<Info> que = new LinkedList<>();
		int cnt = 1;
		que.add(new Info(r, c, 0));
		while (!que.isEmpty()) {
			Info now = que.poll();
			for (int i = 0; i < 4; i++) {
				if ((map[now.r][now.c] & (1 << i)) == 0) {
					int nextR = now.r + dir[i][0];
					int nextC = now.c + dir[i][1];
					if (isRange(nextR, nextC) && !visit[0][nextR][nextC]) {
						visit[0][nextR][nextC] = true;
						que.add(new Info(nextR, nextC, 0));
						cnt++;
					}
				}
			}
		}
		maxZ = cnt > maxZ ? cnt : maxZ;
	}

	static void solveB(int r, int c) {
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[m][n];
		visit = new boolean[2][m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		maxZ = 0;
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[0][i][j]) {
					cnt++;
					visit[0][i][j] = true;
					solve(i, j);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(maxZ);

		maxB = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[0][i][j]) {
					cnt++;
					visit[0][i][j] = true;
					solveB(i, j);
				}
			}
		}
	}

}