package java_basico;


import java.io.Serializable;
import java.util.Objects;

/**
 * Classe usada nos varios exemplos.
 */
public class Produto implements Comparable<Produto>, Serializable
{
	private static final long serialVersionUID = -6334780231396207462L;

	// Constante
	private static final float FATOR = 0.1f;
	
	// Atributos
	private int codigo;	// atributo-chave
	private String nome;
	private double preco;
	
	// Construtor
	public Produto() {
		super();
	}
	
	public Produto(int codigo, String nome, double preco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}
		
	// Metodos getters e setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	// Metodo de regra de negocio
	public double darDesconto() {
		return preco * (1 - FATOR);
	}


	@Override
	public String toString() {
		return "MyClass [" + 
				"inteiro=" + codigo + ", " + 
				(nome != null ? "nome=" + nome : "") + ", " + 
				"preco=" + preco + "]";
	}	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return codigo == other.codigo;
	}


	@Override
	public int compareTo(Produto second) {
		return Double.compare(this.preco, second.preco);
	}

}
