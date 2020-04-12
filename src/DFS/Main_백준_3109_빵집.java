package DFS;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_3109_빵집 {
	static final int[][] dir = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static int cnt;

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C) {
			return false;
		}
		return true;
	}

	static int dfs(int r, int c) {
		visit[r][c] = true;
		if (c == C - 1) {
			cnt++;
			return 1;
		}

		for (int d = 0; d < 3; d++) {
			int nextR = r + dir[d][0];
			int nextC = c + dir[d][1];
			if (isRange(nextR, nextC) && !visit[nextR][nextC] && map[nextR][nextC] == '.') {
				int v = dfs(nextR, nextC);
				if (v == 1) {
					return 1;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		visit = new boolean[R][C];
		cnt = 0;
		for (int i = 0; i < R; i++) {
			dfs(i, 0);
			for (int r = 0; r < R; r++) {
				System.out.println(Arrays.toString(visit[r]));
			}
			System.out.println("----------------------");
		}
		System.out.println(cnt);
	}

}
