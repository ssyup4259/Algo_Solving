package DFS;

import java.util.Scanner;

public class Main_백준_2023_신기한소수 {
	static int N;

	// �Ҽ� ���� �Ǻ�
	static boolean isSosu(int num) {
		if (num < 2) {
			return false;
		} else {
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

	// EX) 2�� �Ҽ� ���� �˾����� 21,22...,29 �߿� �Ҽ��� �Ǻ��ϰ� �װ��� �Ҽ����
	// 231,232,...239 �߿� �Ҽ��� �ִ��� �Ǻ� �ϴ� ��
	// ���ϴ� �ڸ����� �ȴٸ� ���
	static void solve(int num, int depth) {
		if (depth == N) {
			System.out.println(num);
			return;
		}
		for (int i = 0; i <= 9; i++) {
			num = num * 10 + i;
			if (isSosu(num)) {
				solve(num, depth + 1);
			}
			num = num / 10;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		// 1���� 9���� �Ҽ����� �Ǻ��ؼ� ���� �ڸ����� �Ѿ��.
		for (int i = 1; i <= 9; i++) {
			if (isSosu(i)) {
				solve(i, 1);
			}
		}
	}

}
