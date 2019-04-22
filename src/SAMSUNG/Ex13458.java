package SAMSUNG;

import java.util.Scanner;

public class Ex13458 {
	static int N;
	static long[] A;
	static long B, C;
	static long sum;
	
	//최악의 경우 100만개의 시험장에 100만명의 감독관이 필요할 수 도 있으니
	//Integer의 범위를 넘어선다.
	//BigInteger 까지는 안가도 된다.
	static void solve() {
		for (int i = 1; i <= N; i++) {
			if (A[i] <= B) {
				sum++;
			} else {
				A[i] -= B;
				sum++;
				sum += ((A[i] - 1) / C + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = sc.nextInt();
		}
		B = sc.nextInt();
		C = sc.nextInt();
		sum = 0;
		solve();
		System.out.println(sum);
	}

}
