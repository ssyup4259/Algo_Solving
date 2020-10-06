package SIMULATION;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main_백준_17140_이차원배열과연산 {

	static int R, C, K;
	static int rCnt, cCnt;
	static int res;

	static class Info {
		int num, cnt;

		public Info(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}

	static int[][] rOper(int[][] arr) {
		int newC = cCnt * 2 > 100 ? 100 : cCnt * 2;
		int[][] result = new int[rCnt][newC];
		int max = 0;
		for (int i = 0; i < rCnt; i++) {
			List<Info> list = new ArrayList<>();
			for (int j = 0; j < cCnt; j++) {
				boolean flag = false;
				if (arr[i][j] == 0) {
					continue;
				}
				for (int k = 0; k < list.size(); k++) {
					if (list.get(k).num == arr[i][j]) {
						list.get(k).cnt++;
						flag = true;
						break;
					}
				}
				if (!flag) {
					list.add(new Info(arr[i][j], 1));
				}
			}
			Collections.sort(list, new Comparator<Info>() {
				@Override
				public int compare(Info o1, Info o2) {
					// 갯수가 같다면 숫자의 크기 순으로 정렬
					if (o1.cnt == o2.cnt) {
						return Integer.compare(o1.num, o2.num);
					}
					return Integer.compare(o1.cnt, o2.cnt);
				}
			});
			for (int j = 0; j < list.size(); j++) {
				result[i][j * 2] = list.get(j).num;
				result[i][j * 2 + 1] = list.get(j).cnt;
			}
			if (max < list.size() * 2) {
				max = list.size() * 2;
			}
		}

		int[][] realResult = new int[rCnt][max];
		cCnt = max;
		for (int i = 0; i < rCnt; i++) {
			for (int j = 0; j < max; j++) {
				realResult[i][j] = result[i][j];
				// System.out.print(realResult[i][j] + " ");
			}
			// System.out.println();
		}
		return realResult;
	}

	static int[][] cOper(int[][] arr) {
		int newR = rCnt * 2 > 100 ? 100 : rCnt * 2;
		int[][] result = new int[newR][cCnt];
		int max = 0;
		for (int i = 0; i < cCnt; i++) {
			List<Info> list = new ArrayList<>();
			for (int j = 0; j < rCnt; j++) {
				boolean flag = false;
				if (arr[j][i] == 0) {
					continue;
				}
				for (int k = 0; k < list.size(); k++) {
					if (list.get(k).num == arr[j][i]) {
						list.get(k).cnt++;
						flag = true;
						break;
					}
				}
				if (!flag) {
					list.add(new Info(arr[j][i], 1));
				}
			}
			Collections.sort(list, new Comparator<Info>() {
				@Override
				public int compare(Info o1, Info o2) {
					// TODO Auto-generated method stub
					if (o1.cnt == o2.cnt) {
						return Integer.compare(o1.num, o2.num);
					}
					return Integer.compare(o1.cnt, o2.cnt);
				}
			});
			for (int j = 0; j < list.size(); j++) {
				result[j * 2][i] = list.get(j).num;
				result[j * 2 + 1][i] = list.get(j).cnt;
			}
			if (max < list.size() * 2) {
				max = list.size() * 2;
			}
		}

		int[][] realResult = new int[max][cCnt];
		rCnt = max;
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < cCnt; j++) {
				realResult[i][j] = result[i][j];
				// System.out.print(realResult[i][j] + " ");
			}
			// System.out.println();
		}
		return realResult;
	}

	static void solve(int[][] arr, int cnt) {
		// System.out.println("-----------------------------------------");
		if (cnt > 100) {
			res = -1;
			return;
		}
		// R연산
		if (rCnt >= cCnt) {
			int newC = cCnt * 2 > 100 ? 100 : cCnt * 2;
			int[][] result = new int[rCnt][newC];
			result = rOper(arr);
			if (R - 1 >= 0 && R - 1 < result.length && C - 1 >= 0 && C - 1 < result[0].length) {
				if (result[R - 1][C - 1] == K) {
					res = cnt;
					return;
				}
			}
			solve(result, cnt + 1);
		} else {
			int newR = rCnt * 2 > 100 ? 100 : rCnt * 2;
			int[][] result = new int[newR][cCnt];
			result = cOper(arr);
			if (R - 1 >= 0 && R - 1 < result.length && C - 1 >= 0 && C - 1 < result[0].length) {
				if (result[R - 1][C - 1] == K) {
					res = cnt;
					return;
				}
			}
			solve(result, cnt + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		int[][] arr = new int[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		rCnt = 3;
		cCnt = 3;

		if (R < 4 && C < 4 && arr[R - 1][C - 1] == K) {
			System.out.println(0);
			return;
		} else {
			solve(arr, 1);
		}
		System.out.println(res);
	}

}
