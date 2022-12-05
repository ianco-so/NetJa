package  org.example.libs;
/**
* Esta classe representa uma aresta em um grafo.
* Têm dois nós e um peso.
* Para que dois nós sejam conectados, eles devem ter uma aresta entre eles.
* E entre dois nós pode existir apenas uma aresta.
* @author @ianco-so and @fawnbr
*/
public class Aresta implements Comparable<Aresta> {
    private No n1;
    private No n2;
    private Integer custo;

    public Aresta(No n1, No n2, Integer custo) {
        this.n1 = n1;
        this.n2 = n2;
        this.custo = custo;
    }

    // GETTERS E SETTERS

    public No getN1() {
        return this.n1;
    }
    public No getN2() {
        return  this.n2;
    }
    public Integer getCusto() {
        return  this.custo;
    }
    public String toString() {
        return  "(" + n1 + ", " + n2 + ") -> Custo: " + custo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aresta other = (Aresta) obj;
        if (this.getN1() != other.getN1() && (this.getN1() == null || !this.getN1().equals(other.getN1()))) {
            return false;
        }
        if (this.getN2()!= other.n2 && (this.getN2() == null || !this.getN2().equals(other.getN2()))) {
            return false;
        }
        if (this.getCusto() != other.getCusto()) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Aresta o) {
        return this.getCusto() - o.getCusto();
    }
}