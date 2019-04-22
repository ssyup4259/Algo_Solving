package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex3876 {
	static String first, end;
	static int n, result;
	static String[][] arr;

	static class Info {
		String str;
		int cnt;

		Info(String str, int cnt) {
			this.str = str;
			this.cnt = cnt;
		}
	}

	static void bfs(String a) {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(a, 0));

		while (!que.isEmpty()) {
			String str = que.peek().str;
			int nowCnt = que.poll().cnt;
			if (str.equals(end)) { // end 글자 나오면 종료
				if (nowCnt < result) { // result 보다 짧다면 nowCnt가 result
					result = nowCnt;
				}
				return;
			}

			// arr[i][0] 의 갯수를 dir[i][0] 의 갯수 처럼 bfs 돈다
			for (int i = 0; i < n; i++) {
				String nextStr = str.replaceAll(arr[i][0], arr[i][1]);

				// 베타가 알파보다 길이가 무조건 길거나 같으니깐 만들어지는 String의 길이가 end 보다 길어지면 안된다.
				if (!nextStr.equals(str) && nextStr.length() <= end.length()) {
					que.add(new Info(nextStr, nowCnt + 1));
				}
			}
		}

		// que 가 비었는데 종료 되지 않았다면 만들 수 없는것
		result = -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			n = sc.nextInt();
			if (n == 0) {
				break;
			}
			sc.nextLine();
			arr = new String[n][2];
			for (int i = 0; i < n; i++) {
				String str = sc.nextLine();
				arr[i][0] = str.substring(0, str.indexOf(" "));
				arr[i][1] = str.substring(str.indexOf(" ") + 1);
			}
			first = sc.nextLine();
			end = sc.nextLine();
			result = 10000000;

			bfs(first);

			// result 가 그대로인것은 만들 수 없다는 뜻
			if (result == 10000000) {
				result = -1;
			}
			System.out.println(result);
		}
	}

}
