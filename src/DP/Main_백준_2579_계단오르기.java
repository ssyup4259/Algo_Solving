package DP;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_2579_계단오르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 계단의 개수 최대 300개
		int[] score = new int[N + 1]; // 첨수 최대 10000
		int[] memo = new int[N + 1];
		int max = 0;
		for (int i = 1; i <= N; i++) {
			score[i] = sc.nextInt();
		}
		memo[1] = score[1];
		memo[2] = score[1] + score[2];
		for (int i = 3; i <= N; i++) {
			memo[i] = Math.max(score[i - 1] + memo[i - 3], memo[i - 2]) + score[i];
		}
		System.out.println(memo[N]);
	}

}
