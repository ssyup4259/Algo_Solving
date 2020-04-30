package OTHER;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_백준_2407_조합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		BigInteger top = BigInteger.valueOf(1);
		for (int i = 1; i <= n; i++) {
			top = top.multiply(BigInteger.valueOf(i));
		}
		BigInteger bottom = BigInteger.valueOf(1);
		for (int i = 1; i <= m; i++) {
			bottom = bottom.multiply(BigInteger.valueOf(i));
		}
		for (int i = 1; i <= n - m; i++) {
			bottom = bottom.multiply(BigInteger.valueOf(i));
		}
		System.out.println(top.divide(bottom));

	}

}
