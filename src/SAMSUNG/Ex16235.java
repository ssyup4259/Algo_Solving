package SAMSUNG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex16235 {
	static int N, M, K;
	static int[][] A;
	static int[][] board;
	static int[][] dir = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
	static List<Info> deadList;
	static List<Info> fiveList;
	static List<Info>[][] map;

	static class Info implements Comparable<Info> {
		// ��ǥ r, c, ����, �׾����� ����
		int r, c, age;

		Info(int r, int c, int age) {
			this.r = r;
			this.c = c;
			this.age = age;
		}

		// ���� ������ ���� �ϱ����ؼ� ó�� �ẽ
		@Override
		public int compareTo(Info o) {
			if (o.age <= this.age) {
				return 1;
			}
			return -1;
		}

	}

	static boolean isRange(int r, int c) {
		if (r < 1 || r > N || c < 1 || c > N) {
			return false;
		}
		return true;
	}

	static void spring() {// ��
		// �״¾ֵ� �����
		deadList = new ArrayList<>();
		// ���̰� 5�� �Ǵ� �ֵ� �̸� ����
		fiveList = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// ���̼����� ����
				Collections.sort(map[i][j]);
				for (int k = 0; k < map[i][j].size(); k++) {
					Info tree = map[i][j].get(k);
					int r = tree.r;
					int c = tree.c;
					// ��и��̰� ���� �ø���.
					if (tree.age <= board[r][c]) {
						board[r][c] = board[r][c] - tree.age;
						tree.age++;
						if (tree.age % 5 == 0) { // 5�� ������ �Ŀ� ���� �ϴϱ� ����Ʈ�� �߰�
							fiveList.add(tree);
						}
					} else if (tree.age > board[r][c]) {
						deadList.add(tree); // �����ֵ� ����Ʈ�� �߰�
					}
				}
			}
		}

	}

	static void summer() { // ����
		// ���� �ֵ�
		for (int i = 0; i < deadList.size(); i++) {
			Info tree = deadList.get(i);
			int r = tree.r;
			int c = tree.c;
			// �����ֵ��� �������
			board[r][c] = board[r][c] + tree.age / 2;
			// list���� �����ֵ� �����ش�
			map[r][c].remove(tree);
		}
	}

	static void autumn() { // ����
		// ���̰� �ټ��� �ֵ�
		for (int i = 0; i < fiveList.size(); i++) {
			Info tree = fiveList.get(i);
			int r = tree.r;
			int c = tree.c;
			// 8�������� ����
			for (int d = 0; d < 8; d++) {
				int nextR = r + dir[d][0];
				int nextC = c + dir[d][1];
				if (isRange(nextR, nextC)) {
					map[nextR][nextC].add(new Info(nextR, nextC, 1));
				}
			}
		}
	}

	static void winter() { // �ܿ� ����߰�
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				board[i][j] = board[i][j] + A[i][j];
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		A = new int[N + 1][N + 1];
		board = new int[N + 1][N + 1];
		map = new ArrayList[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				A[i][j] = sc.nextInt();
				board[i][j] = 5;
				map[i][j] = new ArrayList<>();
			}
		}
		for (int i = 0; i < M; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int age = sc.nextInt();
			Info tree = new Info(r, c, age);
			map[r][c].add(tree);
		}

		for (int i = 0; i < K; i++) {
			spring();
			summer();
			autumn();
			winter();
		}

		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				result = result + map[i][j].size();
			}
		}

		System.out.println(result);
	}
}
