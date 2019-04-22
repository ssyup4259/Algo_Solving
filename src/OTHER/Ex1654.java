package OTHER;

import java.util.Scanner;

public class Ex1654 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[K];
		int sum = 0;
		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		int flag = sum / N;
		int sum2 = 0;
		for (int i = flag; i > 0; i--) {
			for (int j = 0; j < K; j++) {
				sum2 += (arr[j] / i);
			}
			if (sum2 >= N) {
				System.out.println(i);
				break;
			}
			sum2 = 0;
		}

	}

}
