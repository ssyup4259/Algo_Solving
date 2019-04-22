package SAMSUNG;

import java.util.Scanner;

public class Ex12100 {
	static int N;
	static int[][] map;
	static int result;

	static void dfs(int depth) {
		// 5번 진행 했으면 최대값 갱신
		if (depth == 5) {
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max < map[i][j]) {
						max = map[i][j];
					}
				}
			}
			if (result < max) {
				result = max;
			}
			return;
		}
		// 4방향으로 다 해본다. 방향을 0,1,2,3 으로 했을때 11110 과 11101 순으로 한것은
		// 다른 값이 나온다. 그래서 중복 허용
		for (int d = 0; d < 4; d++) {
			int[][] temp = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					temp[i][j] = map[i][j];
				}
			}
			solve(d);
			dfs(depth + 1);
			// 상위 for문의 다음 d를 해결하기 위해 map 이전값으로
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[i][j];
				}
			}
		}
	}

	// 방향을 정하고 그방향으로 진행
	static void solve(int d) {
		if (d == 1) { // 오른쪽으로
			for (int i = 0; i < N; i++) { // 열을고르고
				int cnt = 0; // 0의갯수 확인용
				int flag = 0; // 이전의 수와 현재 수가 같은지 확인용
				for (int j = N - 1; j >= 0; j--) { // 행의 맨 오른쪽 부터
					if (map[i][j] == 0) {
						cnt++;
					} else {
						if (flag == map[i][j]) { // 이전의 값과 지금의 값이 갔다면
							// 지금의 값을 2배로 0이 아닌칸을 제외하고 제일 오른쪽으로 보낸다.
							map[i][j + cnt + 1] = map[i][j] + map[i][j];
							map[i][j] = 0; // 지금 칸은 0으로 만든다.
							flag = 0; // 가장 오른쪽에서부터 2개씩만 합쳐질수 있으니 합쳐지면 다시 초기화
							cnt++; // 2개의 값이 합쳐져 1개의 값이 생기니 0의 갯수는 하나 늘어남
						} else {
							// 0이 아닌칸을 제외하고 제일 오른쪽으로 보낸다.
							map[i][j + cnt] = map[i][j];
							// 지금의 값을 flag에 저장
							flag = map[i][j];
							// cnt 가 0이 아니라면 지금의 값 0으로 만든다. 만약 0 이라면 가장 오른쪽 값이기에 제외
							if (cnt != 0) {
								map[i][j] = 0;
							}
						}
					}
				}
			}
		} else if (d == 3) { // 왼쪽으로
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				int flag = 0;
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						cnt++;
					} else {
						if (flag == map[i][j]) {
							map[i][j - cnt - 1] = map[i][j] + map[i][j];
							map[i][j] = 0;
							flag = 0;
							cnt++;
						} else {
							map[i][j - cnt] = map[i][j];
							flag = map[i][j];
							if (cnt != 0) {
								map[i][j] = 0;
							}
						}
					}
				}
			}
		} else if (d == 0) { // 위로
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				int flag = 0;
				for (int j = 0; j < N; j++) {
					if (map[j][i] == 0) {
						cnt++;
					} else {
						if (flag == map[j][i]) {
							map[j - cnt - 1][i] = map[j][i] + map[j][i];
							map[j][i] = 0;
							flag = 0;
							cnt++;
						} else {
							map[j - cnt][i] = map[j][i];
							flag = map[j][i];
							if (cnt != 0) {
								map[j][i] = 0;
							}
						}
					}
				}
			}
		} else if (d == 2) { // 아래로
			for (int i = 0; i < N; i++) {
				int cnt = 0;
				int flag = 0;
				for (int j = N - 1; j >= 0; j--) {
					if (map[j][i] == 0) {
						cnt++;
					} else {
						if (flag == map[j][i]) {
							map[j + cnt + 1][i] = map[j][i] + map[j][i];
							map[j][i] = 0;
							flag = 0;
							cnt++;
						} else {
							map[j + cnt][i] = map[j][i];
							flag = map[j][i];
							if (cnt != 0) {
								map[j][i] = 0;
							}
						}
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		result = 0;
		dfs(0);
		System.out.println(result);

	}

}
