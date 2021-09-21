package projetoempresadecartaodebeneficios.Etapa03;

//Importa classes necessárias para o programa
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Projeto Empresa de Cartão de Benefícios.- Etapa 03
 * Trabalho individual.
 * Case Alelo.
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas Silva Ribeiro
 * @version 1.0
 */
public class TransacaoAleloAlimentacao extends Transacao {

  //Variável para controle incremental do cadastro de transações
  public static Integer incrementoTransacaoALI = 1;

  //Variável para controle incremental do tipo de cartao
  public static final String idTipoCartao = "ALI_";

  //Variável para armazenar valor de cashback de cada transação
  public static Double valorCashbackALI;

  //Cria uma lista com as transacoes do cartao
  public static ArrayList<TransacaoAleloAlimentacao> listaTransacaoAleloAlimentacao = new ArrayList<>();

  //Construtor padrão
  public TransacaoAleloAlimentacao(){}

  //Construtor com passagem de parâmetros
  public TransacaoAleloAlimentacao(String numeroDaTransacao, LocalDateTime dataHoraTransacao, String numeroDoCartao,
                                   String cnpjDoEstabelecimentoComercial, String produto, Double valorDaTransacao,
                                   Double valorDeCashback) {

    this.numeroDaTransacao = numeroDaTransacao;
    this.dataHoraTransacao = dataHoraTransacao;
    this.numeroDoCartao = numeroDoCartao;
    this.cnpjDoEstabelecimentoComercial = cnpjDoEstabelecimentoComercial;
    this.produto = produto;
    this.valorDaTransacao = valorDaTransacao;
    this.valorDeCashback = valorDeCashback;
  }

  //Imprime todos os dados de uma operação usando o index da lista como parâmetro
  public static void mostraDadosTransacaoValeALI (Integer x){

    //Recebe o tamanho atual da lista de transações
    AleloAlimentacao.tamanhoListaTransacaoALI = TransacaoAleloAlimentacao.listaTransacaoAleloAlimentacao.size();

    for (int r = 0; r < AleloAlimentacao.tamanhoListaTransacaoALI; r++) {
      mostraNumeroTransacaoALI(r);
      mostraDataHoraTransacaoALI(r);
      mostraNumeroCartaoALI(r);
      mostraCNPJEstabelecimentoTransacaoALI(r);
      mostraProdutoALI();
      mostraValorTransacaoALI(r);
      mostraValorCashbackALI(r);
    }
  }

  //Método que exibe o número da transação customizado
  public static void mostraNumeroTransacaoALI(Integer index) {

    //Busca o atributo gravado na lista
    String numeroTransacaoALI = TransacaoAleloAlimentacao.listaTransacaoAleloAlimentacao.get(index).numeroDaTransacao;
    System.out.printf(">> * Número da transação: %n>> * %s%n", numeroTransacaoALI);
  }

  //Método que exibe a data e a hora da transação
  public static void mostraDataHoraTransacaoALI(Integer index) {

    //Busca o atributo gravado na lista
    LocalDateTime dataHoraTransacao = TransacaoAleloAlimentacao.listaTransacaoAleloAlimentacao.get(index).dataHoraTransacao;

    //Formata a data e a hora no nosso padrão brasileiro
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
    String dataFormatada = formatador.format(dataHoraTransacao);

    System.out.printf(">> * Data e Hora: %n>> * %s%n", dataFormatada);
  }

  //Método que exibe o número do cartão
  public static void mostraNumeroCartaoALI(Integer index) {

    //Busca o atributo gravado na lista
    String numeroCartaoALI = TransacaoAleloAlimentacao.listaTransacaoAleloAlimentacao.get(index).numeroDoCartao;
    System.out.printf(">> * Número da transação: %n>> * %s%n", numeroCartaoALI);
  }

  //Método que exibe o número do CNPJ customizado
  public static void mostraCNPJEstabelecimentoTransacaoALI(Integer index) {

    //Busca o atributo gravado na lista
    String CNPJ = TransacaoAleloAlimentacao.listaTransacaoAleloAlimentacao.get(index).cnpjDoEstabelecimentoComercial;
    CNPJ = " * CNPJ: " + CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) +
            "." + CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
            CNPJ.substring(12, 14);
    System.out.printf("*>> CNPJ do estabelecimento: %n>> * %s%n", CNPJ);
  }

  //Método que exibe o produto (tipo de cartão) usado
  public static void mostraProdutoALI() {

    String produtoALI = "Alelo Alimentação";
    System.out.printf(">> * Produto: %n>> * %s%n", produtoALI);
  }

  //Método que exibe o valor da transação
  public static void mostraValorTransacaoALI(Integer index) {

    //Busca o atributo gravado na lista
    Double valorTransacaoALI = TransacaoAleloAlimentacao.listaTransacaoAleloAlimentacao.get(index).valorDaTransacao;
    System.out.printf(">> * Número da transação: %n>> * R$%.2f%n", valorTransacaoALI);
  }

  //Método que exibe o valor do cashback recebido
  public static void mostraValorCashbackALI(Integer index) {

    //Busca o atributo gravado na lista
    Double valorCashbackALI = TransacaoAleloAlimentacao.listaTransacaoAleloAlimentacao.get(index).valorDaTransacao;
    System.out.printf(">> * Cashback: %n>> * R$%.2f%n", valorCashbackALI);
  }

  //Método que confere se duas compras foram feitas no mesmo valor em menos de 10 segundos
  //Retorna true se OK e false se falhar
  public static Boolean verificaDuasComprasMesmoValor(ArrayList<TransacaoAleloAlimentacao> listaTransacao, double valorCompra) {

    // Se não há transações cadastradas ainda, não precisa fazer nenhum teste
    Integer totalTransacoes = listaTransacao.size();
    if (totalTransacoes == 0) {
      return true;
    }

    //Método para evitar duas compras de mesmo valor em menos de 10 segundos
    LocalDateTime ultimaTransacao = listaTransacao.get(totalTransacoes - 1).dataHoraTransacao;
    if (listaTransacao.get(totalTransacoes - 1).valorDaTransacao.equals(valorCompra)) {
      if (TransacaoAleloAlimentacao.contaSegundosEntreTransacoes(ultimaTransacao) <= 10) {
        return false;
      }
    }
    return true;
  }

  //Método que confere se três compras foram feitas com mesmo cartão em menos de 30 segundos
  //Retorna true se OK e false se falhar
  public static Boolean verificaTresComprasMesmoCartao(ArrayList<TransacaoAleloAlimentacao> listaTransacao, String numeroDoCartao) {

    // Se não há transações cadastradas ainda, não precisa fazer nenhum teste
    int totalTransacoes = listaTransacao.size();
    if (totalTransacoes == 0) {
      return true;
    }
    // Comparar a hora de agora com a hora da penúltima transação
    // (Não devemos passar três compras no mesmo cartão dentro do mesmo minuto.)
    if (totalTransacoes > 1) {
      LocalDateTime penultimaTransacao = listaTransacao.get(totalTransacoes - 2).dataHoraTransacao;
      if (listaTransacao.get(totalTransacoes - 1).numeroDoCartao.equals(numeroDoCartao)) {
        if (TransacaoAleloAlimentacao.contaSegundosEntreTransacoes(penultimaTransacao) <= 30) {
          return false;
        }
      }
    }
    return true;
  }

}
