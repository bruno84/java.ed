import java.util.Scanner;

class Questao06 {
	public static final float precoRefri = 1.5f;
	public static final float precoPizza = 3.0f;	
	public static final float taxa = 1.1f;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Refrigerantes: ");
		int quantRefri = sc.nextInt();
		
		System.out.print("Pizzas: ");
		int quantPizza = sc.nextInt();
		
		System.out.print("Pessoas: ");
		int quantPessoas = sc.nextInt();

		float subtotal = quantRefri * precoRefri + quantPizza * precoPizza;

		System.out.println("Total sem taxa: R$" + subtotal);
		System.out.println("Total com taxa: R$" + subtotal * taxa);
		System.out.println("Valor por pessoa: R$" + (subtotal * taxa) / quantPessoas);
	}
}
