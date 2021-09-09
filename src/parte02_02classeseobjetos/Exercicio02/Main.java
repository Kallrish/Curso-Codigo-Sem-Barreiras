package parte02_02classeseobjetos.Exercicio02;

public class Main {

  /**
   * Roda o programa principal.
   */
  public static void main(String[] args) {

    var agenda = new Agenda("Agenda do curso código sem barreiras!");

    agenda.armazenaPessoa("Anderson Rocha", 1990, 1.80f);
    agenda.armazenaPessoa("Pedro Leão", 1985, 1.80f);
    agenda.armazenaPessoa("Larissa Souza", 1994, 1.61f);
    agenda.armazenaPessoa("Ilan Ramos", 1993, 1.82f);
    agenda.armazenaPessoa("Ana Paula Rodrigues", 1988, 1.55f);
    agenda.armazenaPessoa("Tiago Muniz", 1980, 1.73f);
    agenda.armazenaPessoa("Jonatas Ribeiro", 1984, 1.75f);
    agenda.armazenaPessoa("Vinicius Ferrari", 1985, 1.75f);
    agenda.armazenaPessoa("Sergio Tadeu", 1997, 1.74f);
    agenda.armazenaPessoa("Raphael Morais", 1991, 1.79f);
    agenda.armazenaPessoa("Rafael Castelo", 1996, 1.87f);
    agenda.imprimeAgenda();

    agenda.removePessoa("Anderson Rocha");
    agenda.armazenaPessoa("Rafael Castelo", 1996, 1.87f);

    agenda.imprimeAgenda();

    agenda.imprimePessoa(0);
    agenda.imprimePessoa(3);
    agenda.imprimePessoa(7);

    agenda.removePessoa("Juliano");
  }
}