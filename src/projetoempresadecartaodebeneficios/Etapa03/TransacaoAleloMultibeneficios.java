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
public class TransacaoAleloMultibeneficios extends Transacao{

  //Variável para controle incremental do cadastro de transações
  public static Integer incrementoTransacaoMUL = 1;

  //Variável para controle incremental do tipo de cartao
  public static final String idTipoCartao = "MUL_";

  //Variável para auxiliar na busca dentro de atributos na lista
  public static Integer indiceArrayMUL;

  //Variável para armazenar valor de cashback de cada transação
  public static Double valorCashbackMUL;

  //Cria uma lista com as transacoes do cartao
  public static ArrayList<TransacaoAleloMultibeneficios> listaTransacaoAleloMultibeneficios = new ArrayList<>();

  //Construtor padrão
  public TransacaoAleloMultibeneficios(){}

  //Construtor com passagem de parâmetros
  public TransacaoAleloMultibeneficios(String numeroDaTransacao, LocalDateTime dataHoraTransacao, String numeroDoCartao,
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
  public static void mostraDadosTransacaoValeMUL (Integer x){

    //Recebe o tamanho atual da lista de transações
    AleloMultibeneficios.tamanhoListaTransacaoMUL = TransacaoAleloMultibeneficios.listaTransacaoAleloMultibeneficios.size();

    for (int r = 0; r < AleloMultibeneficios.tamanhoListaTransacaoMUL; r++) {
      mostraNumeroTransacaoMUL(r);
      mostraDataHoraTransacaoMUL(r);
      mostraNumeroCartaoMUL(r);
      mostraCNPJEstabelecimentoTransacaoMUL(r);
      mostraProdutoMUL();
      mostraValorTransacaoMUL(r);
      mostraValorCashbackMUL(r);
    }
  }

  //Método que exibe o número da transação customizado
  public static void mostraNumeroTransacaoMUL(Integer index) {

    //Busca o atributo gravado na lista
    String numeroTransacaoMUL = TransacaoAleloMultibeneficios.listaTransacaoAleloMultibeneficios.get(index).numeroDaTransacao;
    System.out.printf("* Número da transação: %n>> * %s%n", numeroTransacaoMUL);
  }

  //Método que exibe a data e a hora da transação
  public static void mostraDataHoraTransacaoMUL(Integer index) {

    //Busca o atributo gravado na lista
    LocalDateTime dataHoraTransacao = TransacaoAleloMultibeneficios.listaTransacaoAleloMultibeneficios.get(index).dataHoraTransacao;

    //Formata a data e a hora no nosso padrão brasileiro
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
    String dataFormatada = formatador.format(dataHoraTransacao);

    System.out.printf(">> * Data e Hora: %n>> * %s%n", dataFormatada);
  }

  //Método que exibe o número do cartão
  public static void mostraNumeroCartaoMUL(Integer index) {

    //Busca o atributo gravado na lista
    String numeroCartaoMUL = TransacaoAleloMultibeneficios.listaTransacaoAleloMultibeneficios.get(index).numeroDoCartao;
    System.out.printf(">> * Número da transação: %n>> * %s%n", numeroCartaoMUL);
  }

  //Método que exibe o número do CNPJ customizado
  public static void mostraCNPJEstabelecimentoTransacaoMUL(Integer index) {

    //Busca o atributo gravado na lista
    String CNPJ = TransacaoAleloMultibeneficios.listaTransacaoAleloMultibeneficios.get(index).cnpjDoEstabelecimentoComercial;
    CNPJ = " * CNPJ: " + CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) +
            "." + CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
            CNPJ.substring(12, 14);
    System.out.printf("*>> CNPJ do estabelecimento: %n>> * %s%n", CNPJ);
  }

  //Método que exibe o produto (tipo de cartão) usado
  public static void mostraProdutoMUL() {

    String produtoMUL = "Alelo MULmentação";
    System.out.printf(">> * Número da transação: %n>> * %s%n", produtoMUL);
  }

  //Método que exibe o valor da transação
  public static void mostraValorTransacaoMUL(Integer index) {

    //Busca o atributo gravado na lista
    Double valorTransacaoMUL = TransacaoAleloMultibeneficios.listaTransacaoAleloMultibeneficios.get(index).valorDaTransacao;
    System.out.printf(">> * Número da transação: %n>> * R$%.2f%n", valorTransacaoMUL);
  }

  //Método que exibe o valor do cashback recebido
  public static void mostraValorCashbackMUL(Integer index) {

    //Busca o atributo gravado na lista
    Double valorCashbackMUL = TransacaoAleloMultibeneficios.listaTransacaoAleloMultibeneficios.get(index).valorDaTransacao;
    System.out.printf(">> * Cashback: %n>> * R$%.2f%n", valorCashbackMUL);
  }

  //Método que confere se duas compras foram feitas no mesmo valor em menos de 10 segundos
  //Retorna true se OK e false se falhar
  public static Boolean verificaDuasComprasMesmoValor(ArrayList<TransacaoAleloMultibeneficios> listaTransacao, double valorCompra) {

    // Se não há transações cadastradas ainda, não precisa fazer nenhum teste
    Integer totalTransacoes = listaTransacao.size();
    if (totalTransacoes == 0) {
      return true;
    }

    //Método para evitar duas compras de mesmo valor em menos de 10 segundos
    LocalDateTime ultimaTransacao = listaTransacao.get(totalTransacoes - 1).dataHoraTransacao;
    if (listaTransacao.get(totalTransacoes - 1).valorDaTransacao.equals(valorCompra)) {
      if (TransacaoAleloMultibeneficios.contaSegundosEntreTransacoes(ultimaTransacao) <= 10) {
        return false;
      }
    }
    return true;
  }

  //Método que confere se três compras foram feitas com mesmo cartão em menos de 30 segundos
  //Retorna true se OK e false se falhar
  public static Boolean verificaTresComprasMesmoCartao(ArrayList<TransacaoAleloMultibeneficios> listaTransacao, String numeroDoCartao) {

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
        if (TransacaoAleloMultibeneficios.contaSegundosEntreTransacoes(penultimaTransacao) <= 30) {
          return false;
        }
      }
    }
    return true;
  }

}
