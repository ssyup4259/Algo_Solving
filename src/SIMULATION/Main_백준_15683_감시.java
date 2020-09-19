package SIMULATION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_백준_15683_감시 {
	static final int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M, map[][], order[];
	static List<Info> list;
	static int result = Integer.MAX_VALUE;

	static class Info {
		int r, c, type;

		public Info(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}

	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) {
			return false;
		}
		return true;
	}

	static void fill(int[][] temp, int r, int c, int d) {
		int nextR = r;
		int nextC = c;
		while (true) {
			nextR += dir[d][0];
			nextC += dir[d][1];
			if (isRange(nextR, nextC) && map[nextR][nextC] != 6) {
				temp[nextR][nextC] = -1;
			} else {
				break;
			}
		}
	}

	static void solve() {
		int[][] temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < list.size(); i++) {
			Info info = list.get(i);
			if (info.type == 1) {
				fill(temp, info.r, info.c, order[i]);
			} else if (info.type == 2) {
				fill(temp, info.r, info.c, order[i]);
				fill(temp, info.r, info.c, (order[i] + 2) % 4);
			} else if (info.type == 3) {
				fill(temp, info.r, info.c, order[i]);
				fill(temp, info.r, info.c, (order[i] + 1) % 4);
			} else if (info.type == 4) {
				fill(temp, info.r, info.c, order[i]);
				fill(temp, info.r, info.c, (order[i] + 1) % 4);
				fill(temp, info.r, info.c, (order[i] + 3) % 4);
			} else {
				fill(temp, info.r, info.c, 0);
				fill(temp, info.r, info.c, 1);
				fill(temp, info.r, info.c, 2);
				fill(temp, info.r, info.c, 3);
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			// System.out.println(Arrays.toString(temp[i]));
			for (int j = 0; j < M; j++) {
				if (temp[i][j] == 0) {
					cnt++;
				}
			}
		}
		// System.out.println("========================");

		result = Math.min(cnt, result);
	}

	// CCTV가 바라보는 방향을 모든 경우에 대해서 구한다.
	static void makeOrder(int node) {
		if (node == list.size()) {
			// System.out.println(Arrays.toString(order));
			solve();
			return;
		}
		for (int i = 0; i < 4; i++) {
			order[node] = i;
			makeOrder(node + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					list.add(new Info(i, j, map[i][j]));
				}
			}
		}

		order = new int[list.size()];
		makeOrder(0);
		System.out.println(result);
	}
}
