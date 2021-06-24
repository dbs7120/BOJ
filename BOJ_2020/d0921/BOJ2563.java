package d0921;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이
public class BOJ2563 {

	static boolean[][] map = new boolean[100][100]; // 도화지
	static int N; // 색종이수
	static int size = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		N = Integer.parseInt(br.readLine().trim());

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int marginLeft = Integer.parseInt(st.nextToken());
			int marginBottom = Integer.parseInt(st.nextToken());
			for (int j = marginLeft; j < marginLeft + 10; j++) {
				for (int k = marginBottom; k < marginBottom + 10; k++) {
					map[j][k] = true;
				}

			}

		}
		for (boolean[] e : map) {
			for (boolean f : e) {
				if (f) {
					size++;
				}

			}
		}
		System.out.println(size);

	}

}
