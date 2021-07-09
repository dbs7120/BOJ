package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-07-09
// 집합의 표현
// Disjoint-Set
public class BOJ1717 {

	static int arr[], N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (command == 0) {
				union(a, b);
			} else {
				bw.append((find(a) == find(b) ? "YES" : "NO") + "\n");
			}

		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static void union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		arr[yRoot] = xRoot;
	}

	public static int find(int x) {
		if (arr[x] == x)
			return x;
		return arr[x] = find(arr[x]);
	}

}
