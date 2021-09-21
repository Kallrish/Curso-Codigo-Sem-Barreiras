package projetoempresadecartaodebeneficios.Etapa03;

//Importa classes necessárias para o programa

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
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
public class PortadorDoCartao {

  //Variável para controle incremental do cadastro de portadores
  public static Integer incrementoPortador = 1;

  //Variável auxiliar para receber tamanho da lista de portador
  public static Integer tamanhoListaPortador;

  //Atributos obrigatórios da entidade
  public Integer idPortadorDoCartao;
  public String nome;
  public String cpf;
  public String dataDeNascimento;

  //Cria uma lista com os beneficiários
  public static ArrayList<PortadorDoCartao> listaPortadoresDoCartao = new ArrayList<>();

  //Construtor padrão
  public PortadorDoCartao() {
  }

  //Construtor com passagem de parâmetros
  public PortadorDoCartao(Integer idPortadorDoCartao, String nome, String cpf, String dataDeNascimento) {

    this.idPortadorDoCartao = idPortadorDoCartao;
    this.nome = nome;
    this.cpf = cpf;
    this.dataDeNascimento = dataDeNascimento;
  }

  //Verifica se o CPF é valido
  public static Boolean verificarCPF(String CPF) {

    //Verifica se o CPF usa somente um número repetido
    if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
      return false;

    Character digito10, digito11;
    Integer soma, i, j, numero, peso;

    //"try-catch" para prevenção contra erros de conversão de tipo (Integer)
    try {
      //Calcula primeiro dígito verificador
      soma = 0;
      peso = 10;

      for (i = 0; i < 9; i++) {
        //Converte o caractere na posição i do CPF em um número
        //(48 é a posição de '0' na tabela ASCII)
        numero = (int) (CPF.charAt(i) - 48);
        soma = soma + (numero * peso);
        peso = peso - 1;
      }

      j = 11 - (soma % 11);
      if ((j == 10) || (j == 11))
        digito10 = '0';
      else
        //Converte no respectivo caractere numérico
        digito10 = (char) (j + 48);

      //Calcula segundo dígito verificador
      soma = 0;
      peso = 11;

      for (i = 0; i < 10; i++) {
        numero = (int) (CPF.charAt(i) - 48);
        soma = soma + (numero * peso);
        peso = peso - 1;
      }

      j = 11 - (soma % 11);
      if ((j == 10) || (j == 11))
        digito11 = '0';
      else
        digito11 = (char) (j + 48);

      //Verifica se os dígitos calculados conferem com os dígitos informados
      return (digito10 == CPF.charAt(9)) && (digito11 == CPF.charAt(10));

    } catch (InputMismatchException erro) {
      return false;
    }
  }

  //Retira os caracteres especiais do CPF, caso não sejam digitados só números, para evitar erros
  public static String removeCaracteresEspeciaisCPF(String documento) {

    if (documento.contains("."))
      documento = documento.replace(".", "");
    if (documento.contains("-"))
      documento = documento.replace("-", "");

    return documento;
  }

//  //Método que verifica se a data inserida é válida
//  public static boolean verificarData(String data) {
//    Boolean testeA, testeB;
//    try {
//      SimpleDateFormat formatadorA = new SimpleDateFormat("dd/MM/yyyy");
//      //Testa datas falsas
//      formatadorA.setLenient(false);
//      //Tenta conversão para String
//      formatadorA.parse(data);
//      testeA = true;
//    } catch (ParseException e) {
//      testeA = false;
//    }
//    //Testa se a data é menor que a date atual
//    DateTimeFormatter formatadorA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//    LocalDate dataVerificada = LocalDate.parse(data, formatadorA);
//    LocalDate hoje = LocalDate.now();
//    testeB = dataVerificada.compareTo(hoje) <= 0;
//
//    return (testeA && !testeB);
//  }

  //Retorna o CPF formatado corretamente com o uso de máscara
  public static void mostraCPF(Integer index) {

    //Busca o atributo gravado na lista
    String CPF = PortadorDoCartao.listaPortadoresDoCartao.get(index).cpf;
    CPF = CPF.substring(0, 3) + "." + CPF.substring(3, 6) +
            "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11);
    System.out.printf(">> * CPF: %n>> * %s%n", CPF);
  }

  //Método que exibe o nome do portador
  public static void mostraNome(Integer index) {

    //Busca o atributo gravado na lista
    String nomePortador = PortadorDoCartao.listaPortadoresDoCartao.get(index).nome;
    System.out.printf(">> * Nome: %n>> * %s%n", nomePortador);
  }

  //Retorna a data de nascimento formatado corretamente com o uso de máscara
  public static void mostraDataDeNascimento(Integer index) {

    //Busca o atributo gravado na lista
    String dataNascimento = PortadorDoCartao.listaPortadoresDoCartao.get(index).dataDeNascimento;
    dataNascimento = dataNascimento.substring(0, 2) + "/" + dataNascimento.substring(2, 4) +
            "/" + dataNascimento.substring(4, 8);

    System.out.printf(">> * Data de nascimento: %n>> * %s%n", dataNascimento);
  }

  //Método que exibe o id de cadastro do portador
  public static void mostraIdPortador(Integer index) {

    //Busca o atributo gravado na lista
    Integer idPortador = PortadorDoCartao.listaPortadoresDoCartao.get(index).idPortadorDoCartao;
    System.out.printf(">> * ID: %n>> * %s%n", idPortador);
  }

  //Método para cadastrar um portador de cartão
  public static void cadastrarPortadorCartao() {

    //Declaração de variáveis necessárias
    String nome;
    String cpf;
    String dataDeNascimento;
    Character continuaCadastro;
    Boolean opcaoUsuario, CPFValido, dataDeNascimentoValida, erro;
    Integer i;

    //Instancia o Scanner para receber dados de entrada do usuário
    Scanner entrada = new Scanner(System.in);

    do {
      opcaoUsuario = false;
      erro = false;
      dataDeNascimentoValida = false;

      System.out.println(">>");
      System.out.println("> Menu > Cadastrar portador do cartão");
      System.out.println(">>");
      System.out.println(">> Digite o número referente a opção desejada:");
      System.out.println(">> [1] Cadastrar um portador do cartão");
      System.out.println(">> [2] Voltar para o menu principal");
      System.out.print(">> Opção: ");
      continuaCadastro = entrada.nextLine().trim().charAt(0);

      tamanhoListaPortador = PortadorDoCartao.listaPortadoresDoCartao.size();

      switch (continuaCadastro) {
        case '1' -> {

          do {
            erro = false;
            System.out.println(">>");
            System.out.println(">> Digite o CPF do portador (11 dígitos):");
            System.out.print(">> CPF (somente números): ");
            cpf = entrada.nextLine().trim();
            cpf = PortadorDoCartao.removeCaracteresEspeciaisCPF(cpf);
            CPFValido = PortadorDoCartao.verificarCPF(cpf);

            if (cpf.length() != 11) {
              System.out.println(">>>");
              System.out.println(">>> O CPF precisa ter 11 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", cpf)) {
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

            for (i = 0; i < tamanhoListaPortador; i++) {
              if (PortadorDoCartao.listaPortadoresDoCartao.get(i).cpf.equals(cpf)) {
                System.out.println(">>");
                System.out.println(">> Este CPF já está cadastro. Favor informar outro!");
                erro = true;
              }
            }

          } while (erro);
          System.out.println(">>");
          System.out.println(">> Digite o nome:");
          System.out.print(">> Nome: ");
          nome = entrada.nextLine().trim();

          do {
            System.out.println(">>");
            System.out.println(">> Digite a data de nascimento (8 dígitos):");
            System.out.print(">> Data de nascimento (somente números): ");
            dataDeNascimento = entrada.nextLine().trim();

            if (dataDeNascimento.length() != 8) {
              System.out.println(">>>");
              System.out.println(">>> A data de nascimento precisa ter 8 números. Digite novamente!");
            } else if (Pattern.matches("[a-zA-Z]+", dataDeNascimento)) {
              System.out.println(">>>");
              System.out.println(">>> A data de nascimento só pode ter números. Digite novamente!");
            } else {
              dataDeNascimentoValida = true;
            }

            if (!dataDeNascimentoValida) {
              System.out.println(">>");
              System.out.println(">> A data de nascimento digitado não é válida. Tente novamente!");
            }

          } while (!dataDeNascimentoValida);

          PortadorDoCartao.listaPortadoresDoCartao.add(new PortadorDoCartao(incrementoPortador++, nome,
                  cpf, dataDeNascimento));

          System.out.println(">>");
          System.out.println(">> Cadastro de portador concluído com sucesso!");

        }
        case '2' -> opcaoUsuario = true;
        default -> System.out.println(">> Opção inválida! Digite um número entre 1 e 2!");
      }

    } while (!opcaoUsuario);
  }

  //Método para cadastrar um portador de cartão
  public static void consultarPortadorCartao() {

    //Declaração de variáveis necessárias
    String cpf;
    Character continuaConsulta;
    Boolean opcaoUsuario, CPFValido, CPFEncontrado, erro;
    Integer i;

    //Instancia o Scanner para receber dados de entrada do usuário
    Scanner entrada = new Scanner(System.in);

    do {
      opcaoUsuario = false;
      CPFValido = false;
      erro = false;
      CPFEncontrado = false;

      System.out.println(">>");
      System.out.println("> Menu > Consultar portador do cartão");
      System.out.println(">>");
      System.out.println(">> Digite o número referente a opção desejada:");
      System.out.println(">> [1] Consultar um portador de cartão");
      System.out.println(">> [2] Voltar para o menu principal");
      System.out.print(">> Opção: ");
      continuaConsulta = entrada.nextLine().trim().charAt(0);

      tamanhoListaPortador = PortadorDoCartao.listaPortadoresDoCartao.size();

      switch (continuaConsulta) {
        case '1' -> {

          do {
            erro = false;
            System.out.println(">>");
            System.out.println(">> Digite o CPF do portador (11 dígitos):");
            System.out.print(">> CPF (somente números): ");
            cpf = entrada.nextLine().trim();
            cpf = PortadorDoCartao.removeCaracteresEspeciaisCPF(cpf);
            CPFValido = PortadorDoCartao.verificarCPF(cpf);

            if (cpf.length() != 11) {
              System.out.println(">>>");
              System.out.println(">>> O CPF precisa ter 11 números. Digite novamente!");
              erro = true;
              continue;
            } else if (Pattern.matches("[a-zA-Z]+", cpf)) {
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
          } while (erro);

          for (i = 0; i < tamanhoListaPortador; i++) {
            if (PortadorDoCartao.listaPortadoresDoCartao.get(i).cpf.equals(cpf)) {
              CPFEncontrado = true;
              System.out.println(">>");
              mostraIdPortador(i);
              mostraCPF(i);
              mostraNome(i);
              mostraDataDeNascimento(i);
            }
          }

          if (!CPFEncontrado) {
            System.out.println(">>");
            System.out.println(">> Número do CPF não está cadastrado no sistema.");
            System.out.println(">> Tente novamente!");
          }
        }
        case '2' -> opcaoUsuario = true;
        default -> System.out.println(">> Opção inválida! Digite um número entre 1 e 2!");
      }
    } while (!opcaoUsuario);
  }

  //Método para inicializar a lista de estabelecimento com um de cada tipo
  public static void inicializaPortador() {

    //ALIMENTACAO
    PortadorDoCartao.listaPortadoresDoCartao.add(new PortadorDoCartao(
            incrementoPortador++, "Ana", "31596431075", "12101982"));
    //MOBILIDADE
    PortadorDoCartao.listaPortadoresDoCartao.add(new PortadorDoCartao(
            incrementoPortador++, "Roberto", "79174676008",  "03281995"));
    //MULTIBENEFICIO
    PortadorDoCartao.listaPortadoresDoCartao.add(new PortadorDoCartao(
            incrementoPortador++, "Mara", "08637103014", "02161984"));
    //REFEICAO
    PortadorDoCartao.listaPortadoresDoCartao.add(new PortadorDoCartao(
            incrementoPortador++, "Pedro", "46097780095", "03011988"));

  }

}
