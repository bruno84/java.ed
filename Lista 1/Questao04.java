import java.util.Scanner;

class Questao04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Valor 1: ");
		int n1 = sc.nextInt();

		System.out.print("Valor 2: ");
		int n2 = sc.nextInt();

		System.out.print("Valor 1: ");
		int n3 = sc.nextInt();

		System.out.println("Media aritmetica: " + ((double) n1 + n2 + n3) / 3);
	}
}
