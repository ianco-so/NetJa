package org.example.libs;

/**
 * Esta classe representa um nó de um conjunto disjunto.
 * A diferença entre um nó em um conjunto disjunto para
 * um nó em um grafo é que um nó em um conjunto disjunto
 * tem um pai e um rank, o rank diz a quantidade de filhos
 * que o nó tem, o rank de um nó que tem como pai ele mesmo
 * será 0 (quando ele for um conjunto unitário) >0 (quando
 * ele for o representante de uma árvore na floresta.
 * @param <R>: Tipo do rótulo do nó, deve implementar a interface Comparabl
 * @param <V>: Tipo do valor do nó.
 */
public class NoConjuntoDisjunto<R extends Comparable<R>, V> extends No<R, V> {
    private NoConjuntoDisjunto<R, V> pai;
    private Integer rank;

    /**
     * Construtor da classe NoConjuntoDisjunto
     * @param rotulo: O rótulo do nó
     */
    public NoConjuntoDisjunto(R rotulo) {
        super(rotulo);
        this.pai = this;
        this.rank = 0;
    }
    /**
     * Construtor da classe NoConjuntoDisjunto
     * @param rotulo: O rótulo do nó
     * @param valor: O valor do nó
     */
    public NoConjuntoDisjunto(R rotulo, V valor) {
        super(rotulo, valor);
        this.pai = this;
        this.rank = 0;
    }

    public NoConjuntoDisjunto<R, V> getPai() {
        return this.pai;
    }

    public void setPai(NoConjuntoDisjunto<R, V> pai) {
        this.pai = pai;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void incrementaRank() {
        this.rank++;
    }

}
