package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-07-06
// 2차원 배열의 합
/**
 * 2차원 배열 구간합 공식 </br>
 * pSum[i+1][j+1] = pSum[i][j+1] + pSum[i+1][j] - pSum[i][j] + A[i][j] </br>
 * Σ(r1 ≤ i ≤ r2, c1 ≤ j ≤ c2) A[i][j] </br>
 * = pSum[r2+1][c2+1] - * pSum[r1][c2+1] - pSum[r2+1][c1] + pSum[r1][c1]
 */
public class BOJ2167 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		int sum[][] = new int[N + 1][M + 1];
		sum[0][0] = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + arr[i][j];
			}
		}
		int K = Integer.parseInt(br.readLine());

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int result = sum[x][y] - sum[i - 1][y] - sum[x][j - 1] + sum[i - 1][j - 1]; // 1행부터 생각
			bw.append(result + "\n");

		}
		bw.flush();
		bw.close();
		br.close();

	}
}
