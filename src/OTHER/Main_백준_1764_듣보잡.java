package OTHER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main_백준_1764_듣보잡 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		HashMap<String, Integer> hm = new HashMap<>();
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			hm.put(str, 1);
		}
		List<String> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String str = sc.next();
			if (hm.get(str) != null) {
				list.add(str);
			}
		}

		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
