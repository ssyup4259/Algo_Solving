package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_백준_1987_알파벳 {

	static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int R, C;
	static char[][] map;
	static List<Character> list;
	static int result;

	static boolean isRange(int r, int c) {
		if (r <= 0 || r > R || c <= 0 || c > C) {
			return false;
		}
		return true;
	}

	static void solve(int r, int c) {
		// System.out.println(list.toString());
		for (int d = 0; d < 4; d++) {
			int nextR = r + dir[d][0];
			int nextC = c + dir[d][1];
			if (isRange(nextR, nextC) && !list.contains(map[nextR][nextC])) {
				list.add(map[nextR][nextC]);

				solve(nextR, nextC);
				list.remove(Character.valueOf(map[nextR][nextC]));
			}
		}
		if (result < list.size()) {
			result = list.size();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R + 1][C + 1];
		list = new ArrayList<>();
		for (int i = 1; i <= R; i++) {
			String str = sc.next();
			for (int j = 1; j <= C; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}
		result = 0;
		list.add(map[1][1]);
		solve(1, 1);
		System.out.println(result);
	}
}
