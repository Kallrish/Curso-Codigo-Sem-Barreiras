package projetoempresadecartaodebeneficios;

import java.util.Scanner;

/**
 * Projeto Empresa de Cartão de Benefícios.
 * Trabalho em grupo.
 * Curso Java - Share RH & Alelo"
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas, Ana Paula, Ana Paula Rodrigues, Antônio Carlos, José Erike, Natália
 * @version 1.7
 */
public class GerenciaBeneficios {
  /**
   * Roda o programa principal.
   */
  public static void main(String[] args) {

    //Inicio do programa com retorno ao usuário
    System.out.println("\n---------------------------------------------------------------");
    System.out.println("Olá! Bem-vindo(a) ao gerenciador de benefícios da \"JavAlelo\"!");
    System.out.println("---------------------------------------------------------------\n");
    System.out.println("Para começar, você precisa informar o saldo de cada benefício.");

    //Instancia o objeto in para receber as entradas do usuário
    Scanner in = new Scanner(System.in);

    //Cria variáveis para receber saldo do benefício alimentação e para checar o saldo
    double saldoAlimentacao = 0;
    double checaSaldo;

    //Laço para checar valor digitado e atribuir a variável de saldo
    do {
      //Solicita o saldo do cartão alimentação, declara variável e recebe nela o valor digitado
      //pelo usuário
      System.out.println("\nInforme o saldo do seu Vale Alimentação:");
      System.out.print("R$ ");
      checaSaldo = in.nextDouble();

      //Verifica se o valor digitado para o saldo é zero ou negativo e retorna erro ao usuário
      //Se positivo e maior que zero, atribui o valor ao saldo do benfício
      if (checaSaldo == 0) {
        System.out.println("\n>>>Você digitou R$0,00. O valor precisa ser maior que zero!<<<");
      } else if (checaSaldo < 0) {
        System.out.println("\n>>>R$ " + checaSaldo + " é um valor negativo. O valor precisa ser maior que zero!<<<");
      } else {
        saldoAlimentacao = checaSaldo;
      }

    } while (saldoAlimentacao == 0);

    //Cria variáveis para receber saldo do benefício refeição
    double saldoRefeicao = 0;

    //Laço para checar valor digitado e atribuir a variável de saldo
    do {
      //Solicita o saldo do cartão refeição, declara variável e recebe nela o valor digitado
      //pelo usuário
      System.out.println("\nInforme o saldo do seu Vale Refeição:");
      System.out.print("R$ ");
      checaSaldo = in.nextDouble();

      //Verifica se o valor digitado para o saldo é zero ou negativo e retorna erro ao usuário
      //Se positivo e maior que zero, atribui o valor ao saldo do benfício
      if (checaSaldo == 0) {
        System.out.println("\n>>>Você digitou R$0,00. O valor precisa ser maior que zero!<<<");
      } else if (checaSaldo < 0) {
        System.out.println("\n>>>R$ " + checaSaldo + " é um valor negativo. O valor precisa ser maior que zero!<<<");
      } else {
        saldoRefeicao = checaSaldo;
      }

    } while (saldoRefeicao == 0);

    //Cria variáveis para receber saldo do benefício transporte
    double saldoTransporte = 0;

    //Laço para checar valor digitado e atribuir a variável de saldo
    do {

      //Solicita o saldo do cartão refeição, declara variável e recebe nela o valor digitado
      //pelo usuário
      System.out.println("\nInforme o saldo do seu Vale Transporte:");
      System.out.print("R$ ");
      checaSaldo = in.nextDouble();

      //Verifica se o valor digitado para o saldo é zero ou negativo e retorna erro ao usuário
      //Se positivo e maior que zero, atribui o valor ao saldo do benfício
      if (checaSaldo == 0) {
        System.out.println("\n>>>Você digitou R$0,00. O valor precisa ser maior que zero!<<<");
      } else if (checaSaldo < 0) {
        System.out.println("\n>>>R$ " + checaSaldo + " é um valor negativo. O valor precisa ser maior que zero!<<<");
      } else {
        saldoTransporte = checaSaldo;
      }

    } while (saldoTransporte == 0);

    //Retorna ao usuário mensagem de sucesso na operação
    System.out.println("\n>>>Saldos inseridos com sucesso!<<<\n");
    System.out.println("O saldo dos benefícios do usuário foram atualizados para:\n");
    System.out.printf("Vale alimentação: R$ %.2f\n", saldoAlimentacao);
    System.out.printf("Vale refeição: R$ %.2f\n", saldoRefeicao);
    System.out.printf("Vale transporte: R$ %.2f\n\n", saldoTransporte);

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
              + "utilizar seu saldo:");
      System.out.println("---------------------------------------------------------------\n");
      System.out.println("1 - Vale alimentação");
      System.out.println("2 - Vale refeição");
      System.out.println("3 - Vale transporte");
      System.out.println("4 - Sair do programa");
      System.out.print("Opção: ");

      //Recebe a opção do usuário
      int opcaoMenuPrincipal = in.nextInt();

      //Verifica se o usuário escolheu uma opção válida
      if (opcaoMenuPrincipal < 1 || opcaoMenuPrincipal > 4) {

        System.out.println("\n>>>Opção inválida<<<");
        System.out.println("\n>>>Escolha uma opção entre 1 a 4.<<<\n");

        //Verifica se o benefício é de alimentação e se o saldo está zerado
        //retornando mensagem de erro
      } else if (opcaoMenuPrincipal == 1 && saldoAlimentacao == 0) {
        System.out.println("\n>>>Você tem R$0,00 no seu vale alimentação.<<<\n");
        System.out.println("Selecione outro benefício para utilizar seu saldo!\n");

        //Verifica se o benefício é de alimentação e se o saldo é maior
        //que zero e manda o usuário para o menu de gastos de alimentação
      } else if (opcaoMenuPrincipal == 1 && saldoAlimentacao > 0) {

        //Cria variável para manter o laço do menu de alimentação
        int saidaAlimentacao = 1;

        //Laço para gerenciar o menu alimentação, onde o usuário informa seus
        //gastos e escolhe se quer continuar informando mais ou voltar para o
        //menu anterior
        //Uso do DO-WHILE necessário para que o menu capte a escolha do usuário
        //e retorne de forma correta

        //Retorna mensagem de boas-vindas a interface
        System.out.println("\n---------------------------------------------------");
        System.out.println("Bem-vindo(a)! Hora de usar o seu vale alimentação!");
        System.out.println("-----------------------------------------------------\n");

        do {

          //Cria variável para receber qual o valor a ser gasto
          double gastoAlimentacao;

          //Solicita ao usuário a digitação do gasto e recebe na variável
          System.out.printf("Seu saldo atual é de %.2f.\n", saldoAlimentacao);
          System.out.println("Insira o valor a ser debitado do seu saldo:");
          System.out.print("Valor R$  ");
          gastoAlimentacao = in.nextDouble();

          //Verifica se o valor digitado para o saldo é zero ou negativo e retorna erro ao usuário
          //Se positivo e maior que zero, e o valor não for maior que o saldo atribui o valor ao
          //saldo do benefício
          if (gastoAlimentacao == 0) {

            System.out.println("\n>>>Você digitou R$0,00. O valor precisa ser maior que zero!<<<\n");

          } else if (gastoAlimentacao < 0) {

            System.out.println("\n>>>R$ " + gastoAlimentacao + " é um valor negativo. O valor precisa ser maior que zero!<<<\n");

          } else if (gastoAlimentacao > saldoAlimentacao) {

            System.out.println("\n>>>Saldo insuficiente para realizar essa transação!<<<");
            System.out.printf(">>>Seu saldo atual neste benefício é: %.2f..<<<\n\n", saldoAlimentacao);

          } else {

            //Como o saldo é positivo, subtrai o gasto do saldo e retorna
            //mensagem de sucesso na transação
            saldoAlimentacao -= gastoAlimentacao;
            System.out.println("\n>>>Transação feita com sucesso!<<<");
            System.out.printf(">>>Seu saldo atual neste benefício é: %.2f..<<<\n\n", saldoAlimentacao);

          }

          //Solicita ao usuário informar se quer continuar informando gastos
          //referentes a alimentação, ou se prefere voltar ao menu principal
          System.out.println("----------------------------");
          System.out.println("Escolha uma das opções abaixo:");
          System.out.println("----------------------------\n");
          System.out.println("1 - Informar outro valor a ser debitado do vale alimentação");
          System.out.println("2 - Voltar ao menu principal\n");
          System.out.print("Opção: ");

          //Cria variável para testar se a opção do usuário é válida
          int verificaOpcao;

         //Recebe a opção do usuário
          verificaOpcao = in.nextInt();

          //Verifica se o usuário escolheu uma opção válida
          if (verificaOpcao < 1 || verificaOpcao > 2) {

            System.out.println("\n>>>Opção inválida<<<");
            System.out.println("\n>>>Escolha uma opção entre 1 a 2.<<<\n");

          } else {
            //Recebe resposta do usuário e, ou finaliza o loop e retorna ao menu
            //anterior, ou reinicia o processo de informar gastos referentes a
            //alimentação
            saidaAlimentacao = verificaOpcao;
          }

        } while (saidaAlimentacao != 2);

        //Verifica se o benefício é de refeição e se o saldo está zerado
        //retornando mensagem de erro
      } else if (opcaoMenuPrincipal == 2 && saldoRefeicao == 0) {
        System.out.println("\n>>>Você tem R$0,00 no seu vale refeição.<<<\n");
        System.out.println("Selecione outro benefício para utilizar seu saldo!\n");

      } else if (opcaoMenuPrincipal == 2 && saldoRefeicao > 0) {

        //Cria variável para manter o laço do menu de refeição
        int saidaRefeicao = 1;

        //Laço para gerenciar o menu refeição, onde o usuário informa seus
        //gastos e escolhe se quer continuar informando mais ou voltar para o
        //menu anterior
        //Uso do DO-WHILE necessário para que o menu capte a escolha do usuário
        //e retorne de forma correta

        //Retorna informação de boas-vindas ao usuário
        System.out.println("\n---------------------------------------------------");
        System.out.println("Bem-vindo(a)! Hora de usar o seu vale refeição!");
        System.out.println("-----------------------------------------------------\n");

        do {

          //Cria variável para receber qual o valor a ser gasto
          double gastoRefeicao;

          //Solicita ao usuário a digitação do gasto e recebe na variável
          System.out.printf("Seu saldo atual é de %.2f.\n", saldoRefeicao);
          System.out.println("Insira o valor a ser debitado do seu saldo:");
          System.out.print("Valor R$ ");
          gastoRefeicao = in.nextDouble();

          //Verifica se o valor digitado para o saldo é zero ou negativo e retorna erro ao usuário
          //Se positivo e maior que zero, e o valor não for maior que o saldo atribui o valor ao
          //saldo do benefício
          if (gastoRefeicao == 0) {

            System.out.println("\n>>>Você digitou R$0,00. O valor precisa ser maior que zero!<<<\n");

          } else if (gastoRefeicao < 0) {

            System.out.println("\n>>>R$ " + gastoRefeicao + " é um valor negativo. O valor precisa ser maior que zero!<<<\n");

          } else if (gastoRefeicao > saldoRefeicao) {

            System.out.println("\n>>>Saldo insuficiente para realizar essa transação!<<<");
            System.out.printf(">>>Seu saldo atual neste benefício é: %.2f..<<<\n\n", saldoAlimentacao);

          } else {

            //Como o saldo é positivo, subtrai o gasto do saldo e retorna
            //mensagem de sucesso na transação
            saldoRefeicao -= gastoRefeicao;
            System.out.println("\n>>>Transação feita com sucesso!<<<");
            System.out.printf(">>>Seu saldo atual neste benefício é: %.2f..<<<\n\n", saldoRefeicao);

          }

          //Solicita ao usuário informar se quer continuar informando gastos
          //referentes a refeições, ou se prefere voltar ao menu principal
          System.out.println("----------------------------");
          System.out.println("Escolha uma das opções abaixo:");
          System.out.println("----------------------------\n");
          System.out.println("1 - Digitar outro gasto no cartão refeição");
          System.out.println("2 - Voltar ao menu principal\n");
          System.out.print("Opção: ");

          //Cria variável para testar se a opção do usuário é válida
          int verificaOpcao;

          //Recebe a opção do usuário
          verificaOpcao = in.nextInt();

          //Verifica se o usuário escolheu uma opção válida
          if (verificaOpcao < 1 || verificaOpcao > 2) {

            System.out.println("\n>>>Opção inválida<<<");
            System.out.println("\n>>>Escolha uma opção entre 1 a 2.<<<\n");

          } else {
            //Recebe resposta do usuário e, ou finaliza o loop e retorna ao menu
            //anterior, ou reinicia o processo de informar gastos referentes a
            //alimentação
            saidaRefeicao = verificaOpcao;
          }

        } while (saidaRefeicao != 2);

        //Verifica se o benefício é de transporte e se o saldo está zerado
        //retornando mensagem de erro
      } else if (opcaoMenuPrincipal == 3 && saldoTransporte == 0) {
        System.out.println("\n>>>Você tem R$0,00 no seu vale transporte.<<<\n");
        System.out.println("Selecione outro benefício para utilizar seu saldo!\n");

      } else if (opcaoMenuPrincipal == 3 && saldoTransporte > 0) {

        //Cria variável para manter o laço do menu de transporte
        int saidaTransporte = 1;

        //Laço para gerenciar o menu transporte, onde o usuário informa seus
        //gastos e escolhe se quer continuar informando mais ou voltar para o
        //menu anterior
        //Uso do DO-WHILE necessário para que o menu capte a escolha do usuário
        //e retorne de forma correta

        //Retorna informação de boas-vindas a interface
        System.out.println("\n---------------------------------------------------");
        System.out.println("Bem-vindo(a)! Hora de usar o seu valetransporte!");
        System.out.println("-----------------------------------------------------\n");

        do {

          //Cria variável para receber qual o valor a ser gasto
          double gastoTransporte;

          //Solicita ao usuário a digitação do gasto e recebe na variável
          System.out.printf("Seu saldo atual é de %.2f.\n", saldoTransporte);
          System.out.println("Insira o valor a ser debitado do seu saldo:");
          System.out.print("Valor: R$ ");
          gastoTransporte = in.nextDouble();

          //Verifica se o valor digitado para o saldo é zero ou negativo e retorna erro ao usuário
          //Se positivo e maior que zero, e o valor não for maior que o saldo atribui o valor ao
          //saldo do benefício
          if (gastoTransporte == 0) {

            System.out.println("\n>>>Você digitou R$0,00. O valor precisa ser maior que zero!<<<\n");

          } else if (gastoTransporte < 0) {

            System.out.println("\n>>>R$ " + gastoTransporte + " é um valor negativo. O valor precisa ser maior que zero!<<<\n");

          } else if (gastoTransporte > saldoTransporte) {

            System.out.println("\n>>>Saldo insuficiente para realizar essa transação!<<<");
            System.out.printf(">>>Seu saldo atual neste benefício é: %.2f..<<<\n\n", saldoAlimentacao);

          } else {

            //Como o saldo é positivo, subtrai o gasto do saldo e retorna
            //mensagem de sucesso na transação
            saldoTransporte -= gastoTransporte;
            System.out.println("\n>>>Transação feita com sucesso!<<<");
            System.out.printf(">>>Seu saldo atual neste benefício é: %.2f..<<<\n\n", saldoTransporte);
          }

          //Solicita ao usuário informar se quer continuar informando gastos
          //referentes a refeições, ou se prefere voltar ao menu principal
          System.out.println("----------------------------");
          System.out.println("Escolha uma das opções abaixo:");
          System.out.println("----------------------------\n");
          System.out.println("1 - Digitar outro gasto no cartão transportes");
          System.out.println("2 - Voltar ao menu principal\n");
          System.out.print("Opção: ");
          //Cria variável para testar se a opção do usuário é válida
          int verificaOpcao;

          //Recebe a opção do usuário
          verificaOpcao = in.nextInt();

          //Verifica se o usuário escolheu uma opção válida
          if (verificaOpcao < 1 || verificaOpcao > 2) {

            System.out.println("\n>>>Opção inválida<<<");
            System.out.println("\n>>>Escolha uma opção entre 1 a 2.<<<\n");

          } else {
            //Recebe resposta do usuário e, ou finaliza o loop e retorna ao menu
            //anterior, ou reinicia o processo de informar gastos referentes a
            //alimentação
            saidaTransporte = verificaOpcao;
          }

        } while (saidaTransporte != 2);

        //Opção para caso o usuário não queira mais digitar gastos e prefira
        //sair do programa
      } else if (opcaoMenuPrincipal == 4) {
        System.out.println("\nObrigado por usar nossos serviços.\n");
        System.out.println("------------------------------------");
        System.out.println("Seu saldo final nos benefícios é de:\n");
        System.out.printf("Vale alimentação: R$ %.2f\n", saldoAlimentacao);
        System.out.printf("Vale refeição: R$ %.2f\n", saldoRefeicao);
        System.out.printf("Vale transporte: R$ %.2f", saldoTransporte);
        System.out.println("------------------------------------\n");
        System.out.println("A \"JavAlelo\" agradece a sua preferência!");
        System.out.println("Tenha um ótimo dia!");

        saidaPrincipal = 4;
      }
    } while (saidaPrincipal != 4);
  }
}