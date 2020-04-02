package OTHER;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_백준_1181_단어정렬 {

	static class Info implements Comparable<Info> {
		String str;
		int len;

		public Info(String str, int len) {
			super();
			this.str = str;
			this.len = len;
		}

		@Override
		public int compareTo(Info o) {
			if (this.len == o.len) {
				return this.str.compareTo(o.str);
			}
			return Integer.compare(this.len, o.len);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Info> pq = new PriorityQueue<>();
		List<String> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			if (!list.contains(str)) {
				list.add(str);
			}
		}

		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			if (!pq.contains(new Info(str, str.length()))) {
				pq.add(new Info(str, str.length()));
			}
		}

		while (!pq.isEmpty()) {
			Info info = pq.poll();
			System.out.println(info.str);
		}

	}

}
