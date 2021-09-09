package parte02_02classeseobjetos.Exercicio03;

public class Main {

  public static void main(String[] args) {

    //Instancia os elevadores da classe Elevador
    var elevador1 = new Elevador(35, 18);

    for (int i = 0; i < 40; i++) {
      elevador1.entrar();
    }

    System.out.println(elevador1);

    for (int i = 0; i < 20; i++) {
      elevador1.subir();
    }

    System.out.println(elevador1);

    for (int i = 0; i < 20; i++) {
      elevador1.subir();
    }

    System.out.println(elevador1);

    elevador1.descer();
    elevador1.descer();

    for (int i = 0; i < 100; i++) {
      elevador1.sair();
    }

    System.out.println(elevador1);

    System.out.println("---Fim elevador 1---" );


    var elevador2 = new Elevador(18, 8);

    System.out.println(elevador2);

    elevador2.entrar();
    elevador2.entrar();
    elevador2.entrar();

    elevador2.subir();
    elevador2.subir();

    System.out.println(elevador2);

    System.out.println("---Fim elevador 2---" );

    var elevador3 = new Elevador(10, 6);

    System.out.println(elevador3);

    //Sobe dois andares
    elevador3.subir();
    elevador3.subir();

    //Desce três andares
    elevador3.descer();
    elevador3.descer();
    elevador3.descer();
    elevador3.descer();

    System.out.println(elevador3);

    System.out.println("---Fim elevador 3---" );
  }
}
