package GRAPH;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_백준_17472_다리만들기2 {
	static final int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int N, M, map[][], p[];
	static boolean[][] visit;
	static PriorityQueue<Info> pq = new PriorityQueue<>();

	static class Info implements Comparable<Info> {
		int start, end, w;

		public Info(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Info o) {
			return Integer.compare(this.w, o.w);
		}

	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) {
			return false;
		}
		return true;
	}

	static void distinct(int r, int c, int dist) {
		visit[r][c] = true;
		map[r][c] = dist;

		for (int d = 0; d < 4; d++) {
			int nextR = r + dir[d][0];
			int nextC = c + dir[d][1];
			if (isRange(nextR, nextC) && !visit[nextR][nextC] && map[nextR][nextC] == 1) {
				distinct(nextR, nextC, dist);
			}
		}
	}

	static void checkLen(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nowR = r;
			int nowC = c;
			int len = 0;
			while (true) {
				nowR += dir[d][0];
				nowC += dir[d][1];
				if (!isRange(nowR, nowC)) {
					break;
				} else if (isRange(nowR, nowC)) {
					if (map[nowR][nowC] == 0) {
						len++;
					} else {
						break;
					}
				}
			}

			if (len >= 2 && isRange(nowR, nowC)) {
				pq.add(new Info(map[r][c], map[nowR][nowC], len));
			}
		}
	}

	static int find(int x) {
		if (p[x] != x) {
			p[x] = find(p[x]);
			return p[x];
		}
		return x;
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			if (a < b) {
				p[b] = a;
			} else {
				p[a] = b;
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

		visit = new boolean[N][M];
		int dist = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					distinct(i, j, dist);
					dist++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					checkLen(i, j);
				}
			}
		}

		p = new int[dist];
		for (int i = 1; i < dist; i++) {
			p[i] = i;
		}

		int sum = 0;
		int cnt = 0;
		while (!pq.isEmpty()) {
			Info now = pq.poll();
			if (find(now.start) != find(now.end)) {
				union(now.start, now.end);
				cnt++;
				sum += now.w;
			}

			if (cnt == dist - 2) {
				break;
			}
		}
		if (cnt != dist - 2) {
			sum = -1;
		}
		System.out.println(sum);
	}

}
