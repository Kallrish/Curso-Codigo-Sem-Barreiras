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

  public Beneficiario() {

  }

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
        System.out.println("Cadastro de beneficiário");
        System.out.println("==================================================================");
        System.out.println("Insira o nome do(a) beneficiário(a):");
        System.out.print("Nome: ");
        nomeBeneficiario1 = in.nextLine().trim();
        listaBeneficiarios.add(new Beneficiario(incrementoIdentificadorBeneficiario++,
                nomeBeneficiario1));
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("Cadastro realizado com sucesso!");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Deseja cadastrar outro beneficiário?");
        System.out.println("Digite \"s\" para SIM e \"n\" para NÃO.");
        System.out.print("Opção: ");
        opcao = in.nextLine().trim().toLowerCase().charAt(0);
      } while (opcao == 's');
  }

  public String getNomeBeneficiario() {
    return nomeBeneficiario;
  }

  public void setNomeBeneficiario(String nomeBeneficiario) {
    this.nomeBeneficiario = nomeBeneficiario;
  }

}