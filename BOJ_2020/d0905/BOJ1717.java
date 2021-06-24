package d0905;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1717 {

	static int N, M;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		p = new int[N + 1];
		makeSet();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cmd = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			if (cmd == 0) {
				unionSet(num1, num2);
			} else if (cmd == 1) {
				if (findSet(num1) == findSet(num2)) {
					bw.write("YES\n");
				} else
					bw.write("NO\n");

			}
		}

//		for (int e : p)
//			System.out.print(e + " ");


		bw.flush();
		bw.close();

	}

	public static void makeSet() {
		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}
	}

	public static int findSet(int x) {
		if (p[x] == x)
			return x;
		return p[x] = findSet(p[x]);
	}

	public static void unionSet(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if (x != y) {
			p[y] = x;
		}

	}

}
