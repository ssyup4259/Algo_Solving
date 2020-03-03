
import java.util.Arrays;

import java.util.stream.IntStream;

public class ex03 {

	static String skill = "CBD";

	static String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

	public static void main(String[] args) {
		System.out.println(solution(skill, skill_trees));
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		int[] arrIndex = new int[skill.length()];
		char[] skill_set = new char[skill.length()];
		for (int i = 0; i < skill.length(); i++) {
			skill_set[i] = skill.charAt(i);
		}

		int cnt = 0;
		for (int i = 0; i < skill_trees.length; i++) {

			String skill_tree = skill_trees[i];
			int[] order = new int[skill_tree.length()]; // 스킬트리 안의 스킬을 순서별로 다시 배열 만듬
			// cde --> caffde (100023)
			int flag = 0;
			for (int j = 0; j < skill_tree.length(); j++) {
				for (int k = 0; k < skill_set.length; k++) {
					if (skill_tree.charAt(j) == skill_set[k]) {
						order[j] = k + 1;
					}
				}
			}

			// 무조건 1이 앞에 있어야됨 --> 작은 숫자가 앞에
			int idx = 1;
			boolean check = true;
			for (int j = 0; j < order.length; j++) {
				if (order[j] == 0) { // 0은 아무스킬이니 건너 뛰고
					continue;
				} else {
					if (idx < order[j]) { // 선행 스킬 안배웠는데 다음 스킬이 나왔다
						check = false;
						break;
					} else { // 1번스킬의 위치를 찾았으면 다음에는 2번 스킬 찾아야함
							// 위의 if 문에서 1보다 큰게 현재 앞에 아무것도 없다는게 보장됨
						idx++;
					}
				}
			}
			if (check) {
				cnt++;
			}
			System.out.println(Arrays.toString(order));
		}
		answer = cnt;
		return answer;

	}

}