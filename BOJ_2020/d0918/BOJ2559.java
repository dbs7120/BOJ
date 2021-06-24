package d0918;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열
public class BOJ2559 {

	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = -987654;

		// O(N^2)
//		for (int i = 0; i <= N - K; i++) {
//			int sum = 0;
//			for (int j = i; j < i + K; j++) {
//				sum += arr[j];
//			}
//			max = Math.max(max, sum);
//
//		}

		// O(N)
		int sum = 0;
		// 첫 구간 따로 구하기
		for (int i = 0; i < K; i++)
			sum += arr[i];
		max = sum;

		for (int i = K; i < N; i++) {
			sum = sum + (arr[i] - arr[i - K]);
			max = Math.max(max, sum);
		}

		System.out.println(max);

	}

}
