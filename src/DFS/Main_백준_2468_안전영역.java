package DFS;

import java.util.Scanner;

public class Main_백준_2468_안전영역 {
	static final int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int N;
	static int[][] map;
	static boolean[][] visit;

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}

	static void dfs(int r, int c, int day) {
		for (int d = 0; d < 4; d++) {
			int nextR = r + dir[d][0];
			int nextC = c + dir[d][1];
			if (isRange(nextR, nextC) && !visit[nextR][nextC] && map[nextR][nextC] > day) {
				visit[nextR][nextC] = true;
				dfs(nextR, nextC, day);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int max = 0;
		for (int day = 0; day <= 100; day++) {
			if (day == 0) {
				max = 1;
				continue;
			}

			visit = new boolean[N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j] && map[i][j] > day) {
						cnt++;
						visit[i][j] = true;
						dfs(i, j, day);
					}
				}
			}
			if (max < cnt) {
				max = cnt;
			}
		}
		System.out.println(max);
	}

}
