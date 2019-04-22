package SAMSUNG;

import java.util.Scanner;

public class Ex14889 {
	static int N;
	static int[][] map;
	static int[] arrA;
	static int totalSum;
	static int result;

	// ��ŸƼ ���� ����� �������� N/2�� �̴´�. Ex)N �� 6�϶�
	// ��ŸƮ ���� ��� 1,2,3 or 1,2,4 �̷��� �ߺ� ��� X
	static void teamA(int depth, int idx) {
		// ��ŸƼ ���� ����� �ٻ����ٸ�
		if (idx == N / 2) {
			int sumA = 0;
			int sumB = 0;
			int[] arrB = new int[N / 2];
			int cnt = 0;
			boolean flag = false;
			// ��ŸƼ���� ���� ���̵��� ��ũ������ �־��ش�.
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < arrA.length; j++) {
					if (i == arrA[j]) {
						flag = false;
						break;
					} else {
						flag = true;
					}
				}
				if (flag) {
					arrB[cnt] = i;
					cnt++;
				}
			}
			// ��ŸƮ���� ��ũ���� ������ ���ϰ�
			for (int i = 0; i < arrA.length - 1; i++) {
				for (int j = i + 1; j < arrA.length; j++) {
					sumA += map[arrA[i]][arrA[j]];
					sumA += map[arrA[j]][arrA[i]];
					sumB += map[arrB[i]][arrB[j]];
					sumB += map[arrB[j]][arrB[i]];
				}
			}
			// �հ��� ���� �ּҰ� �ǰ� �����Ѵ�.
			if (result > Math.abs(sumB - sumA)) {
				result = Math.abs(sumB - sumA);
			}
			return;
		}
		// �����ְ� �̴´�. (1,5,6)�� (6,5,1)�� ����� ������� ���� ������
		// 1���� �̾����� �������� 2������ N���� ���̵��� �̴´�.
		// 1,5���� �̾Ҵٸ� ������ 6������ N���� ���̵� �� �̴´�.
		for (int i = depth; i <= N; i++) {
			arrA[idx] = i;
			teamA(i + 1, idx + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		totalSum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				totalSum += map[i][j];
			}
		}
		arrA = new int[N / 2];
		result = Integer.MAX_VALUE;
		teamA(1, 0);
		System.out.println(result);
	}

}
