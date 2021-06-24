package d0816;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

// 단어 정렬
public class BOJ1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		ArrayList<String> words = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String word = sc.next();
			if (!words.contains(word)) { // 중복 입력단계에서 바로제거
				words.add(word);
			}
		}
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) { // 길이순 우선정렬후 사전순
				if (o1.length() != o2.length())
					return o1.length() - o2.length();

				return o1.compareTo(o2);
			}
		});

		for (String e : words) {
			System.out.println(e);
		}

		sc.close();
	}

}
