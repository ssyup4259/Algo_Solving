package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class InfoEx2146 {
	int r;
	int c;
	int cnt;

	public InfoEx2146(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class Ex2146 {
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int count;
	static int result;

	static void bfs(int r, int c) {
		Queue<InfoEx2146> que = new LinkedList<>();
		que.add(new InfoEx2146(r, c, 0));
		int nowR = r;
		int nowC = c;

		while (!que.isEmpty()) {
			r = que.peek().r;
			c = que.peek().c;
			int aaa = que.poll().cnt;

			for (int i = 0; i < 4; i++) {
				int nextR = r + dir[i][0];
				int nextC = c + dir[i][1];
				int nextCnt = aaa + 1;

				if (map[nextR][nextC] != -1) {
					// 지금 현재의 섬에 머물렀다면
					if (map[nextR][nextC] == map[nowR][nowC]) {
						continue;
					}
					// 이미 방문했다면
					if (visit[nextR][nextC]) {
						continue;
					}
					// 방문하지 않았고 다른 섬이라면
					if (map[nextR][nextC] != 0) {
						// 섬 내부까지 cnt+1 되었으니 다시 -1 해서 최소값
						result = Math.min(result, nextCnt - 1);
						return;
					}

					visit[nextR][nextC] = true;
					que.add(new InfoEx2146(nextR, nextC, nextCnt));
				}
			}
		}

	}

	static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];

			if (map[nextR][nextC] != -1) {
				if (map[nextR][nextC] == count) {
					continue;
				} else if (map[nextR][nextC] == 0) {
					continue;
				} else {
					map[nextR][nextC] = count;
					dfs(nextR, nextC);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 2][N + 2];
		count = 1;
		result = 10000;
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				if (i == 0 || j == 0 || i == N + 1 || j == N + 1) {
					map[i][j] = -1;
				} else {
					map[i][j] = sc.nextInt();
				}

			}
		}

		// 하나의 섬은 하나의 숫자로 바꾼다. 111 섬, 222 섬 등등
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				if (map[i][j] == 1) {
					count++;
					map[i][j] = count;
					dfs(i, j);
				}
			}
		}

		// 1의섬에서 2의섬 또는 3의섬 다리 길이중 짧은 것 출력
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (map[i][j] != 0) {
					visit = new boolean[N + 2][N + 2];
					bfs(i, j);
				}
			}
		}

		System.out.println(result);
	}

}
