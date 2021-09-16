package projetoempresadecartaodebeneficios.Etapa02;

//Importa bibliotecas
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Projeto Empresa de Cartão de Benefícios.- Etapa 02
 * Trabalho em grupo - Grupo JavAlelo.
 * Curso Java - Share RH & Alelo".
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas, Ana Paula Rodrigues,
 * @author Antônio Carlos, Natália, Karina, Giovanna, Cristovão, Sérgio.
 *
 * @version 2.5
 */

public class Beneficiario {

  //Cria variáveis necessárias para classe
  public static Integer incrementoIdentificadorBeneficiario = 1;

  //Cria as variáveis necessárias
  public Integer identificadorBeneficiario;
  public String nomeBeneficiario;


  //Cria uma lista com os beneficiários
  public static List<Beneficiario> listaBeneficiarios = new ArrayList<>();

  //Construtor padrão
  public Beneficiario() {

  }

  //Construtor com parâmetros
  public Beneficiario(Integer identificadorBeneficiario,
                      String nomeBeneficiario) {

    //Armazena variável de incremento para controlar o cadastro.
    this.identificadorBeneficiario = identificadorBeneficiario;
    //Armazena o nome passado por parâmetro
    this.nomeBeneficiario = nomeBeneficiario;
    //Indentifcadores serão criados junto com os cartões

  }

  public static void cadastrarBeneficiario() {

    //Instancia a classe Scanner para receber entrada de dados do usuário
    Scanner in = new Scanner(System.in);

    //Cria as variáveis
    String nomeBeneficiario1;
    char opcao = 's';

    //Recebe os dados do usuário e realiza o cadastro do beneficiário
    do {
      Ferramentas.imprimeLinhaDupla();
      System.out.println("= Cadastro inicial de beneficiário                               =");
      Ferramentas.imprimeLinhaDupla();
      System.out.println("- Insira o nome do(a) beneficiário(a):                           -");
      System.out.print("- Nome: ");
      nomeBeneficiario1 = in.nextLine().trim();
      Ferramentas.imprimeEspacador();

      boolean verificador = false;

      //Laço para percorrer a lista de beneficiários
      for (int i = 0; i < Beneficiario.listaBeneficiarios.size(); i++) {

        //Se o beneficiário já existe na lista, retorna erro
        if (Beneficiario.listaBeneficiarios.get(i).nomeBeneficiario.equals(nomeBeneficiario1)) {
          Ferramentas.imprimeLinha();
          System.out.println("- Já existe um beneficiário cadastrado com esse nome!            -");
          System.out.println("- Não é possível cadastrar dois nomes iguais!                    -");
          verificador = true;
        }
      }

      //Se o beneficiário não é repetido, realiza o cadastro
      if (!verificador) {
        listaBeneficiarios.add(new Beneficiario(incrementoIdentificadorBeneficiario++,
                nomeBeneficiario1));

        Ferramentas.imprimeLinha();
        System.out.println("- Cadastro realizado com sucesso!                                -");
        Ferramentas.imprimeLinha();
      }

      //
      Ferramentas.imprimeEspacador();
      Ferramentas.imprimeLinha();
      System.out.println("- Deseja cadastrar outro beneficiário?                           -");
      System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
      Ferramentas.imprimeLinha();
      System.out.print("- Opção: ");
      Ferramentas.imprimeEspacador();
      opcao = in.nextLine().trim().toLowerCase().charAt(0);

      // Reinicia a variável para a próxima busca
      verificador = false;

    } while (opcao == 's');
  }

  public static void cadastrarBeneficiarioPrimeiraVez() {

    //Instancia a classe Scanner para pegar entrada de dados do usuário
    Scanner in = new Scanner(System.in);

    //Cria as variáveis necessárias
    String nomeBeneficiario1;

    //Recebe os dados do usuário e cadastra o primeiro beneficiário na lista
    Ferramentas.imprimeLinhaDupla();
    System.out.println("= Cadastro inicial de beneficiário                               =");
    Ferramentas.imprimeLinhaDupla();
    System.out.println("- Insira o nome do(a) beneficiário(a):                           -");
    System.out.print("Nome: ");
    nomeBeneficiario1 = in.nextLine().trim();
    Ferramentas.imprimeEspacador();
    listaBeneficiarios.add(new Beneficiario(incrementoIdentificadorBeneficiario++,
            nomeBeneficiario1));
    Ferramentas.imprimeLinha();
    System.out.println("- Cadastro realizado com sucesso!                               - ");
    Ferramentas.imprimeLinha();
  }
}