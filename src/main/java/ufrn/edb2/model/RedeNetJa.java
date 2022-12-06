package ufrn.edb2.model;
import java.util.ArrayList;
import java.util.List;
/**
 * Esta classe representa informações para geração da árvore-solução do problema.
 * Nela está contida número de casas da amostra, número máximo de conexões por casa e o custo de cada uma das conexões.
 * @author @ianco-so and @fawnbr
 */
public class RedeNetJa {
    private Integer numeroResidencias;
    private Integer numeroMaximoConexoes;
    private List<List<Integer>> custoConexoes;

    public RedeNetJa() {
        numeroResidencias = null;
        numeroMaximoConexoes = null;
        custoConexoes = null;
    }

    public RedeNetJa(Integer numeroResidencias, Integer numeroMaximoConexoes) {
        this.numeroResidencias = numeroResidencias;
        this.numeroMaximoConexoes = numeroMaximoConexoes;
    }

    // GETTERS E SETTERS

    public Integer getNumeroResidencias() {
        return numeroResidencias;
    }

    public void setNumeroResidencias(Integer numeroResidencias) {
        this.numeroResidencias = numeroResidencias;
    }

    public Integer getNumeroMaximoConexoes() {
        return numeroMaximoConexoes;
    }

    public void setNumeroMaximoConexoes(Integer numeroMaximoConexoes) {
        this.numeroMaximoConexoes = numeroMaximoConexoes;
    }

    public List<List<Integer>> getCustoConexoes() {
        return custoConexoes;
    }

    // HELPERS

    /**
     * Coloca na matriz de custo o custo entre duas casas.
     * @param linha Linha da matriz a ser colocado o custo.
     * @param coluna Coluna da matriz a ser colocado o custo.
     * @param valor Valor do custo.
     */
    public void adicionarCusto(Integer linha, Integer coluna, Integer valor) {
        custoConexoes.get(linha).add(coluna, valor);
    }


    /**
     * Inicializa matriz de custo de conexões.
     * @throws IllegalStateException Caso numeroResidencias esteja nulo.
     */
    public void inicializarMatrizDeCusto() {
        if(numeroResidencias == null) {
            throw new IllegalStateException("Não é permitido inicializar a matriz sem definir o número de residências.");
        }

        custoConexoes = new ArrayList<>();

        for (Integer linha = 0; linha < numeroResidencias; linha++) {
            custoConexoes.add(new ArrayList<>());
        }
    }

    @Override
    public String toString() {
        return "RedeNetJa [numeroResidencias=" + numeroResidencias + ", numeroMaximoConexoes=" + numeroMaximoConexoes
                + ", custoConexoes=" + custoConexoes + "]";
    }
}
