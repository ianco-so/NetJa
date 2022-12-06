package  ufrn.edb2.model.arvore;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
* Um grafo é um conjunto de nós e um conjunto de arestas.
* Cada aresta conecta dois nós.
* Cada nó tem um rótulo.
* Cada aresta tem um custo.
* Este grafo não é direcionado, então cada aresta conecta dois nós em ambas as direções.
* @author @ianco-so and @fawnbr
*/
public class Grafo<R extends Comparable<R>> {
    private  Set<No<R>> nos;
    private  Set<Aresta<R>> arestas;

    /**
     * Construtor de um grafo que tem uma lista
     * de nós.
     * @param nos: Lista de nós do grafo.
     */
    public Grafo() {
        this.nos = new HashSet<>();
        this.arestas = new HashSet<>();
    }
    public Grafo(No<R>... nos) {
        this.nos = new HashSet<>();
        this.arestas = new HashSet<>();
        for (No<R> no : nos) {
            this.nos.add(no);
        }
    }
    public Grafo(List<No<R>> nos) {
        this.nos = new HashSet<>();
        this.arestas = new HashSet<>();;
        for (No<R> no : nos) {
            this.nos.add(no);
        }
    }
    public Grafo(List<No<R>> nos, List<Aresta<R>> arestas) {
        this.nos = new HashSet<>();
        this.arestas = new HashSet<>();
        for (No<R> no : nos) {
            this.nos.add(no);
        }
        //Se os nós das arestas existirem no grafo, então adiciona a aresta ao grafo.
        for (Aresta<R> aresta : arestas) {
            if (this.nos.contains(aresta.getNo1()) && this.nos.contains(aresta.getNo2())) {
                this.arestas.add(aresta);
            }
        }
    }

    /**
     * Adiciona um nó no grafo.
    * @param no: Nó a ser adicionado.
    */
    public void adicionarNo(No<R> no) {
        this.nos.add(no);
    }

    /**
     * Adiciona uma aresta no grafo.
    * @param aresta  Aresta a ser adicionada.
    */
    public void adicionarAresta(Aresta<R> aresta) {
        if (this.nos.contains(aresta.getNo1()) && this.nos.contains(aresta.getNo2())) {
            this.arestas.add(aresta);
        }
    }

    /**
     * Adiciona um conjunto de arestas no grafo.
     * @param arestas Lista de arestas a serem adicionadas.
     */
    public void adicionarArestas(List<Aresta<R>> arestas) {
        for (Aresta<R> aresta : arestas) {
            if (this.nos.contains(aresta.getNo1()) && this.nos.contains(aresta.getNo2())) {
                this.arestas.add(aresta);
            }
        }
    }

    /**
    * Obtém os nós de um grafo.
    * @return Os nós do grafo.
    */
    public List<No<R>> getNos() {
        return this.nos.stream().collect(Collectors.toList());
    }

    /**
    * Obtém as arestas de um grafo.
    * @return As arestas do grafo.
    */
    public List<Aresta<R>> getArestas() {
        return this.arestas.stream().collect(Collectors.toList());
    }
    
    /**
     * Obtém o nó de um grafo que tem um rótulo específico.
     * @param rotulo: Rótulo do nó a ser obtido.
     * @return O nó que tem o rótulo especificado.
     */
    public No<R> getNo(R rotulo) {
        for (No<R> no : this.nos) {
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

    /**
     * Retorna o custo total, somando todas as arestas.
     * @return Custo total de todas as arestas.
     */
    public Integer getCustoTotal() {
        return arestas.stream().reduce(0, (subtotal, aresta) -> subtotal + aresta.getCusto(), Integer::sum);
    }

    @Override
    public String toString() {
        String str = "Grafo: \n";
        for (Aresta<R> aresta : this.arestas) {
            str += aresta.toString() + "\n";
        }
        for (No<R> no : this.nos) {
            str += no.toString() + " ";
        }
        str += "\n";

        str += "Custo total: " + this.getCustoTotal() + "\n";
        return str;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grafo<?> other = (Grafo<?>) obj;
        if (other.nos.isEmpty() || this.nos.isEmpty()) {
            return false;
        }
        //Um grafo é igual ao outro se ambos tiverem os mesmos nos (nenhum a mais ou a menos)
        if (!this.nos.containsAll(other.nos) || !other.nos.containsAll(this.nos))  {
            return false;
        }
        //Para um grafo ser igual ao outro precisa que todas as arestas sejam as mesmas (nenhuma a mais ou a menos)
        if ((!this.arestas.containsAll(other.arestas) || !other.arestas.containsAll(this.arestas) && !this.arestas.isEmpty())) {
            return false;
        }
        return true;
    }
}