package d0923;
import java.util.Scanner;

// 스위치 켜고 끄기
// 20갯수당 개행받아 입력받기때문에 편의상 Scanner 사용
public class BOJ1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] light = new boolean[N + 1]; // 0 사용 X
		for (int i = 1; i <= N; i++) {
			int temp = sc.nextInt();
			if (temp == 1) {
				light[i] = true;
			} else {
				light[i] = false;
			}
		}
		int cnt = sc.nextInt(); // 학생수
		for (int i = 0; i < cnt; i++) {
			int sex = sc.nextInt(); // 성별
			int value = sc.nextInt(); // 받은수
			if (sex == 1) { // 남자
				for (int j = 1; j <= N; j++) {
					if (j % value == 0) {
						light[j] = !light[j];
					}
				}

			} else { // 여자
				// value => center
				int left = value - 1;
				int right = value + 1;
				light[value] = !light[value];
				while (true) {
					if (left == 0)
						break;
					if (right == N + 1)
						break;
					if (light[left] != light[right])
						break;
					light[left] = !light[left];
					light[right] = !light[right];
					left--;
					right++;
				}
			}
		}
		int line = 0;
		for (int i = 1; i <= N; i++) {
			if (line == 20) {
				System.out.println();
				line = 0;
			}
			if (light[i])
				System.out.print("1 ");
			else
				System.out.print("0 ");
			line++;

		}
		sc.close();

	}

}
