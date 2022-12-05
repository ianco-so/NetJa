package org.example;

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

        String caminhoEstatico = "C:/Users/Lucas/www/NetJa/src/main/java/org/example/resources/exemplo.txt";
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

    }
}