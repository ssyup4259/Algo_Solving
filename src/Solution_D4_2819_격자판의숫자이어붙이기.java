import java.util.HashSet;
import java.util.Scanner;

public class Solution_D4_2819_격자판의숫자이어붙이기 {
 static int[][] map;
	static final int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static HashSet<String> hs;

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= 4 || c < 0 || c >= 4) {
			return false;
		}
		return true;
	}

	static void solve(int r, int c, String str) {
		str += map[r][c];
		if (str.length() == 7) {
			//System.out.println(str);
			hs.add(str);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nextR = r + dir[d][0];
			int nextC = c + dir[d][1];
			if (isRange(nextR, nextC)) {
				solve(nextR, nextC, str);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			map = new int[4][4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			hs = new HashSet<>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					solve(i, j, "");
				}
			}
			System.out.println("#" + tc + " " + hs.size());
		}
	}

}
