package DP;

import java.util.Scanner;

public class Ex2163 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] dp = new int[301][301];
		dp[1][1] = 0;   //������
		dp[2][1] = 1;
		dp[1][2] = 1;
		
		//1*1 �� ������ �ϱ� ������ ������ �̰Ŵ�
		System.out.println(n * m -1);
	}
}
