package parte01_md01;

//Importa o pacote necessário para receber entrada pelo usuário
import java.util.Scanner;

/** Classe com a implementação "parte 01" do "exercício03" do material "md01".
 * Curso Java - Share RH & Alelo"
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 * */
public class md01Exercicio03 {
  /** Roda o programa principal. */
  public static void main(String[] args) {

    //Instancia o objeto in para receber as entradas do usuário
    Scanner in = new Scanner(System.in);

    //Retorna na tela o nome do programa, e solicita o primeiro valor ao usuário
    System.out.println("Calcula área do retângulo: ");
    System.out.println("Digite o valor da base: ");

    //Atribui o valor digitado na variável referente a base do triângulo
    double base = in.nextDouble();

    //Solicita na tela o segundo valor ao usuário
    System.out.println("Digite o valor da altura: ");

    //Atribui o valor digitado na variável referente a altura do triângulo
    double altura = in.nextDouble();

    //Atribui a variável o resultado do cálculo da área do triângulo
    double area = base * altura;

    //Retorna na tela a área do triângulo na tela para o usuário
    System.out.println("A área do retângulo é : " + area + "!");

    //Finaliza o recurso do Scanner
    in.close();
  }
}
