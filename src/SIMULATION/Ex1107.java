package SIMULATION;

import java.util.Scanner;

public class Ex1107 {
	static int N;
	static boolean[] as = new boolean[10];
	static int min;

	// num�� ���峭 ��ư�� �� �մ��� Ȯ��
	static boolean check(int num) {
		boolean flag = true;
		if (num == 0) { // num=0�̰� 0�� ��ư�� ���峭���̶�� �ȵ�
			if (as[0]) {
				flag = false;
			}
		} else {
			while (num != 0) {
				int a = num % 10;
				num = num / 10;
				if (as[a]) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	static void near() {
		int depth = 0; // �� ���ڰ� �Ǳ� ���� + -������ Ƚ��
		while (true) {
			// ������ N ������� N�� 3000 �϶� 3000�� ������ 4�������� ä�� ���� ����
			// (3001,2999),(3002,2998)...�˻�
			// 3001�� 3000�� 4�� ���ϱ� +��ư 1��
			boolean flag = false;
			if (check(N + depth)) { // ���峭 ��ư�� �ִ��� �˻� �ϱ�
				// 3001�� ���峭 ��ư�� ���ٸ� min�� 1 + 4 = 5���ȴ�
				if (min > depth + Integer.toString(N + depth).length()) {
					min = depth + Integer.toString(N + depth).length();
				}
				flag = true;
			}
			if (N - depth >= 0) {
				if (check(N - depth)) {
					if (min > depth + Integer.toString(N - depth).length()) {
						min = depth + Integer.toString(N - depth).length();
					}
					flag = true;
				}
			}

			depth++;
			if (flag || depth == Math.abs(N - 100)) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			as[num] = true;
		}

		if (N == 100) {
			System.out.println(0);
		} else {
			// �ּҰ��� 100������ N���� ++��ư, --��ư������ ���� �ִ� ������� �ٲ���´�.
			min = Math.abs(N - 100);
			near();
			System.out.println(min);
		}
	}

}
