package SAMSUNG;

import java.util.Scanner;

public class Ex14503 {
	static int N, M, R, C, D;
	static int[][] map;
	static boolean[][] visit;
	static final int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int cnt, dCnt;

	static boolean isRange(int a, int b) { // map���� �ȿ� �ִ��� Ȯ��
		boolean flag = false;
		if (a >= 1 && a < N - 1 && b >= 1 && b < M - 1) {
			flag = true;
		}
		return flag;
	}

	static void next(int r, int c, int d) {
		int nextR = r;
		int nextC = c;
		int nextD;
		if (d == 0) {
			nextD = 3;
		} else {
			nextD = d - 1;
		}
		nextR = r + dir[nextD][0];
		nextC = c + dir[nextD][1];
		// �� ���� ��� û�Ұ� �̹� ���ְų� ���� ���
		if(dCnt == 4) {
			if (d == 0) {
				nextD = 2;
			} else if (d == 1) {
				nextD = 3;
			} else if (d == 2) {
				nextD = 0;
			} else {
				nextD = 1;
			}
			nextR = r + dir[nextD][0];
			nextC = c + dir[nextD][1];
			// �ڷ� �� �� �ִٸ� ����, ���ٸ� �۵�����
			if (isRange(nextR, nextC) && map[nextR][nextC] == 0) {
				dCnt = 0;
				next(nextR, nextC, d);
				return;
			} else if (!isRange(nextR, nextC) || map[nextR][nextC] == 1) {
				return;
			}
		} else {
			if (!isRange(nextR, nextC) || map[nextR][nextC] == 1) {
				dCnt++;
				next(r, c, nextD);
				return;
			}
			// ���� ������ û������ ���� �����̶��
			if (isRange(nextR, nextC) && map[nextR][nextC] == 0 && !visit[nextR][nextC]) {
				dCnt = 0;
				cnt++;
				visit[nextR][nextC] = true;
				next(nextR, nextC, nextD); // ���� û��
				return;
			}
			// ���� ������ û���� ������ ���ٸ�(���̰ų� û�Ҹ� �Ͽ��ٸ�)
			if (isRange(nextR, nextC) && (map[nextR][nextC] == 1 || visit[nextR][nextC])) {
				dCnt++;
				next(r, c, nextD);
				return;
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = false;
				map[i][j] = sc.nextInt();
			}
		}
		cnt = 1;
		dCnt = 0;
		visit[R][C] = true;
		next(R, C, D);
		System.out.println(cnt);
	}

}
