package parte01_md02;

//Importa o pacote necessário para receber entrada pelo usuário
import java.util.Scanner;

/** Classe com a implementação do "exercício04" do material "md02".
 * Curso Java - Share RH & Alelo"
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 * */
public class md02Exercicio01 {

  /** Roda o programa principal. */
  public static void main(String[] args) {

    //Instancia o objeto in para receber as entradas do usuário
    Scanner in = new Scanner(System.in);

    //Retorna na tela informando nome do programa e solicita entrada do usuário
    System.out.println("Teste - Par ou Ímpar");
    System.out.println("Digite um número:");

    //Atribui o valor digitado na variável referente ao número
    int valor = in.nextInt();

    //Confere se o número é par ou ímpar e retorna mensagem na tela
    if (valor % 2 == 0) {
      System.out.println("O número " +  valor + " é par!");
    } else {
      System.out.println("O número " +  valor + " é ímpar!");
    }

    //Finaliza o recurso do Scanner
    in.close();
  }
}
