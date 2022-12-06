package ufrn.edb2.libs;

import java.util.ArrayList;
import java.util.List;

public class GeradorDeArvoresPorCombinacao implements GeraArvore {

    private List<Aresta<Character>> arestas = null;
    private List<No<Character>> nos = null;

    public GeradorDeArvoresPorCombinacao() {
        //
    }

    @Override
    public Grafo<Character> gerarArvore(Grafo<Character> grafo, Integer quantidadeMaximaConexoes) {
        this.preencherInformacoesGrafo(grafo);
        
        // Gera todas as combinações de arestas possíveis
        List<List<Aresta<Character>>> combinacaoDeArestasPossiveis = gerarArvoresPossiveis();

        List<List<Aresta<Character>>> combinacaoDeArestasValidas = new ArrayList<>();

        // Para cada combinação de aresta, aplica uma validação baseada em:
        // - Quantidade de arestas
        // - Quantidade máxima de conexões
        for(Integer i = 0; i < combinacaoDeArestasPossiveis.size(); i++) {
            if(this.validarArvore(combinacaoDeArestasPossiveis.get(i), quantidadeMaximaConexoes)) {
                combinacaoDeArestasValidas.add(combinacaoDeArestasPossiveis.get(i));
            }
        }

        List<Grafo<Character>> grafos = new ArrayList<>();

        for (List<Aresta<Character>> combinacaoDeArestaValida : combinacaoDeArestasValidas) {
            Grafo<Character> grafoValido = new Grafo<>(nos);
            grafoValido.adicionarArestas(combinacaoDeArestaValida);
            grafos.add(grafoValido);
        }

        // Ordena por custo total
        grafos.sort((a, b)-> {
            if(a.getCustoTotal() > b.getCustoTotal()) {
                return 1;
            }
            else if(b.getCustoTotal() > a.getCustoTotal()) {
                return -1;
            }
            else {
                return 0;
            }
        });

        return grafos.get(0);
    }


    private void preencherInformacoesGrafo(Grafo<Character> grafo) {
        this.arestas = grafo.getArestas();
        this.nos = grafo.getNos();
    }

    private List<List<Aresta<Character>>> gerarArvoresPossiveis() {
        List<List<Aresta<Character>>> arvoresPossiveis = new ArrayList<>();

        // Para cada conjunto, existe 2^n subconjuntos
        Integer max = 1 << arestas.size();

        for (Integer i = 0; i < max; i++) {
            List<Aresta<Character>> subconjunto = new ArrayList<>();
            for (Integer j = 0; j < arestas.size(); j++) {
                if (((i >> j) & 1) == 1) {
                    subconjunto.add(arestas.get(j));
                }
            }
            arvoresPossiveis.add(subconjunto);
        }
        return arvoresPossiveis;
    }

    private Boolean validarArvore(List<Aresta<Character>> arvore, Integer quantidadeMaximaConexoes){
        if(arvore.size() != (nos.size() - 1)) {
            return false;
        }

        Integer[] numeroConexaoNos = new Integer[nos.size()];
        for(Integer i = 0; i < nos.size(); i++) {
            numeroConexaoNos[i] = 0;
        }

        for(Aresta<Character> aresta : arvore) {
            Integer no1 = nos.indexOf(aresta.getNo1());
            Integer no2 = nos.indexOf(aresta.getNo2());
            numeroConexaoNos[no1] = numeroConexaoNos[no1] + 1;
            numeroConexaoNos[no2] = numeroConexaoNos[no2] + 1;
        }

        if(!this.validarNumeroDeConexoesNos(numeroConexaoNos, quantidadeMaximaConexoes)) {
            return false;
        }

        return true;
    }

    private Boolean validarNumeroDeConexoesNos (Integer[] numeroConexaoNos, Integer quantidadeMaximaConexoes) {
        for (int i = 0; i < numeroConexaoNos.length; i++) {
            if(numeroConexaoNos[i] > quantidadeMaximaConexoes || numeroConexaoNos[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
