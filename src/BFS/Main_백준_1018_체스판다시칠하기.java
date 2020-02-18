package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_1018_체스판다시칠하기 {
	static int N, M;
	static char[][] newMap = new char[8][8];
	// (0,0)���� (8,8)���� Ž�� �Ұ� ���� ������ �Ʒ������θ� ���� �ȴ�.
	static int[][] dir = { { 0, 1 }, { 1, 0 } };
	static int result;
	static int cnt;

	static class Info {
		int r, c;

		Info(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= 8 || c < 0 || c >= 8) {
			return false;
		}
		return true;
	}

	static void bfs(int r, int c) {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(r, c));
		boolean[][] visit = new boolean[N][M];
		visit[0][0] = true;

		while (!que.isEmpty()) {
			int nowR = que.peek().r;
			int nowC = que.poll().c;
			// ��������
			if (nowR == 7 && nowC == 7) {
				if (cnt < result) {
					result = cnt;
				}
				// ���ݻ��� �ٲ۰��� ���ݴ� ����� �ϳ��� ���� �Ѵ�.
				// �������� 'B'�� ���� 'W' �ϼ��� ����
				if (64 - cnt < result) {
					result = 64 - cnt;
				}
			}
			for (int i = 0; i < 2; i++) {
				int nextR = nowR + dir[i][0];
				int nextC = nowC + dir[i][1];
				if (isRange(nextR, nextC) && !visit[nextR][nextC]) {
					if (newMap[nextR][nextC] != newMap[nowR][nowC]) {
						que.add(new Info(nextR, nextC));
						visit[nextR][nextC] = true;
					} else { // ������ ������ ������ ���ٸ� �ٲ�����Ѵ�.
						que.add(new Info(nextR, nextC));
						cnt++;
						if (newMap[nextR][nextC] == 'W') {
							newMap[nextR][nextC] = 'B';
						} else {
							newMap[nextR][nextC] = 'W';
						}
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
		sc.nextLine();
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		result = Integer.MAX_VALUE;
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				// ������ (i,j)�� ���� 8*8ĭ�� ü������ ����� newMap�� ����
				for (int r = 0; r < 8; r++) {
					for (int c = 0; c < 8; c++) {
						newMap[r][c] = map[i + r][j + c];
					}
				}
				// newMap�� ������ bfsŽ��
				cnt = 0;
				bfs(0, 0);
			}
		}
		System.out.println(result);
	}

}
