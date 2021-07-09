package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2021-07-09
// ATM
/**
 * 시간이 적게걸리는순으로 나열한다면(정렬한다면) 최종 시간의 합이 최솟값이됨(그리디)
 */
public class BOJ11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int sum[] = new int[N + 1];
		int result = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		sum[0] = 0;

		for (int i = 1; i <= N; i++) {
			sum[i] = sum[i - 1] + arr[i - 1];
			result += sum[i];
		}

		bw.append(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

}
