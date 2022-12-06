package  ufrn.edb2.libs;
/**
* Esta classe representa uma aresta em um grafo.
* Têm dois nós e um peso.
* Para que dois nós sejam conectados, eles devem ter uma aresta entre eles.
* E entre dois nós pode existir apenas uma aresta.
* @author @ianco-so and @fawnbr
*/
public class Aresta<R extends Comparable<R>> implements Comparable<Aresta<R>> {
    private final No<R> n1;
    private final No<R> n2;
    private Integer custo;

    public Aresta(No<R> n1, No<R> n2, Integer custo) {
        if (n1 == null || n2 == null) {
            throw new IllegalArgumentException("Nó nulo");
        }
        if (n1 == n2) {
            throw new IllegalArgumentException("Nós iguais");
        }
        this.n1 = n1;
        this.n2 = n2;
        this.custo = custo;
    }
    public Aresta (No<R> n1, No<R> n2) {
        if (n1 == null || n2 == null) {
            throw new IllegalArgumentException("Nó nulo");
        }
        if (n1 == n2) {
            throw new IllegalArgumentException("Nós iguais");
        }
        this.n1 = n1;
        this.n2 = n2;
        this.custo = 0;
    }
    public Aresta (R rotulo1, R rotulo2, Integer custo) {
        if (rotulo1 == null || rotulo2 == null) {
            throw new IllegalArgumentException("Nó nulo");
        }
        if (rotulo1.equals(rotulo2)) {
            throw new IllegalArgumentException("Nós iguais");
        }
        this.n1 = new No<>(rotulo1);
        this.n2 = new No<>(rotulo2);
        this.custo = custo;
    }
    public Aresta (R rotulo1, R rotulo2) {
        if (rotulo1 == null || rotulo2 == null) {
            throw new IllegalArgumentException("Nó nulo");
        }
        if (rotulo1.equals(rotulo2)) {
            throw new IllegalArgumentException("Nós iguais");
        }
        this.n1 = new No<>(rotulo1);
        this.n2 = new No<>(rotulo2);
        this.custo = 0;
    }

    // GETTERS E SETTERS

    public No<R> getNo1() {
        return this.n1;
    }
    public No<R> getNo2() {
        return  this.n2;
    }
    public Integer getCusto() {
        return  this.custo;
    }

    public void setCusto(Integer custo) {
        this.custo = custo;
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
        final Aresta<R> other = (Aresta<R>) obj;
        if (this == other) {
            return true;
        }
        if (this.getNo1() == null    ||
            this.getNo2() == null    ||
            other.getNo1() == null   ||
            other.getNo2() == null   ) {
            return false;
        }
        if ((this.getNo1() != other.getNo1() && this.getNo1() != other.getNo2()) ||
            (this.getNo2() != other.getNo1() && this.getNo2() != other.getNo2())   ) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Aresta<R> a) {
        return this.getCusto() - a.getCusto();
    }
}