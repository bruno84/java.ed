package java_basico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainEx10ArquivoTexto 
{

	public static void main(String[] args) 
	{
		String path = "Unid1/temp/arquivo_texto.csv"; 	// arquivo sera criado na pasta (temp) ja criada dentro do projeto.
		//String path = "arquivo.txt"; 				// arquivo sera criado na raiz do projeto. (nao recomendado)
		//String path = "/temp/arquivo.txt"; 		// arquivo criado na pasta (temp) ja criada na mesma unidade (C, D, etc) do projeto.
		//String path = "/arquivo.txt"; 			// arquivo sera criado na raiz da mesma unidade (C, D, etc) do projeto.

		
		String textoInput = "A1;" + "A2;" + "\n" + "B1;" + "B2;";
		String textoOutput;
		
		try {
			escritor(path, textoInput);
		} catch (IOException e) {
			System.out.println("Erro na escrita");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Pane geral!");
			e.printStackTrace();
		}
		
		
		try {
			textoOutput = leitor(path);
			System.out.print(textoOutput);
		} catch (IOException e) {
			System.out.println("Erro na leitura");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Pane geral!");
			e.printStackTrace();
		}
		
	}

	public static void escritor(String path, String texto) throws IOException 
	{
		BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(path) );
		bufferedWriter.append(texto);
		bufferedWriter.close();
	}



	public static String leitor(String path) throws IOException 
	{
		BufferedReader bufferedReader = new BufferedReader( new FileReader(path) );
		
		StringBuffer sbResult = new StringBuffer();
		String linha = "";
		
		while (linha != null) 
		{
			sbResult.append(linha + "\n");
			linha = bufferedReader.readLine();
			
			if(linha != null) {
				String[] parts = linha.split(";");
				for (int i = 0; i < parts.length; i++) {
					System.out.print("["+parts[i]+"] ");
				}
			}

		}
		bufferedReader.close();
		
		return sbResult.toString();
	}

	
}
