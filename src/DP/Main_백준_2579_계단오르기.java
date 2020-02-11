package DP;

import java.util.Scanner;

public class Main_백준_2579_계단오르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 계단의 개수 최대 300개
		int[] score = new int[N]; // 첨수 최대 10000
		int[] memo = new int[N];
		memo[0] = score[0];
		memo[1] = score[0] + score[1];
		int cnt = 0; // 3 번 연속한 계단인지 검사
		int max = 0;
		for (int i = 0; i < N; i++) {
			score[i] = sc.nextInt();
			if (i >= 2) {
				cnt++;
				int a = memo[i - 2];
				int b = memo[i - 1];
				if (a < b && cnt < 2) {
					memo[i] = b + score[i];
					cnt++;
				} else {
					memo[i] = a + score[i];
					cnt = 1;
				}
			}
			max = max < memo[i] ? memo[i] : max;
		}
		System.out.println(max);
	}

}
