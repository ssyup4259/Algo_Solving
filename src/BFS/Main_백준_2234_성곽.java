package BFS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_2234_성곽 {
	static final int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int n, m, map[][];
	static boolean[][] visit;
	static List<Info> list;

	static class Info {
		int r, c;

		public Info(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= m || c < 0 || c >= n) {
			return false;
		}
		return true;
	}

	static int solve(int r, int c) {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(r, c));
		list.add(new Info(r, c));
		visit[r][c] = true;
		int cnt = 1;
		while (!que.isEmpty()) {
			Info now = que.poll();
			for (int d = 0; d < 4; d++) {
				int nextR = now.r + dir[d][0];
				int nextC = now.c + dir[d][1];

				if (isRange(nextR, nextC) && !visit[nextR][nextC]) {
					if ((map[nextR][nextC] & (1 << d)) == 0) {
						cnt++;
						visit[nextR][nextC] = true;
						que.add(new Info(nextR, nextC));
						list.add(new Info(nextR, nextC));
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		visit = new boolean[m][n];
		int max = 0;
		int cnt = 0;
		int[][][] board = new int[m][n][2];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					list = new ArrayList<>();
					int flag = solve(i, j);
					if (max < flag) {
						max = flag;
					}
					cnt++;
					for (int k = 0; k < list.size(); k++) {
						Info now = list.get(k);
						board[now.r][now.c][0] = flag;
						board[now.r][now.c][1] = cnt;
					}
				}
			}
		}

		int useKmax = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int d = 0; d < 4; d++) {
					int nextR = i + dir[d][0];
					int nextC = j + dir[d][1];
					if (isRange(nextR, nextC)) {
						if (board[nextR][nextC][1] != board[i][j][1]) {
							int flag = board[nextR][nextC][0] + board[i][j][0];
							if (flag > useKmax) {
								useKmax = flag;
							}
						}
					}
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
		System.out.println(useKmax);
	}

}