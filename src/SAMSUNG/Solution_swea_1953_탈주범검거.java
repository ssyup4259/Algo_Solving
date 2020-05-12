package SAMSUNG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_swea_1953_탈주범검거 {
	// 상0 우1 하2 좌3, 비트 연산 1,2,4,8
	static final int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M, map[][];

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
		if (r < 0 || r >= N || c < 0 || c >= M) {
			return false;
		}
		return true;
	}

	// 현재에서 오른쪽으로 가면 다음 칸에서는 왼쪽에서 온것이다
	static int changeD(int d) {
		if (d == 0) {
			return 2;
		} else if (d == 1) {
			return 3;
		} else if (d == 2) {
			return 0;
		} else {
			return 1;
		}
	}

	static int solve(int R, int C, int L) {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(R, C, 0));
		boolean[][] visit = new boolean[N][M];
		visit[R][C] = true;
		int res = 0;
		while (!que.isEmpty()) {
			Info now = que.poll();
			for (int d = 0; d < 4; d++) {
				// 현재 칸에서 벽이 막혀있지 않으면
				if ((map[now.r][now.c] & 1 << d) == 0) {
					int nextR = now.r + dir[d][0];
					int nextC = now.c + dir[d][1];
					// 다음 칸이 범위 안이고 간 곳이 아니라면
					if (isRange(nextR, nextC) && !visit[nextR][nextC]) {
						// 다음 칸이 지금 칸으로부터 오는길이 막혀 있지않다면
						int dd = changeD(d);
						if ((map[nextR][nextC] & 1 << dd) == 0) {
							visit[nextR][nextC] = true;
							if (now.cnt + 1 < L) {
								res++;
								que.add(new Info(nextR, nextC, now.cnt + 1));
							}
						}
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][M];
			int R = sc.nextInt();
			int C = sc.nextInt();
			int L = sc.nextInt();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int type = sc.nextInt();
					if (type == 0) {
						map[i][j] = 15;
					} else if (type == 1) {
						map[i][j] = 0;
					} else if (type == 2) {
						map[i][j] = 10;
					} else if (type == 3) {
						map[i][j] = 5;
					} else if (type == 4) {
						map[i][j] = 12;
					} else if (type == 5) {
						map[i][j] = 9;
					} else if (type == 6) {
						map[i][j] = 3;
					} else if (type == 7) {
						map[i][j] = 6;
					}
				}
			}
			int res = solve(R, C, L);
			System.out.println("#" + tc + " " + (res + 1));
		}
	}

}
