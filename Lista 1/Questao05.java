import java.util.Scanner;

class Questao05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Valor 1: ");
		double n1 = sc.nextDouble();

		System.out.print("Valor 2: ");
		double n2 = sc.nextDouble();

		System.out.print("Valor 1: ");
		double n3 = sc.nextDouble();

		System.out.println("Media aritmetica: " + (n1 + n2 + n3) / 3);
	}
}
