package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-07-27
// 부분합
public class BOJ1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int sum, result, low, high;
		sum = low = high = 0;
		result = Integer.MAX_VALUE;

		while (true) {
			if (sum >= S) {
				sum -= arr[low++];
				result = Math.min(result, (high - low + 1));
			} else if (high == N)
				break;
			else
				sum += arr[high++];

		}
		if (result == Integer.MAX_VALUE)
			bw.append(0 + "\n");
		else
			bw.append(result + "\n");

		bw.flush();
		bw.close();
		br.close();

	}

}
