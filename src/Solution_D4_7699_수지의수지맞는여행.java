import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_7699_수지의수지맞는여행 {
	static int R, C;
	static char[][] map;
	static boolean[] v = new boolean[26];
	static final int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int max;

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C) {
			return false;
		}
		return true;
	}

	static void solve(int r, int c, int cnt) {
		max = max < cnt ? cnt : max;
		v[map[r][c]-'A'] = true;
		for (int d = 0; d < 4; d++) {
			int nextR = r + dir[d][0];
			int nextC = c + dir[d][1];
			if (isRange(nextR, nextC) && !v[map[nextR][nextC]-'A']) {
				solve(nextR, nextC, cnt + 1);
			}
		}
		v[map[r][c]-'A'] = false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			R = sc.nextInt();
			C = sc.nextInt();
			map = new char[R][C];
			for (int i = 0; i < R; i++) {
				String str = sc.next();
				for (int j = 0; j < C; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			max = Integer.MIN_VALUE;
			solve(0, 0, 1);
			System.out.println("#" + tc + " " + max);

		}
	}

}
