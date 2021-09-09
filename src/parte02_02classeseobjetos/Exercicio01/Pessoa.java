package parte02_02classeseobjetos.Exercicio01;

//Importa o pacote necessário para receber entrada pelo usuário

import java.time.LocalDate;

/**
 * Classe com a implementação da "parte 02" do "exercício01" do material "02classeseobjetos".
 * Curso Java - Share RH & Alelo"
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 */
public class Pessoa {

  //Cria variáveis necessárias
  public String nome;
  public Integer anoDeNascimento;
  public Float altura;

  //Método que retorna a idade atual da pessoa
  public void calculaIdade() {
    Integer anoAtual = LocalDate.now().getYear();
    Integer idade = anoAtual - this.anoDeNascimento;
    System.out.println("A idade da pessoa é: " + idade + " anos.");
  }

  //Método que retorna na tela todos os dados da pessoa impressos
  public void imprimeDados() {
    System.out.println("\nDados da pessoa: ");
    System.out.println("------------------");
    System.out.printf("Nome: %s, Altura: %.2f, Ano de Nascimento: %d%n",
            this.nome,
            this.altura,
            this.anoDeNascimento);
    System.out.println("------------------");
  }

  //Altera o método toString()
  @Override
  public String toString() {
    return "Pessoa{" +
            "nome='" + nome + '\'' +
            ", anoDeNascimento=" + anoDeNascimento +
            ", altura=" + altura +
            '}';
  }

}