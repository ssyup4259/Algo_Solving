package SIMULATION;

import java.util.Scanner;

public class Ex2455 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] in = new int[5]; // 탄사람 저장용
		int[] out = new int[5]; // 내린사람 저장용
		for (int i = 1; i <= 4; i++) {
			out[i] = sc.nextInt();
			in[i] = sc.nextInt();
		}

		int[] result = new int[5];// 각각의 승강장을 지나고 안에 남아있는 사람 저장
		result[0] = 0;
		for (int i = 1; i <= 4; i++) { // 1~4번 승강장
			result[i] = result[i - 1] + in[i] - out[i];
		}

		int max = 0;
		for (int i = 0; i < 5; i++) { // 가장 많이 남아있는 사람 수
			if (max < result[i])
				max = result[i];
		}
		System.out.println(max);
	}

}
