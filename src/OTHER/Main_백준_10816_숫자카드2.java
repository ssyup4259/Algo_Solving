package OTHER;

import java.util.Scanner;

public class Main_백준_10816_숫자카드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 최대 500000
		int[] arr = new int[20000001];
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			arr[num + 10000000]++;
		}
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			System.out.print(arr[num + 10000000] + " ");
		}
	}

}
