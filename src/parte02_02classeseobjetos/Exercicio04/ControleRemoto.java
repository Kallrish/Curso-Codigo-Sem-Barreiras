package parte02_02classeseobjetos.Exercicio04;

//Importa a classe Scanner para receber entrada do usuário
import java.util.Scanner;

/** Classe com a implementação "parte 02" do "exercício04" do material "02classeseobjetos".
 * Curso Java - Share RH & Alelo"
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 * */
public class ControleRemoto {

  //Cria as variáveis necessárias
  Integer volumeMaximo = 100, canalMaximo = 50;

  //Instancia o objeto televisão
  Televisao tv1 = new Televisao();

  //Método para aumentar o volume da televisão
  public void aumentarVolume() {

    Integer volume = tv1.getVolume();

    //Verifica se o volume já está no máximo
    if (volume < volumeMaximo) {
      volume++;
      tv1.setVolume(volume);
      System.out.printf("Volume: %d\n\n", tv1.getVolume());
    } else {
      System.out.printf("Volume: %d\n", tv1.getVolume());
      System.out.println("Volume já está no máximo!\n");
    }
  }

  //Método para diminuir o volume da televisão
  public void diminuirVolume() {

    Integer volume = tv1.getVolume();

    //Verifica se o volume já está no mínimo
    if (volume > 0) {
      volume--;
      tv1.setVolume(volume);
      System.out.printf("Volume: %d\n", tv1.getVolume());

    } else {
      System.out.printf("Volume: %d\n", tv1.getVolume());
      System.out.println("Volume já está no mínimo!\n");
    }
  }

  //Método para aumentar o canal da televisão
  public void aumentarCanal() {

    Integer canal = tv1.getCanal();

    //Verifica se o canal já está no máximo
    if (canal < canalMaximo) {
      canal++;
      tv1.setCanal(canal);
      System.out.printf("Canal: %d\n\n", tv1.getCanal());

    } else {
      System.out.printf("Canal: %d\n", tv1.getCanal());
      System.out.println("Canal já está no máximo!\n");
    }
  }

  //Método para diminuir o canal da televisão
  public void diminuirCanal() {

    Integer canal = tv1.getCanal();

    //Verifica se o canal já está no mínimo
    if (canal > 0) {
      canal--;
      tv1.setCanal(canal);
      System.out.printf("Canal: %d\n", tv1.getCanal());

    } else {
      System.out.printf("Canal: %d\n", tv1.getCanal());
      System.out.println("Canal já está no mínimo!\n");
    }
  }

  //Método para ligar a televisão
  public void ligaTelevisao() {

    //Verifica estado da variável booleana e atribui valor se necessário
    if (tv1.isLigado()) {
      System.out.println("A televisão já está ligada!\n");

    } else {
      tv1.setLigado(true);
      System.out.println("A televisão foi ligada!\n");
    }
  }

  //Método para desligar a televisão
  public void desligaTelevisao() {

    //Verifica estado da variável booleana e atribui valor se necessário
    if (tv1.isLigado()) {
      tv1.setLigado(false);
      System.out.println("A televisão foi desligada!\n");

    } else {
      System.out.println("A televisão já está desligada!\n");
    }

  }

  //Método para escolher um canal específico da televisão
  public void irParaCanalEspecifico() {

    //Uso do try para controlar a abertura e fechamento do scanner na memória
    try (Scanner in = new Scanner(System.in)) {

      tv1.setEscolhaValidaSubMenu(false);

      //Laço para receber opção válida do usuário e mudar para canal específico
      do {
        Integer canal = in.nextInt();
        if (canal > 50 || canal < 1) {
          System.out.println("Escolha um canal entre 1 e 50!");
        } else {
          tv1.setCanal(canal);
          System.out.printf("Canal %d\n\n", tv1.getCanal());
          tv1.setEscolhaValidaSubMenu(true);
        }
      } while (!tv1.escolhaValidaSubMenu);
    }
  }

  //Método para mostrar o canal e volume atual da televisão
  public void canalEVolumeAtual() {

    System.out.printf("Canal: %d - Volume: %d\n", tv1.getCanal(), tv1.getVolume());

  }

}
