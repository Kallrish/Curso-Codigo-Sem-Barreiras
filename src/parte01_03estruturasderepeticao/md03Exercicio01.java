package parte01_03estruturasderepeticao;

//Importa o pacote necessário para receber entrada pelo usuário
import java.util.Scanner;

/** Classe com a implementação "parte 01" do "exercício01" do material "03estruturasderepeticao".
 * Curso Java - Share RH & Alelo"
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 * */
public class md03Exercicio01 {

  /** Roda o programa principal. */
  public static void main(String[] args) {

    //Instancia o objeto in para receber as entradas do usuário
    Scanner in = new Scanner(System.in);

    //Retorna na tela informando nome do programa e solicita entrada do usuário
    System.out.println("Curiosidades sobre valores - 10 valores");

    //Declara variáveis e inicializa
    double med = 0, maior = Double.MIN_VALUE, menor = Double.MAX_VALUE, valor;
    int qtdDeNumeros = 10 ;

    //Laço para verificar todos os números
    for (int cont = 1; cont <= qtdDeNumeros; cont++) {
      System.out.printf("Digite o %dº valor:\n", cont );
      valor = in.nextDouble();
      if (valor > maior) {
        maior = valor;
      }
      if (valor < menor) {
        menor = valor;
      }
      med += valor;
    }

    //Faz a média
    med = med / qtdDeNumeros;

    //Retorno dos valores na tela
    System.out.printf("O maior número digitado é: %.2f .\n", maior);
    System.out.printf("O menor número digitado é: %.2f .\n", menor);
    System.out.printf("A média dos números digitados é %.2f .\n", med);

    in.close();
  }
}
