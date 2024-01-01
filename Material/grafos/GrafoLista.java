package grafos;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


//Grafo implementado sobre lista
public class GrafoLista
{
	// Atributos
	private int arestas;
	private Map< Integer, Set<Aresta> > linkedHashMap;
	
	// Construtor
	public GrafoLista() 
	{
		this.arestas = 0;
		this.linkedHashMap = new LinkedHashMap< Integer, Set<Aresta> >();	
	}	
		
	
	// MÉTODOS:
	
	// Quantidade de arestas
	public int getArestas() {
		return arestas;
	}
	
	
    // Verifica se existe aresta
    public boolean existeAresta(int vi, int vf) 
    {
    	Set<Aresta> set = linkedHashMap.get(vi);
    	
    	if( set == null ) {
    		return false;
    	} 
    	else 
    	{
        	for (Aresta aresta : set) {
    			if(aresta.vf == vf) {
    				return true;
    			}
    		}
        	return false;
    	}  
    }
	
    
    // Exibe arestas
	public void imprimir() 
    {
		for (Integer vi : linkedHashMap.keySet()) 
		{
			Set<Aresta> set = linkedHashMap.get(vi);
        	for (Aresta aresta : set) {
        		System.out.println(aresta.vi+"->"+aresta.vf+" : "+aresta.peso);
    		}
		}
    }
    
    
    // lista vertices adjacentes a um dado vertice
    public List<Integer> listaAdjacentes(int v) 
    {
        List<Integer> listResult = new ArrayList<Integer>();

        Set<Aresta> set = linkedHashMap.get(v);
        
    	for (Aresta aresta : set) {
    		 listResult.add( aresta.vf );
		}
		
        return listResult;
    }

	
    // insere aresta. OBS: Vertice: 0..n-1
    public void insereAresta(int vi, int vf, double peso) 
    {
		Set<Aresta> set = linkedHashMap.get(vi);
		
		Aresta arestaNew = new Aresta(vi, vf, peso);
		
        if (set == null) 
        {
        	// posicao vi que ainda nao tinha lista
        	Set<Aresta> setNew = new LinkedHashSet<Aresta>();
        	setNew.add( arestaNew );
        	linkedHashMap.put(vi, setNew);
        } 
        else 
        {
        	// posicao vi que ja tinha lista
            set.add(arestaNew);
        } 
        
        arestas++;
	}
	
	
    public boolean removeAresta(int vi, int vf) 
    {
    	Set<Aresta> set = linkedHashMap.get(vi);
    	
    	if( set == null ) {
    		return false;
    	} 
    	else 
    	{
        	for (Aresta aresta : set) {
    			if(aresta.vf == vf) {
    				set.remove( new Aresta(vi, vf, 0) );
    				arestas--;
    				return true;
    			}
    		}
        	return false;
    	}  
    }  
	
}


// Classe que representa cada aresta
class Aresta
{   
	// Atributos
	int vi; 		// vertice inicio
    int vf;			// vertice fim (ID)
    double peso;	
    
    // Construtor
    Aresta(int vi, int vf, double peso) 
    {
    	this.vi = vi;
        this.vf = vf;
        this.peso = peso;
    }

	@Override
	public int hashCode() {
		return Objects.hash(vf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aresta other = (Aresta) obj;
		return vf == other.vf;
	}    
}



