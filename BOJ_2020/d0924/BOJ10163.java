package d0924;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이
public class BOJ10163 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim()); // 색종이수;
		int[][] map = new int[101][101]; // 최대 101칸

		int number = 1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()) + x1;
			int y2 = Integer.parseInt(st.nextToken()) + y1;
			for (int y = y1; y < y2; y++) {
				for (int x = x1; x < x2; x++) {
					map[y][x] = number;
				}
			}
			number++;
		}

		number = 1;
		int size = 0;
		for (int i = 0; i < N; i++) {
			for (int[] e : map) {
				for (int f : e) {
					if (f == number) {
						size++;
					}
				}
			}
			System.out.println(size);
			size = 0;
			number++;
		}
	}

}
