package projetoempresadecartaodebeneficios.Etapa03;

//Importa bibliotecas/classes necessárias para o programa

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
public class EstabelecimentoComercial {

  //Variável para controle incremental do cadastro de estabelecimentos
  public static Integer incrementoEstabelecimento = 1;

  //Variável auxiliar para receber tamanho da lista de portador
  public static Integer tamanhoListaEstabelecimento;

  //Atributos obrigatórios da entidade
  public Integer idEstabelecimentoComercial;
  public String cnpj;
  public String razaoSocial;
  public String estadoUF;
  public String tipoDoEstabelecimento;

  //Cria uma lista com os beneficiários
  public static ArrayList<EstabelecimentoComercial> listaEstabelecimentoComercial = new ArrayList<>();

  //Construtor padrão
  public EstabelecimentoComercial() {

  }

  //Construtor com passagem de parâmetros
  public EstabelecimentoComercial(Integer idEstabelecimentoComercial, String cnpj, String razaoSocial,
                                  String estadoUF, String tipoDoEstabelecimento) {
    this.idEstabelecimentoComercial = idEstabelecimentoComercial;
    this.cnpj = cnpj;
    this.razaoSocial = razaoSocial;
    this.estadoUF = estadoUF;
    this.tipoDoEstabelecimento = tipoDoEstabelecimento;
  }

  //Verifica se o CNPJ é valido
  public static Boolean verificarCNPJ(String CNPJ) {

    //Verifica se o CNPJ usa somente um número repetido
    if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
            CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
            CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
            CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
            CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
            (CNPJ.length() != 14))
      return false;

    Character digito13, digito14;
    Integer soma, i, j, numero, peso;

    //"try-catch" para prevenção contra erros de conversão de tipo (Integer)
    try {
      //Calcula primeiro dígito verificador
      soma = 0;
      peso = 2;

      for (i = 11; i >= 0; i--) {
        //Converte o caractere na posição i do CNPJ em um número
        //(48 é a posição de '0' na tabela ASCII)
        numero = (Integer) (CNPJ.charAt(i) - 48);
        soma = soma + (numero * peso);
        peso = peso + 1;
        if (peso == 10)
          peso = 2;
      }

      j = soma % 11;
      if ((j == 0) || (j == 1))
        digito13 = '0';
      else
        digito13 = (char) ((11 - j) + 48);

      //Calcula segundo dígito verificador
      soma = 0;
      peso = 2;

      for (i = 12; i >= 0; i--) {
        numero = (int) (CNPJ.charAt(i) - 48);
        soma = soma + (numero * peso);
        peso = peso + 1;
        if (peso == 10)
          peso = 2;
      }

      j = soma % 11;
      if ((j == 0) || (j == 1))
        digito14 = '0';
      else
        digito14 = (char) ((11 - j) + 48);

      //Verifica se os dígitos calculados conferem com os dígitos informados
      return (digito13 == CNPJ.charAt(12)) && (digito14 == CNPJ.charAt(13));

      } catch(InputMismatchException erro){
        return false;
      }
    }

    //Retira os caracteres especiais do CNPJ, caso não sejam digitados só números, para evitar erros
    public static String removeCaracteresEspeciaisCNPJ (String documento){

      if (documento.contains("."))
        documento = documento.replace(".", "");
      if (documento.contains("-"))
        documento = documento.replace("-", "");
      if (documento.contains("/"))
        documento = documento.replace("/", "");

      return documento;
    }

    //Retorna o CNPJ formatado corretamente com o uso de máscara
    public static void mostraCNPJ (Integer index){

      //Busca o atributo gravado na lista
      String CNPJ = EstabelecimentoComercial.listaEstabelecimentoComercial.get(index).cnpj;
      CNPJ = CNPJ.substring(0, 2) + "." + CNPJ.substring(2, 5) +
              "." + CNPJ.substring(5, 8) + "." + CNPJ.substring(8, 12) + "-" +
              CNPJ.substring(12, 14);
      System.out.printf(">> * CNPJ: %n>> * %s%n", CNPJ);
    }

    //Método que exibe a razão social do estabelecimento
    public static void mostraRazaoSocial (Integer index){

      //Busca o atributo gravado na lista
      String razaoSocial = EstabelecimentoComercial.listaEstabelecimentoComercial.get(index).razaoSocial;
      System.out.printf(">> * Razão social: %n>> * %s%n", razaoSocial);
    }

    //Método que exibe o estadoUF do estabelecimento
    public static void mostraEstadoUF (Integer index){

      //Busca o atributo gravado na lista
      String uf = EstabelecimentoComercial.listaEstabelecimentoComercial.get(index).estadoUF;
      System.out.printf(">> * Estado (UF): %n>> * %s%n", uf);
    }

    //Método que exibe o estadoUF do estabelecimento
    public static void mostraTipoDoEstabelecimento (Integer index){

      //Busca o atributo gravado na lista
      String tipo = EstabelecimentoComercial.listaEstabelecimentoComercial.get(index).tipoDoEstabelecimento;
      System.out.printf(">> * Tipo do estabelecimento: %n>> * %s%n", tipo);
    }

    //Método que exibe o id de cadastro do estabelecimento
    public static void mostraIdPortador (Integer index){

      //Busca o atributo gravado na lista
      Integer idEstabelecimento = EstabelecimentoComercial.listaEstabelecimentoComercial.get(index).idEstabelecimentoComercial;
      System.out.printf(">> * ID: %n>> * %s%n", idEstabelecimento);
    }

    public static void cadastrarEstabelecimentoComercial () {
      //Declaração de variáveis necessárias
      String razaoSocial;
      String cnpj;
      String tipoEstabelecimento = "";
      String estado;
      Character continuaCadastroA;
      Character continuaCadastroB;
      Boolean opcaoUsuario, CNPJValido, estadoValido, tipoValido, erro;
      Integer i;

      //Instancia o Scanner para receber dados de entrada do usuário
      Scanner entrada = new Scanner(System.in);

      do {
        opcaoUsuario = false;
        CNPJValido = false;
        estadoValido = false;
        tipoValido = false;
        erro = false;
        System.out.println(">>");
        System.out.println("> Menu > Cadastrar estabelecimento comercial");
        System.out.println(">>");
        System.out.println(">> Digite o número referente a opção desejada:");
        System.out.println(">> [1] Cadastrar um estabelecimento comercial");
        System.out.println(">> [2] Voltar para o menu principal");
        System.out.print(">> Opção: ");
        continuaCadastroA = entrada.nextLine().trim().charAt(0);

        tamanhoListaEstabelecimento = EstabelecimentoComercial.listaEstabelecimentoComercial.size();

        switch (continuaCadastroA) {
          case '1' -> {
            do {
              erro = false;
              System.out.println(">>");
              System.out.println(">> Digite o CNPJ do portador (14 dígitos):");
              System.out.print(">> CNPJ (somente números): ");
              cnpj = entrada.nextLine().trim();
              cnpj = EstabelecimentoComercial.removeCaracteresEspeciaisCNPJ(cnpj);
              CNPJValido = EstabelecimentoComercial.verificarCNPJ(cnpj);

              if (cnpj.length() != 14) {
                System.out.println(">>>");
                System.out.println(">>> O CNPJ precisa ter 14 números. Digite novamente!");
                erro = true;
                continue;
              } else if (Pattern.matches("[a-zA-Z]+", cnpj)) {
                System.out.println(">>>");
                System.out.println(">>> O CNPJ só pode ter números. Digite novamente!");
                erro = true;
                continue;
              } else if (!CNPJValido) {
                System.out.println(">>");
                System.out.println(">> O CNPJ digitado não é válido. Digite novamente!");
                erro = true;
                continue;
              }

              for (i = 0; i < tamanhoListaEstabelecimento; i++) {
                if (EstabelecimentoComercial.listaEstabelecimentoComercial.get(i).cnpj.equals(cnpj)) {
                  System.out.println(">>");
                  System.out.println(">> Este CNPJ já está cadastro. Favor informar outro!");
                  erro = true;
                }
              }

            } while (erro);


            System.out.println(">>");
            System.out.println(">> Digite a razão social:");
            System.out.print(">> Razão social: ");
            razaoSocial = entrada.nextLine().trim();

            do {
            System.out.println(">>");
            System.out.println(">> Digite o estado (UF) - Somente duas letras");
            System.out.print(">> Estado (Ex.: MG): ");
            estado = entrada.nextLine().trim().toUpperCase();

            if (estado.length() != 2) {
              System.out.println(">>>");
              System.out.println(">>> O estado precisa ter 2 letras. Digite novamente!");
            } else if (Pattern.matches("[0-9]+", estado)) {
              System.out.println(">>>");
              System.out.println(">>> O estado só pode ter letras. Digite novamente!");
            } else {
              estadoValido = true;
            }
            } while (!estadoValido);

            do {
              System.out.println(">>");
              System.out.println(">> Digite qual o tipo do estabelecimento:");
              System.out.println("> [1] Farmácia ");
              System.out.println("> [2] Mercado");
              System.out.println("> [3] Restaurante");
              System.out.println("> [4] Posto de Combustível");
              System.out.print(">> Tipo: ");
              continuaCadastroB = entrada.nextLine().trim().charAt(0);

              switch (continuaCadastroB) {
                case '1' -> {
                  tipoEstabelecimento = "FARMACIA";
                  tipoValido = true;
                }
                case '2' -> {
                  tipoEstabelecimento = "MERCADO";
                  tipoValido = true;
                }
                case '3' -> {
                  tipoEstabelecimento = "RESTAURANTE";
                  tipoValido = true;
                }
                case '4' -> {
                  tipoEstabelecimento = "POSTO_COMBUSTIVEL";
                  tipoValido = true;
                }
                default -> {
                  if (!tipoValido) {
                    System.out.println(">>");
                    System.out.println(">> O tipo digitado não é válido. Tente novamente!");
                  }
                }
              }
            } while (!tipoValido);


            EstabelecimentoComercial.listaEstabelecimentoComercial.add(new EstabelecimentoComercial
                    (incrementoEstabelecimento++, cnpj, razaoSocial, estado, tipoEstabelecimento));

            System.out.println(">>");
            System.out.println(">> Cadastro de portador concluído com sucesso!");

          }
          case '2' -> opcaoUsuario = true;
          default -> System.out.println(">> Opção inválida! Digite um número entre 1 e 2!");
        }
      } while (!opcaoUsuario);
    }

    public static void consultarEstabelecimentoComercial () {

      //Declaração de variáveis necessárias
      String cnpj;
      Character continuaConsulta;
      Boolean opcaoUsuario, CNPJValido, CNPJEncontrado, erro;
      Integer i;

      //Instancia o Scanner para receber dados de entrada do usuário
      Scanner entrada = new Scanner(System.in);

      do {
        opcaoUsuario = false;
        CNPJValido = false;
        erro = false;
        CNPJEncontrado = false;

        System.out.println(">>");
        System.out.println("> Menu > Consultar estabelecimento comercial");
        System.out.println(">>");
        System.out.println(">> Digite o número referente a opção desejada:");
        System.out.println(">> [1] Consultar um estabelecimento comercial");
        System.out.println(">> [2] Voltar para o menu principal");
        System.out.print(">> Opção: ");
        continuaConsulta = entrada.nextLine().trim().charAt(0);

        tamanhoListaEstabelecimento = EstabelecimentoComercial.listaEstabelecimentoComercial.size();

        switch (continuaConsulta) {
          case '1' -> {

            do {
              erro = false;
              System.out.println(">>");
              System.out.println(">> Digite o CNPJ do portador (14 dígitos):");
              System.out.print(">> CNPJ (somente números): ");
              cnpj = entrada.nextLine().trim();
              cnpj = EstabelecimentoComercial.removeCaracteresEspeciaisCNPJ(cnpj);
              CNPJValido = EstabelecimentoComercial.verificarCNPJ(cnpj);

              if (cnpj.length() != 14) {
                System.out.println(">>>");
                System.out.println(">>> O CNPJ precisa ter 14 números. Digite novamente!");
                erro = true;
                continue;
              } else if (Pattern.matches("[a-zA-Z]+", cnpj)) {
                System.out.println(">>>");
                System.out.println(">>> O CNPJ só pode ter números. Digite novamente!");
                erro = true;
                continue;
              } else if (!CNPJValido) {
                System.out.println(">>");
                System.out.println(">> O CNPJ digitado não é válido. Digite novamente!");
                erro = true;
                continue;
              }

            } while (erro);

            for (i = 0; i < tamanhoListaEstabelecimento; i++) {
              if (EstabelecimentoComercial.listaEstabelecimentoComercial.get(i).cnpj.equals(cnpj)) {
                CNPJEncontrado = true;
                System.out.println(">>");
                mostraIdPortador(i);
                mostraCNPJ(i);
                mostraRazaoSocial(i);
                mostraTipoDoEstabelecimento(i);
              }
            }

            if (!CNPJEncontrado) {
              System.out.println(">>");
              System.out.println(">> Número do CNPJ não está cadastrado no sistema.");
              System.out.println(">> Tente novamente!");
            }
          }
          case '2' -> opcaoUsuario = true;
          default -> System.out.println(">> Opção inválida! Digite um número entre 1 e 2!");
        }
      } while (!opcaoUsuario);
    }

    //Método para inicializar a lista de estabelecimento com um de cada tipo
    public static void inicializaEstabelecimentoComercial () {

      //FARMACIA
      EstabelecimentoComercial.listaEstabelecimentoComercial.add(new EstabelecimentoComercial(
              incrementoEstabelecimento++, "58368261000149", "Farmácia do Povo", //58368261000149
              "SP", "FARMACIA"));
      //MERCADO
      EstabelecimentoComercial.listaEstabelecimentoComercial.add(new EstabelecimentoComercial(
              incrementoEstabelecimento++, "20432057000177", "Mercado São José",
              "MG", "MERCADO"));
      //RESTAURANTE
      EstabelecimentoComercial.listaEstabelecimentoComercial.add(new EstabelecimentoComercial(
              incrementoEstabelecimento++, "06050170000167", "Deluxe China",
              "SC", "RESTAURANTE"));
      //POSTO_COMBUSTIVEL
      EstabelecimentoComercial.listaEstabelecimentoComercial.add(new EstabelecimentoComercial(
              incrementoEstabelecimento++, "60230435000154", "Posto Prata",
              "BA", "POSTO_COMBUSTIVEL"));

    }

  }