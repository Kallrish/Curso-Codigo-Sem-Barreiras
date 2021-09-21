package projetoempresadecartaodebeneficios.Etapa03;

//Importa classes necessárias para o programa
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Projeto Empresa de Cartão de Benefícios.- Etapa 03
 * Trabalho individual.
 * Case Alelo.
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas Silva Ribeiro
 * @version 1.0
 */
public class Utilidades {

  //Método para exibir extrato detalhado de todas as transações realizadas no cartão
  public static void consultarExtrato() {

    //Declaração de variáveis necessárias
    String numeroCartao;
    Character tipoCartao;
    Boolean opcaoUsuario, cartaoValido, erro;
    Integer i;

    //Instancia o Scanner para receber dados de entrada do usuário
    Scanner entrada = new Scanner(System.in);

    do {
      opcaoUsuario = false;
      cartaoValido = false;
      System.out.println(">>");
      System.out.println("> Menu > Visualizar Extrato");
      System.out.println(">>");
      System.out.println(">> Digite o número referente a opção desejada:");
      System.out.println(">> [1] Alelo Alimentação");
      System.out.println(">> [2] Alelo Mobilidade");
      System.out.println(">> [3] Alelo Multibenefícios");
      System.out.println(">> [4] Alelo Refeição");
      System.out.println(">> [5] Voltar para o menu ");
      System.out.print(">> Opção: ");
      tipoCartao = entrada.nextLine().charAt(0);

      //Recebe o tamanho atual da lista de transações
      AleloAlimentacao.tamanhoListaTransacaoALI = TransacaoAleloAlimentacao.listaTransacaoAleloAlimentacao.size();
      AleloMobilidade.tamanhoListaTransacaoMOB = TransacaoAleloMobilidade.listaTransacaoAleloMobilidade.size();
      AleloMultibeneficios.tamanhoListaTransacaoMUL = TransacaoAleloMultibeneficios.listaTransacaoAleloMultibeneficios.size();
      AleloRefeicao.tamanhoListaTransacaoREF = TransacaoAleloRefeicao.listaTransacaoAleloRefeicao.size();

      switch (tipoCartao) {
        case '1' -> {
          do {
            erro = false;
            System.out.println(">> Informe o número do cartão:");
            System.out.print(">> Número do Cartão (sem espaços): ");
            numeroCartao = entrada.nextLine();
            numeroCartao = AleloAlimentacao.removeCaracteresEspeciaisNumeroCartao(numeroCartao);

            if (numeroCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }

            for (i = 0; i < AleloAlimentacao.tamanhoListaTransacaoALI; i++) {
              if (TransacaoAleloAlimentacao.listaTransacaoAleloAlimentacao.get(i).numeroDoCartao.equals(numeroCartao)) {
                System.out.println(">>");
                System.out.println("> Menu > Visualizar Extrato > Vale Alimentação");
                System.out.println(">>>");
                TransacaoAleloAlimentacao.mostraDadosTransacaoValeALI(i);
                cartaoValido = true;
              }
            }
            if (!cartaoValido) {
              System.out.println(">>");
              System.out.println(">> O número do cartão não está cadastrado no sistema. Digite novamente!");
              erro = true;
              continue;
            }

          } while (erro);

        }
        case '2' -> {
          do {
            erro = false;
            System.out.println(">> Informe o número do cartão:");
            System.out.print(">> Número do Cartão (sem espaços): ");
            numeroCartao = entrada.nextLine();
            numeroCartao = AleloMobilidade.removeCaracteresEspeciaisNumeroCartao(numeroCartao);

            if (numeroCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }

            for (i = 0; i < AleloMobilidade.tamanhoListaTransacaoMOB; i++) {
              if (TransacaoAleloMobilidade.listaTransacaoAleloMobilidade.get(i).numeroDoCartao.equals(numeroCartao)) {
                System.out.println(">>");
                System.out.println("> Menu > Visualizar Extrato > Vale Mobilidade");
                System.out.println(">>>");
                TransacaoAleloMobilidade.mostraDadosTransacaoValeMOB(i);
                cartaoValido = true;
              }
            }
            if (!cartaoValido) {
              System.out.println(">>");
              System.out.println(">> O número do cartão não está cadastrado no sistema. Digite novamente!");
              erro = true;
              continue;
            }

          } while (erro);
        }
        case '3' -> {
          do {
            erro = false;
            System.out.println(">> Informe o número do cartão:");
            System.out.print(">> Número do Cartão (sem espaços): ");
            numeroCartao = entrada.nextLine();
            numeroCartao = AleloMultibeneficios.removeCaracteresEspeciaisNumeroCartao(numeroCartao);

            if (numeroCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }

            for (i = 0; i < AleloMultibeneficios.tamanhoListaTransacaoMUL; i++) {
              if (TransacaoAleloMultibeneficios.listaTransacaoAleloMultibeneficios.get(i).numeroDoCartao.equals(numeroCartao)) {
                System.out.println(">>");
                System.out.println("> Menu > Visualizar Extrato > Vale Multibenefícios");
                System.out.println(">>>");
                TransacaoAleloMultibeneficios.mostraDadosTransacaoValeMUL(i);
                cartaoValido = true;
              }
            }
            if (!cartaoValido) {
              System.out.println(">>");
              System.out.println(">> O número do cartão não está cadastrado no sistema. Digite novamente!");
              erro = true;
              continue;
            }

          } while (erro);
        }
        case '4' -> {
          do {
            erro = false;
            System.out.println(">> Informe o número do cartão:");
            System.out.print(">> Número do Cartão (sem espaços): ");
            numeroCartao = entrada.nextLine();
            numeroCartao = AleloRefeicao.removeCaracteresEspeciaisNumeroCartao(numeroCartao);

            if (numeroCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }

            for (i = 0; i < AleloRefeicao.tamanhoListaTransacaoREF; i++) {
              if (TransacaoAleloRefeicao.listaTransacaoAleloRefeicao.get(i).numeroDoCartao.equals(numeroCartao)) {
                System.out.println(">>");
                System.out.println("> Menu > Visualizar Extrato > Vale Refeição");
                System.out.println(">>>");
                TransacaoAleloRefeicao.mostraDadosTransacaoValeREF(i);
                cartaoValido = true;
              }
            }
            if (!cartaoValido) {
              System.out.println(">>");
              System.out.println(">> O número do cartão não está cadastrado no sistema. Digite novamente!");
              erro = true;
              continue;
            }

          } while (erro);
        }
        case '5' -> opcaoUsuario = true;
        default -> System.out.println(">> Opção inválida! Digite um número de 1 a 5!");
      }
    } while (!opcaoUsuario);
  }

  //Método para incluir saldo em um cartão
  public static void incluirSaldo() {

    //Declaração de variáveis necessárias
    String numeroCartao, entradaValor;
    Character tipoCartao, continuaCadastro;
    Boolean opcaoUsuario, cartaoValido, valorValido, erro;
    Double valor;
    Integer i, indexCartao = 0;

    //Instancia o Scanner para receber dados de entrada do usuário
    Scanner entrada = new Scanner(System.in);

    do {
      opcaoUsuario = false;
      cartaoValido = false;
      valorValido = false;

      System.out.println(">>");
      System.out.println("> Menu > Adicionar Saldo");
      System.out.println(">>");
      System.out.println(">> Digite o número referente a opção desejada:");
      System.out.println(">> [1] Alelo Alimentação");
      System.out.println(">> [2] Alelo Mobilidade");
      System.out.println(">> [3] Alelo Multibenefícios");
      System.out.println(">> [4] Alelo Refeição");
      System.out.println(">> [5] Voltar para o menu ");
      System.out.print(">> Opção: ");
      tipoCartao = entrada.nextLine().trim().charAt(0);

      //Recebe o tamanho atual da lista de cartões
      AleloAlimentacao.tamanhoListaCartaoALI = AleloAlimentacao.listaAleloAlimentacao.size();
      AleloMobilidade.tamanhoListaCartaoMOB = AleloMobilidade.listaAleloMobilidade.size();
      AleloMultibeneficios.tamanhoListaCartaoMUL = AleloMultibeneficios.listaAleloMultibeneficios.size();
      AleloRefeicao.tamanhoListaCartaoREF = AleloRefeicao.listaAleloRefeicao.size();

      switch (tipoCartao) {
        case '1' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Adicionar Saldo > Vale Alimentação");
            System.out.println(">>>");
            System.out.println(">>> Informe o número do cartão (16 dígitos):");
            System.out.print(">>> Número do Cartão (sem espaços): ");
            numeroCartao = entrada.nextLine().trim();
            numeroCartao = Cartao.removeCaracteresEspeciaisNumeroCartao(numeroCartao);

            for (i = 0; i < AleloAlimentacao.tamanhoListaCartaoALI; i++) {
              if (AleloAlimentacao.listaAleloAlimentacao.get(i).numeroDoCartao.equals(numeroCartao)) {
                cartaoValido = true;
                indexCartao = i;
              }
            }
            if (numeroCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (!cartaoValido) {
              System.out.println(">>");
              System.out.println(">> O número do cartão não está cadastrado no sistema. Digite novamente!");
              erro = true;
              continue;
            }

          } while (erro);

          do {
            System.out.println(">>>");
            System.out.println(">>> Qual valor deseja adicionar?");
            System.out.print(">>> Valor: ");
            entradaValor = entrada.nextLine().trim();
            valor = Double.parseDouble(entradaValor);

            if (valor > 0) {
              AleloAlimentacao.listaAleloAlimentacao.get(indexCartao).saldo += valor;
              valorValido = true;
              System.out.printf(">>> O valor de R$%.2f foi adicionado com sucesso ao cartão!%n", valor);
              System.out.printf(">>> O saldo atual do cartão é: R$%.2f!%n",
                      AleloAlimentacao.listaAleloAlimentacao.get(indexCartao).saldo);
            } else if (Pattern.matches("[a-zA-Z]+", Double.toString(valor))) {
              System.out.println(">>>");
              System.out.println(">>> Você só pode digitar números. Digite novamente!");
            } else {
              System.out.println(">>> O valor não pode ser 0 ou negativo!");
              System.out.println(">>> Tente novamente!");
            }

          } while (!valorValido);
        }
        case '2' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Adicionar Saldo > Vale Mobilidade");
            System.out.println(">>>");
            System.out.println(">>> Informe o número do cartão (16 dígitos):");
            System.out.print(">>> Número do Cartão (sem espaços): ");
            numeroCartao = entrada.nextLine().trim();
            numeroCartao = Cartao.removeCaracteresEspeciaisNumeroCartao(numeroCartao);

            for (i = 0; i < AleloMobilidade.tamanhoListaCartaoMOB; i++) {
              if (AleloMobilidade.listaAleloMobilidade.get(i).numeroDoCartao.equals(numeroCartao)) {
                cartaoValido = true;
                indexCartao = i;
              }
            }
            if (numeroCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (!cartaoValido) {
              System.out.println(">>");
              System.out.println(">> O número do cartão não está cadastrado no sistema. Digite novamente!");
              erro = true;
              continue;
            }

          } while (erro);

          do {
            System.out.println(">>>");
            System.out.println(">>> Qual valor deseja adicionar?");
            System.out.print(">>> Valor: ");
            entradaValor = entrada.nextLine().trim();
            valor = Double.parseDouble(entradaValor);

            if (valor > 0) {
              AleloMobilidade.listaAleloMobilidade.get(indexCartao).saldo += valor;
              valorValido = true;
              System.out.printf(">>> O valor de R$%.2f foi adicionado com sucesso ao cartão!%n", valor);
              System.out.printf(">>> O saldo atual do cartão é: R$%.2f!%n",
                      AleloMobilidade.listaAleloMobilidade.get(indexCartao).saldo);
            } else if (Pattern.matches("[a-zA-Z]+", Double.toString(valor))) {
              System.out.println(">>>");
              System.out.println(">>> Você só pode digitar números. Digite novamente!");
            } else {
              System.out.println(">>> O valor não pode ser 0 ou negativo!");
              System.out.println(">>> Tente novamente!");
            }

          } while (!valorValido);
        }
        case '3' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Adicionar Saldo > Vale Multibenefícios");
            System.out.println(">>>");
            System.out.println(">>> Informe o número do cartão (16 dígitos):");
            System.out.print(">>> Número do Cartão (sem espaços): ");
            numeroCartao = entrada.nextLine().trim();
            numeroCartao = Cartao.removeCaracteresEspeciaisNumeroCartao(numeroCartao);

            for (i = 0; i < AleloMultibeneficios.tamanhoListaCartaoMUL; i++) {
              if (AleloMultibeneficios.listaAleloMultibeneficios.get(i).numeroDoCartao.equals(numeroCartao)) {
                cartaoValido = true;
                indexCartao = i;
              }
            }
            if (numeroCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (!cartaoValido) {
              System.out.println(">>");
              System.out.println(">> O número do cartão não está cadastrado no sistema. Digite novamente!");
              erro = true;
              continue;
            }

          } while (erro);

          do {
            System.out.println(">>>");
            System.out.println(">>> Qual valor deseja adicionar?");
            System.out.print(">>> Valor: ");
            entradaValor = entrada.nextLine().trim();
            valor = Double.parseDouble(entradaValor);

            if (valor > 0) {
              AleloMultibeneficios.listaAleloMultibeneficios.get(indexCartao).saldo += valor;
              valorValido = true;
              System.out.printf(">>> O valor de R$%.2f foi adicionado com sucesso ao cartão!%n", valor);
              System.out.printf(">>> O saldo atual do cartão é: R$%.2f!%n",
                      AleloMultibeneficios.listaAleloMultibeneficios.get(indexCartao).saldo);
            } else if (Pattern.matches("[a-zA-Z]+", Double.toString(valor))) {
              System.out.println(">>>");
              System.out.println(">>> Você só pode digitar números. Digite novamente!");
            } else {
              System.out.println(">>> O valor não pode ser 0 ou negativo!");
              System.out.println(">>> Tente novamente!");
            }

          } while (!valorValido);
        }
        case '4' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Adicionar Saldo > Vale Refeição");
            System.out.println(">>>");
            System.out.println(">>> Informe o número do cartão (16 dígitos):");
            System.out.print(">>> Número do Cartão (sem espaços): ");
            numeroCartao = entrada.nextLine().trim();
            numeroCartao = Cartao.removeCaracteresEspeciaisNumeroCartao(numeroCartao);

            for (i = 0; i < AleloRefeicao.tamanhoListaCartaoREF; i++) {
              if (AleloRefeicao.listaAleloRefeicao.get(i).numeroDoCartao.equals(numeroCartao)) {
                cartaoValido = true;
                indexCartao = i;
              }
            }
            if (numeroCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (!cartaoValido) {
              System.out.println(">>");
              System.out.println(">> O número do cartão não está cadastrado no sistema. Digite novamente!");
              erro = true;
              continue;
            }

          } while (erro);

          do {
            System.out.println(">>>");
            System.out.println(">>> Qual valor deseja adicionar?");
            System.out.print(">>> Valor: ");
            entradaValor = entrada.nextLine().trim();
            valor = Double.parseDouble(entradaValor);

            if (valor > 0) {
              AleloRefeicao.listaAleloRefeicao.get(indexCartao).saldo += valor;
              valorValido = true;
              System.out.printf(">>> O valor de R$%.2f foi adicionado com sucesso ao cartão!%n", valor);
              System.out.printf(">>> O saldo atual do cartão é: R$%.2f!%n",
                      AleloRefeicao.listaAleloRefeicao.get(indexCartao).saldo);
            } else if (Pattern.matches("[a-zA-Z]+", Double.toString(valor))) {
              System.out.println(">>>");
              System.out.println(">>> Você só pode digitar números. Digite novamente!");
            } else {
              System.out.println(">>> O valor não pode ser 0 ou negativo!");
              System.out.println(">>> Tente novamente!");
            }
          } while (!valorValido);
        }
        case '5' -> opcaoUsuario = true;
        default -> System.out.println(">> Opção inválida! Digite um número de 1 a 5!");
      }
    } while (!opcaoUsuario);
  }

  //Método para incluir saldo em um cartão
  public static void consultarSaldo() {

    //Declaração de variáveis necessárias
    String numeroCartao;
    Character tipoCartao;
    Boolean opcaoUsuario, cartaoValido, erro;

    Integer i;

    //Instancia o Scanner para receber dados de entrada do usuário
    Scanner entrada = new Scanner(System.in);

    do {
      opcaoUsuario = false;
      cartaoValido = false;

      System.out.println(">>");
      System.out.println("> Menu > Consultar Saldo");
      System.out.println(">>");
      System.out.println(">> Digite o número referente a opção desejada:");
      System.out.println(">> [1] Alelo Alimentação");
      System.out.println(">> [2] Alelo Mobilidade");
      System.out.println(">> [3] Alelo Multibenefícios");
      System.out.println(">> [4] Alelo Refeição");
      System.out.println(">> [5] Voltar para o menu ");
      System.out.print(">> Opção: ");
      tipoCartao = entrada.nextLine().trim().charAt(0);

      //Recebe o tamanho atual da lista de cartões
      AleloAlimentacao.tamanhoListaCartaoALI = AleloAlimentacao.listaAleloAlimentacao.size();
      AleloMobilidade.tamanhoListaCartaoMOB = AleloMobilidade.listaAleloMobilidade.size();
      AleloMultibeneficios.tamanhoListaCartaoMUL = AleloMultibeneficios.listaAleloMultibeneficios.size();
      AleloRefeicao.tamanhoListaCartaoREF = AleloRefeicao.listaAleloRefeicao.size();

      switch (tipoCartao) {
        case '1' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Consultar Saldo > Vale Alimentação");
            System.out.println(">>>");
            System.out.println(">>> Informe o número do cartão (16 dígitos):");
            System.out.print(">>> Número do Cartão (sem espaços): ");
            numeroCartao = entrada.nextLine().trim();
            numeroCartao = Cartao.removeCaracteresEspeciaisNumeroCartao(numeroCartao);

            for (i = 0; i < AleloAlimentacao.tamanhoListaCartaoALI; i++) {
              if (AleloAlimentacao.listaAleloAlimentacao.get(i).numeroDoCartao.equals(numeroCartao)) {
                cartaoValido = true;
                System.out.println(">>>");
                System.out.printf(">>> O saldo atual do cartão é: R$%.2f!%n",
                        AleloAlimentacao.listaAleloAlimentacao.get(i).saldo);
              }
            }
            if (numeroCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (!cartaoValido) {
              System.out.println(">>");
              System.out.println(">> O número do cartão não está cadastrado no sistema. Digite novamente!");
              erro = true;
              continue;
            }
          } while (erro);
        }
        case '2' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Consultar Saldo > Vale Mobilidade");
            System.out.println(">>>");
            System.out.println(">>> Informe o número do cartão (16 dígitos):");
            System.out.print(">>> Número do Cartão (sem espaços): ");
            numeroCartao = entrada.nextLine().trim();
            numeroCartao = Cartao.removeCaracteresEspeciaisNumeroCartao(numeroCartao);

            for (i = 0; i < AleloMobilidade.tamanhoListaCartaoMOB; i++) {
              if (AleloMobilidade.listaAleloMobilidade.get(i).numeroDoCartao.equals(numeroCartao)) {
                cartaoValido = true;
                System.out.println(">>>");
                System.out.printf(">>> O saldo atual do cartão é: R$%.2f!%n",
                        AleloMobilidade.listaAleloMobilidade.get(i).saldo);
              }
            }
            if (numeroCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (!cartaoValido) {
              System.out.println(">>");
              System.out.println(">> O número do cartão não está cadastrado no sistema. Digite novamente!");
              erro = true;
              continue;
            }
          } while (erro);
        }
        case '3' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Consultar Saldo > Vale Multibenefícios>");
            System.out.println(">>>");
            System.out.println(">>> Informe o número do cartão (16 dígitos):");
            System.out.print(">>> Número do Cartão (sem espaços): ");
            numeroCartao = entrada.nextLine().trim();
            numeroCartao = Cartao.removeCaracteresEspeciaisNumeroCartao(numeroCartao);

            for (i = 0; i < AleloMultibeneficios.tamanhoListaCartaoMUL; i++) {
              if (AleloMultibeneficios.listaAleloMultibeneficios.get(i).numeroDoCartao.equals(numeroCartao)) {
                cartaoValido = true;
                System.out.println(">>>");
                System.out.printf(">>> O saldo atual do cartão é: R$%.2f!%n",
                        AleloMultibeneficios.listaAleloMultibeneficios.get(i).saldo);
              }
            }
            if (numeroCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (!cartaoValido) {
              System.out.println(">>");
              System.out.println(">> O número do cartão não está cadastrado no sistema. Digite novamente!");
              erro = true;
              continue;
            }
          } while (erro);
        }
        case '4' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Consultar Saldo > Vale Refeição");
            System.out.println(">>>");
            System.out.println(">>> Informe o número do cartão (16 dígitos):");
            System.out.print(">>> Número do Cartão (sem espaços): ");
            numeroCartao = entrada.nextLine().trim();
            numeroCartao = Cartao.removeCaracteresEspeciaisNumeroCartao(numeroCartao);

            for (i = 0; i < AleloRefeicao.tamanhoListaCartaoREF; i++) {
              if (AleloRefeicao.listaAleloRefeicao.get(i).numeroDoCartao.equals(numeroCartao)) {
                cartaoValido = true;
                System.out.println(">>>");
                System.out.printf(">>> O saldo atual do cartão é: R$%.2f!%n",
                        AleloRefeicao.listaAleloRefeicao.get(i).saldo);
              }
            }
            if (numeroCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (!cartaoValido) {
              System.out.println(">>");
              System.out.println(">> O número do cartão não está cadastrado no sistema. Digite novamente!");
              erro = true;
              continue;
            }
          } while (erro);
        }
        case '5' -> opcaoUsuario = true;
        default -> System.out.println(">> Opção inválida! Digite um número de 1 a 5!");
      }
    } while (!opcaoUsuario);
  }

  //Método para cadastrar um cartão
  public static void cadastrarCartao() {

    //Declaração de variáveis necessárias
    String numeroDoCartao;
    String cpfDoPortador;
    LocalDate dataDeValidade;
    String dataFormatada;
    String codigoDeSeguranca;
    String tipoDeCartao;
    String senha;
    Double saldo;
    Character continuaCadastro;
    Boolean opcaoUsuario, CPFValido, CPFRepetido, senhaValida, erro;
    Integer i;

    //Instancia o Scanner para receber dados de entrada do usuário
    Scanner entrada = new Scanner(System.in);

    do {
      opcaoUsuario = false;
      CPFValido = false;
      CPFRepetido = false;
      senhaValida = false;

      System.out.println(">>");
      System.out.println("> Menu > Cadastrar cartão");
      System.out.println(">>");
      System.out.println(">> Digite o número referente a opção desejada:");
      System.out.println(">> [1] Cadastrar cartão Alelo Alimentação");
      System.out.println(">> [2] Cadastrar cartão Alelo Mobilidade");
      System.out.println(">> [3] Cadastrar cartão Alelo Multibenefícios");
      System.out.println(">> [4] Cadastrar cartão Alelo Refeição");
      System.out.println(">> [5] Voltar para o menu principal");
      System.out.print(">> Opção: ");
      continuaCadastro = entrada.nextLine().trim().charAt(0);

      //Recebe o tamanho atual da lista de cartões
      AleloAlimentacao.tamanhoListaCartaoALI = AleloAlimentacao.listaAleloAlimentacao.size();
      AleloMobilidade.tamanhoListaCartaoMOB = AleloMobilidade.listaAleloMobilidade.size();
      AleloMultibeneficios.tamanhoListaCartaoMUL = AleloMultibeneficios.listaAleloMultibeneficios.size();
      AleloRefeicao.tamanhoListaCartaoREF = AleloRefeicao.listaAleloRefeicao.size();
      PortadorDoCartao.tamanhoListaPortador = PortadorDoCartao.listaPortadoresDoCartao.size();

      switch (continuaCadastro) {
        case '1' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Cadastrar cartão > Alelo Alimentação");
            System.out.println(">>>");
            System.out.println(">>> Digite o CPF do portador (11 dígitos):");
            System.out.print(">>> CPF (somente números): ");
            cpfDoPortador = entrada.nextLine().trim();
            cpfDoPortador = PortadorDoCartao.removeCaracteresEspeciaisCPF(cpfDoPortador);
            CPFValido = PortadorDoCartao.verificarCPF(cpfDoPortador);

            if (cpfDoPortador.length() != 11) {
              System.out.println(">>>");
              System.out.println(">>> O CPF precisa ter 11 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", cpfDoPortador)) {
              System.out.println(">>>");
              System.out.println(">>> O CPF só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (!CPFValido) {
              System.out.println(">>");
              System.out.println(">> O CPF digitado não é válido. Digite novamente!");
              erro = true;
              continue;
            }

            for (i = 0; i < PortadorDoCartao.tamanhoListaPortador; i++) {
              if (PortadorDoCartao.listaPortadoresDoCartao.get(i).cpf.equals(cpfDoPortador)) {
                erro = false;
              }
            }

          } while (erro);

          do {
            System.out.println(">>>");
            System.out.println(">>> Digite a senha (4 dígitos):");
            System.out.print(">>> Senha (somente números): ");
            senha = entrada.nextLine().trim();

            if (senha.length() != 4) {
              System.out.println(">>>");
              System.out.println(">>> A senha precisa ter 4 números. Digite novamente!");
            } else if (Pattern.matches("[a-zA-Z]+", senha)) {
              System.out.println(">>>");
              System.out.println(">>> A senha só pode ter números. Digite novamente!");
            } else {
              senhaValida = true;
            }
          } while (!senhaValida);

          //O número do cartão é gerado automaticamente
          numeroDoCartao = AleloAlimentacao.geraNumeroAleatorioParaCartao();

          //O CVV do cartão é gerado automaticamente
          codigoDeSeguranca = AleloAlimentacao.geraCVVAleatorioParaCartao();

          //Data de validade é criada automaticamente. Com base na data atua é somado 2 anos.
          dataDeValidade = LocalDate.now().plusYears(2);
          DateTimeFormatter formatador = DateTimeFormatter.ofPattern("ddMMyyyy");
          dataFormatada = dataDeValidade.format(formatador);

          //Recebe o tipo do cartão
          tipoDeCartao = "Alelo Alimentação";

          //Saldo inicial de R$600,00
          saldo = 600.0;

          AleloAlimentacao.listaAleloAlimentacao.add(new AleloAlimentacao(
                  AleloAlimentacao.incrementoCartaoALI++, numeroDoCartao,
                  cpfDoPortador, dataFormatada, codigoDeSeguranca, tipoDeCartao,
                  senha, saldo));

          System.out.println(">>>");
          System.out.println(">>> Dados do novo cartão");
          System.out.println(">>>");
          System.out.printf(">>> Cartão número: %s%n", numeroDoCartao);
          System.out.printf(">>> CPF: %s%n", cpfDoPortador);
          dataFormatada = dataFormatada.substring(0, 2) + "/" + dataFormatada.substring(2, 4) +
                  "/" + dataFormatada.substring(6, 8);
          System.out.printf(">>> Data de Validade: %s%n", dataFormatada);
          System.out.printf(">>> CVV: %s%n", codigoDeSeguranca);
          System.out.printf(">>> Tipo Cartão: %s%n", tipoDeCartao);
          System.out.printf(">>> Saldo: %.2f%n", saldo);
          System.out.println(">>>");
          System.out.println(">>> Cadastro de cartão alimentação concluído com sucesso!");

        }
        case '2' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Cadastrar cartão > Alelo Mobilidade");
            System.out.println(">>>");
            System.out.println(">>> Digite o CPF do portador (11 dígitos):");
            System.out.print(">>> CPF (somente números): ");
            cpfDoPortador = entrada.nextLine().trim();
            cpfDoPortador = PortadorDoCartao.removeCaracteresEspeciaisCPF(cpfDoPortador);
            CPFValido = PortadorDoCartao.verificarCPF(cpfDoPortador);
            if (cpfDoPortador.length() != 11) {
              System.out.println(">>>");
              System.out.println(">>> O CPF precisa ter 11 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", cpfDoPortador)) {
              System.out.println(">>>");
              System.out.println(">>> O CPF só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (!CPFValido) {
              System.out.println(">>");
              System.out.println(">> O CPF digitado não é válido. Digite novamente!");
              erro = true;
              continue;
            }

            for (i = 0; i < PortadorDoCartao.tamanhoListaPortador; i++) {
              if (PortadorDoCartao.listaPortadoresDoCartao.get(i).cpf.equals(cpfDoPortador)) {
                erro = false;
              }
            }

          } while (erro);

          do {
            System.out.println(">>>");
            System.out.println(">>> Digite a senha (4 dígitos):");
            System.out.print(">>> Senha (somente números): ");
            senha = entrada.nextLine().trim();

            if (senha.length() != 4) {
              System.out.println(">>>");
              System.out.println(">>> A senha precisa ter 4 números. Digite novamente!");
            } else if (Pattern.matches("[a-zA-Z]+", senha)) {
              System.out.println(">>>");
              System.out.println(">>> A senha só pode ter números. Digite novamente!");
            } else {
              senhaValida = true;
            }
          } while (!senhaValida);

          //O número do cartão é gerado automaticamente
          numeroDoCartao = AleloMobilidade.geraNumeroAleatorioParaCartao();

          //O CVV do cartão é gerado automaticamente
          codigoDeSeguranca = AleloMobilidade.geraCVVAleatorioParaCartao();

          //Data de validade é criada automaticamente. Com base na data atua é somado 2 anos.
          dataDeValidade = LocalDate.now().plusYears(2);
          DateTimeFormatter formatador = DateTimeFormatter.ofPattern("ddMMyyyy");
          dataFormatada = dataDeValidade.format(formatador);

          //Recebe o tipo do cartão
          tipoDeCartao = "Alelo Mobilidade";

          //Saldo inicial de R$600,00
          saldo = 600.0;

          AleloMobilidade.listaAleloMobilidade.add(new AleloMobilidade(
                  AleloMobilidade.incrementoCartaoMOB++, numeroDoCartao,
                  cpfDoPortador, dataFormatada, codigoDeSeguranca, tipoDeCartao,
                  senha, saldo));

          System.out.println(">>>");
          System.out.println(">>> Dados do novo cartão");
          System.out.println(">>>");
          System.out.printf(">>> Cartão número: %s%n", numeroDoCartao);
          System.out.printf(">>> CPF: %s%n", cpfDoPortador);
          dataFormatada = dataFormatada.substring(0, 2) + "/" + dataFormatada.substring(2, 4) +
                  "/" + dataFormatada.substring(6, 8);
          System.out.printf(">>> Data de Validade: %s%n", dataFormatada);
          System.out.printf(">>> CVV: %s%n", codigoDeSeguranca);
          System.out.printf(">>> Tipo Cartão: %s%n", tipoDeCartao);
          System.out.printf(">>> Saldo: %.2f%n", saldo);
          System.out.println(">>>");
          System.out.println(">>> Cadastro de cartão mobilidade concluído com sucesso!");
        }
        case '3' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Cadastrar cartão > Alelo Multibenefícios");
            System.out.println(">>>");
            System.out.println(">>> Digite o CPF do portador (11 dígitos):");
            System.out.print(">>> CPF (somente números): ");
            cpfDoPortador = entrada.nextLine().trim();
            cpfDoPortador = PortadorDoCartao.removeCaracteresEspeciaisCPF(cpfDoPortador);
            CPFValido = PortadorDoCartao.verificarCPF(cpfDoPortador);

            if (cpfDoPortador.length() != 11) {
              System.out.println(">>>");
              System.out.println(">>> O CPF precisa ter 11 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", cpfDoPortador)) {
              System.out.println(">>>");
              System.out.println(">>> O CPF só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (!CPFValido) {
              System.out.println(">>");
              System.out.println(">> O CPF digitado não é válido. Digite novamente!");
              erro = true;
              continue;
            }

            for (i = 0; i < PortadorDoCartao.tamanhoListaPortador; i++) {
              if (PortadorDoCartao.listaPortadoresDoCartao.get(i).cpf.equals(cpfDoPortador)) {
                erro = false;
              }
            }

          } while (erro);

          do {
            System.out.println(">>>");
            System.out.println(">>> Digite a senha (4 dígitos):");
            System.out.print(">>> Senha (somente números): ");
            senha = entrada.nextLine().trim();

            if (senha.length() != 4) {
              System.out.println(">>>");
              System.out.println(">>> A senha precisa ter 4 números. Digite novamente!");
            } else if (Pattern.matches("[a-zA-Z]+", senha)) {
              System.out.println(">>>");
              System.out.println(">>> A senha só pode ter números. Digite novamente!");
            } else {
              senhaValida = true;
            }
          } while (!senhaValida);

          //O número do cartão é gerado automaticamente
          numeroDoCartao = AleloMultibeneficios.geraNumeroAleatorioParaCartao();

          //O CVV do cartão é gerado automaticamente
          codigoDeSeguranca = AleloMultibeneficios.geraCVVAleatorioParaCartao();

          //Data de validade é criada automaticamente. Com base na data atua é somado 2 anos.
          dataDeValidade = LocalDate.now().plusYears(2);
          DateTimeFormatter formatador = DateTimeFormatter.ofPattern("ddMMyyyy");
          dataFormatada = dataDeValidade.format(formatador);

          //Recebe o tipo do cartão
          tipoDeCartao = "Alelo Multibenefícios";

          //Saldo inicial de R$600,00
          saldo = 600.0;

          AleloMultibeneficios.listaAleloMultibeneficios.add(new AleloMultibeneficios(
                  AleloMultibeneficios.incrementoCartaoMUL++, numeroDoCartao,
                  cpfDoPortador, dataFormatada, codigoDeSeguranca, tipoDeCartao,
                  senha, saldo));

          System.out.println(">>>");
          System.out.println(">>> Dados do novo cartão");
          System.out.println(">>>");
          System.out.printf(">>> Cartão número: %s%n", numeroDoCartao);
          System.out.printf(">>> CPF: %s%n", cpfDoPortador);
          dataFormatada = dataFormatada.substring(0, 2) + "/" + dataFormatada.substring(2, 4) +
                  "/" + dataFormatada.substring(6, 8);
          System.out.printf(">>> Data de Validade: %s%n", dataFormatada);
          System.out.printf(">>> CVV: %s%n", codigoDeSeguranca);
          System.out.printf(">>> Tipo Cartão: %s%n", tipoDeCartao);
          System.out.printf(">>> Saldo: %.2f%n", saldo);
          System.out.println(">>>");
          System.out.println(">>> Cadastro de cartão multibenefícios concluído com sucesso!");
        }
        case '4' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Cadastrar cartão > Alelo Refeição");
            System.out.println(">>>");
            System.out.println(">>> Digite o CPF do portador (11 dígitos):");
            System.out.print(">>> CPF (somente números): ");
            cpfDoPortador = entrada.nextLine().trim();
            cpfDoPortador = PortadorDoCartao.removeCaracteresEspeciaisCPF(cpfDoPortador);
            CPFValido = PortadorDoCartao.verificarCPF(cpfDoPortador);

            if (cpfDoPortador.length() != 11) {
              System.out.println(">>>");
              System.out.println(">>> O CPF precisa ter 11 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", cpfDoPortador)) {
              System.out.println(">>>");
              System.out.println(">>> O CPF só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (!CPFValido) {
              System.out.println(">>");
              System.out.println(">> O CPF digitado não é válido. Digite novamente!");
              erro = true;
              continue;
            }

            for (i = 0; i < PortadorDoCartao.tamanhoListaPortador; i++) {
              if (PortadorDoCartao.listaPortadoresDoCartao.get(i).cpf.equals(cpfDoPortador)) {
                erro = false;
              }
            }

          } while (erro);

          do {
            System.out.println(">>>");
            System.out.println(">>> Digite a senha (4 dígitos):");
            System.out.print(">>> Senha (somente números): ");
            senha = entrada.nextLine().trim();

            if (senha.length() != 4) {
              System.out.println(">>>");
              System.out.println(">>> A senha precisa ter 4 números. Digite novamente!");
            } else if (Pattern.matches("[a-zA-Z]+", senha)) {
              System.out.println(">>>");
              System.out.println(">>> A senha só pode ter números. Digite novamente!");
            } else {
              senhaValida = true;
            }
          } while (!senhaValida);

          //O número do cartão é gerado automaticamente
          numeroDoCartao = AleloRefeicao.geraNumeroAleatorioParaCartao();

          //O CVV do cartão é gerado automaticamente
          codigoDeSeguranca = AleloRefeicao.geraCVVAleatorioParaCartao();

          //Data de validade é criada automaticamente. Com base na data atua é somado 2 anos.
          dataDeValidade = LocalDate.now().plusYears(2);
          DateTimeFormatter formatador = DateTimeFormatter.ofPattern("ddMMyyyy");
          dataFormatada = dataDeValidade.format(formatador);

          //Recebe o tipo do cartão
          tipoDeCartao = "Alelo Refeição";

          //Saldo inicial de R$600,00
          saldo = 600.0;

          AleloRefeicao.listaAleloRefeicao.add(new AleloRefeicao(
                  AleloRefeicao.incrementoCartaoREF++, numeroDoCartao,
                  cpfDoPortador, dataFormatada, codigoDeSeguranca, tipoDeCartao,
                  senha, saldo));

          System.out.println(">>>");
          System.out.println(">>> Dados do novo cartão");
          System.out.println(">>>");
          System.out.printf(">>> Cartão número: %s%n", numeroDoCartao);
          System.out.printf(">>> CPF: %s%n", cpfDoPortador);
          dataFormatada = dataFormatada.substring(0, 2) + "/" + dataFormatada.substring(2, 4) +
                  "/" + dataFormatada.substring(6, 8);
          System.out.printf(">>> Data de Validade: %s%n", dataFormatada);
          System.out.printf(">>> CVV: %s%n", codigoDeSeguranca);
          System.out.printf(">>> Tipo Cartão: %s%n", tipoDeCartao);
          System.out.printf(">>> Saldo: %.2f%n", saldo);
          System.out.println(">>>");
          System.out.println(">>> Cadastro de cartão alimentação concluído com sucesso!");
        }
        case '5' -> opcaoUsuario = true;
        default -> System.out.println(">> Opção inválida! Digite um número entre 1 e 2!");
      }
    }
    while (!opcaoUsuario);
  }

  //Método para consultar um cartão
  public static void consultarCartao() {

    //Declaração de variáveis necessárias
    String numeroDoCartao;
    Double saldo;
    Character continuaCadastro, tipoCartao;
    Boolean opcaoUsuario, cartaoEncontrado, cartaoValido, erro;

    Integer i;

    //Instancia o Scanner para receber dados de entrada do usuário
    Scanner entrada = new Scanner(System.in);

    do {
      opcaoUsuario = false;
      cartaoEncontrado = false;
      cartaoValido = false;

      System.out.println(">>");
      System.out.println("> Menu > Consultar cartão");
      System.out.println(">> Digite o número do tipo de cartão que deseja consultar:");
      System.out.println(">> [1] Alelo Alimentação");
      System.out.println(">> [2] Alelo Mobilidade");
      System.out.println(">> [3] Alelo Multibenefícios");
      System.out.println(">> [4] Alelo Refeição");
      System.out.println(">> [5] Voltar para o menu ");
      System.out.print(">> Opção: ");
      tipoCartao = entrada.nextLine().trim().charAt(0);

      //Recebe o tamanho atual da lista de cartões
      AleloAlimentacao.tamanhoListaCartaoALI = AleloAlimentacao.listaAleloAlimentacao.size();
      AleloMobilidade.tamanhoListaCartaoMOB = AleloMobilidade.listaAleloMobilidade.size();
      AleloMultibeneficios.tamanhoListaCartaoMUL = AleloMultibeneficios.listaAleloMultibeneficios.size();
      AleloRefeicao.tamanhoListaCartaoREF = AleloRefeicao.listaAleloRefeicao.size();

      switch (tipoCartao) {
        case '1' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Consultar cartão > Alelo Alimentação");
            System.out.println(">>>");
            System.out.println(">>> Digite o número do cartão (16 dígitos):");
            System.out.print(">>> Número do cartão(somente números): ");
            numeroDoCartao = entrada.nextLine().trim();

            if (numeroDoCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }

          } while (erro);

          for (i = 0; i < AleloAlimentacao.tamanhoListaCartaoALI; i++) {
            if (AleloAlimentacao.listaAleloAlimentacao.get(i).numeroDoCartao.equals(numeroDoCartao)) {
              cartaoEncontrado = true;
              System.out.println(">>");
              AleloAlimentacao.mostraIdCartaoALI(i);
              AleloAlimentacao.mostraNumeroCartaoALI(i);
              AleloAlimentacao.mostraCPFCartaoALI(i);
              AleloAlimentacao.mostraDataValidadeALI(i);
              AleloAlimentacao.mostraCVVALI(i);
              AleloAlimentacao.mostraTipoCartaoALI(i);
              AleloAlimentacao.mostraSaldoALI(i);
            }
          }
          if (!cartaoEncontrado) {
            System.out.println(">>>");
            System.out.println(">>> Número do cartão não está cadastrado no sistema.");
            System.out.println(">>> Tente novamente!");
          }
        }
        case '2' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Consultar cartão > Alelo Mobilidade");
            System.out.println(">>>");
            System.out.println(">>> Digite o número do cartão (16 dígitos):");
            System.out.print(">>> Número do cartão(somente números): ");
            numeroDoCartao = entrada.nextLine().trim();

            if (numeroDoCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }
          } while (erro);

          for (i = 0; i < AleloMobilidade.tamanhoListaCartaoMOB; i++) {
            if (AleloMobilidade.listaAleloMobilidade.get(i).numeroDoCartao.equals(numeroDoCartao)) {
              cartaoEncontrado = true;
              System.out.println(">>");
              AleloMobilidade.mostraIdCartaoMOB(i);
              AleloMobilidade.mostraNumeroCartaoMOB(i);
              AleloMobilidade.mostraCPFCartaoMOB(i);
              AleloMobilidade.mostraDataValidadeMOB(i);
              AleloMobilidade.mostraCVVMOB(i);
              AleloMobilidade.mostraTipoCartaoMOB(i);
              AleloMobilidade.mostraSaldoMOB(i);
            }
          }
          if (!cartaoEncontrado) {
            System.out.println(">>>");
            System.out.println(">>> Número do cartão não está cadastrado no sistema.");
            System.out.println(">>> Tente novamente!");
          }
        }
        case '3' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Consultar cartão > Alelo Multibeneficios");
            System.out.println(">>>");
            System.out.println(">>> Digite o número do cartão (16 dígitos):");
            System.out.print(">>> Número do cartão(somente números): ");
            numeroDoCartao = entrada.nextLine().trim();

            if (numeroDoCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }
          } while (erro);

          for (i = 0; i < AleloMultibeneficios.tamanhoListaCartaoMUL; i++) {
            if (AleloMultibeneficios.listaAleloMultibeneficios.get(i).numeroDoCartao.equals(numeroDoCartao)) {
              cartaoEncontrado = true;
              System.out.println(">>");
              AleloMultibeneficios.mostraIdCartaoMUL(i);
              AleloMultibeneficios.mostraNumeroCartaoMUL(i);
              AleloMultibeneficios.mostraCPFCartaoMUL(i);
              AleloMultibeneficios.mostraDataValidadeMUL(i);
              AleloMultibeneficios.mostraCVVMUL(i);
              AleloMultibeneficios.mostraTipoCartaoMUL(i);
              AleloMultibeneficios.mostraSaldoMUL(i);
            }
          }
          if (!cartaoEncontrado) {
            System.out.println(">>>");
            System.out.println(">>> Número do cartão não está cadastrado no sistema.");
            System.out.println(">>> Tente novamente!");
          }
        }
        case '4' -> {
          do {
            erro = false;
            System.out.println(">>");
            System.out.println("> Menu > Consultar cartão > Alelo Refeição");
            System.out.println(">>>");
            System.out.println(">>> Digite o número do cartão (16 dígitos):");
            System.out.print(">>> Número do cartão(somente números): ");
            numeroDoCartao = entrada.nextLine().trim();

            if (numeroDoCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }
          } while (erro);

          for (i = 0; i < AleloRefeicao.tamanhoListaCartaoREF; i++) {
            if (AleloRefeicao.listaAleloRefeicao.get(i).numeroDoCartao.equals(numeroDoCartao)) {
              cartaoEncontrado = true;
              System.out.println(">>");
              AleloRefeicao.mostraIdCartaoREF(i);
              AleloRefeicao.mostraNumeroCartaoREF(i);
              AleloRefeicao.mostraCPFCartaoREF(i);
              AleloRefeicao.mostraDataValidadeREF(i);
              AleloRefeicao.mostraCVVREF(i);
              AleloRefeicao.mostraTipoCartaoREF(i);
              AleloRefeicao.mostraSaldoREF(i);
            }
          }
          if (!cartaoEncontrado) {
            System.out.println(">>>");
            System.out.println(">>> Número do cartão não está cadastrado no sistema.");
            System.out.println(">>> Tente novamente!");
          }
        }
        case '5' -> opcaoUsuario = true;
        default -> System.out.println(">>> Opção inválida! Digite um número entre 1 e 5!");

      }
    } while (!opcaoUsuario);
  }

  //Método para realizar compra/transação com o cartão
  public static void realizarTransacao() {

    //Declaração de variáveis necessárias
    String numeroTransacao;
    String numeroDoCartao;
    String senhaDoCartao;
    String cnpjEstabelecimento;
    LocalDateTime dataHoraTransacao;
    Double saldoAtual = 0.0;
    Double valorTransacao;
    Double valorCashback;
    Double valorReceitaAlelo;
    Integer idControleAlelo;
    Integer index = 0;
    LocalDate dataDeValidade = LocalDate.now();
    String codigoDeSeguranca;

    Character menu;
    Character menuEstabelecimento;

    Boolean opcaoUsuario, cartaoValido, senhaValido, estabelecimento, cnpjValido, validadeValido,
            cvvValido, valorValido, transacaoOK, cartaoCorreto, erro;
    Integer i;

    //Instancia o Scanner para receber dados de entrada do usuário
    Scanner entrada = new Scanner(System.in);

    do {
      //Recebe o tamanho atual da lista de cartões

      PortadorDoCartao.tamanhoListaPortador = PortadorDoCartao.listaPortadoresDoCartao.size();
      EstabelecimentoComercial.tamanhoListaEstabelecimento = EstabelecimentoComercial.listaEstabelecimentoComercial.size();
      AleloAlimentacao.tamanhoListaTransacaoALI = TransacaoAleloAlimentacao.listaTransacaoAleloAlimentacao.size();
      AleloMobilidade.tamanhoListaTransacaoMOB = TransacaoAleloMobilidade.listaTransacaoAleloMobilidade.size();
      AleloMultibeneficios.tamanhoListaTransacaoMUL = TransacaoAleloMultibeneficios.listaTransacaoAleloMultibeneficios.size();
      AleloRefeicao.tamanhoListaTransacaoREF = TransacaoAleloRefeicao.listaTransacaoAleloRefeicao.size();
      ControleReceitaAlelo.tamanhoListaTransacaoALELO = ControleReceitaAlelo.listaExtratoControleReceitaAlelo.size();

      opcaoUsuario = false;
      cartaoValido = false;
      cartaoCorreto = false;
      senhaValido = false;
      validadeValido = false;
      cvvValido = false;
      valorValido = false;
      transacaoOK = false;
      estabelecimento = false;

      System.out.println(">>");
      System.out.println("> Menu > Cadastrar transação");
      System.out.println(">>");
      System.out.println(">> Digite o número no qual quer comprar:");
      System.out.println(">> [1] Alelo Alimentação");
      System.out.println(">> [2] Alelo Mobilidade");
      System.out.println(">> [3] Alelo Multibenefícios");
      System.out.println(">> [4] Alelo Refeição");
      System.out.println(">> [5] Voltar para o menu principal");
      System.out.print(">> Opção: ");
      menu = entrada.nextLine().trim().charAt(0);

      switch (menu) {
        case '1' -> {

          do {
            erro = false;
            estabelecimento = false;
            cartaoCorreto = false;
            System.out.println(">>>");
            System.out.println("> Menu > Cadastrar transação > Vale Alimentação");
            System.out.println(">>>");
            System.out.println(">>> É necessário logar no sistema.");
            System.out.println(">>>");
            System.out.println(">>> Digite o número do cartão (16 dígitos):");
            System.out.print(">> Número do cartão (somente números): ");
            numeroDoCartao = entrada.nextLine().trim();
            AleloAlimentacao.removeCaracteresEspeciaisNumeroCartao(numeroDoCartao);
            System.out.println(">>>");
            System.out.println(">>> Digite o CVV do cartão (3 dígitos):");
            System.out.print(">> CVV (somente números): ");
            codigoDeSeguranca = entrada.nextLine().trim();
            System.out.println(">>>");
            System.out.println(">>> Digite sua senha (4 dígitos):");
            System.out.print(">> Senha (somente números): ");
            senhaDoCartao = entrada.nextLine().trim();

            //Busca data de validade do cartão e converte para LocalDate
            for (i = 0; i < AleloAlimentacao.listaAleloAlimentacao.size(); i++) {
              if (AleloAlimentacao.listaAleloAlimentacao.get(i).numeroDoCartao.equals(numeroDoCartao)) {
                String data = AleloAlimentacao.listaAleloAlimentacao.get(i).dataDeValidade;
                data = data.substring(0, 2) + "/" + data.substring(2, 4) +
                        "/" + data.substring(4, 8);
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataDeValidade = LocalDate.parse(data, formatador);
                index = i;
                erro = false;
              }
            }

            if (numeroDoCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (dataDeValidade.compareTo(LocalDate.now()) < 0) {
              System.out.println(">>>");
              System.out.println(">>> Este cartão está vencido há " +
                      ChronoUnit.DAYS.between(dataDeValidade, LocalDateTime.now()) + " dia(s).");
              System.out.println(">>> Você não pode usá-lo para comprar!");
              erro = true;
              continue;
            } else if (codigoDeSeguranca.length() != 3) {
              System.out.println(">>>");
              System.out.println(">>> O CVV precisa ter 3 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", codigoDeSeguranca)) {
              System.out.println(">>>");
              System.out.println(">>> O CVV só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (senhaDoCartao.length() != 4) {
              System.out.println(">>>");
              System.out.println(">>> A senha precisa ter 4 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", senhaDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> A senha só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }

            //Verifica se já existem os dados de login informados
            for (i = 0; i < AleloAlimentacao.listaAleloAlimentacao.size(); i++) {
              if (AleloAlimentacao.listaAleloAlimentacao.get(i).numeroDoCartao.equals(numeroDoCartao) &&
                      AleloAlimentacao.listaAleloAlimentacao.get(i).senha.equals(senhaDoCartao) &&
                      AleloAlimentacao.listaAleloAlimentacao.get(i).codigoDeSeguranca.equals(codigoDeSeguranca)) {
                saldoAtual = AleloAlimentacao.listaAleloAlimentacao.get(i).saldo;
                erro = false;
                cartaoCorreto = true;
              }
            }

            if (cartaoCorreto) {
              System.out.println(">>>");
              System.out.println(">>> Login concluído com sucesso!");
            } else {
              System.out.println(">>>");
              System.out.println(">>> Número do cartão e/ou senha incorretos. Tente novamente!");
            }
          } while (erro);

          do {
            estabelecimento = true;
            System.out.println(">>>");
            System.out.println(">>> Digite o CNPJ do estabelecimento (14 dígitos):");
            System.out.print(">>> CNPJ (Somente número): ");
            cnpjEstabelecimento = entrada.nextLine().trim();
            cnpjEstabelecimento = EstabelecimentoComercial.removeCaracteresEspeciaisCNPJ(cnpjEstabelecimento);
            cnpjValido = EstabelecimentoComercial.verificarCNPJ(cnpjEstabelecimento);

            if (cnpjEstabelecimento.length() != 14) {
              System.out.println(">>>");
              System.out.println(">>> O CNPJ precisa ter 14 números. Digite novamente!");
              estabelecimento = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", cnpjEstabelecimento)) {
              System.out.println(">>>");
              System.out.println(">>> O CNPJ só pode ter números. Digite novamente!");
              estabelecimento = true;
              continue;
            } else if (!cnpjValido) {
              System.out.println(">>");
              System.out.println(">> O CNPJ digitado não é válido. Digite novamente!");
              estabelecimento = true;
              continue;
            }
            for (i = 0; i < EstabelecimentoComercial.tamanhoListaEstabelecimento; i++) {
              if (EstabelecimentoComercial.listaEstabelecimentoComercial.get(i).cnpj.equals(cnpjEstabelecimento) &&
                      EstabelecimentoComercial.listaEstabelecimentoComercial.get(i).tipoDoEstabelecimento.equals("MERCADO")) {
                estabelecimento = false;
                continue;
              }
            }

            if (estabelecimento) {
              System.out.println(">>");
              System.out.println(">> Este estabelecimento só aceita vale alimentação. Tente novamente!");
            }
          } while (estabelecimento);

          do {
            try {
              transacaoOK = false;
              System.out.println(">>>");
              System.out.println(">>> Digite o valor da compra:");
              System.out.print(">> Valor (somente números): ");
              valorTransacao = Double.parseDouble(entrada.nextLine().trim());
            } catch (InputMismatchException e) {
              System.out.print(">> Você só pode digitar números! Tente novamente!");
              transacaoOK = true;
              continue;
            }

            //valida regras de transação
            if (valorTransacao < 0) {
              System.out.println(">>>");
              System.out.println(">>> Você só pode digitar valores positivos! Tente novamente! ");
              transacaoOK = true;
              continue;
            } else if (valorTransacao > saldoAtual) {
              System.out.println(">>>");
              System.out.println(">>> Você não tem saldo suficiente para uma compra nesse valor! Tente novamente! ");
              transacaoOK = true;
              continue;

              //regra específica vale alimentação
            } else if (valorTransacao > 999) {
              System.out.println(">>>");
              System.out.println(">>> O valor da compra não pode ser maior que R$999! Tente novamente! ");
              transacaoOK = true;
              continue;

              //Não devemos passar duas compras do mesmo valor em um período de 10
              //segundos.
            } else if (!TransacaoAleloAlimentacao.verificaDuasComprasMesmoValor(TransacaoAleloAlimentacao.listaTransacaoAleloAlimentacao, valorTransacao)) {
              System.out.println(">>>");
              System.out.println(">>> Não é possível fazer duas compras no mesmo valor em menos de 10 segundos! Tente mais tarde! ");
              transacaoOK = true;
              continue;

              //Não devemos passar três compras no mesmo cartão em um período de 30
              //segundos.
            } else if (!TransacaoAleloAlimentacao.verificaTresComprasMesmoCartao(TransacaoAleloAlimentacao.listaTransacaoAleloAlimentacao, numeroDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> Não é possível fazer três compras no mesmo cartão em menos de 30 segundos! Tente mais tarde! ");
              transacaoOK = true;
              continue;

            } else {
              dataHoraTransacao = LocalDateTime.now();
              numeroTransacao = TransacaoAleloAlimentacao.idTipoCartao + TransacaoAleloAlimentacao.incrementoTransacaoALI++;
              valorReceitaAlelo = ControleReceitaAlelo.setSaldoAlelo(valorTransacao);
              idControleAlelo = ControleReceitaAlelo.incrementoControle++;
              valorCashback = valorTransacao * 0.03;

              //Atualiza o saldo do cartão mediante a compra e deposita o cashback recebido
              AleloAlimentacao.listaAleloAlimentacao.get(index).saldo -= valorTransacao;
              AleloAlimentacao.listaAleloAlimentacao.get(index).saldo += valorCashback;

              //Deposita valor da receita da transferência no saldo da Alelo(5%)
              ControleReceitaAlelo.setSaldoAlelo(valorTransacao);

              //Cria nova posição na lista com esta transação
              TransacaoAleloAlimentacao.listaTransacaoAleloAlimentacao.add(new TransacaoAleloAlimentacao(
                      numeroTransacao, dataHoraTransacao, numeroDoCartao, cnpjEstabelecimento, "ALIMENTACAO",
                      valorTransacao, valorCashback));

              //Cria nova posição na lista com esta transação
              ControleReceitaAlelo.listaExtratoControleReceitaAlelo.add(new ControleReceitaAlelo
                      (idControleAlelo, numeroTransacao, dataHoraTransacao, numeroDoCartao,
                              cnpjEstabelecimento, "ALIMENTACAO", valorTransacao, valorReceitaAlelo));

              System.out.println(">>>");
              System.out.println(">>> Compra efetuada com sucesso! ");
              System.out.printf(">>> Você recebeu R$%.2f de cashback.%n", valorCashback);
              AleloAlimentacao.mostraSaldoALI(index);

            }

          } while (transacaoOK);
        }
        case '2' -> {

          do {
            erro = false;
            cartaoCorreto = false;
            System.out.println(">>>");
            System.out.println("> Menu > Cadastrar transação > Vale Mobilidade");
            System.out.println(">>>");
            System.out.println(">>> É necessário logar no sistema.");
            System.out.println(">>>");
            System.out.println(">>> Digite o número do cartão (16 dígitos):");
            System.out.print(">> Número do cartão (somente números): ");
            numeroDoCartao = entrada.nextLine().trim();
            AleloMobilidade.removeCaracteresEspeciaisNumeroCartao(numeroDoCartao);
            System.out.println(">>>");
            System.out.println(">>> Digite o CVV do cartão (3 dígitos):");
            System.out.print(">> CVV (somente números): ");
            codigoDeSeguranca = entrada.nextLine().trim();
            System.out.println(">>>");
            System.out.println(">>> Digite sua senha (4 dígitos):");
            System.out.print(">> Senha (somente números): ");
            senhaDoCartao = entrada.nextLine().trim();

            //Busca data de validade do cartão e converte para LocalDate
            for (i = 0; i < AleloMobilidade.listaAleloMobilidade.size(); i++) {
              if (AleloMobilidade.listaAleloMobilidade.get(i).numeroDoCartao.equals(numeroDoCartao)) {
                String data = AleloMobilidade.listaAleloMobilidade.get(i).dataDeValidade;
                data = data.substring(0, 2) + "/" + data.substring(2, 4) +
                        "/" + data.substring(4, 8);
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataDeValidade = LocalDate.parse(data, formatador);
                index = i;
                erro = false;
              }
            }

            if (numeroDoCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (dataDeValidade.compareTo(LocalDate.now()) < 0) {
              System.out.println(">>>");
              System.out.println(">>> Este cartão está vencido há " +
                      ChronoUnit.DAYS.between(dataDeValidade, LocalDateTime.now()) + " dia(s).");
              System.out.println(">>> Você não pode usá-lo para comprar!");
              erro = true;
              continue;
            }

            if (codigoDeSeguranca.length() != 3) {
              System.out.println(">>>");
              System.out.println(">>> O CVV precisa ter 3 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", codigoDeSeguranca)) {
              System.out.println(">>>");
              System.out.println(">>> O CVV só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }

            if (senhaDoCartao.length() != 4) {
              System.out.println(">>>");
              System.out.println(">>> A senha precisa ter 4 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", senhaDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> A senha só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }

            //Verifica se já existem os dados de login informados
            for (i = 0; i < AleloMobilidade.listaAleloMobilidade.size(); i++) {
              if (AleloMobilidade.listaAleloMobilidade.get(i).numeroDoCartao.equals(numeroDoCartao) &&
                      AleloMobilidade.listaAleloMobilidade.get(i).senha.equals(senhaDoCartao) &&
                      AleloMobilidade.listaAleloMobilidade.get(i).codigoDeSeguranca.equals(codigoDeSeguranca)) {
                saldoAtual = AleloMobilidade.listaAleloMobilidade.get(i).saldo;
                erro = false;
                cartaoCorreto = true;
              }
            }

            if (cartaoCorreto) {
              System.out.println(">>>");
              System.out.println(">>> Login concluído com sucesso!");
            } else {
              System.out.println(">>>");
              System.out.println(">>> Número do cartão e/ou senha incorretos. Tente novamente!");
            }
          } while (erro);

          do {
            estabelecimento = true;
            System.out.println(">>>");
            System.out.println(">>> Digite o CNPJ do estabelecimento (14 dígitos):");
            System.out.print(">>> CNPJ (Somente número): ");
            cnpjEstabelecimento = entrada.nextLine().trim();
            cnpjEstabelecimento = EstabelecimentoComercial.removeCaracteresEspeciaisCNPJ(cnpjEstabelecimento);
            cnpjValido = EstabelecimentoComercial.verificarCNPJ(cnpjEstabelecimento);

            if (cnpjEstabelecimento.length() != 14) {
              System.out.println(">>>");
              System.out.println(">>> O CNPJ precisa ter 14 números. Digite novamente!");
              estabelecimento = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", cnpjEstabelecimento)) {
              System.out.println(">>>");
              System.out.println(">>> O CNPJ só pode ter números. Digite novamente!");
              estabelecimento = true;
              continue;
            } else if (!cnpjValido) {
              System.out.println(">>");
              System.out.println(">> O CNPJ digitado não é válido. Digite novamente!");
              estabelecimento = true;
              continue;
            }
            for (i = 0; i < EstabelecimentoComercial.tamanhoListaEstabelecimento; i++) {
              if (EstabelecimentoComercial.listaEstabelecimentoComercial.get(i).cnpj.equals(cnpjEstabelecimento) &&
                      EstabelecimentoComercial.listaEstabelecimentoComercial.get(i).tipoDoEstabelecimento.equals("POSTO_COMBUSTIVEL")) {
                estabelecimento = false;
                continue;
              }
            }

            if (estabelecimento) {
              System.out.println(">>");
              System.out.println(">> Este estabelecimento só aceita vale mobilidade. Tente novamente!");
            }
          } while (estabelecimento);

          do {
            try {
              transacaoOK = false;
              System.out.println(">>>");
              System.out.println(">>> Digite o valor da compra:");
              System.out.print(">> Valor (somente números): ");
              valorTransacao = Double.parseDouble(entrada.nextLine().trim());
            } catch (InputMismatchException e) {
              System.out.print(">> Você só pode digitar números! Tente novamente!");
              transacaoOK = true;
              continue;
            }

            //valida regras de transação
            if (valorTransacao < 0) {
              System.out.println(">>>");
              System.out.println(">>> Você só pode digitar valores positivos! Tente novamente! ");
              transacaoOK = true;
              continue;
            } else if (valorTransacao > saldoAtual) {
              System.out.println(">>>");
              System.out.println(">>> Você não tem saldo suficiente para uma compra nesse valor! Tente novamente! ");
              transacaoOK = true;
              continue;

              //Não devemos passar duas compras do mesmo valor em um período de 10
              //segundos.
            } else if (!TransacaoAleloMobilidade.verificaDuasComprasMesmoValor(TransacaoAleloMobilidade.listaTransacaoAleloMobilidade, valorTransacao)) {
              System.out.println(">>>");
              System.out.println(">>> Não é possível fazer duas compras no mesmo valor em menos de 10 segundos! Tente mais tarde! ");
              transacaoOK = true;
              continue;

              //Não devemos passar três compras no mesmo cartão em um período de 30
              //segundos.
            } else if (!TransacaoAleloMobilidade.verificaTresComprasMesmoCartao(TransacaoAleloMobilidade.listaTransacaoAleloMobilidade, numeroDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> Não é possível fazer três compras no mesmo cartão em menos de 30 segundos! Tente mais tarde! ");
              transacaoOK = true;
              continue;

            } else {
              dataHoraTransacao = LocalDateTime.now();
              numeroTransacao = TransacaoAleloMobilidade.idTipoCartao + TransacaoAleloMobilidade.incrementoTransacaoMOB++;
              valorReceitaAlelo = ControleReceitaAlelo.setSaldoAlelo(valorTransacao);
              idControleAlelo = ControleReceitaAlelo.incrementoControle++;
              valorCashback = valorTransacao * 0.05;

              //Atualiza o saldo do cartão mediante a compra e deposita o cashback recebido
              AleloMobilidade.listaAleloMobilidade.get(index).saldo -= (valorTransacao + 1);
              AleloMobilidade.listaAleloMobilidade.get(index).saldo += valorCashback;

              //Deposita valor da receita da transferência no saldo da Alelo(5%)
              ControleReceitaAlelo.setSaldoAlelo(valorTransacao);

              //Cria nova posição na lista com esta transação
              TransacaoAleloMobilidade.listaTransacaoAleloMobilidade.add(new TransacaoAleloMobilidade(
                      numeroTransacao, dataHoraTransacao, numeroDoCartao, cnpjEstabelecimento, "MOBILIDADE",
                      valorTransacao, valorCashback));

              ControleReceitaAlelo.listaExtratoControleReceitaAlelo.add(new ControleReceitaAlelo
                      (idControleAlelo, numeroTransacao, dataHoraTransacao, numeroDoCartao,
                              cnpjEstabelecimento, "MOBILIDADE", valorTransacao, valorReceitaAlelo));

              System.out.println(">>>");
              System.out.println(">>> Compra efetuada com sucesso! ");
              System.out.println(">>> Foi descontado R$1,00 de taxa pela transação! ");
              System.out.printf(">>> Você recebeu R$%.2f de cashback.%n", valorCashback);
              AleloMobilidade.mostraSaldoMOB(index);

            }

          } while (transacaoOK);
        }
        case '3' -> {

          do {
            erro = false;
            cartaoCorreto = false;
            System.out.println(">>>");
            System.out.println("> Menu > Cadastrar transação > Vale Multibenefícios");
            System.out.println(">>>");
            System.out.println(">>> É necessário logar no sistema.");
            System.out.println(">>>");
            System.out.println(">>> Digite o número do cartão (16 dígitos):");
            System.out.print(">> Número do cartão (somente números): ");
            numeroDoCartao = entrada.nextLine().trim();
            AleloMobilidade.removeCaracteresEspeciaisNumeroCartao(numeroDoCartao);
            System.out.println(">>>");
            System.out.println(">>> Digite o CVV do cartão (3 dígitos):");
            System.out.print(">> CVV (somente números): ");
            codigoDeSeguranca = entrada.nextLine().trim();
            System.out.println(">>>");
            System.out.println(">>> Digite sua senha (4 dígitos):");
            System.out.print(">> Senha (somente números): ");
            senhaDoCartao = entrada.nextLine().trim();

            //Busca data de validade do cartão e converte para LocalDate
            for (i = 0; i < AleloMultibeneficios.listaAleloMultibeneficios.size(); i++) {
              if (AleloMultibeneficios.listaAleloMultibeneficios.get(i).numeroDoCartao.equals(numeroDoCartao)) {
                String data = AleloMultibeneficios.listaAleloMultibeneficios.get(i).dataDeValidade;
                data = data.substring(0, 2) + "/" + data.substring(2, 4) +
                        "/" + data.substring(4, 8);
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataDeValidade = LocalDate.parse(data, formatador);
                index = i;
                erro = false;
              }
            }

            if (numeroDoCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (dataDeValidade.compareTo(LocalDate.now()) < 0) {
              System.out.println(">>>");
              System.out.println(">>> Este cartão está vencido há " +
                      ChronoUnit.DAYS.between(dataDeValidade, LocalDateTime.now()) + " dia(s).");
              System.out.println(">>> Você não pode usá-lo para comprar!");
              erro = true;
              continue;
            }

            if (codigoDeSeguranca.length() != 3) {
              System.out.println(">>>");
              System.out.println(">>> O CVV precisa ter 3 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", codigoDeSeguranca)) {
              System.out.println(">>>");
              System.out.println(">>> O CVV só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }

            if (senhaDoCartao.length() != 4) {
              System.out.println(">>>");
              System.out.println(">>> A senha precisa ter 4 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", senhaDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> A senha só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }

            //Verifica se já existem os dados de login informados
            for (i = 0; i < AleloMultibeneficios.listaAleloMultibeneficios.size(); i++) {
              if (AleloMultibeneficios.listaAleloMultibeneficios.get(i).numeroDoCartao.equals(numeroDoCartao) &&
                      AleloMultibeneficios.listaAleloMultibeneficios.get(i).senha.equals(senhaDoCartao) &&
                      AleloMultibeneficios.listaAleloMultibeneficios.get(i).codigoDeSeguranca.equals(codigoDeSeguranca)) {
                saldoAtual = AleloMultibeneficios.listaAleloMultibeneficios.get(i).saldo;
                erro = false;
                cartaoCorreto = true;
              }
            }

            if (cartaoCorreto) {
              System.out.println(">>>");
              System.out.println(">>> Login concluído com sucesso!");
            } else {
              System.out.println(">>>");
              System.out.println(">>> Número do cartão e/ou senha incorretos. Tente novamente!");
            }
          } while (erro);

          do {
            estabelecimento = true;
            System.out.println(">>>");
            System.out.println(">>> Digite o CNPJ do estabelecimento (14 dígitos):");
            System.out.print(">>> CNPJ (Somente número): ");
            cnpjEstabelecimento = entrada.nextLine().trim();
            cnpjEstabelecimento = EstabelecimentoComercial.removeCaracteresEspeciaisCNPJ(cnpjEstabelecimento);
            cnpjValido = EstabelecimentoComercial.verificarCNPJ(cnpjEstabelecimento);

            if (cnpjEstabelecimento.length() != 14) {
              System.out.println(">>>");
              System.out.println(">>> O CNPJ precisa ter 14 números. Digite novamente!");
              estabelecimento = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", cnpjEstabelecimento)) {
              System.out.println(">>>");
              System.out.println(">>> O CNPJ só pode ter números. Digite novamente!");
              estabelecimento = true;
              continue;
            } else if (!cnpjValido) {
              System.out.println(">>");
              System.out.println(">> O CNPJ digitado não é válido. Digite novamente!");
              estabelecimento = true;
              continue;
            }
            for (i = 0; i < EstabelecimentoComercial.tamanhoListaEstabelecimento; i++) {
              if (EstabelecimentoComercial.listaEstabelecimentoComercial.get(i).cnpj.equals(cnpjEstabelecimento) &&
                      EstabelecimentoComercial.listaEstabelecimentoComercial.get(i).tipoDoEstabelecimento.equals("FARMACIA")) {
                estabelecimento = false;
                continue;
              }
            }

            if (estabelecimento) {
              System.out.println(">>");
              System.out.println(">> Este estabelecimento só aceita vale multibenefícios. Tente novamente!");
            }

          } while (estabelecimento);

          do {
            try {
              transacaoOK = false;
              System.out.println(">>>");
              System.out.println(">>> Digite o valor da compra:");
              System.out.print(">> Valor (somente números): ");
              valorTransacao = Double.parseDouble(entrada.nextLine().trim());
            } catch (InputMismatchException e) {
              System.out.print(">> Você só pode digitar números! Tente novamente!");
              transacaoOK = true;
              continue;
            }

            //valida regras de transação
            if (valorTransacao < 0) {
              System.out.println(">>>");
              System.out.println(">>> Você só pode digitar valores positivos! Tente novamente! ");
              transacaoOK = true;
              continue;
            } else if (valorTransacao > saldoAtual) {
              System.out.println(">>>");
              System.out.println(">>> Você não tem saldo suficiente para uma compra nesse valor! Tente novamente! ");
              transacaoOK = true;
              continue;

              //Não devemos passar duas compras do mesmo valor em um período de 10
              //segundos.
            } else if (!TransacaoAleloMultibeneficios.verificaDuasComprasMesmoValor(TransacaoAleloMultibeneficios.listaTransacaoAleloMultibeneficios, valorTransacao)) {
              System.out.println(">>>");
              System.out.println(">>> Não é possível fazer duas compras no mesmo valor em menos de 10 segundos! Tente mais tarde! ");
              transacaoOK = true;
              continue;

              //Não devemos passar três compras no mesmo cartão em um período de 30
              //segundos.
            } else if (!TransacaoAleloMultibeneficios.verificaTresComprasMesmoCartao(TransacaoAleloMultibeneficios.listaTransacaoAleloMultibeneficios, numeroDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> Não é possível fazer três compras no mesmo cartão em menos de 30 segundos! Tente mais tarde! ");
              transacaoOK = true;
              continue;

            } else {
              dataHoraTransacao = LocalDateTime.now();
              numeroTransacao = TransacaoAleloMultibeneficios.idTipoCartao + TransacaoAleloMultibeneficios.incrementoTransacaoMUL++;
              valorReceitaAlelo = ControleReceitaAlelo.setSaldoAlelo(valorTransacao);
              idControleAlelo = ControleReceitaAlelo.incrementoControle++;
              valorCashback = valorTransacao * 0.04;

              //Atualiza o saldo do cartão mediante a compra e deposita o cashback recebido
              AleloMultibeneficios.listaAleloMultibeneficios.get(index).saldo -= valorTransacao;
              AleloMultibeneficios.listaAleloMultibeneficios.get(index).saldo += valorCashback;

              //Deposita valor da receita da transferência no saldo da Alelo(5%)
              ControleReceitaAlelo.setSaldoAlelo(valorTransacao);

              //Cria nova posição na lista com esta transação
              TransacaoAleloMultibeneficios.listaTransacaoAleloMultibeneficios.add(new TransacaoAleloMultibeneficios(
                      numeroTransacao, dataHoraTransacao, numeroDoCartao, cnpjEstabelecimento, "MULTIBENEFICIOS",
                      valorTransacao, valorCashback));

              ControleReceitaAlelo.listaExtratoControleReceitaAlelo.add(new ControleReceitaAlelo
                      (idControleAlelo, numeroTransacao, dataHoraTransacao, numeroDoCartao,
                              cnpjEstabelecimento, "MULTIBENEFICIOS", valorTransacao, valorReceitaAlelo));

              System.out.println(">>>");
              System.out.println(">>> Compra efetuada com sucesso! ");
              System.out.printf(">>> Você recebeu R$%.2f de cashback.%n", valorCashback);
              AleloMultibeneficios.mostraSaldoMUL(index);
            }
          } while (transacaoOK);

        }
        case '4' -> {

          do {
            erro = false;
            cartaoCorreto = false;
            System.out.println(">>>");
            System.out.println("> Menu > Cadastrar transação > Vale Refeição");
            System.out.println(">>>");
            System.out.println(">>> É necessário logar no sistema.");
            System.out.println(">>>");
            System.out.println(">>> Digite o número do cartão (16 dígitos):");
            System.out.print(">> Número do cartão (somente números): ");
            numeroDoCartao = entrada.nextLine().trim();
            AleloMobilidade.removeCaracteresEspeciaisNumeroCartao(numeroDoCartao);
            System.out.println(">>>");
            System.out.println(">>> Digite o CVV do cartão (3 dígitos):");
            System.out.print(">> CVV (somente números): ");
            codigoDeSeguranca = entrada.nextLine().trim();
            System.out.println(">>>");
            System.out.println(">>> Digite sua senha (4 dígitos):");
            System.out.print(">> Senha (somente números): ");
            senhaDoCartao = entrada.nextLine().trim();

            //Busca data de validade do cartão e converte para LocalDate
            for (i = 0; i < AleloRefeicao.listaAleloRefeicao.size(); i++) {
              if (AleloRefeicao.listaAleloRefeicao.get(i).numeroDoCartao.equals(numeroDoCartao)) {
                String data = AleloRefeicao.listaAleloRefeicao.get(i).dataDeValidade;
                data = data.substring(0, 2) + "/" + data.substring(2, 4) +
                        "/" + data.substring(4, 8);
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataDeValidade = LocalDate.parse(data, formatador);
                index = i;
                erro = false;
              }
            }

            if (numeroDoCartao.length() != 16) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão precisa ter 16 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", numeroDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> O número do cartão só pode ter números. Digite novamente!");
              erro = true;
              continue;
            } else if (dataDeValidade.compareTo(LocalDate.now()) < 0) {
              System.out.println(">>>");
              System.out.println(">>> Este cartão está vencido há " +
                      ChronoUnit.DAYS.between(dataDeValidade, LocalDateTime.now()) + " dia(s).");
              System.out.println(">>> Você não pode usá-lo para comprar!");
              erro = true;
              continue;
            }

            if (codigoDeSeguranca.length() != 3) {
              System.out.println(">>>");
              System.out.println(">>> O CVV precisa ter 3 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", codigoDeSeguranca)) {
              System.out.println(">>>");
              System.out.println(">>> O CVV só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }

            if (senhaDoCartao.length() != 4) {
              System.out.println(">>>");
              System.out.println(">>> A senha precisa ter 4 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", senhaDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> A senha só pode ter números. Digite novamente!");
              erro = true;
              continue;
            }

            //Verifica se já existem os dados de login informados
            for (i = 0; i < AleloRefeicao.listaAleloRefeicao.size(); i++) {
              if (AleloRefeicao.listaAleloRefeicao.get(i).numeroDoCartao.equals(numeroDoCartao) &&
                      AleloRefeicao.listaAleloRefeicao.get(i).senha.equals(senhaDoCartao) &&
                      AleloRefeicao.listaAleloRefeicao.get(i).codigoDeSeguranca.equals(codigoDeSeguranca)) {
                saldoAtual = AleloRefeicao.listaAleloRefeicao.get(i).saldo;
                erro = false;
                cartaoCorreto = true;
              }
            }

            if (cartaoCorreto) {
              System.out.println(">>>");
              System.out.println(">>> Login concluído com sucesso!");
            } else {
              System.out.println(">>>");
              System.out.println(">>> Número do cartão e/ou senha incorretos. Tente novamente!");
            }
          } while (erro);

          do {
            estabelecimento = true;
            System.out.println(">>>");
            System.out.println(">>> Digite o CNPJ do estabelecimento (14 dígitos):");
            System.out.print(">>> CNPJ (Somente número): ");
            cnpjEstabelecimento = entrada.nextLine().trim();
            cnpjEstabelecimento = EstabelecimentoComercial.removeCaracteresEspeciaisCNPJ(cnpjEstabelecimento);
            cnpjValido = EstabelecimentoComercial.verificarCNPJ(cnpjEstabelecimento);

            if (cnpjEstabelecimento.length() != 14) {
              System.out.println(">>>");
              System.out.println(">>> O CNPJ precisa ter 14 números. Digite novamente!");
              estabelecimento = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", cnpjEstabelecimento)) {
              System.out.println(">>>");
              System.out.println(">>> O CNPJ só pode ter números. Digite novamente!");
              estabelecimento = true;
              continue;
            } else if (!cnpjValido) {
              System.out.println(">>");
              System.out.println(">> O CNPJ digitado não é válido. Digite novamente!");
              estabelecimento = true;
              continue;
            }
            for (i = 0; i < EstabelecimentoComercial.tamanhoListaEstabelecimento; i++) {
              if (EstabelecimentoComercial.listaEstabelecimentoComercial.get(i).cnpj.equals(cnpjEstabelecimento) &&
                      EstabelecimentoComercial.listaEstabelecimentoComercial.get(i).tipoDoEstabelecimento.equals("RESTAURANTE")) {
                estabelecimento = false;
                continue;
              }
            }

            if (estabelecimento) {
              System.out.println(">>");
              System.out.println(">> Este estabelecimento só aceita vale multibenefícios. Tente novamente!");
            }

          } while (estabelecimento);

          do {
            try {
              transacaoOK = false;
              System.out.println(">>>");
              System.out.println(">>> Digite o valor da compra:");
              System.out.print(">> Valor (somente números): ");
              valorTransacao = Double.parseDouble(entrada.nextLine().trim());
            } catch (InputMismatchException e) {
              System.out.print(">> Você só pode digitar números! Tente novamente!");
              transacaoOK = true;
              continue;
            }

            //valida regras de transação
            if (valorTransacao < 0) {
              System.out.println(">>>");
              System.out.println(">>> Você só pode digitar valores positivos! Tente novamente! ");
              transacaoOK = true;
              continue;
            } else if (valorTransacao > saldoAtual) {
              System.out.println(">>>");
              System.out.println(">>> Você não tem saldo suficiente para uma compra nesse valor! Tente novamente! ");
              transacaoOK = true;
              continue;

              //regra específica vale alimentação
            } else if (valorTransacao > 299) {
              System.out.println(">>>");
              System.out.println(">>> O valor da compra não pode ser maior que R$299! Tente novamente! ");
              transacaoOK = true;
              continue;

              //Não devemos passar duas compras do mesmo valor em um período de 10
              //segundos.
            } else if (!TransacaoAleloRefeicao.verificaDuasComprasMesmoValor(TransacaoAleloRefeicao.listaTransacaoAleloRefeicao, valorTransacao)) {
              System.out.println(">>>");
              System.out.println(">>> Não é possível fazer duas compras no mesmo valor em menos de 10 segundos! Tente mais tarde! ");
              transacaoOK = true;
              continue;

              //Não devemos passar três compras no mesmo cartão em um período de 30
              //segundos.
            } else if (!TransacaoAleloRefeicao.verificaTresComprasMesmoCartao(TransacaoAleloRefeicao.listaTransacaoAleloRefeicao, numeroDoCartao)) {
              System.out.println(">>>");
              System.out.println(">>> Não é possível fazer três compras no mesmo cartão em menos de 30 segundos! Tente mais tarde! ");
              transacaoOK = true;
              continue;

            } else {
              dataHoraTransacao = LocalDateTime.now();
              numeroTransacao = TransacaoAleloRefeicao.idTipoCartao + TransacaoAleloRefeicao.incrementoTransacaoREF++;
              valorReceitaAlelo = ControleReceitaAlelo.setSaldoAlelo(valorTransacao);
              idControleAlelo = ControleReceitaAlelo.incrementoControle++;
              valorCashback = valorTransacao * 0.02;

              //Atualiza o saldo do cartão mediante a compra e deposita o cashback recebido
              AleloRefeicao.listaAleloRefeicao.get(index).saldo -= valorTransacao;
              AleloRefeicao.listaAleloRefeicao.get(index).saldo += valorCashback;

              //Deposita valor da receita da transferência no saldo da Alelo(5%)
              ControleReceitaAlelo.setSaldoAlelo(valorTransacao);

              //Cria nova posição na lista com esta transação
              TransacaoAleloRefeicao.listaTransacaoAleloRefeicao.add(new TransacaoAleloRefeicao(
                      numeroTransacao, dataHoraTransacao, numeroDoCartao, cnpjEstabelecimento, "REFEICAO",
                      valorTransacao, valorCashback));

              ControleReceitaAlelo.listaExtratoControleReceitaAlelo.add(new ControleReceitaAlelo
                      (idControleAlelo, numeroTransacao, dataHoraTransacao, numeroDoCartao,
                              cnpjEstabelecimento, "REFEICAO", valorTransacao, valorReceitaAlelo));

              System.out.println(">>>");
              System.out.println(">>> Compra efetuada com sucesso! ");
              System.out.printf(">>> Você recebeu R$%.2f de cashback.%n", valorCashback);
              AleloRefeicao.mostraSaldoREF(index);
            }
          } while (transacaoOK);

        }
        case '5' -> opcaoUsuario = true;
        default -> System.out.println(">> Opção inválida! Digite uma opção entre 1 e 5.");
      }

    } while (!opcaoUsuario);

  }

  //Método para inicializar a lista de estabelecimento com um de cada tipo
  public static void inicializaCartao() {

    //ALIMENTAÇÃO
    AleloAlimentacao.listaAleloAlimentacao.add(new AleloAlimentacao(
            AleloAlimentacao.incrementoCartaoALI++, "4539839271076914",
            "31596431075", "20092023", "191", "Alelo Alimentação",
            "1234", 600.0));

    //MOBILIDADE
    AleloMobilidade.listaAleloMobilidade.add(new AleloMobilidade(

            AleloMobilidade.incrementoCartaoMOB++, "4485790206992754",
            "79174676008", "20092023", "986", "Alelo Mobilidade",
            "1234", 600.0));

    //MULTIBENEFÍCIOS
    AleloMultibeneficios.listaAleloMultibeneficios.add(new AleloMultibeneficios(
            AleloMultibeneficios.incrementoCartaoMUL++, "4726009639461538",
            "08637103014", "20092023", "521", "Alelo Multibenefícios",
            "1234", 600.0));

    //REFEIÇÃO
    AleloRefeicao.listaAleloRefeicao.add(new AleloRefeicao(
            AleloRefeicao.incrementoCartaoREF++, "4024007178852751",
            "46097780095", "20092023", "616", "Alelo Refeição",
            "1234", 600.0));

  }


  //Método sair do programa
  public static void sairPrograma() {
    System.out.println(">");
    System.out.println("> Agradecemos a sua preferência por nossos serviços.");
    System.out.println(">");
    System.out.println("> Fazemos sempre o nosso melhor para garantir o melhor pra você.");
    System.out.println("> Afinal de contas, temos o mesmo sangue! #sangueverde.");
    System.out.println(">");
    System.out.println("> Conte sempre com a gente! ;D");
    System.exit(0);
  }

  //Método para invocar o menu após o acesso inicial ao programa
  public static void inicializaMenu() {

    //Instancia a classe Scanner para receber dados do usuário
    Scanner entrada = new Scanner(System.in);

    //Variáveis necessárias
    Character opcaoMenu;
    Boolean escolhaValidaMenu;

    //Inicia laço para informar opções possíveis no programa e direcionar o usuário
    //para a função desejada
    do {
      escolhaValidaMenu = false;
      System.out.println(">");
      System.out.println("> Gerenciador de Cartões Alelo");
      System.out.println(">");
      System.out.println("> Menu");
      System.out.println(">");
      System.out.println("> Digite uma das opções abaixo:");
      System.out.println("> [0] Cadastrar portador de cartão ");
      System.out.println("> [1] Consultar portador de cartão");
      System.out.println("> [2] Cadastrar cartão");
      System.out.println("> [3] Consultar cartão");
      System.out.println("> [4] Cadastrar estabelecimento comercial");
      System.out.println("> [5] Consultar estabelecimento comercial");
      System.out.println("> [6] Incluir saldo em um cartão");
      System.out.println("> [7] Consultar saldo do cartão");
      System.out.println("> [8] Realizar compra/transação");
      System.out.println("> [9] Consultar extrato de um cartão");
      System.out.println("> [A] Consultar saldo receita Alelo");
      System.out.println("> [B] Consultar extrato receitas Alelo");
      System.out.println("> [C] Sair do programa");
      System.out.print("> Opção: ");
      opcaoMenu = entrada.nextLine().toUpperCase().trim().charAt(0);

      //Usa condicional para direcionar o usuário para a função escolhida do programa
      switch (opcaoMenu) {
        case '0' -> PortadorDoCartao.cadastrarPortadorCartao();
        case '1' -> PortadorDoCartao.consultarPortadorCartao();
        case '2' -> Utilidades.cadastrarCartao();
        case '3' -> Utilidades.consultarCartao();
        case '4' -> EstabelecimentoComercial.cadastrarEstabelecimentoComercial();
        case '5' -> EstabelecimentoComercial.consultarEstabelecimentoComercial();
        case '6' -> Utilidades.incluirSaldo();
        case '7' -> Utilidades.consultarSaldo();
        case '8' -> Utilidades.realizarTransacao();
        case '9' -> Utilidades.consultarExtrato();
        case 'A' -> ControleReceitaAlelo.consultarSaldoAlelo();
        case 'B' -> ControleReceitaAlelo.consultarExtratoAlelo();
        case 'C' -> Utilidades.sairPrograma();
        default -> System.out.println("> Opção inválida! Escolha uma das opções disponíveis");
      }
    } while (!escolhaValidaMenu);
  }
}
