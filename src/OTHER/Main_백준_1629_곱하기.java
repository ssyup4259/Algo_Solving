package OTHER;

import java.util.Scanner;

public class Main_백준_1629_곱하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		long ans = 1;
		long multiply = A % C;

		while (B > 0) {
			if (B % 2 == 1) {
				ans *= multiply;
				ans %= C;
			}
			multiply = ((multiply % C) * (multiply % C)) % C;
			B /= 2;
		}
		System.out.print(ans);

	}

}
