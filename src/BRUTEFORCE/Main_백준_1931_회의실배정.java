package BRUTEFORCE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_백준_1931_회의실배정 {

	static class Info implements Comparable<Info> {
		int start, end;

		Info(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Info o) {
			if (this.end > o.end) {
				return 1;
			} else if (this.end == o.end) {
				if (this.start > o.start) {
					return 1;
				}
			}
			return -1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Info> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			pq.add(new Info(start, end));
		}
		int end = 0;
		int cnt = 0;

		while (!pq.isEmpty()) {
			Info abc = pq.poll();
			if (end <= abc.start) {
				cnt++;
				end = abc.end;
			}
		}
		System.out.println(cnt);
	}

}
