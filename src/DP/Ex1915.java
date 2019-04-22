package DP; 

import java.util.Scanner;

public class Ex1915 {

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

				// 입력다 받고 현재 0이 입력 되어있다면 dp는 0, 현재 1이 입력 되 있으면 밑에처럼
				if (map[i][j] == '1') {
					// 사각형 기준 왼쪽위 바로위 왼쪽 세개 비교 해서 작은거 +1
					if (i >= 1 && j >= 1) {
						int min = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
						dp[i][j] = min + 1;
						// 맨 왼쪽 줄과 맨 윗 줄은 0이면 dp0, 1 이면 dp1 입력
					} else {
						dp[i][j] = 1;
					}
					if (dp[i][j] > result) {
						result = dp[i][j];
					}
				}
			}
		}
		// 사각형 넓이 출력
		System.out.println(result * result);
	}

}
