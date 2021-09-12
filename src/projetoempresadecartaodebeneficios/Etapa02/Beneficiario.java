package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Beneficiario {

  //Cria as variáveis necessárias
  public String nomeBeneficiario;
  private String senhaBeneficiario;
  public String vaIdentificador;
  public String vrIdentificador;
  public String vcIdentificador;

  //Cria uma lista com os beneficiários
  public static List<Beneficiario> listaBeneficiarios = new ArrayList<>();


  public Beneficiario(String nomeBeneficiario, String senhaBeneficiario) {
    this.nomeBeneficiario = nomeBeneficiario;
    this.senhaBeneficiario = senhaBeneficiario;
  }

  public static void cadastrarBeneficiario(){

    try (Scanner in = new Scanner(System.in)) {

      //TODO implementar o cadastro com base na versão antiga
      char continua;
      do {

        //pegar os dados e joga em nas variáveis com nome abaixo
        //pega o in, guardar o nome em nomeBeneficiario1...

        listaBeneficiarios.add(new Beneficiario(nomeBeneficiario1, senhaBeneficiario1));

        //deseja continuar?
        if (continua == 's') {

        }

//        try (Scanner in = new Scanner(System.in)) {
//
//          Pessoa pessoa = new Pessoa();
//          char opcao;
//
//          do {
//            System.out.println("=======================================");
//            System.out.println("Cadastro de beneficiário");
//            System.out.println("=======================================");
//            System.out.println("1 - Insira o nome do beneficiário:");
//            System.out.println("Insira o nome do beneficiário:");
//            pessoa.nome = in.nextLine().trim();
//            System.out.println("---------------------------------------");
//            System.out.println("2 - Dados do Vale Alimentação");
//            System.out.println("Insira a senha de 4 dígitos do cartão:");
//            pessoa.cartao1.senhaCartao = in.nextLine().trim();
//            pessoa.dataDoCadastro = LocalDate.now();
//            pessoa.cartao1.validadeCartao = pessoa.dataDoCadastro.plusYears(2);
//            System.out.println("---------------------------------------");
//            System.out.println("3 - Dados do Vale Refeição");
//            System.out.println("Insira a senha de 4 dígitos do cartão:");
//            pessoa.cartao2.senhaCartao = in.nextLine().trim();
//            pessoa.dataDoCadastro = LocalDate.now();
//            pessoa.cartao2.validadeCartao = pessoa.dataDoCadastro.plusYears(2);
//            System.out.println("---------------------------------------");
//            System.out.println("4 - Dados do Vale Transporte");
//            System.out.println("Insira a senha de 4 dígitos do cartão:");
//            pessoa.cartao3.senhaCartao = in.nextLine().trim();
//            pessoa.dataDoCadastro = LocalDate.now();
//            pessoa.cartao3.validadeCartao = pessoa.dataDoCadastro.plusYears(2);
//            System.out.println("---------------------------------------");
//            System.out.println("Cadastro realizado com sucesso!");
//            beneficiarios.add(pessoa);
//            System.out.println("---------------------------------------");
//            System.out.println("Deseja cadastrar outro beneficiário?");
//            System.out.println("Digite \"s\" para SIM e qualquer outra letra para sair.");
//            opcao = in.nextLine().trim().toLowerCase().charAt(0);
//          } while (opcao == 's');

        }


      } while (continua);

    }

  }

  public String getNomeBeneficiario() {
    return nomeBeneficiario;
  }

  public void setNomeBeneficiario(String nomeBeneficiario) {
    this.nomeBeneficiario = nomeBeneficiario;
  }

  public String getSenhaBeneficiario() {
    return senhaBeneficiario;
  }

  public void setSenhaBeneficiario(String senhaBeneficiario) {
    this.senhaBeneficiario = senhaBeneficiario;
  }

  public String getVaIdentificador() {
    return vaIdentificador;
  }

  public void setVaIdentificador(String vaIdentificador) {
    this.vaIdentificador = vaIdentificador;
  }

  public String getVrIdentificador() {
    return vrIdentificador;
  }

  public void setVrIdentificador(String vrIdentificador) {
    this.vrIdentificador = vrIdentificador;
  }

  public String getVcIdentificador() {
    return vcIdentificador;
  }

  public void setVcIdentificador(String vcIdentificador) {
    this.vcIdentificador = vcIdentificador;
  }

}