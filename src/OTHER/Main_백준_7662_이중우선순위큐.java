package OTHER;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_7662_이중우선순위큐 {
	static class Info {
		int n, value;

		public Info(int n, int value) {
			super();
			this.n = n;
			this.value = value;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int k = sc.nextInt();
			PriorityQueue<Info> pqMax = new PriorityQueue<>(new Comparator<Info>() {
				@Override
				public int compare(Info o1, Info o2) {
					return Integer.compare(o2.value, o1.value);
				}

			});
			PriorityQueue<Info> pqMin = new PriorityQueue<>(new Comparator<Info>() {

				@Override
				public int compare(Info o1, Info o2) {
					return Integer.compare(o1.value, o2.value);
				}
			});
			boolean[] visit = new boolean[k + 1];

			for (int i = 0; i < k; i++) {
				String d = sc.next();
				int n = sc.nextInt();
				if (d.equals("I")) {
					Info now = new Info(i, n);
					pqMax.add(now);
					pqMin.add(now);
				} else if (d.equals("D")) {
					if (n == 1) {
						if (!pqMax.isEmpty()) {
							Info info = pqMax.peek();
							if (!visit[info.n]) {
								pqMax.poll();
								visit[info.n] = true;
							}
						}
					} else {
						if (!pqMin.isEmpty()) {
							Info info = pqMin.peek();
							if (!visit[info.n]) {
								pqMin.poll();
								visit[info.n] = true;
							}
						}
					}
				}
				while (!pqMax.isEmpty()) {
					if (!visit[pqMax.peek().n]) {
						break;
					} else {
						pqMax.poll();
					}
				}
				while (!pqMin.isEmpty()) {
					if (!visit[pqMin.peek().n]) {
						break;
					} else {
						pqMin.poll();
					}
				}
			}
			if (pqMax.isEmpty() || pqMin.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				System.out.println(pqMax.poll().value + " " + pqMin.poll().value);
			}
		}

	}

}
