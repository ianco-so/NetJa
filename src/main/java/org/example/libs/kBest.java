package  org.example.libs;
import java.util.Collections;
import java.util.List;

/**
* This class implements the k-best algorithm.
* @author  @ianco-so, @fawnbr
*/
public class kBest {
    /**
    * This method is for generate all spanning trees of a graph in order of increasing cost.
    * @param graph The graph to be analyzed.
    */
    public static List<Conjunto> genTrees(Grafo graph) {

        return null;
    }
    /**
    * Given a graph, this method returns minimum cost spanning tree.
    * This is an implementation of the kruskal algorithm.
    */
    public static ConjuntosDisjuntos kruskal (Grafo graph) {
        List<Aresta> aresta = graph.getArestas();
        List<No> nos = graph.getNos();
        ConjuntosDisjuntos c = new ConjuntosDisjuntos();
        Collections.sort(aresta);

        for (int i = 0; i < nos.size(); i++) {
            c.create_set(nos.get(i));
        }
        for (int i = 0; i < aresta.size(); i++) {
            Aresta a = aresta.get(i);
            No u = a.getN1();
            No v = a.getN2();
            if (c.find(u) != c.find(v)) {
                c.union(u, v);
            }
        
            }
        }
            
        }
        return null;
    }
}