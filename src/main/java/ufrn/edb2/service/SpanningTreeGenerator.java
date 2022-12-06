package ufrn.edb2.service;
// package  ufrn.edb2.libs;
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;

// /**
// * Essa classe implementa o algoritmo k-best
// * @author  @ianco-so, @fawnbr
// */
// public class SpanningTreeGenerator<R extends Comparable<R>>  {
//     /**
//     * Esse é um método para gerar todas as árvores geradoras do grafo em ordem crescente de custo
//     * É uma implementação do k-best.
//     *   
//     * Input: Grafo G(V,E) em que cada aresta E tem um custo W
//     * Output: Lista de grafos (todas as arvores geradoras em ordem de custo) 
//     * List = {A} 
//     * Grafo MST = kruskal(A) 
//     * while MST ≠ ∅ do
//     * Get partition Ps ∈ List that contains the smallest spanning tree 
//     * Write MST of Ps to Output_File 
//     * Remove Ps from List 
//     * Partition(Ps).
//     * @param graph: o grafo a ser analizado
//     * @return Uma lista de grafos (que são arvores geradoras) em ordem de custo crescente.
//     */
//     public List<Grafo<R>> kBest(Grafo<R> graph) {
//         List<Grafo<R>> msts = new ArrayList<Grafo<R>>();

//         List<Particoes<R>> particoes = new ArrayList<Particoes<R>>();
//         particoes.add(new Particoes<R>());

//         Grafo<R> mst = getSmallestSpanningTree(graph, particoes.get(0));

//         while (!mst.getArestas().isEmpty()) {
//             Grafo<R> ps = this.getSmallestSpanningTreeInList(graph, particoes);
//             msts.add(this.kruskal(ps));
//             particoes.remove(ps);
//             particoes.addAll(this.partition(ps));
//         }
//         return null;
//     }

//     /**
//      * Dado um grafo esse método cria novos grafos que são partições do grafo original
//      * @param graph: o grafo a ser particionado
//      * @return Uma lista de grafos que são partições do grafo original
//      */
//     private List<Particoes<R>> partition(Particoes<R> p, Grafo<R> graph) {
//         List<Particoes<R>> particoes = new ArrayList<Particoes<R>>();

//         Particoes<R> p1 = p, p2 = p;
//         for (Aresta<R> a : graph.getArestas()) {
//             if (p.getArestasIncluidas().contains(a) && p.getArestasExcluidas().contains(a)) {
//                 p1.addArestaExcluida(a);
//                 p2.addArestaIncluida(a);
                
//             }
//         }
//         return particoes;
//     }
//     /**
//      * Dado uma lista de partições esse método retorna a partição que tem a menor arvore geradora
//      * @param graph: O grafo a ser analizado
//      * @param particoes: A lista re partições para achar a que gera a menor arvore geradora
//      * @return O grafo com menor custo
//      */
//     private Grafo<R> getSmallestSpanningTreeInList(Grafo<R> graph, List<Particoes<R>> particoes) {
//         Grafo<R> smallestSpanningTree = null;
//         for (Particoes<R> particao : particoes) {
//             if (smallestSpanningTree == null) {
//                 smallestSpanningTree = this.getSmallestSpanningTree(graph, particao);
//             } else {
//                 if (this.getSmallestSpanningTree(graph, particao).getArestas().size() < smallestSpanningTree.getArestas().size()) {
//                     smallestSpanningTree = this.getSmallestSpanningTree(graph, particao);
//                 }
//             }
//         }
//         return smallestSpanningTree;
//     }
//     /**
//      * Dado um partição de um grafo pega a menor arvore geradora para aquela partição
//      * Essa é uma versão do algoritmo de kruskal
//      * @param graph: o grafo a ser analizado
//      * @param particao: A partição da qual a arvore geradora deve obedecer as restrições
//      * @return o grafo com menor custo que pertença a partição indicada
//      */
//     private Grafo<R> getSmallestSpanningTree(Grafo<R> graph, Particoes<R> particao) {
//         Grafo<R> f = new Grafo<R>();

//         List<Aresta<R>> arestas = new ArrayList<>(graph.getArestas());
//         arestas.removeAll(particao.getArestasIncluidas());
//         List<No<R>> nos = graph.getNos();
//         ConjuntosDisjuntos<R> c = new ConjuntosDisjuntos<R>();
//         Collections.sort(arestas);

//         for (No<R> no : nos) {
//             f.adicionarNo(no);
//             c.makeSet(no.getRotulo());
//         }
//         for (Aresta<R> aresta : particao.getArestasIncluidas()) {
//             f.adicionarAresta(aresta);
//             c.union(aresta.getNo1().getRotulo(), aresta.getNo2().getRotulo());
//         }
//         for (Aresta<R> a : arestas) {
//             R u = a.getNo1().getRotulo();
//             R v = a.getNo2().getRotulo();
//             if (!c.sameSet(u, v)) {
//                 f.adicionarAresta(a);
//                 c.union(u, v);
//             }
//         }
//         return f;
//     }
//     /**
//      * Given a graph, this method returns minimum cost spanning tree.
//      * This is an implementation of the kruskal algorithm.
//      *
//      * The following code is implemented with a disjoint-set data structure.
//      * Here, we represent our forest F as a set of edges,
//      * and use the disjoint-set data structure to efficiently determine
//      * whether two vertices are part of the same tree.
//      *
//      * algorithm Kruskal(G) is
//      *     F:= ∅
//      *     for each v ∈ G.V do
//      *         MAKE-SET(v)
//      *     for each (u, v) in G.E ordered by weight(u, v), increasing do
//      *         if FIND-SET(u) ≠ FIND-SET(v) then
//      *             F:= F ∪ {(u, v)} ∪ {(v, u)}
//      *             UNIO
//      *     return F
//      * @param graph The graph to be analyzed.
//      * @return Uma lista com todas as arestas que compõem a árvore geradora mínima.
//      */
//     public Grafo<R> kruskal(Grafo<R> graph) {
//         Grafo<R> f = new Grafo<R>();

//         List<Aresta<R>> arestas = new ArrayList<>(graph.getArestas());
//         List<No<R>> nos = graph.getNos();
//         ConjuntosDisjuntos<R> c = new ConjuntosDisjuntos<R>();
//         Collections.sort(arestas);

//         for (No<R> no : nos) {
//             f.adicionarNo(no);
//             c.makeSet(no.getRotulo());
//         }
//         for (Aresta<R> a : arestas) {
//             R u = a.getNo1().getRotulo();
//             R v = a.getNo2().getRotulo();
//             if (!c.sameSet(u, v)) {
//                 f.adicionarAresta(a);
//                 c.union(u, v);
//             }
//         }
//         return f;
//     }
// }