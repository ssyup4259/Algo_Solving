package DP;

import java.math.BigInteger;
import java.util.Scanner;

public class Ex1793 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger[] dp = new BigInteger[251]; // 숫자가 너무 커서 long으로도 커버가 되지 않는다.
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");
		for (int i = 3; i <= 250; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2].multiply(new BigInteger("2")));
		}

		while (sc.hasNextInt()) { // 입력이 있으면 테스트케이스 계속 실행
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}
}
