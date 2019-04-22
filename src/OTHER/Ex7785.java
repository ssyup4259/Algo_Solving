package OTHER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Ex7785 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		HashSet<String> hs = new HashSet<>();

		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			String person = str.substring(0, str.indexOf(" "));
			String status = str.substring(str.indexOf(" ") + 1);
			if (status.equals("enter")) {
				hs.add(person);
			} else {
				hs.remove(person);
			}
		}

		ArrayList<String> arr = new ArrayList<>();
		Iterator<String> it = hs.iterator();
		while (it.hasNext()) {
			arr.add(it.next());
		}

		Collections.sort(arr);
		Collections.reverse(arr);

		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}

	}

}
