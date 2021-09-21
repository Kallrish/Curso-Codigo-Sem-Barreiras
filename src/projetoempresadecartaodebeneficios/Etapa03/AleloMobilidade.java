package projetoempresadecartaodebeneficios.Etapa03;

//Importa classes necessárias para o programa
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
public class AleloMobilidade extends Cartao{

  //Variável para controle incremental do cadastro de cartões
  public static Integer incrementoCartaoMOB = 1;

  //Variável auxiliar para receber tamanho da lista de transações
  public static Integer tamanhoListaTransacaoMOB;

  //Variável auxiliar para receber tamanho da lista de transações
  public static Integer tamanhoListaCartaoMOB;

  //Cria uma lista com os atributos do cartao
  public static ArrayList<AleloMobilidade> listaAleloMobilidade = new ArrayList<>();

  //Construtor padrão
  public AleloMobilidade() {
  }

  //Construtor com passagem de parâmetros
  public AleloMobilidade(Integer idCartao, String numeroDoCartao, String cpfDoPortador, String dataDeValidade,
                          String codigoDeSeguranca, String tipoDeCartao, String senha, Double saldo) {

    this.idCartao = idCartao;
    this.numeroDoCartao = numeroDoCartao;
    this.cpfDoPortador = cpfDoPortador;
    this.dataDeValidade = dataDeValidade;
    this.codigoDeSeguranca = codigoDeSeguranca;
    this.tipoDeCartao = tipoDeCartao;
    this.senha = senha;
    this.saldo = saldo;
  }

  //Método que exibe o id de cadastro do cartão
  public static void mostraIdCartaoMOB(Integer index) {

    //Busca o atributo gravado na lista
    Integer id = AleloMobilidade.listaAleloMobilidade.get(index).idCartao;
    System.out.printf(">> * ID: %n>> * %d%n", id);
  }

  //Método que exibe o o número do cartão
  public static void mostraNumeroCartaoMOB(Integer index) {

    //Busca o atributo gravado na lista
    String id = AleloMobilidade.listaAleloMobilidade.get(index).numeroDoCartao;
    System.out.printf(">> * Número do cartão: %n>> * %s%n", id);
  }

  //Retorna o CPF formatado corretamente com o uso de máscara
  public static void mostraCPFCartaoMOB(Integer index) {

    //Busca o atributo gravado na lista
    String CPF = AleloMobilidade.listaAleloMobilidade.get(index).cpfDoPortador;
    CPF = CPF.substring(0, 3) + "." + CPF.substring(3, 6) +
            "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11);
    System.out.printf(">> * CPF do portador: %n>> * %s%n", CPF);
  }

  //Retorna a data de validade formatada corretamente com o uso de máscara
  public static void mostraDataValidadeMOB(Integer index) {

    //Busca o atributo gravado na lista
    String dataValidade = AleloMobilidade.listaAleloMobilidade.get(index).dataDeValidade;

    //Formata a data e a hora no nosso padrão brasileiro
    dataValidade = dataValidade.substring(0, 2) + "/" + dataValidade.substring(2, 4) +
            "/" + dataValidade.substring(4, 8);

    System.out.printf(">> * Data de validade: %n>> * %s%n", dataValidade);
  }

  //Método que exibe o número do cartão
  public static void mostraCVVMOB(Integer index) {

    //Busca o atributo gravado na lista
    String CVV = AleloMobilidade.listaAleloMobilidade.get(index).codigoDeSeguranca;
    System.out.printf(">> * CVV: %n>> * %s%n", CVV);
  }

  //Método que exibe o tipo de cartão
  public static void mostraTipoCartaoMOB(Integer index) {

    //Busca o atributo gravado na lista
    String tipoCartao = AleloMobilidade.listaAleloMobilidade.get(index).tipoDeCartao;
    System.out.printf(">> * Tipo de cartão: %n>> * %s%n", tipoCartao);
  }

  //Método que exibe o saldo do cartão
  public static void mostraSaldoMOB(Integer index) {

    //Busca o atributo gravado na lista
    Double saldoCartao = AleloMobilidade.listaAleloMobilidade.get(index).saldo;
    System.out.printf(">> * Saldo: %n>> * R$%.2f%n", saldoCartao);
  }

}
