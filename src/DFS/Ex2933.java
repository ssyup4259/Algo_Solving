package DFS;

import java.util.Scanner;

public class Ex2933 {
	static int R, C;
	static char[][] map;
	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	static void breakMineral(int cnt, int r) { // ¹Ì³×¶ö ÆÄ±«
		if (cnt % 2 == 0) {
			for (int i = 0; i < C; i++) {
				if (map[r][i] == 'x') {
					map[r][i] = '.';
					break;
				}
			}
		} else {
			for (int i = -1; i >= 0; i--) {
				if (map[r][i] == 'x') {
					map[r][i] = '.';
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			breakMineral(i, R - sc.nextInt());
		}
	}
}
