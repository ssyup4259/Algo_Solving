package SAMSUNG;

import java.util.Scanner;

public class Ex14889 {
	static int N;
	static int[][] map;
	static int[] arrA;
	static int totalSum;
	static int result;

	// 스타티 팀의 멤버를 무작위로 N/2명 뽑는다. Ex)N 이 6일때
	// 스타트 팀의 멤버 1,2,3 or 1,2,4 이런식 중복 허용 X
	static void teamA(int depth, int idx) {
		// 스타티 팀의 멤버가 다뽑혔다면
		if (idx == N / 2) {
			int sumA = 0;
			int sumB = 0;
			int[] arrB = new int[N / 2];
			int cnt = 0;
			boolean flag = false;
			// 스타티팀에 없는 아이들을 링크팀으로 넣어준다.
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < arrA.length; j++) {
					if (i == arrA[j]) {
						flag = false;
						break;
					} else {
						flag = true;
					}
				}
				if (flag) {
					arrB[cnt] = i;
					cnt++;
				}
			}
			// 스타트팀과 링크팀의 총합을 구하고
			for (int i = 0; i < arrA.length - 1; i++) {
				for (int j = i + 1; j < arrA.length; j++) {
					sumA += map[arrA[i]][arrA[j]];
					sumA += map[arrA[j]][arrA[i]];
					sumB += map[arrB[i]][arrB[j]];
					sumB += map[arrB[j]][arrB[i]];
				}
			}
			// 합계의 차가 최소가 되게 갱신한다.
			if (result > Math.abs(sumB - sumA)) {
				result = Math.abs(sumB - sumA);
			}
			return;
		}
		// 순서있게 뽑는다. (1,5,6)과 (6,5,1)은 계산의 결과값이 같기 때문에
		// 1번을 뽑았으면 다음에는 2번부터 N번의 아이들중 뽑는다.
		// 1,5번을 뽑았다면 다음은 6번부터 N번의 아이들 중 뽑는다.
		for (int i = depth; i <= N; i++) {
			arrA[idx] = i;
			teamA(i + 1, idx + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		totalSum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
				totalSum += map[i][j];
			}
		}
		arrA = new int[N / 2];
		result = Integer.MAX_VALUE;
		teamA(1, 0);
		System.out.println(result);
	}

}
