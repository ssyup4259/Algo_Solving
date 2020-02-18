package DFS;
import java.util.Scanner;

public class Main_백준_1012_유기농배추 {
	static final int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int M, N, K;
	static int[][] arr;
	static boolean[][] visit;

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) {
			return false;
		}
		return true;
	}

	static void dfs(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nextR = r + dir[d][0];
			int nextC = c + dir[d][1];
			if (isRange(nextR, nextC) && !visit[nextR][nextC] && arr[nextR][nextC] == 1) {
				visit[nextR][nextC] = true;
				dfs(nextR, nextC);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N][M];
			visit = new boolean[N][M];
			for (int i = 0; i < K; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				arr[r][c] = 1;
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visit[i][j] && arr[i][j] == 1) {
						visit[i][j] = true;
						cnt++;
						dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}

	}

}
