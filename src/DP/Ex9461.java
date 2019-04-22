package DP;

import java.util.Scanner;

public class Ex9461 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long[] dp = new long[101];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		
		//bottom-up 방식으로 저장
		for (int i = 6; i <= 100; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}

}
