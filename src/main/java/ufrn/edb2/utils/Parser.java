package ufrn.edb2.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import ufrn.edb2.model.RedeNetJa;

/**
 * Classe responsável por parsear o arquivo e transformar numa classe RedeNetJa.
* @author @ianco-so and @fawnbr
*/
public class Parser {

    /**
     * Recebe o caminho de um arquivo, acessa-o e parseia para a classe RedeNetJa.
     * Formato: 
     * <valor de n> <valor de d> 
     * <custo c1---c2> <custo c1---c3> <custo c1---c4> … <custo c1---cn> 
     * <custo c2---c3> <custo c2---c4> … <custo c2---cn> 
     * <custo c3---c4> … <custo c3---cn> 
     * … 
     * <custo c<n-1>-cn> 
     * @param caminho Caminho do arquivo
     * @return Uma classe RedeNetJa com as informações preenchidas.
     */
    public static RedeNetJa parsearArquivo(String caminho) {
        File arquivo = new File(caminho);
        RedeNetJa rede = new RedeNetJa();
        try {
            Scanner scanner = new Scanner(arquivo);
            int numeroCasas = scanner.nextInt();
            int conexaoMaxima = scanner.nextInt();
            rede.setNumeroResidencias(numeroCasas);
            rede.setNumeroMaximoConexoes(conexaoMaxima);
            rede.inicializarMatrizDeCusto();
            for (int i = 0; i < numeroCasas-1; i++) {
                for (int j = 0; j < numeroCasas - 1 - i; j++) {
                    rede.adicionarCusto(i, j, scanner.nextInt());
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return rede;
    }
}
