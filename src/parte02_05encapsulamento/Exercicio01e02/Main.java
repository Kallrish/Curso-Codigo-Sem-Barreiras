package parte02_05encapsulamento.Exercicio01e02;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    //Instancia um país passando atributos por meio de um construtor
    var pais1 = new Pais("BRA", "Brasil", 8516000d);
    //Atribui uma população ao país criado
    pais1.setPopulacao(211000000);

    var pais2 = new Pais("VNZ", "Venezuela", 916445d);
    pais2.setPopulacao(28520000);

    var pais3 = new Pais("CLB", "Colômbia", 1143000d);
    pais3.setPopulacao(50340000);

    var pais4 = new Pais("PER", "Peru", 1285000d);
    pais4.setPopulacao(32510000);

    var pais5 = new Pais("BLV", "Bolívia", 1099000d);
    pais5.setPopulacao(11510000);

    System.out.println(pais1.verificaMesmoPais(pais2));
    System.out.println(pais2.verificaMesmoPais(pais1));
    System.out.println(pais2.verificaMesmoPais(pais3));
    System.out.println(pais3.verificaMesmoPais(pais4));
    System.out.println(pais4.verificaMesmoPais(pais5));
    System.out.println(pais5.verificaMesmoPais(pais1));

    System.out.println(pais1.getDensidadePopulacional("Brasil"));
    System.out.println(pais2.getDensidadePopulacional("Venezuela"));
    System.out.println(pais3.getDensidadePopulacional("Colômbia"));
    System.out.println(pais4.getDensidadePopulacional("Peru"));
    System.out.println(pais5.getDensidadePopulacional("Bolívia"));

    pais1.adicionaVizinhos(pais2);
    pais1.adicionaVizinhos(pais3);
    pais1.adicionaVizinhos(pais4);
    pais1.adicionaVizinhos(pais5);

    pais2.adicionaVizinhos(pais1);
    pais2.adicionaVizinhos(pais3);

    pais3.adicionaVizinhos(pais1);
    pais3.adicionaVizinhos(pais2);
    pais3.adicionaVizinhos(pais4);

    pais4.adicionaVizinhos(pais1);
    pais4.adicionaVizinhos(pais3);
    pais4.adicionaVizinhos(pais5);

    pais5.adicionaVizinhos(pais1);
    pais5.adicionaVizinhos(pais4);

    System.out.println(Arrays.toString(pais2.getPaisesVizinhosComum(pais1)));
    System.out.println(Arrays.toString(pais2.getPaisesVizinhosComum(pais2)));
    System.out.println(Arrays.toString(pais3.getPaisesVizinhosComum(pais2)));
    System.out.println(Arrays.toString(pais3.getPaisesVizinhosComum(pais4)));
    System.out.println(Arrays.toString(pais4.getPaisesVizinhosComum(pais2)));
    System.out.println(Arrays.toString(pais4.getPaisesVizinhosComum(pais4)));
    System.out.println(Arrays.toString(pais5.getPaisesVizinhosComum(pais2)));
    System.out.println(Arrays.toString(pais5.getPaisesVizinhosComum(pais4)));
  }
}