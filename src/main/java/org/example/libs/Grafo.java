package  org.example.libs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* Um grafo é um conjunto de nós e um conjunto de arestas.
* Cada aresta conecta dois nós.
* Cada nó tem um rótulo.
* Cada aresta tem um custo.
* Este grafo não é direcionado, então cada aresta conecta dois nós em ambas as direções.
* @author @ianco-so and @fawnbr
*/
public class Grafo<R extends Comparable<R>, V> {
    private  Set<No<R, V>> nos;
    private  Set<Aresta<R, V>> arestas;

    /**
     * Construtor de um grafo que tem uma lista
     * de nós.
     * @param nos: Lista de nós do grafo.
     */
    public Grafo() {
        this.nos = new HashSet<>();
        this.arestas = new HashSet<>();
    }
    public Grafo(No<R, V>... nos) {
        this.nos = new HashSet<>();
        this.arestas = new HashSet<>();
        for (No<R, V> no : nos) {
            this.nos.add(no);
        }
    }
    public Grafo(List<No<R, V>> nos) {
        this.nos = new HashSet<>();
        this.arestas = new HashSet<>();;
        for (No<R, V> no : nos) {
            this.nos.add(no);
        }
    }
    public Grafo(List<No<R, V>> nos, List<Aresta<R, V>> arestas) {
        this.nos = new HashSet<>();
        this.arestas = new HashSet<>();
        for (No<R, V> no : nos) {
            this.nos.add(no);
        }
        //Se os nós das arestas existirem no grafo, então adiciona a aresta ao grafo.
        for (Aresta<R, V> aresta : arestas) {
            if (this.nos.contains(aresta.getNo1()) && this.nos.contains(aresta.getNo2())) {
                this.arestas.add(aresta);
            }
        }
    }

    /**
     * Adiciona um nó no grafo.
    * @param no: Nó a ser adicionado.
    */
    public void adicionarNo(No<R, V> no) {
        this.nos.add(no);
    }

    /**
     * Adiciona uma aresta no grafo.
    * @param aresta  Aresta a ser adicionada.
    */
    public void adicionarAresta(Aresta<R, V> aresta) {
        if (this.nos.contains(aresta.getNo1()) && this.nos.contains(aresta.getNo2())) {
            this.arestas.add(aresta);
        }
    }
    public void adicionarArestas(Aresta<R, V>... arestas) {
        for (Aresta<R, V> aresta : arestas) {
            if (this.nos.contains(aresta.getNo1()) && this.nos.contains(aresta.getNo2())) {
                this.arestas.add(aresta);
            }
        }
    }

    /**
    * Obtém os nós de um grafo.
    * @return Os nós do grafo.
    */
    public List<No<R, V>> getNos() {
        List<No<R, V>> nosList = new ArrayList<No<R, V>>();
        No<R, V>
        return (No<R,V>[]) this.nos.toArray();
    }

    /**
    * Obtém as arestas de um grafo.
    * @return As arestas do grafo.
    */
    public List<Aresta<R, V>> getArestas() {
        List<Aresta<R, V>> arestasList = new ArrayList<Aresta<R, V>>();
        Aresta<R, V> [] arestasVec = new Aresta[this.arestas.size()];
        arestasVec = this.arestas.toArray(arestasVec);
        for (Aresta<R, V> aresta : arestasVec) {
            arestasList.add(aresta);
        }
        return arestasList;
    }
    /**
     * Obtém o nó de um grafo que tem um rótulo específico.
     * @param rotulo: Rótulo do nó a ser obtido.
     * @return O nó que tem o rótulo especificado.
     */
    public No<R, V> getNo(R rotulo) {
        for (No<R, V> no : this.nos) {
            if (no.getRotulo().equals(rotulo)) {
                return no;
            }
        }
        return null;
    }

    /**
    * Obtém o número de nós de um grafo.
    * @return A quantidade de nós.
    */
    public Integer getQuantidadeNos() {
        return this.nos.size();
    }

    /**
    * Obtém o número de arestas de um grafo.
    * @return A quantidade de arestas.
    */
    public Integer getQuantidadeArestas() {
        return this.arestas.size();
    }

    @Override
    public String toString() {
        String str = "Grafo: \n";
        for (Aresta<R, V> aresta : this.arestas) {
            str += aresta.toString() + "\n";
        }
        for (No<R, V> no : this.nos) {
            str += no.toString() + "\n";
        }

        return str;
    }
}