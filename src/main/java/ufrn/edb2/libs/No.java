package  ufrn.edb2.libs;
/**
* Esta classe representa um nó no grafo.
 * Um nó do grafo tem um rotulo e um valor
 * Um nó é igual a outro se os seus rótulos forem iguais
* @author @ianco-so and @fawnbr
*/
public class No <R extends Comparable<R>> {
    private R rotulo;

    public No(R rotulo) {
        this.rotulo = rotulo;
    }

    public R getRotulo() {
        return this.rotulo;
    }

    public void setRotulo(R rotulo) { 
        this.rotulo = rotulo;
    }

    @Override
    public String toString() {
        return this.getRotulo().toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final No other = (No) obj;
        if ((this.getRotulo() == null) ? (other.getRotulo() != null) : !this.getRotulo().equals(other.getRotulo())) {
            return false;
        }
        return true;
    }
}