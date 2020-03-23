package OTHER;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main_백준_1920_수찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			hs.add(num);
		}
		int M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			if (hs.contains(Integer.valueOf(num))) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}

}
