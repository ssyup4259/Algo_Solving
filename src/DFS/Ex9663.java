package DFS;

import java.util.Scanner;

public class Ex9663 {
	static int N;
	static int[][] map, newMap;
	// ���� �� �� �ִ� 8���� �� ��� �� ���� �� ���� �� �»�
	// ������ ���� �� ���� �ϳ��� �Ʒ��� �������鼭 ���� ��ġ�Ұ��̱⿡
	// ���� ���� �Ǵ� ����, ���� �� �ִ��� Ȯ�θ� �ϸ�ȴ�.
	// ������ ���� ���� ���� �� �� �Ʒ� �κп��� ���� �� ���� ����
	static int[][] dir = { { -1, 0 }, { -1, 1 }, { -1, -1 } }; // �� ��� �»�
	static int result;

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}

	static boolean move(int r, int c) {
		// ���� ù��° ĭ�� ������ N��° ĭ���� �˻��ؾߵǴ�
		for (int i = 1; i < N; i++) {
			for (int d = 0; d < 3; d++) { // ����������
				int nextR = r + dir[d][0] * i;
				int nextC = c + dir[d][1] * i;

				if (!isRange(nextR, nextC)) {
					continue;
				} else {
					// �˻� �ؼ� ������ ���� �ִٸ� ������ ���� ���� �� �� �ִٴ� ��
					if (map[nextR][nextC] == 1) {
						return false;
					}
				}
			}
		}

		return true;
	}

	static void solve(int depth) {
		if (depth == N) {
			result++;
			return;
		}
		for (int i = 0; i < N; i++) {
			// ������ ���� ���ٸ� ���� solve�� DFS
			if (move(depth, i)) {
				map[depth][i] = 1;
				solve(depth + 1);
				map[depth][i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		newMap = new int[N][N];
		result = 0;
		solve(0);
		System.out.println(result);
	}

}
