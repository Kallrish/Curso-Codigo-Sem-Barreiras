package projetoempresadecartaodebeneficios;

import java.util.Scanner;

/**
 * Projeto Empresa de Cartão de Benefícios.
 * Trabalho em grupo.
 * Curso Java - Share RH & Alelo"
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas, Ana Paula, Ana Paula Rodrigues, Antônio Carlos, José Erike, Natália
 * @version 1.0
 */
public class GerenciaBeneficios {
  /**
   * Roda o programa principal.
   */
  public static void main(String[] args) {

    //Inicio do programa com retorno ao usuário
    System.out.println("\n---------------------------------------------------------------");
    System.out.println("Olá! Bem-vindo ao gerenciado de benefícios da \"Todos Por Um\"!");
    System.out.println("---------------------------------------------------------------\n");
    System.out.println("Para começar, você precisa informar o saldo de cada benefício.");

    //Instancia o objeto in para receber as entradas do usuário
    Scanner in = new Scanner(System.in);

    //Solicita o saldo do cartão alimentação, declara variável e recebe nela o valor digitado
    //pelo usuário
    System.out.println("\nInforme o saldo do Cartão Alimentação:");
    System.out.print("R$ ");
    double saldoAlimentacao;
    saldoAlimentacao = in.nextDouble();

    //Solicita o saldo do cartão refeição, declara variável e recebe nela o valor digitado
    //pelo usuário
    System.out.println("\nInforme o saldo do Cartão Refeição:");
    System.out.print("R$ ");
    double saldoRefeicao;
    saldoRefeicao = in.nextDouble();

    //Solicita o saldo do cartão refeição, declara variável e recebe nela o valor digitado
    //pelo usuário
    System.out.println("\nInforme o saldo do Cartão Transporte:");
    System.out.print("R$ ");
    double saldoTransporte;
    saldoTransporte = in.nextDouble();

    //Retorna ao usuário mensagem de sucesso na operação
    System.out.println("\n>>>Saldos inseridos com sucesso!<<<\n");

    //Cria variável para controlar o laço do menu principal
    int saidaPrincipal = 0;

    //Laço para gerenciar o menu principal, onde o usuário escolhe o que fazer
    //Uso do DO-WHILE necessário para que o menu capte a escolha do usuário
    //e retorne de forma correta
    do {

      //Solicita ao usuário escolher a opção referente ao benefício que cadastrar
      //transações, ou dá a opção de sair do programa
      System.out.println("---------------------------------------------------------------");
      System.out.println("Escolha em qual categoria de benefício você deseja\n"
                       + "cadastrar as suas transações:");
      System.out.println("---------------------------------------------------------------\n");
      System.out.println("1 - Cartão Alimentação");
      System.out.println("2 - Cartão Refeição");
      System.out.println("3 - Cartão Transporte");
      System.out.println("4 - Sair do programa");
      System.out.print("Opção: ");

      //Recebe a opção do usuário
      int opcaoMenuPrincipal = in.nextInt();

      //Verifica se o benefício é de alimentação e se o saldo está zerado
      //retornando mensagem de erro
      if (opcaoMenuPrincipal == 1 && saldoAlimentacao == 0) {
        System.out.println("\n>>>Você não tem saldo no cartão alimentação.<<<\n");
        System.out.println("Selecione outro benefício para registrar transações!\n");

        //Verifica se o benefício é de alimentação e se o saldo é maior
        //que zero e manda o usuário para o menu de gastos de alimentação
      } else if (opcaoMenuPrincipal == 1 && saldoAlimentacao > 0) {

        //Cria variável para manter o laço do menu de alimentação
        int saidaAlimentacao;

        //Laço para gerenciar o menu alimentação, onde o usuário informa seus
        //gastos e escolhe se quer continuar informando mais ou voltar para o
        //menu anterior
        //Uso do DO-WHILE necessário para que o menu capte a escolha do usuário
        //e retorne de forma correta
        do {

          //Cria variável para receber qual o valor a ser gasto
          double gastoAlimentacao;

          //Solicita ao usuário a digitação do gasto e recebe na variável
          System.out.println("\n---------------------------------------------------");
          System.out.println("Bem-vindo a interface de gasto do seu vale alimentação!");
          System.out.println("-----------------------------------------------------\n");
          System.out.println("Insira o valor a ser gasto:");
          System.out.print("Valor R$  ");
          gastoAlimentacao = in.nextDouble();

          //Verifica se o gasto informado é maior que o saldo e informa que
          //o saldo é insuficiente
          if (gastoAlimentacao > saldoAlimentacao) {

            System.out.println("\n>>>Saldo insuficiente para realizar essa transação!<<<\n");

          } else {

            //Como o saldo é positivo, subtrai o gasto do saldo e retorna
            //mensagem de sucesso na transação
            saldoAlimentacao -= gastoAlimentacao;
            System.out.println("\n>>>Transação feita com sucesso!<<<\n");

          }

          //Solicita ao usuário informar se quer continuar informando gastos
          //referentes a alimentação, ou se prefere voltar ao menu principal
          System.out.println("----------------------------");
          System.out.println("Escolha uma das opções abaixo:");
          System.out.println("----------------------------\n");
          System.out.println("1 - Digitar outro gasto no cartão alimentação");
          System.out.println("2 - Voltar ao menu principal\n");
          System.out.print("Opção: ");

          //Recebe resposta do usuário e, ou finaliza o loop e retorna ao menu
          //anterior, ou reinicia o processo de informar gastos referentes a
          //alimentação
          saidaAlimentacao = in.nextInt();

        } while (saidaAlimentacao != 2);

        //Verifica se o benefício é de refeição e se o saldo está zerado
        //retornando mensagem de erro
      } else if (opcaoMenuPrincipal == 2 && saldoRefeicao == 0) {
        System.out.println("\n>>>Você não tem saldo no cartão refeição.<<<\n");
        System.out.println("Selecione outro benefício para registrar transações!\n");

      } else if (opcaoMenuPrincipal == 2 && saldoRefeicao > 0) {

        //Cria variável para manter o laço do menu de refeição
        int saidaRefeicao;

        //Laço para gerenciar o menu refeição, onde o usuário informa seus
        //gastos e escolhe se quer continuar informando mais ou voltar para o
        //menu anterior
        //Uso do DO-WHILE necessário para que o menu capte a escolha do usuário
        //e retorne de forma correta
        do {

          //Cria variável para receber qual o valor a ser gasto
          double gastoRefeicao;

          //Solicita ao usuário a digitação do gasto e recebe na variável
          System.out.println("\n---------------------------------------------------");
          System.out.println("Bem-vindo a interface de gasto do seu vale refeição!");
          System.out.println("-----------------------------------------------------\n");
          System.out.println("Insira o valor a ser gasto:");
          System.out.print("Valor R$ ");
          gastoRefeicao = in.nextDouble();

          //Verifica se o gasto informado é maior que o saldo e informa que
          //o saldo é insuficiente
          if (gastoRefeicao > saldoAlimentacao) {

            System.out.println("\n>>>Saldo insuficiente para realizar essa transação!<<<\n");

          } else {

            //Como o saldo é positivo, subtrai o gasto do saldo e retorna
            //mensagem de sucesso na transação
            saldoRefeicao -= gastoRefeicao;
            System.out.println(">>>Transação feita com sucesso!<<<");

          }

          //Solicita ao usuário informar se quer continuar informando gastos
          //referentes a refeições, ou se prefere voltar ao menu principal
          System.out.println("----------------------------");
          System.out.println("Escolha uma das opções abaixo:");
          System.out.println("----------------------------\n");
          System.out.println("1 - Digitar outro gasto no cartão refeição");
          System.out.println("2 - Voltar ao menu principal\n");
          System.out.print("Opção: ");

          //Recebe resposta do usuário e, ou finaliza o loop e retorna ao menu
          //anterior, ou reinicia o processo de informar gastos referentes a
          //refeições
          saidaRefeicao = in.nextInt();

        } while (saidaRefeicao != 2);

        //Verifica se o benefício é de transporte e se o saldo está zerado
        //retornando mensagem de erro
      } else if (opcaoMenuPrincipal == 3 && saldoTransporte == 0) {
        System.out.println("\n>>>Você não tem saldo no cartão transporte.<<<\n");
        System.out.println("Selecione outro benefício para registrar transações!\n");

      } else if (opcaoMenuPrincipal == 3 && saldoTransporte > 0) {

        //Cria variável para manter o laço do menu de transporte
        int saidaTransporte;

        //Laço para gerenciar o menu transporte, onde o usuário informa seus
        //gastos e escolhe se quer continuar informando mais ou voltar para o
        //menu anterior
        //Uso do DO-WHILE necessário para que o menu capte a escolha do usuário
        //e retorne de forma correta
        do {

          //Cria variável para receber qual o valor a ser gasto
          double gastoTransporte;

          //Solicita ao usuário a digitação do gasto e recebe na variável
          System.out.println("\n---------------------------------------------------");
          System.out.println("Bem-vindo a interface de gasto do seu vale transporte!");
          System.out.println("-----------------------------------------------------\n");
          System.out.println("Insira o valor a ser gasto:");
          System.out.print("Valor: R$ ");
          gastoTransporte = in.nextDouble();

          //Verifica se o gasto informado é maior que o saldo e informa que
          //o saldo é insuficiente
          if (gastoTransporte > saldoAlimentacao) {

            System.out.println("\n>>>Saldo insuficiente para realizar essa transação!<<<\n");

          } else {

            //Como o saldo é positivo, subtrai o gasto do saldo e retorna
            //mensagem de sucesso na transação
            saldoTransporte -= gastoTransporte;
            System.out.println(">>>Transação feita com sucesso!<<<\n");

          }

          //Solicita ao usuário informar se quer continuar informando gastos
          //referentes a refeições, ou se prefere voltar ao menu principal
          System.out.println("----------------------------");
          System.out.println("Escolha uma das opções abaixo:");
          System.out.println("----------------------------\n");
          System.out.println("1 - Digitar outro gasto no cartão transportes");
          System.out.println("2 - Voltar ao menu principal\n");
          System.out.print("Opção: ");

          //Recebe resposta do usuário e, ou finaliza o loop e retorna ao menu
          //anterior, ou reinicia o processo de informar gastos referentes a
          //transportes
          saidaTransporte = in.nextInt();

        } while (saidaTransporte != 2);

        //Opção para caso o usuário não queira mais digitar gastos e prefira
        //sair do programa
      } else if (opcaoMenuPrincipal == 4) {
        System.out.println("\nObrigado por usar nossos serviços.");
        System.out.println("A \"Todos Por Um\" agradece a sua preferência!");
        saidaPrincipal = 4;
      }
    } while (saidaPrincipal != 4);
  }
}