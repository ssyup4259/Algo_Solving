package OTHER;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex2210 {
	static String[][] map;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static String result;
	static ArrayList<String> list = new ArrayList<>();

	static boolean isRange(int r, int c) {
		boolean flag = true;
		if (r < 0 || r > 4 || c < 0 || c > 4) {
			flag = false;
		}
		return flag;
	}

	static void dfs(int r, int c) {
		// 숫자 길이 6 고정
		if (result.length() == 6) {
			// list에 이미 그 수 가 없다면 추가
			if (!list.contains(result)) {
				list.add(result);
			}
			// result 초기화
			result = "";
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];
			if (isRange(nextR, nextC)) {
				String str = result;
				result = result + map[nextR][nextC];
				dfs(nextR, nextC);
				// 다음 for문에 result를 넣기 위해 이전으로 변경
				result = str;
			} else {
				continue;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new String[5][5];
		result = "";
		for (int i = 0; i < 5; i++) {
			String str = sc.nextLine();
			map[i] = str.split(" ");
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				result = map[i][j];
				dfs(i, j);
			}
		}
		
		System.out.println(list.size());

	}

}
