package SIMULATION;

import java.util.Scanner;

public class Ex1057 {
	static int cnt;

	static void solve(boolean[] aaa) {
		if (aaa.length <= 1) {  //결승까지 김이랑 임이랑 안만나면 -1
			cnt = -1;
		}

		boolean[] bbb; //다은 토너먼트 배열
		if (aaa.length % 2 == 0) {
			bbb = new boolean[aaa.length / 2];
		} else {
			bbb = new boolean[aaa.length / 2 + 1];
			bbb[aaa.length / 2] = aaa[aaa.length - 1];
		}
		
		for (int i = 0; i < aaa.length - 1; i = i + 2) {
			if (!aaa[i]) {  //둘중에 한명이라도 true 라면 true가 진출
				if (!aaa[i + 1]) {
					bbb[i / 2] = aaa[i];
				} else if (aaa[i + 1]) {
					bbb[i / 2] = aaa[i + 1];
				}
			} else if (aaa[i]) {  
				if (!aaa[i + 1]) {
					bbb[i / 2] = aaa[i];
				}else if(aaa[i+1]) {  //둘다 true라면 김이랑 임이랑 만남
					return;
				}
			}
		}
		cnt++;
		solve(bbb);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int kim = sc.nextInt() - 1;
		int lim = sc.nextInt() - 1;

		boolean[] flag = new boolean[N];

		flag[kim] = true;
		flag[lim] = true;
		cnt = 1;
		solve(flag);
		System.out.println(cnt);
	}

}
