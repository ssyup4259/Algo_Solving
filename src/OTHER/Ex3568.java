package OTHER;

import java.util.Scanner;

public class Ex3568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		//first�� ���߿� ������ ó�� ����
		String first = str.substring(0, str.indexOf(" "));
		String[] arr = str.split(", ");
		
		//arr[0] �� first�� �����ϰ� �ִ�.
		arr[0] = arr[0].substring(str.indexOf(" ") + 1, arr[0].length());
		
		//���� ��� ������ ;�� �Է��ؾ��ϴ�;�� �����ش�
		arr[arr.length - 1] = arr[arr.length - 1].replaceAll(";", "");
		
		//����� ������ ���ο� �迭
		String[] arr2 = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arr2[i] = "";
			for (int j = arr[i].length() - 1; j >= 0; j--) {
				if (arr[i].substring(j).equals("*") || arr[i].substring(j).equals("&")) {
					//�ں��� ©�� ������ ���Ѵ�.
					String flag = arr[i].substring(j, j + 1);
					arr2[i] = arr2[i] + flag;
					arr[i] = arr[i].substring(0, j);
				} else if (arr[i].substring(j).equals("]")) {
					String flag = "[]";
					arr2[i] = arr2[i] + flag;
					arr[i] = arr[i].substring(0, j - 1);
				}
			}
			System.out.println(first + arr2[i] + " " + arr[i] + ";");
		}
	}

}
