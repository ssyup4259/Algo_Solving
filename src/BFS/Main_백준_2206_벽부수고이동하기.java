package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_2206_벽부수고이동하기 {
	static final int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N, M, map[][];

	static class Info {
		int r, c, br, cnt;

		public Info(int r, int c, int br, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.br = br;
			this.cnt = cnt;
		}

	}

	static boolean isRange(int r, int c) {
		if (r < 1 || r > N || c < 1 || c > M) {
			return false;
		}
		return true;
	}

	static int bfs() {
		Queue<Info> que = new LinkedList<>();
		boolean[][][] visit = new boolean[2][N + 1][M + 1];
		que.add(new Info(1, 1, 0, 1));
		visit[0][1][1] = true;
		while (!que.isEmpty()) {
			Info now = que.poll();
			if (now.r == N && now.c == M) {
				return now.cnt;
			}

			for (int d = 0; d < 4; d++) {
				int nextR = now.r + dir[d][0];
				int nextC = now.c + dir[d][1];
				if (isRange(nextR, nextC)) {
					if (map[nextR][nextC] == 0 && !visit[now.br][nextR][nextC]) {
						visit[now.br][nextR][nextC] = true;
						que.add(new Info(nextR, nextC, now.br, now.cnt + 1));
					} else {
						if (now.br == 0 && !visit[now.br + 1][nextR][nextC]) {
							visit[now.br + 1][nextR][nextC] = true;
							que.add(new Info(nextR, nextC, now.br + 1, now.cnt + 1));
						}
					}
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 1; j <= M; j++) {
				map[i][j] = str.charAt(j - 1) - '0';
			}
		}
		System.out.println(bfs());
	}

}
