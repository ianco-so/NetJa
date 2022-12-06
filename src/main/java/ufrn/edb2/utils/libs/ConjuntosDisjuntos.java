package ufrn.edb2.utils.libs;
// package  ufrn.edb2.libs;

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Map;
// import java.util.Set;

// /**
//  * Essa classe implementa um conjunto disjunto.
//  * Ela é uma estrutura de dados que permite gerar a floresta,
//  * inserir nós a floresta, unir conjuntos, verificar se dois
//  * elementos estão no mesmo conjunto e achar o nó representante
//  * de um conjunto.
//  * Essa implementação é uma lista de NoConjuntoDisjunto<R>
//  *
//  * @param <R>: O tipo de rotulo do nó, deve implementar a interface Comparable
//  * @param <V>: O tipo de valor do nó do conjunto
//  */
// public class ConjuntosDisjuntos<R extends Comparable<R>> {
//     private List<NoConjuntoDisjunto<R>> floresta;

//     /**
//      * Construtor da classe ConjuntosDisjuntos
//      * Inicializa a floresta como uma lista vazia
//      */
//     public ConjuntosDisjuntos() {
//         this.floresta = new ArrayList<>();
//     }

//     /**
//      * Construtor da classe ConjuntosDisjuntos
//      * Inicializa a floresta com uma lista de nós
//      *
//      * @param nos: Uma lista de nós
//      */
//     public ConjuntosDisjuntos(NoConjuntoDisjunto... nos) {
//         this.floresta = new ArrayList<>();
//         //Adiciona os nós passados como parâmetro se eles não já estiverem
//         //na floresta e não forem nulos.
//         for (NoConjuntoDisjunto<R> no : nos) {
//             if (no != null && !this.floresta.contains(no)) {
//                 no.setPai(no); //O pai de um nó é ele mesmo quando ele é o representante do conjunto
//                 no.setRank(0); //O rank de um nó é 0 quando ele não tem filhos, nesse caso é o representante do conjunto unitario
//                 this.floresta.add(no);
//             }
// //            else {
// //                throw new IllegalArgumentException("Nó nulo ou já existente na floresta");
// //            }
//         }
//     }

//     /**
//      * Construtor da classe ConjuntosDisjuntos
//      * Inicializa a floresta com uma lista rotulos
//      *
//      * @param rotulos: Uma lista de rotulos
//      */
//     public ConjuntosDisjuntos(R... rotulos) {
//         //this.floresta = new ArrayList<>();
//         for (R rotulo : rotulos) {
//             if (rotulo != null) {
//                 NoConjuntoDisjunto<R> no = new NoConjuntoDisjunto<>(rotulo);
//                 if (!this.floresta.contains(no)) {
//                     no.setPai(no); //O pai de um nó é ele mesmo quando ele é o representante do conjunto
//                     no.setRank(0); //O rank de um nó é 0 quando ele não tem filhos, nesse caso é o representante do conjunto unitario
//                     this.floresta.add(no);
//                 }
// //                else {
// //                    throw new IllegalArgumentException("Nó já existente na floresta");
// //                }
//             }
// //            else {
// //                throw new IllegalArgumentException("Não pode adicionar um nó nulo a floresta");
// //            }
//         }
//     }

//     /**
//      * Criar um novo conjunto disjunto, ou seja,
//      * insere um nó na floresta.
//      */
//     public void makeSet(NoConjuntoDisjunto<R> no) {
//         if (no != null && !this.floresta.contains(no)) {
//             no.setPai(no);
//             no.setRank(0);
//             this.floresta.add(no);
//         }
//     }

//     /**
//      * Criar um novo conjunto disjunto, ou seja,
//      * insere um nó na floresta com um rotulo e um valor.
//      *
//      * @param rotulo: O rotulo do novo nó
//      * @param valor:  O valor do novo nó
//      */
//     public void makeSet(R rotulo) {
//         if (rotulo != null) {
//             NoConjuntoDisjunto<R> no = new NoConjuntoDisjunto<>(rotulo);
//             if (!this.floresta.contains(no)) {
//                 no.setPai(no);
//                 no.setRank(0);
//                 this.floresta.add(no);
//             }
//         }
//     }

//     /**
//      * Encontra o nó que tem um determinado rotulo
//      * @param rotulo: O rotulo do nó que se deseja encontrar
//      * @return O nó que deseja-se encontrar ou nulo se não existir.
//      * @throws IllegalArgumentException: Se o rotulo for nulo
//      */
//     public NoConjuntoDisjunto<R> getNo (R rotulo) {
//         if (rotulo == null) {
//             throw new IllegalArgumentException("Rotulo nulo");
//         }
//         for (NoConjuntoDisjunto<R> no : this.getFloresta()) {
//             if (no.getRotulo().equals(rotulo)) {
//                 return no;
//             }
//         }
//         return null;
//     }

//     /**
//      * Retorna a lista de nós da floresta
//      *
//      * @return: A lista de nós da floresta
//      */
//     public List<NoConjuntoDisjunto<R>> getFloresta() {
//         return this.floresta;
//     }

// //    /**
// //     * Retorna o nó representante do conjunto que o nó passado como parâmetro pertence
// //     *
// //     * @param no: O nó que se deseja saber o representante
// //     * @return: O nó representante do conjunto que o nó passado como parâmetro pertence
// //     */
// //    public NoConjuntoDisjunto<R> findSet(NoConjuntoDisjunto<R> no) {
// //        if (no == null) {
// //            throw new IllegalArgumentException("Nó nulo");
// //        }
// //        if (!this.getFloresta().contains(no)) {
// //            throw new IllegalArgumentException("Nó não pertence a floresta");
// //        }
// //        if (no.getPai() == no) {
// //            return no;
// //        } else {
// //            return findSet(no.getPai());
// //        }
// //    }
//     /**
//      * Dado o rótulo de um nó retorna o representante da árvore que ele pertence,
//      * caso ele esteja na floresta.
//      * @param rotulo: O rotulo do nó que se deseja saber o representante
//      * @return: O nó representante da árvore que o nó pertence
//      */
//     public NoConjuntoDisjunto<R> findSet(R rotulo) {
//         if (rotulo == null) {
//             throw new IllegalArgumentException("Rotulo nulo");
//         }
//         NoConjuntoDisjunto<R> no = this.getNo(rotulo);
//         if (no == null) {
//             throw new IllegalArgumentException("Nó não pertence a floresta");
//         }
//         if (no.getPai() == no) {
//             return no;
//         } else {
//             return findSet(no.getPai().getRotulo());
//         }
//     }
//     /**
//      * Verifica se dois nós pertencem ao mesmo conjunto
//      * ou seja, se eles tem o mesmo representante
//      * @param rotulo1: O rotulo do primeiro nó
//      * @param rotulo2: O rotulo do segundo nó
//      * @return true se os nós pertencem a mesma árvore, false caso contrário
//      */
//     public boolean sameSet(R rotulo1, R rotulo2) {
//         if (rotulo1 == null || rotulo2 == null) {
//             throw new IllegalArgumentException("Rotulo nulo");
//         }
//         NoConjuntoDisjunto<R> no1 = this.getNo(rotulo1);
//         NoConjuntoDisjunto<R> no2 = this.getNo(rotulo2);
//         if (no1 == null || no2 == null) {
//             throw new IllegalArgumentException("Nó não pertence a floresta");
//         }
//         return this.findSet(rotulo1) == this.findSet(rotulo2);
//     }

//     /**
//      * Une dois conjuntos disjuntos que pertencem a floresta
//      * essa união não é feita com base nos tamanhos das floresta
//      * apenas une o representante do outroNo com o no;
//      * @param rotuloDoNo: O que deve ser fundido  com o outro nó
//      * @param rotuloDoOutroNo: O que deve ser fundido com o nó
//      * @return O rotulo do nó que é representante da arvore resultante da união
//      */
//     public R union(R rotuloDoNo, R rotuloDoOutroNo) {
//         if (rotuloDoNo == null || rotuloDoOutroNo == null) {
//             throw new IllegalArgumentException("Rotulo nulo");
//         }
//         NoConjuntoDisjunto<R> no = this.getNo(rotuloDoNo);
//         NoConjuntoDisjunto<R> outroNo = this.getNo(rotuloDoOutroNo);
//         if (no == null || outroNo == null) {
//             throw new IllegalArgumentException("Nó não pertence a floresta");
//         }
//         if (this.sameSet(rotuloDoNo, rotuloDoOutroNo)) {
//             return findSet(rotuloDoNo).getRotulo();
//         }
//         NoConjuntoDisjunto<R> representanteOutroNo = this.findSet(rotuloDoOutroNo);
//         representanteOutroNo.setPai(no);
//         return this.findSet(no.getRotulo()).getRotulo();
//     }
//     /**
//      * Conjuntos são iguais quando todos os seus elementos são iguais
//      * para essa implementação basta que todos os elementos de um conjunto
//      * disjunto estejam no outro conjunto disjunto e vice-versa para
//      * que os conjuntos sejam iguais.
//      *
//      * @param obj: O conjunto que se deseja comparar
//      * @return: true se os conjuntos forem iguais, false caso contrário
//      */
//     @Override
//     public boolean equals(Object obj) {
//         if (obj == null) {
//             return false;
//         }
//         if (obj == this) {
//             return true;
//         }
//         if (!(obj instanceof ConjuntosDisjuntos)) {
//             return false;
//         }
//         ConjuntosDisjuntos<R> conjunto = (ConjuntosDisjuntos<R>) obj;
//         if (conjunto != null) {
//             return this.floresta.containsAll(conjunto.getFloresta())
//                     && conjunto.getFloresta().containsAll(this.floresta);
//         }
//         return false;
//     }
// }
