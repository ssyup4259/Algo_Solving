package DP; 

import java.util.Scanner;

public class Main_백준_1915_가장큰정사각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		char[][] map = new char[n][m];
		int[][] dp = new int[n][m];
		int result = 0;

		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);

				// �Է´� �ް� ���� 0�� �Է� �Ǿ��ִٸ� dp�� 0, ���� 1�� �Է� �� ������ �ؿ�ó��
				if (map[i][j] == '1') {
					// �簢�� ���� ������ �ٷ��� ���� ���� �� �ؼ� ������ +1
					if (i >= 1 && j >= 1) {
						int min = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
						dp[i][j] = min + 1;
						// �� ���� �ٰ� �� �� ���� 0�̸� dp0, 1 �̸� dp1 �Է�
					} else {
						dp[i][j] = 1;
					}
					if (dp[i][j] > result) {
						result = dp[i][j];
					}
				}
			}
		}
		// �簢�� ���� ���
		System.out.println(result * result);
	}

}
