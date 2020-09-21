package DFS;

import java.util.Arrays;
import java.util.Scanner;

public class Main_백준_15684_사다리조작 {
	static int N, M, H, map[][];
	static int answer;
	static boolean[][] visit;
	
	// 현재 홀수개인 사다리 갯수 체크
	static int oddLadder() {
		int result = 0;
		for (int i = 1; i < N + 1; i++) {
			int flag = 0;
			for (int j = 1; j < H + 1; j++) {
				if (map[j][i] != i) {
					flag++;
				}
			}
			if (flag % 2 != 0) {
				result++;
			}
		}
		return result;
	}
	
	//최종 자기라인으로 자신이 갈 수 있나 조사
	static boolean finalCheck() {
		for (int i = 1; i < N + 1; i++) {
			int nowR = 1;
			int nowC = i;
			while (nowR <= H) {
				if (map[nowR][nowC] == nowC) {
					if (map[nowR][nowC - 1] == nowC) {
						nowC--;
					}
					nowR++;
				} else {
					nowR++;
					nowC++;
				}
			}
//			System.out.println("시작 : " + i);
//			System.out.println("끝 : map[" + nowR + "]" + "[" + nowC + "]");
			if (nowC != i) {
				return false;
			}
		}
		return true;
	}

	static void dfs(int r, int c, int depth, int oddCheck) {
		//System.out.println(depth + " : " + oddCheck);
		if (depth == oddCheck) {
			// for (int i = 0; i < H + 1; i++) {
			// System.out.println(Arrays.toString(map[i]));
			// }
			if (finalCheck()) {
				//System.out.println("만들 수 있는 사다리갯수: " + oddCheck);
				answer = oddCheck;
			}
			return;
		}

		for (int i = 1; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (!visit[i][j] && map[i][j - 1] == j - 1 && map[i][j] == j) {
					map[i][j]++;
					visit[i][j] = true;
					dfs(i, j + 1, depth + 1, oddCheck);
					map[i][j]--;
					visit[i][j] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		map = new int[H + 1][N + 1];

		for (int i = 0; i < H + 1; i++) {
			for (int j = 0; j < N + 1; j++) {
				map[i][j] = j;
			}
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b]++;
		}
//		for (int i = 0; i < H + 1; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}

		int oddCheck = oddLadder();
//		System.out.println("홀수 사다리 개수 : " + oddCheck);
		if (oddCheck <= 3) {
			for (int i = 0; i <= 3; i++) {
				answer = -1;
				visit = new boolean[H + 1][N + 1];
				dfs(1, 1, 0, i);
				if (answer != -1) {
					System.out.println(answer);
					return;
				}
			}
		}
		System.out.println(-1);

	}

}
