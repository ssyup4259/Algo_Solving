package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_2178_미로탐색 {
	static int N, M;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static class Info {
		int r, c, cnt;

		Info(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) {
			return false;
		}
		return true;
	}

	static void bfs() {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(0, 0, 1));
		visit[0][0] = true;

		while (!que.isEmpty()) {
			int nowR = que.peek().r;
			int nowC = que.peek().c;
			int cnt = que.poll().cnt;
			if (nowR == N - 1 && nowC == M - 1) {
				System.out.println(cnt);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextR = nowR + dir[i][0];
				int nextC = nowC + dir[i][1];

				if (isRange(nextR, nextC)) {
					if (map[nextR][nextC] == '1' && !visit[nextR][nextC]) {
						que.add(new Info(nextR, nextC, cnt + 1));
						visit[nextR][nextC] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		visit = new boolean[N][M];
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		bfs();

	}

}
