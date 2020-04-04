package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_7569_토마토 {
	static final int[][] dir = { { 0, 0, 1 }, { 0, 0, -1 }, { 0, 1, 0 }, { 0, -1, 0 }, { 1, 0, 0 }, { -1, 0, 0 } };
	static int M, N, H, cnt;
	static int[][][] arr, map;
	static int min, res;
	static boolean[][][] visit;

	static class Info {
		int h, r, c, cnt;

		public Info(int h, int r, int c, int cnt) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static boolean isRange(int h, int r, int c) {
		if (h < 0 || h >= H || r < 0 || r >= N || c < 0 || c >= M) {
			return false;
		}
		return true;
	}

	static void bfs(int h, int r, int c) {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(h, r, c, 0));
		int ans = 0;
		while (!que.isEmpty()) {
			Info now = que.poll();
			ans = now.cnt;
			for (int i = 0; i < 6; i++) {
				int nextH = now.h + dir[i][0];
				int nextR = now.r + dir[i][1];
				int nextC = now.c + dir[i][2];

				if (isRange(nextH, nextR, nextC) && !visit[nextH][nextR][nextC] && arr[nextH][nextR][nextC] == 0) {
					visit[nextH][nextR][nextC] = true;
					map[nextH][nextR][nextC] = 1;
					que.add(new Info(nextH, nextR, nextC, now.cnt + 1));
				}
			}
		}
		if (ans > min) {
			min = ans;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();
		arr = new int[H][N][M];
		map = new int[H][N][M];

		int noCnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					arr[i][j][k] = sc.nextInt();
					map[i][j][k] = arr[i][j][k];
					if (arr[i][j][k] == 0) {
						noCnt++;
					}
				}
			}
		}

		if (noCnt == 0) {
			System.out.println(0);
			return;
		}

		res = 0;
		min = 0;
		visit = new boolean[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (arr[i][j][k] == 1 && !visit[i][j][k]) {
						visit[i][j][k] = true;
						bfs(i, j, k);
					}
				}
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(min);
	}

}
