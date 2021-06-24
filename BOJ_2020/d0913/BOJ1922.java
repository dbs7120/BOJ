package d0913;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 네트워크 연결
public class BOJ1922 {
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

	static int N, M;
	static int[] p;
	static Node[] nodes;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());

		p = new int[N + 1];
		nodes = new Node[M];

		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			nodes[i] = new Node(start, end, weight);
		}

		Arrays.sort(nodes);

		for (int i = 0; i < M; i++) {
			int v1 = find(nodes[i].v1);
			int v2 = find(nodes[i].v2);
			if (v1 != v2) {
				result += nodes[i].weight;
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
			p[y] = x;
		}
	}

}
