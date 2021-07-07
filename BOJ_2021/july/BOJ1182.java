package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-07-07
// 부분수열의 합
public class BOJ1182 {
	static int N, S, arr[], result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		DFS(0, 0);

		bw.append(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

	private static void DFS(int index, int sum) {
		if (index == N)
			return;
		if (sum + arr[index] == S)
			result++;

		DFS(index + 1, sum);
		DFS(index + 1, sum + arr[index]);

	}
}
