package parte01_md02;

//Importa o pacote necessário para receber entrada pelo usuário
import java.util.Scanner;

/** Classe com a implementação do "exercício04" do material "md02".
 * Curso Java - Share RH & Alelo"
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 * */
public class md02Exercicio04 {

  /** Roda o programa principal. */
  public static void main(String[] args) {

    //Instancia o objeto in para receber as entradas do usuário
    Scanner in = new Scanner(System.in);

    //Retorna na tela informando nome do programa e solicita entrada do usuário
    System.out.println("Curiosidades sobre valores - 10 valores");
    System.out.println("Digite o primeiro valor:");

    //Atribui o valor digitado na variável referente a idade
    double a1 = in.nextDouble();
    double max, min, med;
    max = a1;
    min = a1;
    med = a1;

    System.out.println("Digite o segundo valor:");
    double a2 = in.nextDouble();

    //Testa o valor digitado e atribui a variável pra número maior ou menor
    if (a2 > max) {
      max = a2;
      med += a2;
    } else if (a2 < min) {
      min = a2;
      med += a2;
    }
    System.out.println("Digite o terceiro valor:");
    double a3 = in.nextDouble();
    if (a3 > max) {
      max = a3;
      med += a3;
    } else if (a3 < min) {
      min = a3;
      med += a3;
    }
    System.out.println("Digite o quarto valor:");
    double a4 = in.nextDouble();
    if (a4 > max) {
      max = a4;
      med += a4;
    } else if (a4 < min) {
      min = a4;
      med += a4;
    }
    System.out.println("Digite o quinto valor:");
    double a5 = in.nextDouble();
    if (a5 > max) {
      max = a5;
      med += a5;
    } else if (a5 < min) {
      min = a5;
      med += a5;
    }
    System.out.println("Digite o sexto valor:");
    double a6 = in.nextDouble();
    if (a6 > max) {
      max = a6;
      med += a6;
    } else if (a6 < min) {
      min = a6;
      med += a6;
    }
    System.out.println("Digite o sétimo valor:");
    double a7 = in.nextDouble();
    if (a7 > max) {
      max = a7;
      med += a7;
    } else if (a7 < min) {
      min = a7;
      med += a7;
    }
    System.out.println("Digite o oitavo valor:");
    double a8 = in.nextDouble();
    if (a8 > max) {
      max = a8;
      med += a8;
    } else if (a8 < min) {
      min = a8;
      med += a8;
    }
    System.out.println("Digite o nono valor:");
    double a9 = in.nextDouble();
    if (a9 > max) {
      max = a9;
      med += a9;
    } else if (a9 < min) {
      min = a9;
      med += a9;
    }
    System.out.println("Digite o décimo e último valor:");
    double a10 = in.nextDouble();
    if (a10 > max) {
      max = a10;
      med += a10;
    } else if (a10 < min) {
      min = a10;
      med += a10;
    }
    //Faz a média
    med = med/ 10;

    System.out.printf("O maior número digitado é: %.2f .\n", max);
    System.out.printf("O menor número digitado é: %.2f .\n", min);
    System.out.printf("A média dos números digitados é %.2f .: \n", med);

    //Finaliza o recurso do Scanner
    in.close();
  }
}