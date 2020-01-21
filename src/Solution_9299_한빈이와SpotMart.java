import java.util.Scanner;

public class Solution_9299_한빈이와SpotMart {
	static int N, M, a[], max, flag;

	static void solve(int st, int sum, int cnt) {
		if (cnt == 2) {
			max = max > sum ? max : sum;
			return;
		}

		for (int i = st; i < N; i++) {
			if (sum + a[i] <= M) {
				solve(i + 1, sum + a[i], cnt + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 최대 1000
			M = sc.nextInt(); // 최대 2000000
			a = new int[N];
			for (int i = 0; i < N; i++) {
				a[i] = sc.nextInt();
			}
			max = 0;
			flag = 0;
			solve(0, 0, 0);
			if (max == 0) {
				max = -1;
			}
			System.out.println("#" + tc + " " + max);
		}

	}

}
