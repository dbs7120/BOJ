package d0913;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 행성 연결
public class BOJ16398 {

	static class Node implements Comparable<Node> {
		int v1, v2, weight;

		public Node(int v1, int v2, int weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}

	}

	static int N;
	static int[] p;
	static ArrayList<Node> nodes = new ArrayList<Node>();
	static long result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());

		p = new int[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int d = Integer.parseInt(st.nextToken());
				if (i != j) {
					nodes.add(new Node(i, j, d));
				}
			}
		}

		Collections.sort(nodes);

		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		for (int i = 0; i < nodes.size(); i++) {
			int v1 = find(nodes.get(i).v1);
			int v2 = find(nodes.get(i).v2);
			if (v1 != v2) {
				result += nodes.get(i).weight;
				union(v1, v2);
			}
		}

		System.out.println(result);

	}

	public static int find(int x) {
		if (p[x] == x)
			return x;
		return p[x] = find(p[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (y != x) {
			p[x] = y;
		}
	}

}
