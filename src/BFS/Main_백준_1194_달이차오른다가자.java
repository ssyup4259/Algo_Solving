package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_백준_1194_달이차오른다가자 {

	static final int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int N, M;
	static char[][] map;
	static boolean[][][] visit;
	static Queue<Info> que;

	static class Info {
		int r, c, cnt, getKey;

		public Info(int r, int c, int cnt, int getKey) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.getKey = getKey;
		}
	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) {
			return false;
		}
		return true;
	}

	static void solve() {
		while (!que.isEmpty()) {
			int nowR = que.peek().r;
			int nowC = que.peek().c;
			int nowCnt = que.peek().cnt;
			int nowKey = que.poll().getKey;
			if (map[nowR][nowC] == '1') {
				System.out.println(nowCnt);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nextR = nowR + dir[d][0];
				int nextC = nowC + dir[d][1];

				if (isRange(nextR, nextC) && !visit[nowKey][nextR][nextC]) {
					char next = map[nextR][nextC];
					if (next == '.' || next == '0' || next == '1') {
						visit[nowKey][nextR][nextC] = true;
						que.add(new Info(nextR, nextC, nowCnt + 1, nowKey));
					} else if (next >= 'A' && next <= 'F') {
						int newKey = nowKey;
						if ((nowKey & (1 << (next - 'A'))) >= 1) {
							visit[newKey][nextR][nextC] = true;
							que.add(new Info(nextR, nextC, nowCnt + 1, newKey));
						}
					} else if (next >= 'a' && next <= 'f') {
						int newKey = nowKey;
						if ((nowKey & (1 << (next - 'a'))) == 0) {
							newKey = nowKey + (1 << (next - 'a'));
						}
						visit[newKey][nextR][nextC] = true;
						que.add(new Info(nextR, nextC, nowCnt + 1, newKey));
					}
				}
			}
		}
		System.out.println(-1);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visit = new boolean[64][N][M];
		que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					visit[0][i][j] = true;
					que.add(new Info(i, j, 0, 0));
				}
			}
		}
		solve();
	}

}
