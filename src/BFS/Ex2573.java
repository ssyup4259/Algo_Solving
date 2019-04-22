package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex2573 {
	static int N, M, land, result;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] visit;
	static Queue<Info> que;

	static class Info {
		int r;
		int c;
		int zeroCnt; // 주변의 물 갯수

		public Info(int r, int c, int zeroCnt) {
			this.r = r;
			this.c = c;
			this.zeroCnt = zeroCnt;
		}
	}

	static boolean isRange(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M) {
			return false;
		}
		return true;
	}

	// 주변 물 갯 수 확인
	static void checkZero() {
		que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// map 을 탐색하면서 빙하 이라면 que에 넣고 주변 물갯수를 구한다.
				if (map[i][j] != 0) {
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int nextR = i + dir[d][0];
						int nextC = j + dir[d][1];

						if (isRange(nextR, nextC) && map[nextR][nextC] == 0) {
							cnt++;
						}
					}
					que.add(new Info(i, j, cnt));
				}
			}
		}
	}

	// 물 갯수 확인한거 1년 지나는 동안 빼준다.
	static void melt() {
		land = 0;
		while (!que.isEmpty()) {
			Info p = que.poll();

			int r = p.r;
			int c = p.c;
			int zeroCnt = p.zeroCnt;

			map[r][c] = map[r][c] - zeroCnt;
			if (map[r][c] < 0) {
				map[r][c] = 0;
			}
		}

		// 1년후의 빙하 만들어지고 섬의 갯수를 구한다.
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && !visit[i][j]) {
					DFS(i, j);
					// Dfs 가 끝났다는것은 새로운 섬이 만들어지는 것
					land++;
					if (land >= 2) {
						System.out.println(result + 1);
						return;
					}
				}
			}
		}
	}

	static void DFS(int r, int c) {
		visit[r][c] = true;
		for (int i = 0; i < 4; i++) {// 인접한 점들
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];

			if (isRange(nextR, nextC) && map[nextR][nextC] != 0 && !visit[nextR][nextC]) {
				DFS(nextR, nextC);
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

		while (true) {
			checkZero();
			// 빙하가 없다면 2개의상의 섬을 만들 수 없다는 것
			if (que.size() == 0) {
				System.out.println(0);
				break;
			} else {
				melt();
				result++;
			}
		}
	}

}
