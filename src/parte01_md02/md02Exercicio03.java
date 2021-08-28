package parte01_md02;

//Importa o pacote necessário para receber entrada pelo usuário
import java.util.Scanner;

/** Classe com a implementação do "exercício04" do material "md02".
 * Curso Java - Share RH & Alelo"
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 * */
public class md02Exercicio03 {

  /** Roda o programa principal. */
  public static void main(String[] args) {

    //Instancia o objeto in para receber as entradas do usuário
    Scanner in = new Scanner(System.in);

    //Retorna na tela informando nome do programa e solicita entrada do usuário
    System.out.println("Confere qual de 2 números é menor");
    System.out.println("Digite o primeiro número:");

    //Atribui o valor digitado na variável referente a idade
    int a1 = in.nextInt();

    System.out.println("Digite o primeiro número:");
    int a2 = in.nextInt();

    //Verifica quem é menor e retorna mensagem na tela
    if (a1 < a2) {
      System.out.println("O número " + a1 + " é menor que o número " + a2 + "!\n");
    } else if (a1 > a2) {
      System.out.println("O número " + a2 + " é menor que o número " + a1 + "!\n");
    } else {
      System.out.println("Não é possível comparar quem é menor,pois os números são iguais!\n");
    }

    //Retorna na tela informando nome do programa e solicita entrada do usuário
    System.out.println("Confere qual de 2 números é maior");
    System.out.println("Digite o primeiro número:");

    //Atribui o valor digitado na variável referente a idade
    int a3 = in.nextInt();

    System.out.println("Digite o primeiro número:");
    int a4 = in.nextInt();

    //Verifica quem é menor e retorna mensagem na tela
    if (a3 > a4) {
      System.out.println("O número " + a3 + " é maior que o número " + a4 + "!\n");
    } else if (a3 < a4) {
      System.out.println("O número " + a4 + " é maior que o número " + a3 + "!\n");
    } else {
      System.out.println("Não é possível comparar quem é maior,pois os números são iguais!\n");
    }

    //Finaliza o recurso do Scanner
    in.close();
  }
}
