import java.util.Scanner;

public class Ex16986 {
	static int N, K;
	static int[][] map;
	static int[] kh, mh;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		kh = new int[20];
		mh = new int[20];
		for (int i = 0; i < 20; i++) {
			kh[i] = sc.nextInt();
		}
		for (int i = 0; i < 20; i++) {
			mh[i] = sc.nextInt();
		}

	}

}
