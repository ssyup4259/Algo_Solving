package BRUTEFORCE;
import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_14889_스타트와링크 {
	static int N;
	static int[][] map;
	static int[] arrA;
	static int totalSum;
	static int result;

	static void teamA(int depth, int idx) {
		// 스타트 팀의 인원은 전체의 절반
		if (idx == N / 2) {
			int sumA = 0;
			int sumB = 0;
			int[] arrB = new int[N / 2];
			int cnt = 0;
			boolean flag = false;
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < arrA.length; j++) {
					if (i == arrA[j]) {
						flag = false;
						break;
					} else {
						flag = true;
					}
				}
				if (flag) {
					arrB[cnt] = i;
					cnt++;
				}
			}
			for (int i = 0; i < arrA.length - 1; i++) {
				for (int j = i + 1; j < arrA.length; j++) {
					sumA += map[arrA[i]][arrA[j]];
					sumA += map[arrA[j]][arrA[i]];
					sumB += map[arrB[i]][arrB[j]];
					sumB += map[arrB[j]][arrB[i]];
				}
			}
			if (result > Math.abs(sumB - sumA)) {
				result = Math.abs(sumB - sumA);
			}
			return;
		}
		for (int i = depth; i <= N; i++) {
			arrA[idx] = i;
			teamA(i + 1, idx + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		totalSum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				totalSum += map[i][j];
			}
		}
		arrA = new int[N / 2];
		result = Integer.MAX_VALUE;
		teamA(1, 0);
		System.out.println(result);
	}

}
