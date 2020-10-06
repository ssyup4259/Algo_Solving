package SIMULATION;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_17779_게리맨더링2 {
	// 왼쪽 아래 대각선과 오른쪽 아래 대각선 방향 2가지이다.
	static int[][] dir = { { 1, -1 }, { 1, 1 } };
	static int N, map[][];
	static Info top, left, right, bottom;
	static int total, result;

	static class Info {
		int r, c;

		public Info(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Info [r=" + r + ", c=" + c + "]";
		}

	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}
	
	// 각 선거구에 1,2,3,4 를 표기하고 가운데인 5는 토탈점수에서 빼준다.
	static void check() {
//		System.out.println("top: " + top);
//		System.out.println("left: " + left);
//		System.out.println("right: " + right);
//		System.out.println("bottom: " + bottom);
		int[] div = new int[6];
		int len = top.c;
		int[][] arr = new int[N][N];
		for (int i = 0; i < left.r; i++) {
			if (i >= top.r) {
				len--;
			}
			for (int j = 0; j <= len; j++) {
				div[1] += map[i][j];
				arr[i][j] = 1;
			}
		}

		len = top.c;
		for (int i = 0; i <= right.r; i++) {
			if (i > top.r) {
				len++;
			}
			for (int j = N - 1; j > len; j--) {
				div[2] += map[i][j];
				arr[i][j] = 2;
			}
		}

		len = bottom.c;
		for (int i = N - 1; i >= left.r; i--) {
			if (i < bottom.r) {
				len--;
			}
			for (int j = 0; j < len; j++) {
				div[3] += map[i][j];
				arr[i][j] = 3;
			}
		}

		len = bottom.c;
		for (int i = N - 1; i > right.r; i--) {
			if (i <= bottom.r) {
				len++;
			}
			for (int j = N - 1; j >= len; j--) {
				div[4] += map[i][j];
				arr[i][j] = 4;
			}
		}
		div[5] = total - div[1] - div[2] - div[3] - div[4];

		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= 5; i++) {
			if (max < div[i]) {
				max = div[i];
			}
			if (min > div[i]) {
				min = div[i];
			}
		}
		int temp = max - min;

		if (result > temp) {
			result = temp;
		}
		
//		for(int i = 0 ; i< N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
	}

	static void solve(Info top) {
		for (int i = 1; i <= N; i++) {
			int nextR = top.r + dir[0][0] * i;
			int nextC = top.c + dir[0][1] * i;
			if (isRange(nextR, nextC)) {
				left = new Info(nextR, nextC);
				for (int j = 1; j <= N; j++) {
					nextR = top.r + dir[1][0] * j;
					nextC = top.c + dir[1][1] * j;
					right = new Info(nextR, nextC);
					if (isRange(nextR, nextC)) {
						bottom = new Info(left.r + j, left.c + j);
						check();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				total += map[i][j];
			}
		}
		result =  Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				top = new Info(i, j);
				solve(top);
			}
		}

		System.out.println(result);
	}

}
