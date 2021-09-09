package parte01_02estruturasdecontrole;

//Importa o pacote necessário para receber entrada pelo usuário
import java.util.Scanner;

/** Classe com a implementação "parte 01" do "exercício05" do material "02estruturasdecontrole".
 * Curso Java - Share RH & Alelo"
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 * */
public class md02Exercicio05 {

  /** Roda o programa principal. */
  public static void main(String[] args) {

    //Instancia o objeto in para receber as entradas do usuário
    Scanner in = new Scanner(System.in);

    int opcao;
    double v1, v2;

    //Retorna na tela informando nome do programa e solicita entrada do usuário
    System.out.println("Operações Matemáticas");
    System.out.println("Digite o primeiro valor:");
    v1 = in.nextDouble();
    System.out.println("Digite o segundo valor:");
    v2 = in.nextDouble();
    System.out.println("Digite a opção da operação que deseja efetuar:");
    System.out.println("1 - Adição, 2 - Subtração, 3 - Multiplicação ou 4 - Divisão");
    opcao = in.nextInt();

    //Retorna na tela informando nome do programa e solicita a primeira entrada do usuário
    switch (opcao) {
      case 1:
        System.out.printf("O resultado da adição entre %.2f e %.2f é: %.2f !", v1, v2, v1 + v2);
        break;
      case 2:
        System.out.printf("O resultado da subtração entre %.2f e %.2f é: %.2f !", v1, v2, v1 - v2);
        break;
      case 3:
        System.out.printf("O resultado da multiplicação entre %.2f e %.2f é: %.2f !", v1, v2, v1 * v2);
        break;
      case 4:
        if (v2 == 0) {
          System.out.println("Não se pode dividir por 0!");
        } else {
          double resultado = v1 / v2;
          System.out.printf("O resultado da divisão entre %.2f e %.2f é: %.2f !", v1, v2, resultado);
        }
        break;
      default:
        System.out.println("Opção inválida!");
    }

    //Finaliza o recurso do Scanner
    in.close();
  }
}