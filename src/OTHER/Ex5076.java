package OTHER;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex5076 {
	static List<String> list;
	static String result;

	static void makeList(String str) {
		int start = str.indexOf("<");
		int end = str.indexOf(">");
		if (start == -1 && end == -1) { // ��ȣ�� ������ ��
			return;
		}
		String newStr = str.substring(start, end + 1);
		str = str.substring(end + 1);
		list.add(newStr);
		makeList(str);
	}

	static void solve() {
		for (int i = 0; i < list.size(); i++) { // ���±� �ֵ� �� ����
			String str = list.get(i);
			if (str.indexOf("/>") != -1) {
				list.remove(i);
				i--;
			}
		}
		
		if (list.size() % 2 != 0) { // ���ױ� ���� �ߴµ� Ȧ�����̸� illegal
			result = "illegal";
			return;
		}
		
		for (int i = 0; i < list.size() / 2; i++) {
			// Ex) 4���� �±װ� ������ 1��° �±׿� 4��° �±� ���� 2��°�� 3��° �±� ���ƾ��Ѵ�.
			String str1 = list.get(i);
			String str2 = list.get(list.size() - 1 - i);
			String[] str1Arr = str1.split(" "); // �Ӽ� �±׵� ���� ��Ű��, Ŭ��¡ ��ũ�� �Ӽ� ����.
			str1Arr[0] = str1Arr[0].replaceAll("<", "");
			str1Arr[0] = str1Arr[0].replaceAll(">", "");
			str1Arr[0] = str1Arr[0].replaceAll("/", "");
			str2 = str2.replaceAll("<", "");
			str2 = str2.replaceAll(">", "");
			str2 = str2.replaceAll("/", "");
			if (!str1Arr[0].equals(str2)) { // �����װ� Ŭ��¡�� �ٸ��� illegal
				result = "illegal";
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String str = sc.nextLine();
			if (str.equals("#")) {
				break;
			}
			result = "legal";
			list = new ArrayList<>();
			makeList(str);
			solve();
			System.out.println(result);
		}
	}

}
