package SAMSUNG;

import java.util.Scanner;

public class Ex14891 {
	static int[][] tob;

	// ȸ��
	static void rotate(int tobType, int dir) {
		if (dir == 1) { // �ð���� ȸ��
			int temp = tob[tobType][7];
			for (int i = 7; i > 0; i--) {
				tob[tobType][i] = tob[tobType][i - 1];
			}
			tob[tobType][0] = temp;
		} else { // �ݽð�
			int temp = tob[tobType][0];
			for (int i = 0; i < 7; i++) {
				tob[tobType][i] = tob[tobType][i + 1];
			}
			tob[tobType][7] = temp;
		}
	}

	// �ϳ��� ���� ������ ���� ���ϸ� �ȵȴ�. ���������� �ص��� ������ 1,2,3,4 �� ���ؾ��Ѵ�.
	static void solve(int tobType, int dir) {
		if (tobType == 1) {
			// 1���� 2�� �ٸ���
			if (tob[1][2] != tob[2][6]) {
				// 2���� 3�� �ٸ���
				if (tob[2][2] != tob[3][6]) {
					// 3���� 4���ٸ���
					if (tob[3][2] != tob[4][6]) {
						rotate(4, -dir);
					}
					rotate(3, dir);
				}
				rotate(2, -dir);
			}
			rotate(1, dir);
		} else if (tobType == 2) {
			// 1���� 2���� �ٸ��� 1��������. ���⼭�� 1�� ���� ������ 3,4���� ������ ��ġ�� �ʴ´�.
			if (tob[1][2] != tob[2][6]) {
				rotate(1, -dir);
			}
			// 2���� 3�� �ٸ���
			if (tob[2][2] != tob[3][6]) {
				// 3���� 4���ٸ���
				if (tob[3][2] != tob[4][6]) {
					rotate(4, dir);
				}
				rotate(3, -dir);
			}
			rotate(2, dir);
		} else if (tobType == 3) {
			if (tob[3][2] != tob[4][6]) {
				rotate(4, -dir);
			}
			if (tob[2][2] != tob[3][6]) {
				if (tob[2][6] != tob[1][2]) {
					rotate(1, dir);
				}
				rotate(2, -dir);
			}
			rotate(3, dir);
		} else {
			if (tob[3][2] != tob[4][6]) {
				if (tob[2][2] != tob[3][6]) {
					if (tob[2][6] != tob[1][2]) {
						rotate(1, -dir);
					}
					rotate(2, dir);
				}
				rotate(3, -dir);
			}
			rotate(4, dir);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		tob = new int[5][8];

		// 1�� ���� ������ tob�� 1 �࿡ ����
		for (int i = 1; i <= 4; i++) {
			String str = sc.nextLine();
			int flag = Integer.parseInt(str);
			for (int j = 7; j >= 0; j--) {
				tob[i][j] = flag % 10;
				flag = flag / 10;
			}
		}

		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int tobType = sc.nextInt();
			int dir = sc.nextInt();
			solve(tobType, dir);
		}

		int sum = 0;
		if (tob[1][0] == 1) {
			sum += 1;
		}
		if (tob[2][0] == 1) {
			sum += 2;
		}
		if (tob[3][0] == 1) {
			sum += 4;
		}
		if (tob[4][0] == 1) {
			sum += 8;
		}
		System.out.println(sum);
	}

}
