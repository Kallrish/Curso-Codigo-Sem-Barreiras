package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Beneficiario {

  static ArrayList<Pessoa> beneficiarios = new ArrayList<>();

  public static void cadastrarBeneficiario() {

    try (Scanner in = new Scanner(System.in)) {

      System.out.println("=======================================");
      System.out.println("Cadastro de beneficiário");
      System.out.println("=======================================");
      System.out.println("1 - Insira o nome do beneficiário:");
      System.out.println("Insira o nome do beneficiário:");
      Pessoa pessoa = new Pessoa();
      pessoa.nome = in.nextLine().trim();
      System.out.println("---------------------------------------");
      System.out.println("2 - Dados do Vale Alimentação");
      System.out.println("Insira a senha de 4 dígitos do cartão:");
      pessoa.cartao1.senha = in.nextLine().trim();
      pessoa.dataDoCadastro = LocalDate.now();
      pessoa.cartao1.validade = pessoa.dataDoCadastro.plusYears(2);
      pessoa.cartao1.transacoes = new ArrayList<>();
      System.out.println("---------------------------------------");
      System.out.println("3 - Dados do Vale Refeição");
      System.out.println("Insira a senha de 4 dígitos do cartão:");
      pessoa.cartao2.senha = in.nextLine().trim();
      pessoa.dataDoCadastro = LocalDate.now();
      pessoa.cartao2.validade = pessoa.dataDoCadastro.plusYears(2);
      pessoa.cartao2.transacoes = new ArrayList<>();
      System.out.println("---------------------------------------");
      System.out.println("4 - Dados do Vale Transporte");
      System.out.println("Insira a senha de 4 dígitos do cartão:");
      pessoa.cartao3.senha = in.nextLine().trim();
      pessoa.dataDoCadastro = LocalDate.now();
      pessoa.cartao3.validade = pessoa.dataDoCadastro.plusYears(2);
      pessoa.cartao3.transacoes = new ArrayList<>();
      System.out.println("---------------------------------------");
      System.out.println("Cadastro realizado com sucesso!");
      beneficiarios.add(pessoa);

    }
  }

  public static void imprimeBeneficiario() {

   for (Pessoa beneficiario : beneficiarios) {
    System.out.println(beneficiario);
   }

  }
}