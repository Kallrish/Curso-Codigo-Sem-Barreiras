package parte01_md03;

//Importa o pacote necessário para receber entrada pelo usuário
import java.util.Scanner;

/** Classe com a implementação da "parte 01" do "exercício02" do material "md03".
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
    long fator = 1;

      //Realiza o cálculo do fatorial
      for (int cont = 1; cont <= num; cont++) {
        fator *= cont;
      }

      //Retorno na tela
      System.out.printf("O fatorial é %d!", fator);

    //Finaliza o recurso do Scanner
    in.close();
  }
}
