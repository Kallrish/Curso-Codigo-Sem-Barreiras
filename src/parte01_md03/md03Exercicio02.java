package parte01_md03;

//Importa o pacote necessário para receber entrada pelo usuário
import java.util.Scanner;

/** Classe com a implementação do "exercício04" do material "md02".
 * Curso Java - Share RH & Alelo"
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 * */
public class md03Exercicio02 {

  /** Roda o programa principal. */
  public static void main(String[] args) {

    //Instancia o objeto in para receber as entradas do usuário
    Scanner in = new Scanner(System.in);

    //Retorna na tela informando nome do programa e solicita entrada do usuário
    System.out.println("Calcula fatorial");
    System.out.println("Digite o número para calcular: ");
    int num = in.nextInt();
    int fator = 1;

    //Verifica se o número digitado foi 0 ou 1
    if (num == 0 || num == 1) {
      System.out.printf("O fatorial de %d é %d!", num, 1);
    } else {
      //Realiza o cálculo do fatorial
      for (int cont = 0; cont <= num; cont++) {
        fator = num * (num - 1);
      }

      //Retorno na tela
      System.out.printf("O fatorial de %d é %d!", num, fator);
    }

    //Finaliza o recurso do Scanner
    in.close();
  }
}
