package parte02_md02;

//Importa o pacote necessário para receber entrada pelo usuário
import java.util.ArrayList;
import java.util.Scanner;

/** Classe com a implementação da "parte 02" do "exercício01" do material "md02".
 * Curso Java - Share RH & Alelo"
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 * */
public class md02Exercicio01 {
  /** Roda o programa principal. */
  public static void main(String[] args) {

    //Instancia o objeto in para receber as entradas do usuário
    Scanner in = new Scanner(System.in);
    //Instancia o objeto in para receber a lista
    ArrayList<String> numeros = new ArrayList<>();

    //Cria as variáveis necessárias
    Integer quantidade, indice;
    String num;

    //Solicita ao usuário a quantidade de números que ele quer na lista
    //Isso evita solicitar números infinitamente já que não há limite declarado
    System.out.println("Criando uma lista");
    System.out.println("Digite quantos elementos você quer na lista: ");
    quantidade = Integer.parseInt(in.nextLine());

    //Loop para leitura dos números que o usuário quer na lista
    for (indice = 0; indice < quantidade; indice++) {
      System.out.printf("Digite o número %d!\n", indice + 1);
      num = in.nextLine();
      numeros.add(num);

    }

    //Retorna na tela os números que foram armazenados na lista
    System.out.println("\nEsses são os valores da sua lista: ");
    numeros.forEach(System.out::println);

    //Finaliza o recurso do Scanner
    in.close();
  }
}
