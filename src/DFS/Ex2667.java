package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex2667 {
	static int N;
	static char[][] map;
	static boolean[][] visit;
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int result;

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N) {
			return false;
		}
		return true;
	}

	static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];
			if (isRange(nextR, nextC)) {
				// ���� ����Ʈ�� �湮���� �ʾҴٸ� ��� ����
				if (map[nextR][nextC] == '1' && !visit[nextR][nextC]) {
					visit[nextR][nextC] = true;
					result++;
					dfs(nextR, nextC);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new char[N][N];
		visit = new boolean[N][N];
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		// ���� ���� ����� ����Ʈ
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// �湮���� �ʰ� ����Ʈ�� �ִٸ� dfs ����
				if (map[i][j] == '1' && !visit[i][j]) {
					visit[i][j] = true;
					result = 1;
					dfs(i, j);
					list.add(result);
				}
			}
		}
		// �������� ����
		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}
