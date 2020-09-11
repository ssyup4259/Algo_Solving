package SIMULATION;
import java.util.Scanner;

public class Main_백준_13458_시험감독 {
	static int N;
	static long[] A;
	static long B, C;
	static long sum;

	static void solve() {
		for (int i = 1; i <= N; i++) {
			if (A[i] <= B) {  //정감독관 관리가능 인원보다 작을경우
				sum++;
			} else { // 정감독관 관리가능 인원보다 많을경우
				A[i] -= B;
				sum++;
				sum += ((A[i] - 1) / C + 1);  // 부감독관 인원
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
