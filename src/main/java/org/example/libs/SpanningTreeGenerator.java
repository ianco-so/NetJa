package  org.example.libs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
* Essa classe implementa o algoritmo k-best
* @author  @ianco-so, @fawnbr
*/
public class SpanningTreeGenerator<R extends Comparable<R>, V> {
    /**
    * This method is for generate all spanning trees of a graph in order of increasing cost.
    * @param graph The graph to be analyzed.
    */
    public static List<ConjuntosDisjuntos> kBest(Grafo graph) {

        return null;
    }
    /**
     * Given a graph, this method returns minimum cost spanning tree.
     * This is an implementation of the kruskal algorithm.
     *
     * The following code is implemented with a disjoint-set data structure.
     * Here, we represent our forest F as a set of edges,
     * and use the disjoint-set data structure to efficiently determine
     * whether two vertices are part of the same tree.
     *
     * algorithm Kruskal(G) is
     *     F:= ∅
     *     for each v ∈ G.V do
     *         MAKE-SET(v)
     *     for each (u, v) in G.E ordered by weight(u, v), increasing do
     *         if FIND-SET(u) ≠ FIND-SET(v) then
     *             F:= F ∪ {(u, v)} ∪ {(v, u)}
     *             UNIO
     *     return F
     * @param graph The graph to be analyzed.
     * @return Uma lista com todas as arestas que compõem a árvore geradora mínima.
     */
    public List<Aresta<R, V>> kruskal(Grafo graph) {
        List<Aresta<R, V>> f = new ArrayList<Aresta<R, V>>();

        List<Aresta<R, V>> arestas = new ArrayList<>(graph.getArestas());
        List<No<R, V>> nos = graph.getNos();
        ConjuntosDisjuntos c = new ConjuntosDisjuntos();
        Collections.sort(arestas);

        for (No<R, V> no : nos) {
            c.makeSet((NoConjuntoDisjunto) no);
        }
        for (Aresta<R, V> a : arestas) {
            R u = a.getNo1().getRotulo();
            R v = a.getNo2().getRotulo();
            if (!c.sameSet(u, v)) {
                f.add(a);
                c.union(u, v);
            }
        }
        return f;
    }
}