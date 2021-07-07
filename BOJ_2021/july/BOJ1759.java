package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 2021-07-07
// 암호 만들기
/**
 * str 의 길이를 활용하여 조합 구현
 */
public class BOJ1759 {
	static int L, C;
	static char input[];
	static List<String> result;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new char[C];
		result = new ArrayList<String>();
		visited = new boolean[26];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++)
			input[i] = st.nextToken().charAt(0);

		Arrays.sort(input);
		DFS(0, "");
		Collections.sort(result);

		for (String e : result)
			bw.append(e + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

	private static void DFS(int index, String str) {
		if (str.length() == L) {
			int aeiou, non_aeiou;
			aeiou = non_aeiou = 0;
			for (int i = 0; i < L; i++) {

				if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
						|| str.charAt(i) == 'u')
					aeiou++;
				else
					non_aeiou++;
			}

			if (aeiou >= 1 && non_aeiou >= 2) // 모음 자음 유무 길이 판단
				result.add(str);

			return;
		}

		for (int i = index; i < C; i++)
			DFS(i + 1, str + input[i]);

	}
}
