package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex1600 {
	static int K, W, H;
	static int[][] map;
	static boolean[][][] visit;
	static int result;

	static class Info {
		int r;
		int c;
		int cnt; // 수행횟수
		int useK; // 말처럼 이동한 횟수

		Info(int r, int c, int cnt, int useK) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.useK = useK;
		}
	}

	// 말 방향
	static int[][] hDir = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
	// 원숭이 방향
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= H || c < 0 || c >= W) {
			return false;
		}
		return true;
	}

	static void bfs() {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(0, 0, 0, 0));
		visit[0][0][0] = true;

		while (!que.isEmpty()) {
			int nowR = que.peek().r;
			int nowC = que.peek().c;
			int cnt = que.peek().cnt;
			int useK = que.poll().useK;

			if (nowR == H - 1 && nowC == W - 1) {
				if (result > cnt) {
					result = cnt;
				}
				return;
			}

			// 말처럼 몇번을 이동하든 원숭이방향대로는 움직일 수 있다.
			for (int i = 0; i < 4; i++) {
				int nextR = nowR + dir[i][0];
				int nextC = nowC + dir[i][1];
				if (isRange(nextR, nextC)) {
					if (!visit[nextR][nextC][useK] && map[nextR][nextC] != 1) {
						que.add(new Info(nextR, nextC, cnt + 1, useK));
						visit[nextR][nextC][useK] = true;
					}
				}
			}

			// 말처럼 이동한 횟수가 주어진 것 보다 작다면
			if (useK < K) {
				for (int i = 0; i < 8; i++) {
					int nextR = nowR + hDir[i][0];
					int nextC = nowC + hDir[i][1];
					if (isRange(nextR, nextC)) {
						if (!visit[nextR][nextC][useK + 1] && map[nextR][nextC] != 1) {
							que.add(new Info(nextR, nextC, cnt + 1, useK + 1));
							visit[nextR][nextC][useK + 1] = true;
						}
					}
				}
			}
		}
		result = -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		visit = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		result = Integer.MAX_VALUE;
		bfs();
		System.out.println(result);
	}

}
