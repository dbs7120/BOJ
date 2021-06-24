package d0924;
import java.util.Scanner;

// 슈퍼마리오
public class BOJ2851 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int[] mushroom = new int[10];
		for (int i = 0; i < 10; i++) {
			mushroom[i] = sc.nextInt();
			if (sum < mushroom[i])
				sum = mushroom[i];
		}
		if (sum == 100) { // 최대값이 100이라면 출력후 리턴
			System.out.println(100);
			sc.close();
			return;
		}
		sum = 0;
		for (int i = 0; i < 10; i++) {
			if (Math.abs(sum - 100 + mushroom[i]) <= Math.abs(sum - 100)) { // 버섯을 먹은값과 안먹은값 비교
				sum += mushroom[i];
			} else {
				break;
			}
		}
		System.out.println(sum);
		sc.close();

	}

}
