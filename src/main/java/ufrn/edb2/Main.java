package ufrn.edb2;

import java.util.ArrayList;
import java.util.List;

import ufrn.edb2.model.RedeNetJa;
import ufrn.edb2.model.arvore.Aresta;
import ufrn.edb2.model.arvore.Grafo;
import ufrn.edb2.model.arvore.No;
import ufrn.edb2.service.GeradorDeArvoresPorCombinacao;
import ufrn.edb2.utils.Parser;

public class Main {
    public static void main(String[] args) {
        System.out.println("┌───────────────────────────────────────────────┐");
        System.out.println("│                                               │");
        System.out.println("│           Bem-vindo à Rede Net.já             │");
        System.out.println("│                     v1.0                      │");
        System.out.println("├───────────────────────────────────────────────┤");
        System.out.println("│            Autores: ianco-so e fawnbr         │");
        System.out.println("└───────────────────────────────────────────────┘");

        if(args.length != 1) {
            System.out.println("Por favor informe o caminho do arquivo.");
        }
        else if(args.length == 1) {
          System.out.println(">>> Lendo arquivo " + args[0] + "...");
          RedeNetJa redeNetJa = Parser.parsearArquivo(args[0]);
  
          System.out.println("\t>>> Numero de casas: " + redeNetJa.getNumeroResidencias());
          System.out.println("\t>>> Numero de conexoes máxima por casa: " + redeNetJa.getNumeroMaximoConexoes());
          
          System.out.println(">>> Gerando melhor árvore geradora...");
  
  
          //Criar um grafo onde cada nó é uma casa (da uma letra do alfabeto pra o rotulo de cada casa)
          List<No<Character>> nos = new ArrayList<>();
  
          //Criar um Nó com os rotulos começando em a até o número de casas
          for (int i = 0; i < redeNetJa.getNumeroResidencias(); i++) {
              nos.add(new No<Character>((char) (i + 97)));
          }
          
          Grafo<Character> grafo = new Grafo<>(nos);
          int i = 0;
          for (List<Integer> linha : redeNetJa.getCustoConexoes()) {
              int j = 0;
              for (Integer custo : linha) {
                  //Criar uma aresta
                  Aresta<Character> aresta;
                  //Adciona o no i e o no j e o custo a essa nova aresta
                  aresta = new Aresta<Character>(nos.get(i), nos.get(j+1+i), custo);
                  grafo.adicionarAresta(aresta);
                  j++;
              }
              i++;
          }
  
          GeradorDeArvoresPorCombinacao geradorDeArvoresPorCombinacao = new GeradorDeArvoresPorCombinacao();

          Grafo<Character> arvoreMinimaGerada = geradorDeArvoresPorCombinacao.gerarArvore(grafo, redeNetJa.getNumeroMaximoConexoes());

          System.out.println("┌─────────────────────────────────────────────────┐");
          System.out.println("│                MELHOR ARVORE GERADORA           │");
          System.out.println("└─────────────────────────────────────────────────┘");
          System.out.println(">>> Nós:");
          System.out.print("\t");
          for (No<Character> no : arvoreMinimaGerada.getNos()) {
              System.out.print(no + " ");
          }
          System.out.println();
          System.out.println(">>> Conexões:");
          for (Aresta<Character> aresta : arvoreMinimaGerada.getArestas()) {
              System.out.println("\t" + aresta);
          }
          System.out.println(">>> Custo total: "+ arvoreMinimaGerada.getCustoTotal());
        }
    }
}