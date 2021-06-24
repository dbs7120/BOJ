package d0830;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 연결요소의 수(서로소)
public class BOJ11724_disjoint {

	static int N, M;
	static int[] map;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1];
		make();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			union(start, end);
		}
		for (int i = 1; i <= N; i++) {
			if (map[i] == i)
				count++;
		}
		System.out.println(count);
	}

	public static void make() {
		for (int i = 1; i <= N; i++) {
			map[i] = i;
		}
	}

	public static int find(int x) {
		if (map[x] == x)
			return x;
		return map[x] = find(map[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		map[y] = x;
	}

}
