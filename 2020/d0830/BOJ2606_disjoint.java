package d0830;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 바이러스(서로소 집합)
public class BOJ2606_disjoint {

	static int V, N;
	static int[] map;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		map = new int[V + 1];
		make();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			union(start, end);
		}
		for (int i = 1; i <= V; i++) {
			if (find(1) == find(i))
				count++;
		}
		System.out.println(count - 1);

	}

	public static void make() {
		for (int i = 1; i <= V; i++) {
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
