package DFS;

import java.util.Scanner;

public class Main_백준_3109_빵집 {
	static final int[][] dir = { { 0, 1 }, { 1, 1 }, { -1, 1 } };
	static int R, C;
	static char[][] map;

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C) {
			return false;
		}
		return true;
	}

	static void dfs(int r, int c) {

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
	}

}
