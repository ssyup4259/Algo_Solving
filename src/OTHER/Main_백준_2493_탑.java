package OTHER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_백준_2493_탑 {


		static class Info {
			int height, point;

			Info(int height, int point) {
				this.height = height;
				this.point = point;
			}
		}

		public static void main(String[] args) throws NumberFormatException, IOException {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			StringTokenizer stk = new StringTokenizer(br.readLine());
			Stack<Info> st = new Stack<>();
			for (int i = 0; i < n; i++) {
				int result = 0;
				int top = Integer.parseInt(stk.nextToken());
				if (st.isEmpty()) {
					int[] tmp = new int[2];
					tmp[0] = top;
					tmp[1] = i + 1;
					st.add(new Info(top, i + 1));
				} else {
					while (st.size() >= 1 && st.peek().height < top) {
						st.pop();
					}
					if (st.isEmpty()) {
						result = 0;
					} else {
						result = st.peek().point;
					}
					int[] tmp = new int[2];
					tmp[0] = top;
					tmp[1] = i + 1;
					st.add(new Info(top, i + 1));
				}
				if (i == n - 1) {
					System.out.println(result);
				} else {
					System.out.print(result + " ");
				}
			}

		}
	}
