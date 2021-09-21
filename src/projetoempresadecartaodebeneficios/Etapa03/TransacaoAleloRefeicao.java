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
 *
 * @version 1.0
 */
public class TransacaoAleloRefeicao extends Transacao{

  //Variável para controle incremental do cadastro de transações
  public static Integer incrementoTransacaoREF = 1;

  //Variável para controle incremental do tipo de cartao
  public static final String idTipoCartao = "REF_";

  //Variável para auxiliar na busca dentro de atributos na lista
  public static Integer indiceArrayREF;

  //Variável para armazenar valor de cashback de cada transação
  public static Double valorCashbackREF;

  //Cria uma lista com as transacoes do cartao
  public static ArrayList<TransacaoAleloRefeicao> listaTransacaoAleloRefeicao = new ArrayList<>();

  //Construtor padrão
  public TransacaoAleloRefeicao(){}

  //Construtor com passagem de parâmetros
  public TransacaoAleloRefeicao(String numeroDaTransacao, LocalDateTime dataHoraTransacao, String numeroDoCartao,
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
  public static void mostraDadosTransacaoValeREF (Integer x){

    //Recebe o tamanho atual da lista de transações
    AleloRefeicao.tamanhoListaTransacaoREF = TransacaoAleloRefeicao.listaTransacaoAleloRefeicao.size();

    for (int r = 0; r < AleloRefeicao.tamanhoListaTransacaoREF; r++) {
      mostraNumeroTransacaoREF(r);
      mostraDataHoraTransacaoREF(r);
      mostraNumeroCartaoREF(r);
      mostraCNPJEstabelecimentoTransacaoREF(r);
      mostraProdutoREF();
      mostraValorTransacaoREF(r);
      mostraValorCashbackREF(r);
    }
  }

  //Método que exibe o número da transação customizado
  public static void mostraNumeroTransacaoREF(Integer index) {

    //Busca o atributo gravado na lista
    String numeroTransacaoREF = TransacaoAleloRefeicao.listaTransacaoAleloRefeicao.get(index).numeroDaTransacao;
    System.out.printf(">> * Número da transação: %n>> * %s%n", numeroTransacaoREF);
  }

  //Método que exibe a data e a hora da transação
  public static void mostraDataHoraTransacaoREF(Integer index) {

    //Busca o atributo gravado na lista
    LocalDateTime dataHoraTransacao = TransacaoAleloRefeicao.listaTransacaoAleloRefeicao.get(index).dataHoraTransacao;

    //Formata a data e a hora no nosso padrão brasileiro
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
    String dataFormatada = formatador.format(dataHoraTransacao);

    System.out.printf("*>>  Data e Hora: %n>> * %s%n", dataFormatada);
  }

  //Método que exibe o número do cartão
  public static void mostraNumeroCartaoREF(Integer index) {

    //Busca o atributo gravado na lista
    String numeroCartaoREF = TransacaoAleloRefeicao.listaTransacaoAleloRefeicao.get(index).numeroDoCartao;
    System.out.printf(">> * Número da transação: %n>> * %s%n", numeroCartaoREF);
  }

  //Método que exibe o número do CNPJ customizado
  public static void mostraCNPJEstabelecimentoTransacaoREF(Integer index) {

    //Busca o atributo gravado na lista
    String CNPJ = TransacaoAleloRefeicao.listaTransacaoAleloRefeicao.get(index).cnpjDoEstabelecimentoComercial;
    CNPJ = " * CNPJ: " + CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) +
            "." + CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
            CNPJ.substring(12, 14);
    System.out.printf("*>> CNPJ do estabelecimento: %n>> * %s%n", CNPJ);
  }

  //Método que exibe o produto (tipo de cartão) usado
  public static void mostraProdutoREF() {

    String produtoREF = "Alelo REFmentação";
    System.out.printf(">> * Número da transação: %n>> * %s%n", produtoREF);
  }

  //Método que exibe o valor da transação
  public static void mostraValorTransacaoREF(Integer index) {

    //Busca o atributo gravado na lista
    Double valorTransacaoREF = TransacaoAleloRefeicao.listaTransacaoAleloRefeicao.get(index).valorDaTransacao;
    System.out.printf(">> * Número da transação: %n>> * R$%.2f%n", valorTransacaoREF);
  }

  //Método que exibe o valor do cashback recebido
  public static void mostraValorCashbackREF(Integer index) {

    //Busca o atributo gravado na lista
    Double valorCashbackREF = TransacaoAleloRefeicao.listaTransacaoAleloRefeicao.get(index).valorDaTransacao;
    System.out.printf(">> * Cashback: %n>> * R$%.2f%n", valorCashbackREF);
  }

  //Método que confere se duas compras foram feitas no mesmo valor em menos de 10 segundos
  //Retorna true se OK e false se falhar
  public static Boolean verificaDuasComprasMesmoValor(ArrayList<TransacaoAleloRefeicao> listaTransacao, double valorCompra) {

    // Se não há transações cadastradas ainda, não precisa fazer nenhum teste
    Integer totalTransacoes = listaTransacao.size();
    if (totalTransacoes == 0) {
      return true;
    }

    //Método para evitar duas compras de mesmo valor em menos de 10 segundos
    LocalDateTime ultimaTransacao = listaTransacao.get(totalTransacoes - 1).dataHoraTransacao;
    if (listaTransacao.get(totalTransacoes - 1).valorDaTransacao.equals(valorCompra)) {
      if (TransacaoAleloRefeicao.contaSegundosEntreTransacoes(ultimaTransacao) <= 10) {
        return false;
      }
    }
    return true;
  }

  //Método que confere se três compras foram feitas com mesmo cartão em menos de 30 segundos
  //Retorna true se OK e false se falhar
  public static Boolean verificaTresComprasMesmoCartao(ArrayList<TransacaoAleloRefeicao> listaTransacao, String numeroDoCartao) {

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
        if (TransacaoAleloRefeicao.contaSegundosEntreTransacoes(penultimaTransacao) <= 30) {
          return false;
        }
      }
    }
    return true;
  }

}
