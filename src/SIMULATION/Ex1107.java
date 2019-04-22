package SIMULATION;

import java.util.Scanner;

public class Ex1107 {
	static int N;
	static boolean[] as = new boolean[10];
	static int min;

	// num에 고장난 버튼이 들어가 잇는지 확인
	static boolean check(int num) {
		boolean flag = true;
		if (num == 0) { // num=0이고 0번 버튼이 고장난것이라면 안됨
			if (as[0]) {
				flag = false;
			}
		} else {
			while (num != 0) {
				int a = num % 10;
				num = num / 10;
				if (as[a]) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

	static void near() {
		int depth = 0; // 그 숫자가 되기 위해 + -누르는 횟수
		while (true) {
			// 시작은 N 예를들어 N이 3000 일때 3000을 누르면 4번만으로 채널 변경 가능
			// (3001,2999),(3002,2998)...검사
			// 3001은 3000의 4번 더하기 +버튼 1번
			boolean flag = false;
			if (check(N + depth)) { // 고장난 버튼이 있는지 검사 하기
				// 3001에 고장난 버튼이 없다면 min은 1 + 4 = 5가된다
				if (min > depth + Integer.toString(N + depth).length()) {
					min = depth + Integer.toString(N + depth).length();
				}
				flag = true;
			}
			if (N - depth >= 0) {
				if (check(N - depth)) {
					if (min > depth + Integer.toString(N - depth).length()) {
						min = depth + Integer.toString(N - depth).length();
					}
					flag = true;
				}
			}

			depth++;
			if (flag || depth == Math.abs(N - 100)) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();

		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			as[num] = true;
		}

		if (N == 100) {
			System.out.println(0);
		} else {
			// 최소값을 100번에서 N까지 ++버튼, --버튼만으로 갈수 있는 방법으로 바꿔놓는다.
			min = Math.abs(N - 100);
			near();
			System.out.println(min);
		}
	}

}
