package d0802;
import java.util.Scanner;

public class BOJ1913 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int find = sc.nextInt();

		int print = N * N;
		// y++, x=0
		// y=0, x++
		// y--, x=0
		// y=0, x--;
		int[][] map = new int[N][N];
		int len = N;
		while (print != 0) {
			for (int i = N - len; i < len; i++) {
				map[i][N - len] = print;
				print--;
			}
			for (int j = N - len + 1; j < len; j++) {
				map[len - 1][j] = print;
				print--;
			}
			len -= 1;
			for (int i = len - 1; i >= N - len - 1; i--) {
				map[i][len] = print;
				print--;
			}
			for (int j = len - 1; j >= N - len; j--) {
				map[N - len - 1][j] = print;
				print--;
			}
		}

		int y = 0, x = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
				if (map[i][j] == find) {
					y = i;
					x = j;
				}
			}
			System.out.println();
		}
		System.out.println((y + 1) + " " + (x + 1));

		sc.close();
	}

}