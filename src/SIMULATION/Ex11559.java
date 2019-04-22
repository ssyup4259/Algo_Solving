package SIMULATION;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex11559 {
	static char[][] map = new char[12][6];
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static boolean[][] visit;
	static List<Info> list;
	static int result;

	static class Info {
		int r, c;

		Info(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static boolean isRange(int r, int c) {
		if (r < 0 || r >= 12 || c < 0 || c >= 6) {
			return false;
		}
		return true;
	}

	// 빈공간 내리기
	static void breakDown() {
		for (int i = 0; i < 6; i++) {
			int cnt = 0;
			// 아래부터 위로 하나씩 탐색하면서 빈공간 있으면 cnt 증가
			for (int j = 11; j >= 0; j--) {
				if (map[j][i] == '.') {
					cnt++;
				} else {
					// 빈공간 이후 다른 구슬 만나면 그걸 cnt 만큼 내린다.
					if (cnt != 0) {
						map[j + cnt][i] = map[j][i];
						map[j][i] = '.';
					}
				}
			}
		}
	}

	// 부시기
	static void crush() {
		list = new ArrayList<>();
		visit = new boolean[12][6];
		boolean flag = false;
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				// dfs 하면서 list에 넣고 list가 4이상이된다면 부시기
				if (map[i][j] != '.' && !visit[i][j]) {
					dfs(i, j, map[i][j]);
					if (list.size() >= 4) {
						flag = true;
						for (int k = 0; k < list.size(); k++) {
							map[list.get(k).r][list.get(k).c] = '.';
						}
					}
					list.clear(); // list 초기화
				}
			}
		}
		// 4이상인 부실게 있었다면
		if (flag) {
			breakDown();
			result++;
			// 한번더 crush 해본다
			crush();
		}
	}

	static void dfs(int r, int c, char type) {
		visit[r][c] = true;
		list.add(new Info(r, c));
		for (int i = 0; i < 4; i++) {
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];
			if (isRange(nextR, nextC) && map[nextR][nextC] == type && !visit[nextR][nextC]) {
				dfs(nextR, nextC, type);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 12; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		crush();
		System.out.println(result);
	}

}
