package BRUTEFORCE;

import java.util.Scanner;

public class Main_백준_14888_연산자끼워넣기 {
	static int n;
	static int[] arr;
	static int[] oper;
	static int min, max;

	static int[] swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return arr;
	}

	static int sub(int a, int b, int o) {
		int answer = 0;
		if (o == 0) {
			answer = a + b;
		} else if (o == 1) {
			answer = a - b;
		} else if (o == 2) {
			answer = a * b;
		} else if (o == 3) {
			if (a < 0) {
				a = -a;
				answer = a / b;
				answer = -answer;
			} else {
				answer = a / b;
			}
		}
		return answer;
	}

	static void solve(int[] order, int cnt) {
		if (cnt == n - 1) {
			return;
		}
		int result = 0;
		result = result + arr[0];
		for (int i = 1; i < n; i++) {
			result = sub(result, arr[i], order[i - 1]);
			// System.out.println("result: " + result + " arr[i]: " + arr[i] + " order[i-1]:
			// " + order[i - 1]);
		}
		// System.out.println("result: " + result);
		if (min > result) {
			min = result;
		}
		if (max < result) {
			max = result;
		}
		for (int i = cnt; i <= n - 2; i++) {
			order = swap(order, cnt, i);
			solve(order, cnt + 1);
			order = swap(order, i, cnt);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		oper = new int[4]; // +,-,*,% 의 갯수
		int[] order = new int[n - 1]; // 연산자 정렬용
		int flag = 0;
		for (int i = 0; i < 4; i++) {
			oper[i] = sc.nextInt();
			if (oper[i] != 0) {
				for (int j = flag; j < flag + oper[i]; j++) {
					order[j] = i;
				}
				flag = flag + oper[i];
			}
		}
		min = 1000000000;
		max = -1000000000;
		solve(order, 0);
		System.out.println(max);
		System.out.println(min);

	}

}
