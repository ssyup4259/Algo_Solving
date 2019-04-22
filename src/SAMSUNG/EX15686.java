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

	// ����ư �Ÿ� ���ϱ�
	static int menLen(int ar, int ac, int br, int bc) {
		return Math.abs(ar - br) + Math.abs(ac - bc);
	}

	static void solve(int next, int depth) {
		// ���� ġŲ���� M���� �Ǿ��ٸ�
		if (next == M) {
			int sum = 0;
			// ������ ������ ���� M���� ġŲ�������� �Ÿ��� ���� ª�� ���� ������� �����ش�.
			for (int i = 0; i < homeList.size(); i++) {
				Info ho = homeList.get(i);
				int result = 0;
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					Info ch = chickenList.get(openList.get(j));
					result = menLen(ho.r, ho.c, ch.r, ch.c);
					if (min > result) {
						min = result;
						// ġŲ�� �������� �Ÿ��� 1 �̶�� ���� ġŲ�� ������ �ʿ� ����
						if (min == 1) {
							break;
						}
					}
				}
				sum = sum + min;
			}
			// �ּҰ� ����
			if (answer > sum) {
				answer = sum;
			}
			return;
		}

		// ġŲ�� ����Ʈ���� ���� �� ġŲ�� ����Ʈ�� �̴´�. EX) 0,1,2 ��° ġŲ��
		// 012 �� 210�� ������� �������� �ߺ� �Ұ��ϰ� �̴´�.
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
		chickenList = new ArrayList<>(); // �־��� ġŲ�� ����Ʈ
		homeList = new ArrayList<>(); // �־��� �� ����Ʈ
		openList = new ArrayList<>(); // �ִ� M���� ���µ� ġŲ�� ����Ʈ
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