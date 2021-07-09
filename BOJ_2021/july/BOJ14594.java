package july;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2021-07-09
// 동방 프로젝트(Small)
public class BOJ14594 {
	static int N, M, arr[], result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		for (int i = 0; i <= N; i++)
			arr[i] = i;

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x, y);
		}

		for (int i = 1; i <= N; i++) {
			if (find(i - 1) != find(i))
				result++;
		}

		bw.append(result + "\n");
		bw.flush();
		bw.close();
		br.close();

	}

	public static void union(int x, int y) {

		for (int i = x; i < y; i++) {
			int xRoot = find(i);
			int yRoot = find(i + 1);
			if (xRoot != yRoot)
				arr[yRoot] = xRoot;
		}
	}

	public static int find(int x) {
		if (arr[x] == x)
			return x;
		return arr[x] = find(arr[x]);
	}

}
