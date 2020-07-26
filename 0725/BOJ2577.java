import java.util.Scanner;

public class BOJ2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] index = new int[10];
		int[] num = new int[3];
		int result = 1;
		int temp;
		int lengthNum;

		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
			result *= num[i];
		}
		temp = result;
		lengthNum = (int)(Math.log10(result)+1);

		for (int i = 0; i < lengthNum; i++) {
			temp = result / (int) Math.pow(10, i) % 10;
			index[temp]++;
		}


		for (int e : index)
			System.out.println(e);

		sc.close();
	}
}
