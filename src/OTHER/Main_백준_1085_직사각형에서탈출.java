package OTHER;

import java.util.Scanner;

public class Main_백준_1085_직사각형에서탈출 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int min = Math.min(Math.abs(x - w), Math.min(Math.abs(x - 0), Math.min(Math.abs(y - h), Math.abs(y - 0))));
		System.out.println(min);
	}

}
