package DFS;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Ex3197 {
	static int R, C;
	static char[][] map;
	static int[][] board;
	static boolean[][] visit;
	static List<Info> baek;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int result;

	static class Info {
		int r;
		int c;
		int status; // 1. 백조가 존재하는 섬, 2. 섬간의 거리 길이 측정용

		Info(int r, int c, int status) {
			this.r = r;
			this.c = c;
			this.status = status;
		}
	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C) {
			return false;
		}
		return true;
	}

	static void dfs(int r, int c, int cnt) {

		for (int i = 0; i < 4; i++) {
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];

			if (isRange(nextR, nextC)) {
				if (map[nextR][nextC] == '.' && board[nextR][nextC] == 0) {
					board[nextR][nextC] = cnt;
					dfs(nextR, nextC, cnt);
				} else if (map[nextR][nextC] == 'L' && board[nextR][nextC] == 0) {
					board[nextR][nextC] = cnt;
					baek.add(new Info(nextR, nextC, cnt));
					dfs(nextR, nextC, cnt);
				}
			}
		}
	}

	static void bfs(int r, int c) {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(r, c, 0));
		visit[r][c] = true;

		while (!que.isEmpty()) {
			int nowR = que.peek().r;
			int nowC = que.peek().c;
			int nowS = que.poll().status;

			if (board[nowR][nowC] == baek.get(1).status) {
				if (result > nowS) {
					result = nowS - 1;
				}
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextR = nowR + dir[i][0];
				int nextC = nowC + dir[i][1];
				if (isRange(nextR, nextC) && !visit[nextR][nextC]) {
					if (board[nextR][nextC] == baek.get(0).status) {
						continue;
					} else {
						que.add(new Info(nextR, nextC, nowS + 1));
						visit[nextR][nextC] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		map = new char[R][C];
		board = new int[R][C];
		baek = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int cnt = 1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != 'X' && board[i][j] == 0) {
					dfs(i, j, cnt);
					cnt++;
				}
			}
		}

		result = 10000000;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == baek.get(0).status) {
					visit = new boolean[R][C];
					bfs(i, j);
				} else {
					continue;
				}
			}
		}

		if (result % 2 == 0) {
			result = result / 2;
		} else {
			result = result / 2 + 1;
		}
		System.out.println(result);
	}

}
