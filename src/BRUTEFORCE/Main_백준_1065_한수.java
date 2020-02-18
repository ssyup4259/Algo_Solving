package BRUTEFORCE;

import java.util.Scanner;

public class Main_백준_1065_한수 {

	public static int han(int n) {
		if (n < 100)
			return 1;
		else {
			int a = n / 100;
			int b = (n / 10) % 10;
			int c = n % 10;

			int sub = a - b;

			if (sub == b - c) {
				return 1;
			} else
				return 0;
		}

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int count = 0;

		for (int i = 1; i <= n; i++) {
			count += han(i);
		}
		System.out.println(count);
	}

}
