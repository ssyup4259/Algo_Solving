package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_17142_연구소3 {
	static final int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M, map[][];
	static List<Info> list = new ArrayList<>();
	static int[] order;
	static int min, totalZ;

	static class Info {
		int r, c, cnt;

		public Info(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Info [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}

	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}

	static void makeOrder(int idx, int start) {
		if (idx == M) {
			// 바이러스 시작점을 구했다면 bfs를 통해 퍼트려 본다.
			Queue<Info> que = new LinkedList<>();
			boolean[][] visit = new boolean[N][N];
			int zero = 0;
			for (int i = 0; i < order.length; i++) {
				que.add(list.get(order[i]));
				visit[list.get(order[i]).r][list.get(order[i]).c] = true;
			}
			int[][] temp = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp[i][j] = map[i][j];
				}
			}

			int res = 0;
			while (!que.isEmpty()) {
				Info now = que.poll();
				if (now.cnt > res) {
					res = now.cnt;
				}
				for (int d = 0; d < 4; d++) {
					int nextR = now.r + dir[d][0];
					int nextC = now.c + dir[d][1];
					if (isRange(nextR, nextC) && !visit[nextR][nextC]) {
						if (map[nextR][nextC] == 0) {
							visit[nextR][nextC] = true;
							temp[nextR][nextC] = now.cnt + 1;
							que.add(new Info(nextR, nextC, now.cnt + 1));
							zero++;
						} else if (map[nextR][nextC] == 2 && zero != totalZ) {
							visit[nextR][nextC] = true;
							temp[nextR][nextC] = now.cnt + 1;
							que.add(new Info(nextR, nextC, now.cnt + 1));
						}
					}
				}
			}
			// System.out.println(res);
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				// System.out.println(Arrays.toString(temp[i]));
				for (int j = 0; j < N; j++) {
					if (temp[i][j] == 0) {
						cnt++;
					}
				}
			}
			// System.out.println("----------------------");
			if (cnt == 0) {
				if (res < min) {
					min = res;
				}
			}
			return;
		}
		
		// 바이러스를 퍼트릴 아이을 dfs로 구한다.
		for (int i = start; i < list.size(); i++) {
			order[idx] = i;
			makeOrder(idx + 1, i + 1);

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		int num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					list.add(new Info(i, j, 0));
					num++;
				} else if (map[i][j] == 0) {
					totalZ++;
				}
			}
		}
		order = new int[M];
		min = Integer.MAX_VALUE;
		makeOrder(0, 0);
		if (min >= Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}

}
