package parte01_md02;

//Importa o pacote necessário para receber entrada pelo usuário
import java.util.Scanner;

/** Classe com a implementação do "exercício04" do material "md02".
 * Curso Java - Share RH & Alelo"
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 * */
public class md02Exercicio06 {

  /** Roda o programa principal. */
  public static void main(String[] args) {

    //Instancia o objeto in para receber as entradas do usuário
    Scanner in = new Scanner(System.in);

    //Cria as variáveis e inicializa
    int op1, op2;
    double v1, v2, resultado;

    //Retorna na tela informando nome do programa e solicita a primeira entrada do usuário
    System.out.println("Hora do jogo: Jokenpô!");
    System.out.println("Jogador 1 - Digite o número da sua opção:");
    System.out.println("1 - Pedra, 2 - Papel ou 3 - Tesoura");
    op1 = in.nextInt();

    //Retorna na tela informando nome do programa e solicita a segunda entrada do usuário
    System.out.println("\nJogador 2 - Digite o número da sua opção:");
    op2 = in.nextInt();

    //Verifica as opções e informa qual jogador ganhou
    if (op1 == op2) {
      System.out.println("Houve empate!.");
    } else if (op1 == 1 && op2 == 2 || op1 == 2 && op2 == 3 || op1 == 3 && op2 == 1) {
      System.out.println("Vitória do jogador 2!");
    } else {
      System.out.println("Vitória do jogador 1!");
    }

    //Finaliza o recurso do Scanner
    in.close();
  }
}