package OTHER;

import java.util.Scanner;

public class Main_백준_11050_이항계수1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int a = 1;
		for (int i = 1; i <= N; i++) {
			a = a * i;
		}

		int b = 1;
		for (int i = 1; i <= K; i++) {
			b = b * i;
		}

		int c = 1;
		for (int i = 1; i <= N - K; i++) {
			c = c * i;
		}

		int result = a / (b * c);
		System.out.println(result);
	}

}
