package ufrn.edb2.service;

import ufrn.edb2.model.arvore.Grafo;

public interface GeraArvore {
    public Grafo<Character> gerarArvore(Grafo<Character> grafo, Integer quantidadeMaximaConexoes);
}
