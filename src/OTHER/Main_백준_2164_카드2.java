package OTHER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_백준_2164_카드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num = 1;
		int cnt = 0;
		while (num < N) {
			num *= 2;
			cnt++;
		}
		if (num == N) {
			System.out.println(N);
		} else {
			System.out.println((N - num / 2) * 2);
		}
	}

}
