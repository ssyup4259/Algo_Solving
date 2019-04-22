package SAMSUNG;

import java.util.Scanner;

public class Ex14500 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int result;

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) {
			return false;
		}
		return true;
	}

	// ��,�� ��� ���� ����� ���������� �����¿� dfs������
	// 4ĭ¥�� ��Ʈ�ι̳븦 ����� �ִ�.
	static void dfs(int r, int c, int depth, int sum) {
		sum += map[r][c];
		if (depth == 3) { // dfs �� �ִ밪 ����
			if (result < sum) {
				result = sum;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];
			if (isRange(nextR, nextC) && !visit[nextR][nextC]) {
				visit[nextR][nextC] = true;
				dfs(nextR, nextC, depth + 1, sum);
				visit[nextR][nextC] = false;
			}
		}
	}

	// ��,�� ��� ���
	static void other(int r, int c) {
		int cnt = 0;
		int sum = map[r][c];
		int[] arr = new int[4];
		// ���� �������� �߽����� �����¿� �� ������ arr�� �ִ´�.
		for (int i = 0; i < 4; i++) {
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];

			// ���� ������ ����� cnt�� �߰����ְ�
			if (!isRange(nextR, nextC)) {
				cnt++;
			} else {
				arr[i] = map[nextR][nextC];
			}
		}
		// ������ ������� 2���̻��� �ȴٸ� ��,������ ����� �� �� ����.
		if (cnt > 1) {
			return;
		} else {
			// ����� �־����ٸ�
			int min = Integer.MAX_VALUE;
			// arr�� �־���� ���� �� ��ġ�� 4���� ���ڿ��� �ּҰ��� ���տ��� ���� ���شٸ�
			// ���� ���� �߽��� ���� 3���� ���� �ִ밡 �ȴ�.
			for (int i = 0; i < 4; i++) {
				sum = sum + arr[i];
				if (min > arr[i]) {
					min = arr[i];
				}
			}
			sum = sum - min;
		}
		// ��ü����� �ִ밪 ����
		if (result < sum) {
			result = sum;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				dfs(i, j, 0, 0);
				visit[i][j] = false;
				other(i, j);
			}
		}
		System.out.println(result);

	}

}
