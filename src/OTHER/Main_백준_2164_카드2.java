package OTHER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_백준_2164_카드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		while (list.size() > 1) {
			list.remove(0);
			if (list.size() == 1) {
				break;
			}
			int num = list.get(0);
			list.remove(0);
			list.add(num);
		}
		System.out.println(list.get(0));
	}

}
