import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_9280_진용이네주차타워 {
	static int n, m, r[], w[], sum;
	static boolean[] visit;
	static int[] where;
	static Queue<Integer> que;

	static void in(int now) {
		int num = 0;
		if (que.isEmpty()) { // 대기차가 없다면 그 차 기준
			num = now; //
		} else { // 대기 하는 차가 있다면 대기하고 있던 차 기준
			num = que.peek();
			que.add(now);
		}

		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (!visit[i]) {
				visit[i] = true;
				where[num] = i; // num 차를 i번 주차장에 주차 했다고 표시
				sum += (r[i] * w[num]);
				que.poll();
				flag = true;
				break;
			}
		}

		if (!flag && que.isEmpty()) { // 주차장 꽉찼다면
			que.add(num);
		}
	}

	static void out(int num) {
		visit[where[num]] = false;
		if (!que.isEmpty()) {
			visit[where[num]] = true;
			int a = que.poll();
			sum += (r[where[num]] * w[a]);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt(); // 주차 공간
			m = sc.nextInt(); // 오늘 들어올 차량 대수
			r = new int[n];
			where = new int[m];
			for (int i = 0; i < n; i++) {
				r[i] = sc.nextInt();
			}
			w = new int[m];
			for (int i = 0; i < m; i++) {
				w[i] = sc.nextInt();
			}
			sum = 0;
			visit = new boolean[n];
			que = new LinkedList<>();
			for (int i = 0; i < 2 * m; i++) {
				int x = sc.nextInt();
				if (x > 0) {
					in(x - 1);
				} else {
					out(Math.abs(x + 1));
				}
			}
			System.out.println("#" + tc + " " + sum);

		}
	}

}
