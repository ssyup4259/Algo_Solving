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
			// �Է� ���� �켱������ ���ٸ� 1, �ƴϸ� -1
			if (this.c < o.c) {
				return 1;
			}
			return -1;
		}
	}

	public static void main(String[] args) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		for (int i = 9; i >= 0; i--) {
			pq.add(new Info(i * 2, i)); // pq.offer(i) �� ���� ����
		}

		while (!pq.isEmpty()) {
			System.out.print(pq.peek().r + " " + pq.size() + " " + pq.poll().r + " " + pq.size());
			System.out.println();
		}

	}

}
