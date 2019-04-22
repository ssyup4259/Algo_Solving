package SAMSUNG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex16234 {
	static int N, L, R;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int result; // 인구 이동수
	static boolean moveChk;

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}

	static class Info {
		int r;
		int c;

		Info(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static void bfs(int r, int c) {
		Queue<Info> que = new LinkedList<>();
		Queue<Info> que2 = new LinkedList<>();
		que.add(new Info(r, c));
		que2.add(new Info(r, c)); // 새로운 인구수 입력용
		visit[r][c] = true;
		int sum = map[r][c];
		int cnt = 1;

		while (!que.isEmpty()) {
			int nowR = que.peek().r;
			int nowC = que.poll().c;

			for (int i = 0; i < 4; i++) {
				int nextR = nowR + dir[i][0];
				int nextC = nowC + dir[i][1];

				if (!isRange(nextR, nextC)) {
					continue;
				}
				if (visit[nextR][nextC]) {
					continue;
				} else if (!visit[nextR][nextC]) {
					if (Math.abs(map[nextR][nextC] - map[nowR][nowC]) >= L
							&& Math.abs(map[nextR][nextC] - map[nowR][nowC]) <= R) {
						sum = sum + map[nextR][nextC];
						cnt++;
						moveChk = true; // 인구이동이 일어나니깐 true
						visit[nextR][nextC] = true;
						que.add(new Info(nextR, nextC));
						que2.add(new Info(nextR, nextC));
					}
				}
			}
		}

		int flag = sum / cnt;
		while (!que2.isEmpty()) { // 인구이동후 인구수 입력
			map[que2.peek().r][que2.peek().c] = flag;
			que2.poll();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		map = new int[N][N];
		result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		moveChk = true; // 인구이동이 일어나는지 확인용
		while (moveChk) {
			visit = new boolean[N][N];
			moveChk = false;
			result++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j]) {
						continue;
					}
					bfs(i, j);
				}
			}
		}
		System.out.println((result - 1)); // while 무조건 한번먼저 도니깐 -1 해줘야된다
	}
}
