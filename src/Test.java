import java.util.PriorityQueue;
import java.util.Scanner;

public class Test {

	static class Info implements Comparable<Info> {
		int r, c;

		Info(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Info o) {
			// 입력 값이 우선순위가 높다면 1, 아니면 -1
			if (this.c < o.c) {
				return 1;
			}
			return -1;
		}
	}

	public static void main(String[] args) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		for (int i = 9; i >= 0; i--) {
			pq.add(new Info(i * 2, i)); // pq.offer(i) 와 같이 삽입
		}

		while (!pq.isEmpty()) {
			System.out.print(pq.peek().r + " " + pq.size() + " " + pq.poll().r + " " + pq.size());
			System.out.println();
		}

	}

}
