package projetoempresadecartaodebeneficios.Etapa02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    Scanner in = new Scanner(System.in);

    String nomeBeneficiario1;

    char opcao = 's';

    do {
      System.out.println("==================================================================");
      System.out.println("= Cadastro inicial de beneficiário                               =");
      System.out.println("==================================================================");
      System.out.println("- Insira o nome do(a) beneficiário(a):                           -");
      System.out.print("- Nome: ");
      nomeBeneficiario1 = in.nextLine().trim();
      System.out.println("-                                                                -");


      boolean verificador = false;

      //Laço para percorrer a lista de beneficiários
      for (int i = 0; i < Beneficiario.listaBeneficiarios.size(); i++) {

        //Se o beneficiário já existe na lista, retorna erro
        if (Beneficiario.listaBeneficiarios.get(i).getNomeBeneficiario().equals(nomeBeneficiario1)) {
          System.out.println("------------------------------------------------------------------");
          System.out.println("- Já existe um beneficiário cadastrado com esse nome!            -");
          System.out.println("- Não é possível cadastrar dois nomes iguais!                    -");
          verificador = true;
        }
      }

      if (!verificador) {
        listaBeneficiarios.add(new Beneficiario(incrementoIdentificadorBeneficiario++,
                nomeBeneficiario1));

        System.out.println("------------------------------------------------------------------");
        System.out.println("- Cadastro realizado com sucesso!                                -");
        System.out.println("------------------------------------------------------------------");
      }

      System.out.println("-                                                                -");
      System.out.println("------------------------------------------------------------------");
      System.out.println("- Deseja cadastrar outro beneficiário?                           -");
      System.out.println("- Digite [s] para SIM e [n] para NÃO.                            -");
      System.out.println("------------------------------------------------------------------");
      System.out.print("- Opção: ");
      System.out.println("-                                                                -");
      opcao = in.nextLine().trim().toLowerCase().charAt(0);

      // Reinicia a variável para a próxima busca
      verificador = false;

    } while (opcao == 's');
  }

  public static void cadastrarBeneficiarioPrimeiraVez() {

    Scanner in = new Scanner(System.in);

    String nomeBeneficiario1;

    System.out.println("==================================================================");
    System.out.println("= Cadastro inicial de beneficiário                               =");
    System.out.println("==================================================================");
    System.out.println("- Insira o nome do(a) beneficiário(a):                           -");
    System.out.print("Nome: ");
    nomeBeneficiario1 = in.nextLine().trim();
    System.out.println("-                                                                -");
    listaBeneficiarios.add(new Beneficiario(incrementoIdentificadorBeneficiario++,
            nomeBeneficiario1));

    System.out.println("------------------------------------------------------------------");
    System.out.println(">>>Cadastro realizado com sucesso!<<<");
    System.out.println("------------------------------------------------------------------");
  }

  public String getNomeBeneficiario() {
    return nomeBeneficiario;
  }

  public void setNomeBeneficiario(String nomeBeneficiario) {
    this.nomeBeneficiario = nomeBeneficiario;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;

    if (!(obj instanceof Beneficiario))
      return false;

    if (obj == this)
      return true;

    Beneficiario p = (Beneficiario) obj;

    // Aqui você implementa como deve se feita a comparação.
    // Verifica se os nomes dos produtos são iguais, ids e etc.

    if (p.nomeBeneficiario == this.nomeBeneficiario) {
      return true;
    } else {
      return false;
    }
  }

}