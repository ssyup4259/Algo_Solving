package DP;

import java.util.Scanner;

public class Ex2163 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] dp = new int[301][301];
		dp[1][1] = 0;   //무조건
		dp[2][1] = 1;
		dp[1][2] = 1;
		
		//1*1 을 만들어야 하기 때문에 무조건 이거다
		System.out.println(n * m -1);
	}
}
