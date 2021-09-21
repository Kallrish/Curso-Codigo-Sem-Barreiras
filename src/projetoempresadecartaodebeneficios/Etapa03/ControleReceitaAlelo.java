package projetoempresadecartaodebeneficios.Etapa03;

//Importa bibliotecas/classes necessárias para o programa

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Projeto Empresa de Cartão de Benefícios.- Etapa 03
 * Trabalho individual.
 * Case Alelo.
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas Silva Ribeiro
 * @version 1.0
 */

public class ControleReceitaAlelo {

  //Variável para controle incremental do cadastro de controle
  public static Integer incrementoControle = 1;

  //Variável auxiliar para receber tamanho da lista de transações
  public static Integer tamanhoListaTransacaoALELO;

  //Atributos obrigatórios da entidade
  public Integer idControleAlelo;
  public String numeroDaTransacao;
  public LocalDateTime dataHoraTransacao;
  public String numeroDoCartao;
  public String cnpjDoEstabelecimentoComercial;
  public String produto;
  public Double valorDaTransacao;
  public Double valorReceitaAlelo;
  public static Double saldoControleAlelo = 0.0;

  //Cria uma lista com as transações para criar o extrato
  public static ArrayList<ControleReceitaAlelo> listaExtratoControleReceitaAlelo = new ArrayList<>();

  //Construtor padrão
  public ControleReceitaAlelo() {
  }

  //Construtor com passagem de parâmetros
  public ControleReceitaAlelo(Integer idControleAlelo, String numeroDaTransacao, LocalDateTime dataHoraTransacao, String numeroDoCartao,
                              String cnpjDoEstabelecimentoComercial, String produto, Double valorDaTransacao,
                              Double valorReceitaAlelo) {

    this.idControleAlelo = idControleAlelo;
    this.numeroDaTransacao = numeroDaTransacao;
    this.dataHoraTransacao = dataHoraTransacao;
    this.numeroDoCartao = numeroDoCartao;
    this.cnpjDoEstabelecimentoComercial = cnpjDoEstabelecimentoComercial;
    this.produto = produto;
    this.valorDaTransacao = valorDaTransacao;
    this.valorReceitaAlelo = valorReceitaAlelo;
  }

  //Método getter para o atributo saldo
  public static Double getSaldoControleAlelo() {
    return saldoControleAlelo;
  }

  //Método para depositar a receita de transação da Alelo no saldo
  public static Double setSaldoAlelo(Double valorDaTransacao) {
    Double receita = valorDaTransacao * 0.05;
    ControleReceitaAlelo.saldoControleAlelo += receita;
    return receita;
  }

  //Método que exibe o id da transação de receita
  public static void mostraidALELO (Integer index) {
    //Busca o atributo gravado na lista
    Integer idAlelo = ControleReceitaAlelo.listaExtratoControleReceitaAlelo.get(index).idControleAlelo;
    System.out.printf(">> * ID: %n>> * %d%n", idAlelo);
  }

  //Método que mostra o número da transação do cartão usado
  public static void mostraNumeroTransacaoALELO (Integer index) {
    //Busca o atributo gravado na lista
    String numeroTransacaoALELO = ControleReceitaAlelo.listaExtratoControleReceitaAlelo.get(index).numeroDaTransacao;
    System.out.printf(">> * Número da transação: %n>> * %s%n", numeroTransacaoALELO);
  }

  //Método que mostra a data e hora da transação
  public static void mostraDataHoraTransacaoALELO (Integer index) {
    //Busca o atributo gravado na lista
    LocalDateTime dataHoraTransacao = ControleReceitaAlelo.listaExtratoControleReceitaAlelo.get(index).dataHoraTransacao;

    //Formata a data e a hora no nosso padrão brasileiro
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
    String dataFormatada = formatador.format(dataHoraTransacao);

    System.out.printf(">> * Data e Hora: %n>> * %s%n", dataFormatada);
  }

  //Método que mostra o número do cartão usado
  public static void mostraNumeroCartaoALELO (Integer index) {
    //Busca o atributo gravado na lista
    String numeroCartaoALELO = ControleReceitaAlelo.listaExtratoControleReceitaAlelo.get(index).numeroDoCartao;
    System.out.printf(">> * Número da transação: %n>> * %s%n", numeroCartaoALELO);
  }

  //Método que mostra o CNPJ do estabelecimento onde ocorreu a compra
  public static void mostraCNPJEstabelecimentoALELO (Integer index) {
    //Busca o atributo gravado na lista
    String CNPJ = ControleReceitaAlelo.listaExtratoControleReceitaAlelo.get(index).cnpjDoEstabelecimentoComercial;
    CNPJ = CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) +
            "." + CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
            CNPJ.substring(12, 14);
    System.out.printf(">> * CNPJ do estabelecimento: %n>> * %s%n", CNPJ);
  }

  //Método que mostra qual produto foi usado
  public static void mostraProdutoALELO (Integer index) {

    //Busca o atributo gravado na lista
    String produtoALELO = ControleReceitaAlelo.listaExtratoControleReceitaAlelo.get(index).produto;
    System.out.printf(">> * Produto: %n>> * %s%n", produtoALELO);
  }

  //Método que mostrar o valor da transação
  public static void mostraValorTransacaoALELO (Integer index) {

    //Busca o atributo gravado na lista
    Double valorTransacaoALELO = ControleReceitaAlelo.listaExtratoControleReceitaAlelo.get(index).valorDaTransacao;
    System.out.printf(">> * Valor da transação: %n>> * R$%.2f%n", valorTransacaoALELO);
  }

  //Método que mostrar o valor da receita da empresa naquela transação
  public static void mostraValorReceitaALELO (Integer index) {
    //Busca o atributo gravado na lista
    Double ReceitaALELO =  ControleReceitaAlelo.listaExtratoControleReceitaAlelo.get(index).valorReceitaAlelo;
    System.out.printf(">> * Receita da transação: %n>> * R$%.2f%n", ReceitaALELO);
  }

  //Método para incluir saldo em um cartão
  public static void consultarSaldoAlelo() {

    //Declaração de variáveis necessárias
    Double saldoReceita = ControleReceitaAlelo.getSaldoControleAlelo();

    System.out.println(">>");
    System.out.println("> Menu > Consultar saldo receita Alelo");
    System.out.println(">>");
    System.out.println(">> O saldo atual da receita das transações é:");
    System.out.printf(">> %.2f%n", saldoReceita);

  }

  //Método para exibir extrato detalhado de todas as transações realizadas no cartão
  public static void consultarExtratoAlelo() {

    //Declaração de variáveis necessárias
    Integer i;

    System.out.println(">>");
    System.out.println("> Menu > Consultar extrato receita Alelo");
    System.out.println(">>");
    System.out.println(">> Extratos das transações geradoras de receita:");

    ControleReceitaAlelo.tamanhoListaTransacaoALELO = ControleReceitaAlelo.listaExtratoControleReceitaAlelo.size();

    for (i = 0; i < ControleReceitaAlelo.tamanhoListaTransacaoALELO; i++) {
      System.out.println(">>");
      ControleReceitaAlelo.mostraidALELO(i);
      ControleReceitaAlelo.mostraNumeroTransacaoALELO(i);
      ControleReceitaAlelo.mostraDataHoraTransacaoALELO(i);
      ControleReceitaAlelo.mostraNumeroCartaoALELO(i);
      ControleReceitaAlelo.mostraCNPJEstabelecimentoALELO(i);
      ControleReceitaAlelo.mostraProdutoALELO(i);
      ControleReceitaAlelo.mostraValorTransacaoALELO(i);
      ControleReceitaAlelo.mostraValorReceitaALELO(i);
    }

  }


}
