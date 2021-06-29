package jun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// 2021-06-29
// 숫자 카드 2
public class BOJ10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			hash.put(input, hash.getOrDefault(input, 0) + 1); // getOrDefault: 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환

		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			int input = Integer.parseInt(st.nextToken());
			bw.append(hash.getOrDefault(input, 0) + " ");
		}

		bw.append("\n");
		bw.flush();
		bw.close();
		br.close();

	}

}
