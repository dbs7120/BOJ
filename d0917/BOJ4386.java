package d0917;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

// 별자리 만들기
public class BOJ4386 {

	static class Node {
		int v1;
		int v2;
		double weight;

		public Node(int v1, int v2, double weight) {
			this.v1 = v1;
			this.v2 = v2;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [v1=" + v1 + ", v2=" + v2 + ", weight=" + weight + "]";
		}

	}

	static int N;
	static double map[][];
	static double input[][];
	static double result = 0;
	static ArrayList<Node> nodes;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new double[N][N];
		input = new double[N][2];
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			input[i - 1][0] = x;
			input[i - 1][1] = y;
			p[i] = i;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) {
					map[i][j] = 0;
				} else {
					map[i][j] = Math.hypot(input[i][0] - input[j][0], input[i][1] - input[j][1]);

				}
			}
		}
		nodes = new ArrayList<Node>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i >= j)
					continue;
				nodes.add(new Node(i, j, map[i][j]));
			}
		}
		Collections.sort(nodes, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				return (int) (o1.weight - o2.weight);
			}
		});

		for (Node e : nodes) {
			int v1 = findSet(e.v1);
			int v2 = findSet(e.v2);
			if (v1 != v2) {
				unionSet(v1, v2);
				result += e.weight;
			}
		}
		System.out.printf("%.2f\n", result);

	}

	public static int findSet(int x) {
		if (x == p[x])
			return x;
		else
			return p[x] = findSet(p[x]);
	}

	public static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if (y != x) {
			p[y] = x;
		}
	}

}
