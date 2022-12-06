// package ufrn.edb2.libs;

// import java.util.List;
// import java.util.ArrayList;
// /**
//  * Essa classe é uma partição de um grafo
//  * Uma partição de um grafo tem duas listas de arestas
//  * Uma lista de arestas que estão incluidas e as que estão excluidas da partição 
//  * arestas que não estão explicitamente incluidas ou excluidas são chamadas de arestas neutras
//  * Qualquer arvore produzida a partir dessa partição deve conter os arestas incluidas na partição
//  * e deve não conter as arestas excluidas, mas pode conter ou não conter arestas neutras
//  */
// public class Particoes<R extends Comparable<R>> {
//     List<Aresta<R>> arestasIncluidas;
//     List<Aresta<R>> arestasExcluidas;

//     public Particoes() {
//         this.arestasExcluidas = new ArrayList<Aresta<R>>();
//         this.arestasIncluidas = new ArrayList<Aresta<R>>();
//     }
//     public Particoes(List<Aresta<R>> arestasIncluidas, List<Aresta<R>> arestasExcluidas) {
//         this.arestasIncluidas = arestasIncluidas;
//         this.arestasExcluidas = arestasExcluidas;
//     }


//     public List<Aresta<R>> getArestasIncluidas() {
//         return arestasIncluidas;
//     }

//     public void setArestasIncluidas(List<Aresta<R>> arestasIncluidas) {
//         this.arestasIncluidas = arestasIncluidas;
//     }

//     public List<Aresta<R>> getArestasExcluidas() {
//         return arestasExcluidas;
//     }

//     public void setArestasExcluidas(List<Aresta<R>> arestasExcluidas) {
//         this.arestasExcluidas = arestasExcluidas;
//     }

//     public void addArestaIncluida(Aresta<R> aresta) {
//         this.arestasIncluidas.add(aresta);
//     }

//     public void addArestaExcluida(Aresta<R> aresta) {
//         this.arestasExcluidas.add(aresta);
//     }

//     public void removeArestaIncluida(Aresta<R> aresta) {
//         this.arestasIncluidas.remove(aresta);
//     }

//     public void removeArestaExcluida(Aresta<R> aresta) {
//         this.arestasExcluidas.remove(aresta);
//     }

//     public boolean isArestaIncluida(Aresta<R> aresta) {
//         return this.arestasIncluidas.contains(aresta);
//     }

//     public boolean isArestaExcluida(Aresta<R> aresta) {
//         return this.arestasExcluidas.contains(aresta);
//     }

//     public boolean isArestaNeutra(Aresta<R> aresta) {
//         return !this.isArestaIncluida(aresta) && !this.isArestaExcluida(aresta);
//     }

//     @Override
//     public boolean equals(Object obj) {
//         if (obj == null) {
//             return false;
//         }
//         if (getClass() != obj.getClass()) {
//             return false;
//         }
//         final Particoes<R> other = (Particoes<R>) obj;
//         if (!this.arestasIncluidas.containsAll(other.arestasIncluidas) || !other.arestasIncluidas.containsAll(this.arestasIncluidas)) {
//             return false;
//         }
//         if (!this.arestasExcluidas.containsAll(other.arestasExcluidas) || !other.arestasExcluidas.containsAll(this.arestasExcluidas)) {
//             return false;
//         }
//         return true;
//     }
// }
