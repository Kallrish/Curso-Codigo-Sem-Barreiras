package parte02_03arrayselistas;

//Importa o pacote necessário para receber entrada pelo usuário

import java.util.Scanner;

/**
 * Classe com a implementação da "parte 02" do "exercício03" do material "03arrayselistas".
 * Curso Java - Share RH & Alelo"
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 */
public class md02Exercicio03 {
  /**
   * Roda o programa principal.
   */
  public static void main(String[] args) {

    //Instancia o objeto in para receber as entradas do usuário
    try (Scanner in = new Scanner(System.in)) {

      //Cria as variáveis necessárias
      Integer quantidade, indice, pares = 0;

      //Solicita ao usuário a quantidade de números que ele quer na lista
      System.out.println("Quantos números inteiros são pares na lista?\n");
      System.out.println("Digite quantos elementos você quer na lista: ");
      quantidade = Integer.parseInt(in.nextLine());
      Integer[] numeros = new Integer[quantidade];

      //Loop para leitura dos números que o usuário quer na lista
      for (indice = 0; indice < quantidade; indice++) {
        System.out.printf("Digite o número %d!\n", (indice + 1));
        numeros[indice] = Integer.parseInt(in.nextLine());


        if (numeros[indice] == 0) {
          pares++;
        } else if (numeros[indice] != 0) {
          if (numeros[indice] % 2 == 0) {
            pares++;
          }
        }
      }

      //Retorna na tela os números que foram armazenados na lista
      System.out.printf("\nA sua lista tem %d números pares!", pares);

    }
  }
}