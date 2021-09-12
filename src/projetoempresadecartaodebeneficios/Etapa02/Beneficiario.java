package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Beneficiario {

  static ArrayList<Pessoa> beneficiarios = new ArrayList<>();

  public static void cadastrarBeneficiario() {

    try (Scanner in = new Scanner(System.in)) {

      Pessoa pessoa = new Pessoa();
      char opcao;

      do {
       System.out.println("=======================================");
       System.out.println("Cadastro de beneficiário");
       System.out.println("=======================================");
       System.out.println("1 - Insira o nome do beneficiário:");
       System.out.println("Insira o nome do beneficiário:");
       pessoa.nome = in.nextLine().trim();
       System.out.println("---------------------------------------");
       System.out.println("2 - Dados do Vale Alimentação");
       System.out.println("Insira a senha de 4 dígitos do cartão:");
       pessoa.cartao1.senhaCartao = in.nextLine().trim();
       pessoa.dataDoCadastro = LocalDate.now();
       pessoa.cartao1.validadeCartao = pessoa.dataDoCadastro.plusYears(2);
       System.out.println("---------------------------------------");
       System.out.println("3 - Dados do Vale Refeição");
       System.out.println("Insira a senha de 4 dígitos do cartão:");
       pessoa.cartao2.senhaCartao = in.nextLine().trim();
       pessoa.dataDoCadastro = LocalDate.now();
       pessoa.cartao2.validadeCartao = pessoa.dataDoCadastro.plusYears(2);
       System.out.println("---------------------------------------");
       System.out.println("4 - Dados do Vale Transporte");
       System.out.println("Insira a senha de 4 dígitos do cartão:");
       pessoa.cartao3.senhaCartao = in.nextLine().trim();
       pessoa.dataDoCadastro = LocalDate.now();
       pessoa.cartao3.validadeCartao = pessoa.dataDoCadastro.plusYears(2);
       System.out.println("---------------------------------------");
       System.out.println("Cadastro realizado com sucesso!");
       beneficiarios.add(pessoa);
       System.out.println("---------------------------------------");
       System.out.println("Deseja cadastrar outro beneficiário?");
       System.out.println("Digite \"s\" para SIM e qualquer outra letra para sair.");
       opcao = in.nextLine().trim().toLowerCase().charAt(0);
      } while (opcao == 's');

    }
  }

}