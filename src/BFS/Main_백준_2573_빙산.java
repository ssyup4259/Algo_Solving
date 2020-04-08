package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_2573_빙산 {
	static final int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N, M, map[][];
	static Queue<Info> que = new LinkedList<>();
	static boolean[][] visit;

	static class Info {
		int r, c, arround;

		public Info(int r, int c, int arround) {
			super();
			this.r = r;
			this.c = c;
			this.arround = arround;
		}

	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) {
			return false;
		}
		return true;
	}

	static int checkArround(int r, int c) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			int nextR = r + dir[d][0];
			int nextC = c + dir[d][1];
			if (isRange(nextR, nextC) && map[nextR][nextC] == 0) {
				cnt++;
			}
		}
		return cnt;
	}

	static void dfs(int r, int c) {
		int arround = checkArround(r, c);
		que.add(new Info(r, c, arround));
		for (int d = 0; d < 4; d++) {
			int nextR = r + dir[d][0];
			int nextC = c + dir[d][1];
			if (isRange(nextR, nextC) && !visit[nextR][nextC] && map[nextR][nextC] != 0) {
				visit[nextR][nextC] = true;
				dfs(nextR, nextC);
			}
		}
	}

	static int checkDistinct() {
		int cnt = 0;
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visit[i][j]) {
					if (cnt == 0) {
						visit[i][j] = true;
						cnt++;
						dfs(i, j);
					} else {
						return 1; // 2개 구역 이상
					}
				}
			}
		}
		if (cnt == 0) { // 모두가 다녹아서 0일때
			return 0;
		} else { // 아직 1개 구역일때
			return 2;
		}
	}

	static void afterYear() {
		while (!que.isEmpty()) {
			Info now = que.poll();
			map[now.r][now.c] -= now.arround;
			if (map[now.r][now.c] < 0) {
				map[now.r][now.c] = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int result = 0;
		while (true) {
			int check = checkDistinct();
			if (check == 0) {
				result = 0;
				break;
			} else if (check == 1) {
				break;
			} else {
				result++;
				afterYear();
			}
		}

		System.out.println(result);
	}

}
