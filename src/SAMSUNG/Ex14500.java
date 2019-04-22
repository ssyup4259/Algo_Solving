package SAMSUNG;

import java.util.Scanner;

public class Ex14500 {
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

	// ㅗ,ㅏ 모양 등을 빼고는 시작점에서 상하좌우 dfs돌리면
	// 4칸짜리 테트로미노를 만들수 있다.
	static void dfs(int r, int c, int depth, int sum) {
		sum += map[r][c];
		if (depth == 3) { // dfs 끝 최대값 갱신
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

	// ㅗ,ㅏ 모양 계산
	static void other(int r, int c) {
		int cnt = 0;
		int sum = map[r][c];
		int[] arr = new int[4];
		// 지금 시작점을 중심으로 상하좌우 의 점수를 arr에 넣는다.
		for (int i = 0; i < 4; i++) {
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];

			// 만약 범위를 벗어나면 cnt를 추가해주고
			if (!isRange(nextR, nextC)) {
				cnt++;
			} else {
				arr[i] = map[nextR][nextC];
			}
		}
		// 범위를 벗어난것이 2개이상이 된다면 ㅗ,ㅏ등의 모양이 될 수 없다.
		if (cnt > 1) {
			return;
		} else {
			// 모양이 주어졌다면
			int min = Integer.MAX_VALUE;
			// arr에 넣어놓은 값을 다 합치고 4개의 인자에서 최소값을 총합에서 제외 해준다면
			// 지금 현재 중심점 포함 3개의 합이 최대가 된다.
			for (int i = 0; i < 4; i++) {
				sum = sum + arr[i];
				if (min > arr[i]) {
					min = arr[i];
				}
			}
			sum = sum - min;
		}
		// 전체결과와 최대값 갱신
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
