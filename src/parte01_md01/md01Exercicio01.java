package parte01_md01;

/** Classe com a implementação "parte 01" do "exercício01" do material "md01".
 * Curso Java - Share RH & Alelo"
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 * */
public class md01Exercicio01 {
  /** Roda o programa principal. */
  public static void main(String[] args) {

    //Inicializa as variáveis com os valores solicitados
    int y = 99;
    int z = 11;
    int x = 0;

    //Retorna na tela os valores iniciais das variáveis
     System.out.println("A variável Y contém: " + y + " e a variável Z contém " + z + ".");

     //Troca os valores das variáveis entre si
     x = y;
     y = z;
     z = x;

     //Retorna na tela os novos valores das variáveis
     System.out.println("Agora, a variável Y contém: " + y + " e a variável Z contém " + z + ".");
  }
}
