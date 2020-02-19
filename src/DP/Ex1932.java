package DP;

import java.util.Scanner;

public class Ex1932 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n][n];
		int max = 0;
		dp[0][0] = sc.nextInt();
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = sc.nextInt();
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j];
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i][j];
				} else { 
					dp[i][j] = (dp[i - 1][j - 1] > dp[i - 1][j] ? dp[i - 1][j - 1] : dp[i - 1][j]) + dp[i][j];
				}
				if (max < dp[i][j]) {
					max = dp[i][j];
				}
			}
		}
		System.out.println(max);
	}

}
