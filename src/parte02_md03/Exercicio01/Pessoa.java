package parte02_md03.Exercicio01;

//Importa o pacote necessário para receber entrada pelo usuário

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Classe com a implementação da "parte 02" do "exercício01" do material "md03".
 * Curso Java - Share RH & Alelo"
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 */
public class Pessoa {

  private String nome;
  private String datadenascimento;
  private double altura;

  public Pessoa(String nome, String datadenascimento, double altura) {
    this.nome = nome;
    this.datadenascimento = datadenascimento;
    this.altura = altura;
  }

  public String getNome() {
    return this.nome;
  }

  public void getDataDeNascimento() {

    DateTimeFormatter formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dtnasc = LocalDate.parse(datadenascimento, formatoBrasil);
    System.out.printf("Data de Nascimento: %S\n", dtnasc);
  }

  public double getAltura() {
    return this.altura;
  }

  public void calculaIdade() {
    DateTimeFormatter formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate dtnasc = LocalDate.parse(datadenascimento, formatoBrasil);
    LocalDate dataPessoa = LocalDate.of(dtnasc.getYear(), dtnasc.getMonth(), dtnasc.getDayOfMonth());
    LocalDate dataAgora = LocalDate.now();
    Period periodo = Period.between(dataPessoa, dataAgora);
    System.out.printf("A idade da pessoa é: %d anos\n", periodo.getYears());
  }

  public void imprimeDados() {
    System.out.println("\nDados da pessoa: ");
    System.out.println("------------------");
    System.out.printf("Nome: %s\n", getNome());
    getDataDeNascimento();
    System.out.printf("Altura: %.2f\n", getAltura());
    System.out.println("------------------");
  }

  public static void main(String[] args) {

    Pessoa pessoa1 = new Pessoa("Joana D'ark Rizzo", "23/06/1990", 1.60);

    pessoa1.imprimeDados();

    pessoa1.calculaIdade();

  }
}

