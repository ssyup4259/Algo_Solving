package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex1938 {
	static int n;
	static char[][] map;
	static boolean[][][] visit;
	static Info bbb;
	static Info eee;
	static Queue<Info> que;
	static int result;

	static class Info {
		int r;
		int c;
		int status;
		int cnt;

		Info(int r, int c, int status, int cnt) {
			this.r = r;
			this.c = c;
			this.status = status; // 1이면 세로, 2이면 가로
			this.cnt = cnt;
		}
	}

	static boolean isEmpty(int r, int c) { // 중심 기준 8개칸 통나무 있나 확인
		if (r + 1 < n && r - 1 >= 0 && c + 1 < n && c - 1 >= 0) {
			if (map[r - 1][c - 1] != '1' && map[r - 1][c] != '1' && map[r - 1][c + 1] != '1' && map[r + 1][c - 1] != '1'
					&& map[r + 1][c] != '1' && map[r + 1][c + 1] != '1' && map[r][c - 1] != '1'
					&& map[r][c + 1] != '1') {
				return true;
			}
		}
		return false;
	}

	static void up(Info info) {
		int r = info.r;
		int c = info.c;
		int status = info.status;
		int cnt = info.cnt;
		// 현재 세로일때 통나무위가 비어있다면
		// 세로니깐 한칸만 조사
		if (status == 1 && r - 2 >= 0) {
			if (map[r - 2][c] != '1' && !visit[r - 1][c][1]) {
				que.add(new Info(r - 1, c, status, cnt + 1));
				visit[r - 1][c][status] = true;
			}
			// 현재 가로일때 통나무 위가 비어있다면
			// 가로니깐 위에 3칸 조사해야된다
		} else if (status == 2 && r - 1 >= 0) {
			if (map[r - 1][c - 1] != '1' && map[r - 1][c] != '1' && map[r - 1][c + 1] != '1' && !visit[r - 1][c][2]) {
				que.add(new Info(r - 1, c, status, cnt + 1));
				visit[r - 1][c][status] = true;
			}
		}
	}

	static void down(Info info) {
		int r = info.r;
		int c = info.c;
		int status = info.status;
		int cnt = info.cnt;
		if (status == 1 && r + 2 < n) {
			if (map[r + 2][c] != '1' && !visit[r + 1][c][1]) {
				que.add(new Info(r + 1, c, status, cnt + 1));
				visit[r + 1][c][status] = true;
			}
		} else if (status == 2 && r + 1 < n) {
			if (map[r + 1][c - 1] != '1' && map[r + 1][c] != '1' && map[r + 1][c + 1] != '1' && !visit[r + 1][c][2]) {
				que.add(new Info(r + 1, c, status, cnt + 1));
				visit[r + 1][c][status] = true;
			}
		}
	}

	static void left(Info info) {
		int r = info.r;
		int c = info.c;
		int status = info.status;
		int cnt = info.cnt;
		if (status == 1 && c - 1 >= 0) {
			if (map[r - 1][c - 1] != '1' && map[r][c - 1] != '1' && map[r + 1][c - 1] != '1'
					&& !visit[r][c - 1][status]) {
				que.add(new Info(r, c - 1, status, cnt + 1));
				visit[r][c - 1][status] = true;
			}
		} else if (status == 2 && c - 2 >= 0) {
			if (map[r][c - 2] != '1' && !visit[r][c - 1][status]) {
				que.add(new Info(r, c - 1, status, cnt + 1));
				visit[r][c - 1][status] = true;
			}
		}
	}

	static void right(Info info) {
		int r = info.r;
		int c = info.c;
		int status = info.status;
		int cnt = info.cnt;
		if (status == 1 && c + 1 < n) {
			if (map[r - 1][c + 1] != '1' && map[r][c + 1] != '1' && map[r + 1][c + 1] != '1'
					&& !visit[r][c + 1][status]) {
				que.add(new Info(r, c + 1, status, cnt + 1));
				visit[r][c + 1][status] = true;
			}
		} else if (status == 2 && c + 2 < n) {
			if (map[r][c + 2] != '1' && !visit[r][c + 1][status]) {
				que.add(new Info(r, c + 1, status, cnt + 1));
				visit[r][c + 1][status] = true;
			}

		}
	}

	static void turn(Info info) {
		int r = info.r;
		int c = info.c;
		int status = info.status;
		int cnt = info.cnt;
		if (isEmpty(r, c)) { // 8개 칸에 통나무 없고
			if (status == 1 && !visit[r][c][2]) {
				que.add(new Info(r, c, 2, cnt + 1));
				visit[r][c][2] = true;
			} else if (status == 2 && !visit[r][c][1]) {
				que.add(new Info(r, c, 1, cnt + 1));
				visit[r][c][1] = true;
			}
		}
	}

	static void bfs() {
		que = new LinkedList<>();
		que.add(bbb);
		visit[bbb.r][bbb.c][bbb.status] = true;
		while (!que.isEmpty()) {
			Info info = que.poll();
			if (info.r == eee.r && info.c == eee.c && info.status == eee.status) {
				if (info.cnt < result) {
					result = info.cnt;
				}
				return;
			}
			up(info);
			down(info);
			left(info);
			right(info);
			turn(info);
		}

		result = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		map = new char[n][n];
		visit = new boolean[n][n][3];

		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
				if (i >= 2) {
					if (map[i][j] == 'B' && map[i - 1][j] == 'B' && map[i - 2][j] == 'B') {
						bbb = new Info(i - 1, j, 1, 0); // 시작 통나무
					} else if (map[i][j] == 'E' && map[i - 1][j] == 'E' && map[i - 2][j] == 'E') {
						eee = new Info(i - 1, j, 1, 0); // 끝 위치
					}
				}
				if (j >= 2) {
					if (map[i][j] == 'B' && map[i][j - 1] == 'B' && map[i][j - 2] == 'B') {
						bbb = new Info(i, j - 1, 2, 0);
					} else if (map[i][j] == 'E' && map[i][j - 1] == 'E' && map[i][j - 2] == 'E') {
						eee = new Info(i, j - 1, 2, 0);
					}
				}
			}
		}

		result = Integer.MAX_VALUE;
		bfs();
		System.out.println(result);
	}

}
