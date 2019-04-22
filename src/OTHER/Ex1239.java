package OTHER;

import java.util.Scanner;

public class Ex1239 {
	static int result;

	static int[] swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		return arr;
	}

	static void solve(int[] arr, int depth, int N) {
		if (depth == N) {
			return;
		}
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < i + arr.length; j++) {
				j = j % arr.length;
				sum = sum + arr[j];
				if (sum > 50) {
					break;
				} else if (sum == 50) {  //50%만들어쓰니 중앙 가로지름
					cnt++;
					break;
				}
			}
		}
		cnt = cnt / 2; //50%니깐 나눠줘야한다.
		if (result < cnt) {
			result = cnt;
		}
		for (int i = depth; i < N; i++) {  //순열만드는용
			swap(arr, depth, i);
			solve(arr, depth + 1, N);
			swap(arr, i, depth);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		result = 0;
		solve(arr, 0, N);
		System.out.println(result);
	}

}
