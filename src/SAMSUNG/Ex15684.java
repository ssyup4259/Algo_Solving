package SAMSUNG;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Ex15684 {
	static int N, M, H;
	static int[][] map;

	static class Info implements Comparable<Info> {
		int r, c;

		Info(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Info o) {
			if (this.c < o.c) {
				return -1;
			}
			return 1;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		PriorityQueue<Info> que = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			que.add(new Info(sc.nextInt(), sc.nextInt()));
		}
		
		for(int i = 0; i< M ;i++) {
			System.out.println(que.peek().r + " " + que.poll().c);
			
		}
	}

}
