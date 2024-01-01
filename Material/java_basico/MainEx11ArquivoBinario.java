package java_basico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainEx11ArquivoBinario
{

	public static void main(String[] args) 
	{
		String path = "Unid1/temp/arquivo_binario.dat"; 	// arquivo sera criado na pasta (temp) ja criada dentro do projeto.
		//String path = "arquivo.txt"; 				// arquivo sera criado na raiz do projeto.
		//String path = "/temp/arquivo.txt"; 		// arquivo criado na pasta (temp) ja criada na mesma unidade (C, D, etc) do projeto.
		//String path = "/arquivo.txt"; 			// arquivo sera criado na raiz da mesma unidade (C, D, etc) do projeto.

		
		// ESCRITA
		
		List<Object> listInput  = new ArrayList<Object>();
		
		// OBS: MyClass deve implementar a interface Serializable.
		Produto obj1 = new Produto(1, "arroz", 6.5);
		Produto obj2 = new Produto(2, "feijao", 10.0);
		Produto obj3 = new Produto(3, "macarrao", 4.0);

		listInput.add(obj1);
		listInput.add(obj2);
		listInput.add(obj3);

		try {
			escritor(path, listInput);
		} catch (IOException e) {
			System.out.println("Erro na escrita");
			e.printStackTrace();
		}


		// LEITURA
		
		try {
			List<Object> listOutput = leitor(path);
			
			for (Object object : listOutput) 
			{
				Produto myObj = (Produto) object;
				System.out.print( myObj.toString() );
			}
			
		} catch (IOException e) {
			System.out.println("Erro na leitura: IOException");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Erro na leitura: ClassNotFoundException");
			e.printStackTrace();
		}
		
	}


	
	public static void escritor(String path, List<Object> lista) throws IOException 
	{
		File file = new File(path);
    	file.delete();
        file.createNewFile();

        ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
        
        objOutput.writeObject(lista);
        objOutput.close();
	}
	
	
	


	@SuppressWarnings("unchecked")
	public static List<Object> leitor(String path) throws IOException, ClassNotFoundException 
	{
		List<Object> lista = new ArrayList<Object>();
		
		File file = new File(path);
	    
		if(file.exists()) 
		{
			ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
			lista = (ArrayList<Object>) objInput.readObject();
	        objInput.close();
		}
		
		return lista;
	}

	

		
}


