package DFS;
import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_14500_테트로미노 {
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int result;

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M) {
			return false;
		}
		return true;
	}
	
	// ㅗ 모양을 제외한 테트로미노들의 구간합을 DFS로 구한다.
	static void dfs(int r, int c, int depth, int sum) {
		sum += map[r][c];
		if (depth == 3) {
			if (result < sum) {
				result = sum;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];
			if (isRange(nextR, nextC) && !visit[nextR][nextC]) {
				visit[nextR][nextC] = true;
				dfs(nextR, nextC, depth + 1, sum);
				visit[nextR][nextC] = false;
			}
		}
	}

	// ㅜ 모양은 가운데를 기준으로 4방향의 값을 합한후 최소값을 뺀다.
	static void other(int r, int c) {
		int cnt = 0;
		int sum = map[r][c];
		int[] arr = new int[4];
		for (int i = 0; i < 4; i++) {
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];
			
			// 지도의 범위안에 블록의 4방향중 안들어가는 거 갯수 센다.
			if (!isRange(nextR, nextC)) {
				cnt++;
				arr[i] = 0;
			} else {
				arr[i] = map[nextR][nextC];
			}
		}
		// 위에서 계산한 갯수가 2개 이상이라는 것은 절대 ㅗ 관련 모양이 안나온다.
		if (cnt > 2) {
			return;
		} else {
			//4방향중 최소값을 구한다.
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 4; i++) {
				sum = sum + arr[i];
				if (min > arr[i]) {
					min = arr[i];
				}
			}
			sum = sum - min;
		}
		if (result < sum) {
			result = sum;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visit[i][j] = true;
				dfs(i, j, 0, 0);
				visit[i][j] = false;
				other(i, j);
			}
		}
		System.out.println(result);

	}

}
