import java.util.Scanner;

class Questao03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1, num2;

		System.out.print("Primeiro numero: ");
		num1 = sc.nextInt();

		System.out.print("Segundo numero: ");
		num2 = sc.nextInt();
		
		System.out.println("Adicao: " + (num1 + num2));	
	
		System.out.println("Sub: " + (num1 - num2));	

		System.out.println("Mult: " + (num1 * num2));	

		System.out.println("Quociente: " + (num1 / num2));	

		System.out.println("Resto: " + (num1 % num2));		
	}
}
