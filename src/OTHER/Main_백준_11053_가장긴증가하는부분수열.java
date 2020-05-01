package OTHER;

import java.util.Scanner;

public class Main_백준_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int[] memo = new int[N];
		for (int i = 0; i < N; i++) {
			memo[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && memo[i] <= memo[j]) {
					memo[i] = memo[j] + 1;
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			if (max < memo[i]) {
				max = memo[i];
			}
		}
		System.out.println(max);
	}

}
