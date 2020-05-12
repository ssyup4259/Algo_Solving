package SAMSUNG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution_swea_5644_무선충전 {
	static final int[][] dir = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int M, A, arrA[], arrB[], score[];
	static List<Battery> Batterys;

	static class Battery {
		int r, c, range, power, num;

		public Battery(int r, int c, int range, int power, int num) {
			this.r = r;
			this.c = c;
			this.range = range;
			this.power = power;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Battery [r=" + r + ", c=" + c + ", range=" + range + ", power=" + power + "]";
		}

	}

	static int len(int ar, int ac, int br, int bc) {
		return Math.abs(ar - br) + Math.abs(ac - bc);
	}

	static void solve(int ar, int ac, int br, int bc, int t) {
		List<Battery> aList = new ArrayList<>();
		List<Battery> bList = new ArrayList<>();
		for (int i = 0; i < Batterys.size(); i++) {
			Battery bt = Batterys.get(i);
			int aLen = len(ar, ac, bt.r, bt.c);
			int bLen = len(br, bc, bt.r, bt.c);
			if (aLen <= bt.range) {
				aList.add(bt);
			}
			if (bLen <= bt.range) {
				bList.add(bt);
			}
		}

		Collections.sort(aList, new Comparator<Battery>() {
			@Override
			public int compare(Battery o1, Battery o2) {
				return Integer.compare(o2.power, o1.power);
			}
		});
		Collections.sort(bList, new Comparator<Battery>() {
			@Override
			public int compare(Battery o1, Battery o2) {
				return Integer.compare(o2.power, o1.power);
			}
		});

		if (aList.size() == 0 && bList.size() == 0) {
			score[t] = 0;
		} else if (aList.size() >= 1 && bList.size() == 0) {
			score[t] = aList.get(0).power;
		} else if (aList.size() == 0 && bList.size() >= 1) {
			score[t] = bList.get(0).power;
		} else if (aList.size() >= 1 && bList.size() >= 1) {
			int max = 0;
			for (int i = 0; i < aList.size(); i++) {
				Battery aBat = aList.get(i);
				for (int j = 0; j < bList.size(); j++) {
					Battery bBat = bList.get(j);
					int sum = 0;
					if (aBat.num == bBat.num) {
						sum = aBat.power;
					} else {
						sum = aBat.power + bBat.power;
					}
					if (max < sum) {
						max = sum;
					}
				}
			}
			score[t] = max;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			M = sc.nextInt(); // 총 이동시간
			A = sc.nextInt(); // BC 의 개수
			arrA = new int[M];
			arrB = new int[M];
			for (int i = 0; i < M; i++) {
				arrA[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				arrB[i] = sc.nextInt();
			}
			Batterys = new ArrayList<>();
			for (int i = 0; i < A; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();
				int range = sc.nextInt();
				int power = sc.nextInt();
				Batterys.add(new Battery(r, c, range, power, i));
			}
			score = new int[M + 1];
			int ar = 1;
			int ac = 1;
			int br = 10;
			int bc = 10;
			for (int i = 0; i < M + 1; i++) {
				solve(ar, ac, br, bc, i);
				if (i == M) {
					break;
				}
				ar += dir[arrA[i]][0];
				ac += dir[arrA[i]][1];
				br += dir[arrB[i]][0];
				bc += dir[arrB[i]][1];
			}
			
			int sum = 0;
			for (int i = 0; i < M + 1; i++) {
				sum += score[i];
			}
			System.out.println("#" + tc + " " + sum);
		}
	}

}
