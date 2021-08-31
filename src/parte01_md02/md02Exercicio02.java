package parte01_md02;

//Importa o pacote necessário para receber entrada pelo usuário
import java.util.Scanner;

/** Classe com a implementação "parte 01" do "exercício02" do material "md02".
 * Curso Java - Share RH & Alelo"
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 * */
public class md02Exercicio02 {

  /** Roda o programa principal. */
  public static void main(String[] args) {

    //Instancia o objeto in para receber as entradas do usuário
    Scanner in = new Scanner(System.in);

    //Retorna na tela informando nome do programa e solicita entrada do usuário
    System.out.println("Seleção de categoria de campeonato - Nadador");
    System.out.println("Digite a sua idade:");

    //Atribui o valor digitado na variável referente a idade
    int opcao = in.nextInt();

    //Confere se a idade e retorna a categoria na qual o nadador se encontra
    if (opcao >= 5 && opcao <= 7) {
      System.out.println("Sua categoria é Infantil A");
    } else if (opcao >= 8 && opcao <= 11){
      System.out.println("Sua categoria é Infantil B");
    } else if (opcao >= 12 && opcao <= 13){
      System.out.println("Sua categoria é Juvenil A");
    } else if (opcao >= 14 && opcao <= 17){
      System.out.println("Sua categoria é Juvenil B");
    } else if (opcao < 5){
      System.out.println("Você é muito novo pra competir!");
    } else{
      System.out.println("Sua categoria é Adultos");
    }
    //Finaliza o recurso do Scanner
    in.close();
  }
}
