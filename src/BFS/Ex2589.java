package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class InfoEx2589 {
	int r;
	int c;
	int cnt;

	InfoEx2589(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class Ex2589 {
	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int result;

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C) {
			return false;
		}
		return true;
	}

	static void bfs(int r, int c) {
		Queue<InfoEx2589> que = new LinkedList<>();
		que.add(new InfoEx2589(r, c, 0));
		int len = 0; // 길이

		while (!que.isEmpty()) {
			int nowR = que.peek().r;
			int nowC = que.peek().c;
			int nowCnt = que.poll().cnt;
			if (len < nowCnt) {
				len = nowCnt;
			}
			for (int i = 0; i < 4; i++) {
				int nextR = nowR + dir[i][0];
				int nextC = nowC + dir[i][1];

				if (isRange(nextR, nextC) && !visit[nextR][nextC] && map[nextR][nextC] == 'L') {
					que.add(new InfoEx2589(nextR, nextC, nowCnt + 1));
					visit[nextR][nextC] = true;
				}
			}
		}
		// while 이 끝났다면 더이상 갈 수 있는 길이 없다는것
		// 현재의 길이가 result 에 저장되 있는것 보다 크다면 변경
		if (len > result) {
			result = len;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L') {
					visit = new boolean[R][C];
					visit[i][j] = true;
					bfs(i, j);
				}
			}
		}
		System.out.println(result);
	}

}
