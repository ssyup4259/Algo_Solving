package SAMSUNG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Ex14502 {
	static int N, M;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static List<Info> list;
	static int result, max;
	static int[][] map;

	static class Info {
		int r, c;

		Info(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) {
			return false;
		}
		return true;
	}

	// �������� �� �����
	static void makeWall(int cnt) {
		if (cnt == 3) {
			int[][] arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = map[i][j];
				}
			}

			virus(arr);
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	// ���̷��� �۶߸���
	static void virus(int[][] arr) {
		// �ʱ� ���̷��� ť�� �ֱ�
		Queue<Info> que = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			que.add(list.get(i));
		}

		// bfs�� ���̷��� �۶߸���
		while (!que.isEmpty()) {
			int r = que.peek().r;
			int c = que.poll().c;

			for (int i = 0; i < 4; i++) {
				int nextR = r + dir[i][0];
				int nextC = c + dir[i][1];

				if (isRange(nextR, nextC)) {
					if (arr[nextR][nextC] == 0) {
						arr[nextR][nextC] = 2;
						que.add(new Info(nextR, nextC));
					}
				}
			}
		}

		// �������� �˻�
		int checkZero = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					checkZero++;
				}
			}
		}

		if (checkZero > max) {
			max = checkZero;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) { // �ʱ���̷��� ť�� ����
					list.add(new Info(i, j));
				}
			}
		}
		max = 0;
		makeWall(0);
		System.out.println(max);
	}

}
