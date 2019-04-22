package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex16953 {
	static long A, B;
	static int result;

	static class Info {
		long num;
		int cnt; // 지금 숫자, 만드는데 걸린 횟수

		Info(long num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	static void bfs(long a) {
		Queue<Info> que = new LinkedList<>();
		que.add(new Info(a, 0));

		while (!que.isEmpty()) {
			long nowN = que.peek().num;
			int nowC = que.poll().cnt;

			// 지금 숫자가 B가되면 횟수 최소값 갱신
			if (nowN == B) {
				if (result > nowC) {
					result = nowC;
				}
			}
			// 지금 숫자가 B보다 크면 넘어간다.
			if (nowN > B) {
				continue;
			}

			// 두 경우를 가지로 bfs 뻗어나간다.
			long nextN1 = nowN * 2;
			que.add(new Info(nextN1, nowC + 1));
			long nextN2 = nowN * 10 + 1;
			que.add(new Info(nextN2, nowC + 1));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// A가 입력으로 999999998 이 들어왔을때 연산을 하면 int의 범위 벗어난다
		// A,B 둘다 long으로
		A = sc.nextLong();
		B = sc.nextLong();
		result = Integer.MAX_VALUE;
		bfs(A);
		// result 안 바꼈다면 만들수 없는것
		if (result == Integer.MAX_VALUE) {
			result = -1;
		} else {
			result++;
		}
		System.out.println(result);
	}

}
