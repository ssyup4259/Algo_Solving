package OTHER;

import java.util.Scanner;

public class Ex9205 {

	// a,b ���������� ����ư �Ÿ�
	static int len(int ar, int ac, int br, int bc) {
		int len = Math.abs(ar - br) + Math.abs(ac - bc);
		return len;
	}

	public static void main(String[] ar) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt(); // ������ ����

			int[] c = new int[n + 2]; // c��ǥ��
			int[] r = new int[n + 2]; // r��ǥ��
			int[][] map = new int[n + 2][n + 2];

			for (int i = 0; i < n + 2; i++) {
				c[i] = sc.nextInt();
				r[i] = sc.nextInt();
			}

			for (int i = 0; i < n + 2; i++) {
				// ���ڸ� �״�δ� 1
				map[i][i] = 1;
				for (int j = i + 1; j < n + 2; j++) {
					// i��ǥ�� j ��ǥ ������ ����ư �Ÿ�
					int len = len(r[i], c[i], r[j], c[j]);
					// 20���� 50���;� ���ôϱ� �Ÿ��� 1000�� �Ѿ�� �ȵȴ�.
					// 1�� �������� 2�� �������� �Ÿ��� 1000���ϸ� ���� �ִٰ� ǥ�� �Ѵ�.
					if (len <= 1000) {
						map[i][j] = 1;
						map[j][i] = 1;
					}

				}
			}

			// �÷��̵� �ͼ�
			for (int k = 0; k < n + 2; k++) {
				for (int i = 0; i < n + 2; i++) {
					for (int j = 0; j < n + 2; j++) {
						// EX) ������ 1�� �������� ��� 2�� �������� ���� �ֵ���
						// ������ 2�� �������� �� ���ִٰ� ǥ���Ѵ�.
						// ���������� ��� �� �� �ִٸ� ������ ���� ���� ���� map�� 1�̵ȴ�.
						if (map[i][k] == 1 && map[k][j] == 1) {
							map[i][j] = 1;
							map[j][i] = 1;
						}
					}
				}
			}

			if (map[0][n + 1] == 1) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}
		}
	}
}