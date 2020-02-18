package OTHER;

import java.util.Scanner;

public class Main_백준_1110_더하기사이클 {

	public static int sum(int n) {
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		n1 = n / 10;
		n2 = n % 10;
		n3 = n1 + n2;
		return n3;
	}

	public static int newN(int n, int n1) {
		int n2 = 0;
		int n3 = 0;
		int n4 = 0;
		n2 = n % 10;
		n3 = n1 % 10;
		n4 = n2 * 10 + n3;

		return n4;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int n1 = 0;
		int n2 = 0;
		int cnt = 0;
		int nn = n;
		while (true) {
			n1 = sum(nn);
			n2 = newN(nn, n1);
			nn = n2;
			cnt = cnt + 1;
			if (n2 == n) {
				break;
			}
		}
		System.out.println(cnt);
	}

}
