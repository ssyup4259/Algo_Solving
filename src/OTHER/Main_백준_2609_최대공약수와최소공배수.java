package OTHER;

import java.util.Scanner;

public class Main_백준_2609_최대공약수와최소공배수 {

	static int gcd(int A, int B) {
		while (B != 0) {
			int temp = A % B;
			A = B;
			B = temp;
		}
		return A;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		if (A < B) {
			int temp = A;
			A = B;
			B = temp;
		}

		int res1 = gcd(A, B);
		int res2 = A * B / res1;

		System.out.println(res1);
		System.out.println(res2);
	}

}
