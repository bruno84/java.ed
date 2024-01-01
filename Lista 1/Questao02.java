import java.util.Scanner;

class Questao02 {
	public static void main(String args[]) {
		byte idade;
		float altura;
		char primeiraLetra;
		String nomeCompleto;

		Scanner sc = new Scanner(System.in);

		System.out.print("Nome completo: ");
		nomeCompleto = sc.nextLine();	
		System.out.print("Idade: ");
		idade = sc.nextByte();	
		System.out.print("Altura: ");
		altura = sc.nextFloat();

		primeiraLetra = nomeCompleto.charAt(0);

		System.out.print("Nome completo ");
		System.out.println("Meu nome é " + nomeCompleto);
		System.out.println("Eu tenho " + idade + " anos e " + altura + "m de altura");
		System.out.println("A primeira letra do meu nome é " + primeiraLetra);
	}
}
