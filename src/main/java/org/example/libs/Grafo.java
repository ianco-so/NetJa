package  org.example.libs;

import java.util.List;

/**
* Um grafo é um conjunto de nós e um conjunto de arestas.
* Cada aresta conecta dois nós.
* Cada nó tem um rótulo.
* Cada aresta tem um custo.
* Este grafo não é direcionado, então cada aresta conecta dois nós em ambas as direções.
* @author @ianco-so and @fawnbr
*/
public class Grafo {
    private  List<No> nos;
    private  List<Aresta> arestas;

    public Grafo(List<No> nos, List<Aresta> arestas) {
        this.nos = nos;
        this.arestas = arestas;
    }

    /**
     * Adiciona um nó no grafo.
    * @param node  Nó a ser adicionado.
    */
    public void adicionarNo(No node) {
        this.nos.add(node);
    }

    /**
     * Adiciona uma aresta no grafo.
    * @param Aresta  Aresta a ser adicionada.
    */
    public void adicionarAresta(Aresta aresta) {
        this.arestas.add(aresta);
    }

    /**
    * Obtém os nós de um grafo.
    * @return Os nós do grafo.
    */
    public List<No> getNos() {
        return this.nos;
    }

    /**
    * Obtém as arestas de um grafo.
    * @return As arestas do grafo.
    */
    public List<Aresta> getArestas() {
        return this.arestas;
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
}