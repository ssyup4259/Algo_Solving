package SIMULATION;

import java.util.Scanner;

public class Main_백준_1057_토너먼트 {
	static int cnt;

	static void solve(boolean[] aaa) {
		if (aaa.length <= 1) {  //��±��� ���̶� ���̶� �ȸ����� -1
			cnt = -1;
		}

		boolean[] bbb; //���� ��ʸ�Ʈ �迭
		if (aaa.length % 2 == 0) {
			bbb = new boolean[aaa.length / 2];
		} else {
			bbb = new boolean[aaa.length / 2 + 1];
			bbb[aaa.length / 2] = aaa[aaa.length - 1];
		}
		
		for (int i = 0; i < aaa.length - 1; i = i + 2) {
			if (!aaa[i]) {  //���߿� �Ѹ��̶� true ��� true�� ����
				if (!aaa[i + 1]) {
					bbb[i / 2] = aaa[i];
				} else if (aaa[i + 1]) {
					bbb[i / 2] = aaa[i + 1];
				}
			} else if (aaa[i]) {  
				if (!aaa[i + 1]) {
					bbb[i / 2] = aaa[i];
				}else if(aaa[i+1]) {  //�Ѵ� true��� ���̶� ���̶� ����
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
