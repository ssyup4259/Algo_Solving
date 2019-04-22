package SAMSUNG;

import java.util.Scanner;

public class Ex14890 {
	static int N, L;
	static int[][] map;
	static int xCnt; // ��θ� ���� �� ���� ����

	// ������ Ž��
	static void solveRight(int r, int c) {
		int cnt = 1; // ���� ĭ�� ���� ���� �� ã�� ����
		for (int i = 0; i < N - 1; i++) {
			// ����ĭ�� ����ĭ�� ������ cnt����
			if (map[r][c + i + 1] == map[r][c + i]) {
				cnt++;
				// ����ĭ�� ���� ĭ���� 2�̻� ũ�ٸ� ��� �ȵǰ� �޼ҵ� ����
			} else if (map[r][c + i + 1] > map[r][c + i] + 1) {
				xCnt++;
				return;
				// ����ĭ�� ���� ĭ���� 2�̻� �۴ٸ� ��� �ȵǰ� �޼ҵ� ����
			} else if (map[r][c + i + 1] < map[r][c + i] - 1) {
				xCnt++;
				return;
				// ���� ĭ�� ���� ĭ ���� 1 ũ�ٸ�
			} else if (map[r][c + i + 1] == map[r][c + i] + 1) {
				// cnt�� ���� ���̺��� ��ٸ� cnt =1 ������ش�
				if (cnt >= L) {
					cnt = 1;
					// cnt�� �۴ٸ� ��� �ȵǰ� �޼ҵ�����
				} else {
					xCnt++;
					return;
				}
				// ����ĭ�� ���� ĭ���� 1�۴ٸ�
			} else if (map[r][c + i + 1] == map[r][c + i] - 1) {
				int flag = 1; // ���� ĭ ���� ���̰����� ���� ����
				for (int j = 1; j < N - (c + i + 1); j++) {
					if (map[r][c + i + 1 + j] == map[r][c + i + 1]) {
						flag++;
					} else {
						break;
					}
				}
				// ���� ĭ���� ���� ���̰� ���� ���̺��� ��ٸ�
				if (flag >= L) {
					i = i + L - 1;
					cnt = 0;
				} else {
					xCnt++;
					return;
				}
			}
		}
	}

	static void solveDown(int r, int c) {
		int cnt = 1;
		for (int i = 0; i < N - 1; i++) {
			if (map[r + i + 1][c] == map[r + i][c]) {
				cnt++;
			} else if (map[r + i + 1][c] > map[r + i][c] + 1) {
				xCnt++;
				return;
			} else if (map[r + i + 1][c] < map[r + i][c] - 1) {
				xCnt++;
				return;
			} else if (map[r + i + 1][c] == map[r + i][c] + 1) {
				if (cnt >= L) {
					cnt = 1;
				} else {
					xCnt++;
					return;
				}
			} else if (map[r + i + 1][c] == map[r + i][c] - 1) {
				int flag = 1;
				for (int j = 1; j < N - (r + i + 1); j++) {
					if (map[r + i + 1 + j][c] == map[r + i + 1][c]) {
						flag++;
					} else {
						break;
					}
				}
				if (flag >= L) {
					i = i + L - 1;
					cnt = 0;
				} else {
					xCnt++;
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < N; i++) {
			solveRight(i, 0);
			solveDown(0, i);
		}
		System.out.println(N * 2 - xCnt);
	}

}
