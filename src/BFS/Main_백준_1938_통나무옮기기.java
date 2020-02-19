package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_1938_통나무옮기기 {
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
			this.status = status; // 1�̸� ����, 2�̸� ����
			this.cnt = cnt;
		}
	}

	static boolean isEmpty(int r, int c) { // �߽� ���� 8��ĭ �볪�� �ֳ� Ȯ��
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
		// ���� �����϶� �볪������ ����ִٸ�
		// ���δϱ� ��ĭ�� ����
		if (status == 1 && r - 2 >= 0) {
			if (map[r - 2][c] != '1' && !visit[r - 1][c][1]) {
				que.add(new Info(r - 1, c, status, cnt + 1));
				visit[r - 1][c][status] = true;
			}
			// ���� �����϶� �볪�� ���� ����ִٸ�
			// ���δϱ� ���� 3ĭ �����ؾߵȴ�
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
		if (isEmpty(r, c)) { // 8�� ĭ�� �볪�� ����
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
						bbb = new Info(i - 1, j, 1, 0); // ���� �볪��
					} else if (map[i][j] == 'E' && map[i - 1][j] == 'E' && map[i - 2][j] == 'E') {
						eee = new Info(i - 1, j, 1, 0); // �� ��ġ
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
