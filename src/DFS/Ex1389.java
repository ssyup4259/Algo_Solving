package DFS;

import java.util.Scanner;

public class Ex1389 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = 9999999;
			}
		}

		int start, end;
		for (int i = 1; i <= m; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			arr[start][end] = 1; // start 친구와 end 친구 관계
			arr[end][start] = 1;
		}

		for (int i = 1; i <= n; i++) { // (1,5)의 친구관계가 (1,3) +(3,5)가 적은지 (1,5)가 적은지 확인
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					arr[j][k] = (arr[j][k] < (arr[j][i] + arr[i][k]) ? arr[j][k] : (arr[j][i] + arr[i][k]));
				}
			}
		}

		for (int i = 1; i <= n; i++) { // 친구관계수 다 더하기
			for (int j = 1; j <= n; j++) {
				arr[i][j] = arr[i][j] + arr[i][j - 1];
			}
		}

		int min = 99999;
		int flag = 0;
		for (int i = 1; i <= n; i++) {
			if (arr[i][n] < min) {
				min = arr[i][n];
				flag = i;
			}
		}

		System.out.println(flag);
	}

}
