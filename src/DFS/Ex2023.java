package DFS;

import java.util.Scanner;

public class Ex2023 {
	static int N;

	// 소수 인지 판별
	static boolean isSosu(int num) {
		if (num < 2) {
			return false;
		} else {
			for (int i = 2; i <= num / 2; i++) {
				if (num % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

	// EX) 2가 소수 인지 알았으면 21,22...,29 중에 소수를 판별하고 그것이 소수라면
	// 231,232,...239 중에 소수가 있는지 판별 하는 식
	// 원하는 자릿수가 된다면 출력
	static void solve(int num, int depth) {
		if (depth == N) {
			System.out.println(num);
			return;
		}
		for (int i = 0; i <= 9; i++) {
			num = num * 10 + i;
			if (isSosu(num)) {
				solve(num, depth + 1);
			}
			num = num / 10;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		// 1부터 9까지 소수인지 판별해서 다음 자릿수로 넘어간다.
		for (int i = 1; i <= 9; i++) {
			if (isSosu(i)) {
				solve(i, 1);
			}
		}
	}

}
