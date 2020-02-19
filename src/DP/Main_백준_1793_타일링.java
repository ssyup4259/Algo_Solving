package DP;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_백준_1793_타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger[] dp = new BigInteger[251]; // ���ڰ� �ʹ� Ŀ�� long���ε� Ŀ���� ���� �ʴ´�.
		dp[0] = new BigInteger("1");
		dp[1] = new BigInteger("1");
		dp[2] = new BigInteger("3");
		for (int i = 3; i <= 250; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2].multiply(new BigInteger("2")));
		}

		while (sc.hasNextInt()) { // �Է��� ������ �׽�Ʈ���̽� ��� ����
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}
}
