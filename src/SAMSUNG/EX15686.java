package SAMSUNG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EX15686 {
	static int N, M;
	static List<Info> chickenList, homeList;
	static List<Integer> openList;
	static int answer;

	static class Info {
		int r, c;

		Info(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	// 맨하튼 거리 구하기
	static int menLen(int ar, int ac, int br, int bc) {
		return Math.abs(ar - br) + Math.abs(ac - bc);
	}

	static void solve(int next, int depth) {
		// 뽑은 치킨집에 M개가 되었다면
		if (next == M) {
			int sum = 0;
			// 각각의 집에서 뽑힌 M개의 치킨집까지의 거리를 구해 짧은 값을 결과값에 더해준다.
			for (int i = 0; i < homeList.size(); i++) {
				Info ho = homeList.get(i);
				int result = 0;
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					Info ch = chickenList.get(openList.get(j));
					result = menLen(ho.r, ho.c, ch.r, ch.c);
					if (min > result) {
						min = result;
						// 치킨과 집사이의 거리가 1 이라면 다음 치킨집 조사할 필요 없음
						if (min == 1) {
							break;
						}
					}
				}
				sum = sum + min;
			}
			// 최소값 갱신
			if (answer > sum) {
				answer = sum;
			}
			return;
		}

		// 치킨집 리스트에서 문을 열 치킨집 리스트를 뽑는다. EX) 0,1,2 번째 치킨집
		// 012 와 210의 결과값은 같아지니 중복 불가하게 뽑는다.
		for (int i = depth; i < chickenList.size(); i++) {
			openList.add(i);
			solve(next + 1, i + 1);
			openList.remove(openList.size() - 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		chickenList = new ArrayList<>(); // 주어진 치킨집 리스트
		homeList = new ArrayList<>(); // 주어진 집 리스트
		openList = new ArrayList<>(); // 최대 M개의 오픈된 치킨집 리스트
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int n = sc.nextInt();
				if (n == 2) {
					chickenList.add(new Info(i, j));
				} else if (n == 1) {
					homeList.add(new Info(i, j));
				}
			}
		}
		answer = Integer.MAX_VALUE;
		solve(0, 0);
		System.out.println(answer);
	}

}