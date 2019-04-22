package DFS;

import java.util.Scanner;

public class Ex9663 {
	static int N;
	static int[][] map, newMap;
	// 퀸이 갈 수 있는 8방향 상 상우 우 우하 하 하좌 좌 좌상
	// 하지만 맨위 행 부터 하나씩 아래로 내려오면서 퀸을 배치할것이기에
	// 퀸이 위에 또는 좌위, 우위 에 있는지 확인만 하면된다.
	// 이전의 퀸이 현재 퀸으 좌 우 아래 부분에는 있을 수 없기 때문
	static int[][] dir = { { -1, 0 }, { -1, 1 }, { -1, -1 } }; // 상 우상 좌상
	static int result;

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}

	static boolean move(int r, int c) {
		// 퀸이 첫번째 칸에 있을때 N번째 칸까지 검사해야되니
		for (int i = 1; i < N; i++) {
			for (int d = 0; d < 3; d++) { // 세방향으로
				int nextR = r + dir[d][0] * i;
				int nextC = c + dir[d][1] * i;

				if (!isRange(nextR, nextC)) {
					continue;
				} else {
					// 검사 해서 이전에 퀸이 있다면 지금의 퀸이 공격 할 수 있다는 것
					if (map[nextR][nextC] == 1) {
						return false;
					}
				}
			}
		}

		return true;
	}

	static void solve(int depth) {
		if (depth == N) {
			result++;
			return;
		}
		for (int i = 0; i < N; i++) {
			// 이전에 퀸이 없다면 다음 solve로 DFS
			if (move(depth, i)) {
				map[depth][i] = 1;
				solve(depth + 1);
				map[depth][i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		newMap = new int[N][N];
		result = 0;
		solve(0);
		System.out.println(result);
	}

}
