package grafos;

import java.util.ArrayList;
import java.util.List;

// Grafo implementado sobre matriz
public class GrafoMatriz
{	
	// Atributos do grafo
    private int maxVertices;
    private int arestas;
    private double[][] matrizPesos;

    
    // Construtor
    public GrafoMatriz(int maxVertices) 
    {
    	this.maxVertices = maxVertices;
    	this.arestas = 0;
    	
    	// cria matriz de pesos
    	matrizPesos = new double[maxVertices][maxVertices];

    	// preenche matriz
    	for (int i = 0; i < maxVertices; i++)
    		for (int j = 0; j < maxVertices; j++)
    			matrizPesos[i][j] = Double.NaN;
    }

 
    // METODOS
    
    // Quantidade de arestas
    public int getArestas() {
		return arestas;
	}

    // Verifica se existe aresta
    public boolean existeAresta(int vi, int vf) {
    	return !Double.isNaN(matrizPesos[vi][vf]);
    }
    
    
    // Exibe arestas
	public void imprimir() 
    {
        for (int i = 0; i < maxVertices; i++) {
            for (int j = 0; j < maxVertices; j++) {
                if (Double.isNaN(matrizPesos[i][j]) == false) {
                    System.out.println(i+"->"+j+" : "+ matrizPesos[i][j]);
                }
            }
        }
    }
    
	
    // lista vertices adjacentes a um dado vertice
    public List<Integer> listaAdjacentes(int v) 
    {
        List<Integer> list = new ArrayList<Integer>();

        for (int j = 0; j < matrizPesos[v].length; j++) {
            if (Double.isNaN(matrizPesos[v][j]) == false) {
            	list.add(j);
            }
        }

        return list;
    }
    
    
    // insere aresta. OBS: Vertice: 0..n-1
    public boolean insereAresta(int vi, int vf, double peso) 
    {
        if (vi >= maxVertices || vf >= maxVertices) {
        	return false;
        }
        else
        {
        	// Verifica se aresta ja existia
            if ( Double.isNaN( matrizPesos[vi][vf]) == true ) {
                arestas++;
            }

            matrizPesos[vi][vf] = peso;
            return true;
        } 
    }


    // remove aresta. OBS: Vertice: 0..n-1
    public boolean removeAresta(int vi, int vf) 
    {
        if (vi >= maxVertices || vf >= maxVertices) {
        	return false; // indice errado
        }
        else if ( Double.isNaN( matrizPesos[vi][vf]) == true ) {
        	return false; // aresta nao existia
        }
        else
        {
            matrizPesos[vi][vf] = Double.NaN;
            arestas--;
            return true;
        }
    }

    
    // encontra aresta com menor peso
    public Integer[] arestaMinima() 
    {
        double min = Double.MAX_VALUE;
        int vi = 0, vf = 0;

        for (int i = 0; i < matrizPesos.length; i++) 
            for (int j = 0; j < matrizPesos[i].length; j++) 
                if (Double.isNaN(matrizPesos[i][j]) == false) 
                    if (matrizPesos[i][j] < min) {
                    	min = matrizPesos[i][j];
                        vi = i;
                        vf = j;
                    }

        Integer aresta[] = new Integer[2];
        aresta[0] = vi;
        aresta[1] = vf;
        
        return aresta;
    }
 
}
