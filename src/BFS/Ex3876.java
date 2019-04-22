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
			if (str.equals(end)) { // end ���� ������ ����
				if (nowCnt < result) { // result ���� ª�ٸ� nowCnt�� result
					result = nowCnt;
				}
				return;
			}

			// arr[i][0] �� ������ dir[i][0] �� ���� ó�� bfs ����
			for (int i = 0; i < n; i++) {
				String nextStr = str.replaceAll(arr[i][0], arr[i][1]);

				// ��Ÿ�� ���ĺ��� ���̰� ������ ��ų� �����ϱ� ��������� String�� ���̰� end ���� ������� �ȵȴ�.
				if (!nextStr.equals(str) && nextStr.length() <= end.length()) {
					que.add(new Info(nextStr, nowCnt + 1));
				}
			}
		}

		// que �� ����µ� ���� ���� �ʾҴٸ� ���� �� ���°�
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

			// result �� �״���ΰ��� ���� �� ���ٴ� ��
			if (result == 10000000) {
				result = -1;
			}
			System.out.println(result);
		}
	}

}
