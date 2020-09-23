package d0921;
import java.util.Scanner;

// 빙고
public class BOJ2578 {

	static int[][] bingo = new int[5][5];
	static int[] input = new int[25];
	static int cnt = 0;
	static int result = 0;
	static boolean end = false;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 25; i++) {
			input[i] = sc.nextInt();
			for (int y = 0; y < 5; y++) {
				for (int x = 0; x < 5; x++) {
					if (bingo[y][x] == input[i])
						bingo[y][x] = 0;
				}
			}

			for (int x = 0; x < 5; x++) {
				if (bingo[0][x] == 0) {
					int temp = 1;
					for (int y = 1; y < 5; y++) {

						if (bingo[y][x] == 0) {
							temp++;
						}
					}
					if (temp == 5) {
						cnt++;
					}
				}
			}

			for (int y = 0; y < 5; y++) {
				if (bingo[y][0] == 0) {
					int temp = 1;
					for (int x = 1; x < 5; x++) {

						if (bingo[y][x] == 0) {
							temp++;
						}
					}
					if (temp == 5) {
						cnt++;
					}
				}
			}

			if (bingo[0][0] == 0 && bingo[1][1] == 0 && bingo[2][2] == 0 && bingo[3][3] == 0 && bingo[4][4] == 0) {
				cnt++;
			}
			if (bingo[0][4] == 0 && bingo[1][3] == 0 && bingo[2][2] == 0 && bingo[3][1] == 0 && bingo[4][0] == 0) {
				cnt++;
			}

			if (cnt >= 3 && !end) {
				result = i + 1;
				end = true;
			} else {
				cnt = 0;
			}

		}
		System.out.println(result);
		sc.close();
	}

}
