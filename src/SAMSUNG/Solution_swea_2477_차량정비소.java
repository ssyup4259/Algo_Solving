package SAMSUNG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_swea_2477_차량정비소 {
	static int[] aTime, bTime;
	static Info[] aUse, bUse;
	static Queue<Integer> aWait, bWait;

	static class Info {
		int num, remain;

		public Info(int num, int remain) {
			this.num = num;
			this.remain = remain;
		}

	}

	// A 창구에 비어 있으면 넣기
	static void insertA(int num) {
		boolean flag = false;
		for (int i = 0; i < aUse.length; i++) {
			if (aUse[i] == null) {
				flag = true;
				aUse[i] = new Info(num, aTime[i]);
				break;
			}
		}
		// 넣을데가 없다면 대기큐에 넣어놓음
		if (!flag) {
			aWait.add(num);
		}
	}
	
	static void insertB(int num) {
		boolean flag = false;
		for (int i = 0; i < aUse.length; i++) {
			if (aUse[i] == null) {
				flag = true;
				aUse[i] = new Info(num, aTime[i]);
				break;
			}
		}
		// 넣을데가 없다면 대기큐에 넣어놓음
		if (!flag) {
			aWait.add(num);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			aTime = new int[N];
			bTime = new int[M];
			int[] visitTime = new int[K];
			for (int i = 0; i < N; i++) {
				aTime[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				bTime[i] = sc.nextInt();
			}
			for (int i = 0; i < K; i++) {
				visitTime[i] = sc.nextInt();
			}

			aUse = new Info[N];
			bUse = new Info[M];
			aWait = new LinkedList<>();
			bWait = new LinkedList<>();
			int time = 0;
			int flag = 0;

			while (true) {
				for (int i = flag; i < visitTime.length; i++) {
					if (time == visitTime[i]) {
						insertA(i);
					}
				}
				if (!bWait.isEmpty()) {
					
				}

			}
		}
	}

}
