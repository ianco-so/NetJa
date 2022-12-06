package org.example;

import org.example.libs.Aresta;
import org.example.libs.Grafo;
import org.example.libs.No;
import org.example.libs.SpanningTreeGenerator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.println("│                                               │");
        System.out.println("│           Bem-vindo à Rede Net.já             │");
        System.out.println("│                     v1.0                      │");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.println("│            Autores: ianco-so e fawnbr         │");
        System.out.println("└───────────────────────────────────────────────┘");

        // FIXME Reimplementar quando for deixar pro .jar
        // if(args.length != 1) {
        //     System.out.println("Por favor informe o nome do arquivo.");
        // }
        // else if(args.length == 1) {
        //   args[0]
        // }

        String caminhoEstatico = "src/main/java/org/example/resources/exemplo.txt";
        System.out.println("Lendo arquivo " + caminhoEstatico + "...");
        RedeNetJa redeNetJa = Parser.parsearArquivo(caminhoEstatico);

        System.out.println("Numero de casas: " + redeNetJa.getNumeroResidencias());
        System.out.println("Numero de conexoes máxima por casa: " + redeNetJa.getNumeroMaximoConexoes());

        for (List<Integer> linha : redeNetJa.getCustoConexoes()) {
            for (Integer custo : linha) {
                System.out.print(custo + " ");
            }
            System.out.println();
        }

        System.out.println("================MELHOR ARVORE GERADORA==========================");
        //Criar um grafo onde cada nó é uma casa (da uma letra do alfabeto pra o rotulo de cada casa)
        List<No<Character, Integer>> nos = new ArrayList<>();

        //Criar um Nó com os rotulos começando em a até o número de casas
        for (int i = 0; i < redeNetJa.getNumeroResidencias(); i++) {
            nos.add(new No<Character, Integer>((char) (i + 97), null));
        }
        //System.out.println(nos);
        Grafo<Character, Integer> grafo = new Grafo(nos);
        int i = 0;
        for (List<Integer> linha : redeNetJa.getCustoConexoes()) {
            int j = 0;
            for (Integer custo : linha) {
                //Criar uma aresta
                Aresta<Character, Integer> aresta;
                //Adciona o no i e o no j e o custo a essa nova aresta
                aresta = new Aresta<Character, Integer>(nos.get(i), nos.get(j+1+i), custo);
                grafo.adicionarAresta(aresta);
                j++;
            }
            i++;
        }
        System.out.println(grafo);

        SpanningTreeGenerator<Character, Integer> spanningTreeGenerator = new SpanningTreeGenerator<Character, Integer>();
        List<Aresta<Character, Integer>> list = spanningTreeGenerator.kruskal(grafo);
        for (Aresta<Character, Integer> aresta : list) {
            System.out.println(aresta);
        }
    }
}