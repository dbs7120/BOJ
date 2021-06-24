package d0923;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//자리배정
public class BOJ10157 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int C = Integer.parseInt(st.nextToken()); // 가로
		int R = Integer.parseInt(st.nextToken()); // 세로
		int cnt = Integer.parseInt(br.readLine().trim());

		if (cnt > R * C) {
			System.out.println(0);
			return;
		}

		int[][] map = new int[R][C];
		int number = 1;

		int lenX = C;
		int lenY = R;
		while (number < R * C) {
			for (int y = R - lenY; y < lenY; y++) {
				if (number > R * C)
					break;
				map[y][C - lenX] = number++;

			}

			for (int x = C - lenX + 1; x < lenX; x++) {
				if (number > R * C)
					break;
				map[lenY - 1][x] = number++;
			}

			lenY--;
			lenX--;

			for (int y = lenY - 1; y >= R - lenY - 1; y--) {
				if (number > R * C)
					break;
				map[y][lenX] = number++;
			}

			for (int x = lenX - 1; x >= C - lenX; x--) {
				if (number > R * C)
					break;
				map[R - lenY - 1][x] = number++;
			}

		}

//		for (int[] e : map) {
//			for (int f : e) {
//				System.out.print(f + " ");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == cnt) {
					System.out.println((j + 1) + " " + (i + 1));
					break;
				}
			}
		}

	}

}
