package parte01_md1;

//Importa o pacote necessário para receber entrada pelo usuário
import java.util.Scanner;

/** Classe com a implementação do "exercício04" do material "diadois".
 * Curso Java - Share RH & Alelo"
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 * */
public class Exercicio04 {
    /** Roda o programa principal. */
    public static void main(String[] args) {

        //Instancia o objeto in para receber as entradas do usuário
        Scanner in = new Scanner(System.in);

        //Retorna na tela o nome do programa, e solicita o primeiro valor ao usuário
        System.out.println("\nCalcula % eleição: \n");
        System.out.println("Digite o número total de eleitores do município: ");

        //Atribui o valor digitado na variável referente ao total de eleitores
        int a1 = in.nextInt();

        //Solicita o segundo valor ao usuário
        System.out.println("Digite o número de votos em branco: ");

        //Atribui o valor digitado na variável referente aos votos em branco
        int a2 = in.nextInt();

        //Solicita o terceiro valor ao usuário
        System.out.println("Digite o número de votos nulos: ");

        //Atribui o valor digitado na variável referente aos votos nulos
        int a3 = in.nextInt();

        //Solicita o quarto valor ao usuário
        System.out.println("Digite o número de votos válidos: ");

        //Atribui o valor digitado na variável referente aos votos válidos
        int a4 = in.nextInt();

        //Calcula as porcentagens e atribui nas variáveis
        float p2 = ((float) a2 * 100) / a1;
        float p3 = ((float) a3 * 100) / a1;
        float p4 = ((float) a4 * 100) / a1;

        //Retorna na tela os 3 resultados dos cálculos de porcentagem
        System.out.println("\nEm relação ao total de eleitores temos os seguintes números: \n");
        System.out.println("Percentual de votos em branco: " + p2 + "%.");
        System.out.println("Percentual de votos nulos: " + p3 + "%.");
        System.out.println("Percentual de votos válidos: " + p4 + "%.");
    }
}
