package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-07-19
// 수들의 합
// 투포인터 알고리즘
public class BOJ2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int sum, result, low, high;
		sum = result = low = high = 0;

		while (true) {
			if (sum >= M)
				sum -= arr[low++];
			else if (high == N)
				break;
			else
				sum += arr[high++];
			if (sum == M)
				result++;
		}

		bw.append(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}
}
