package parte02_02classeseobjetos.Exercicio01;

/**
 * Roda o programa principal.
 */

public class Main {

  public static void main(String[] args) {

    //Instancia um objeto da classe Pessoa
    var pessoa = new Pessoa();
    pessoa.nome = "Joana D'ark Rizzo";
    pessoa.anoDeNascimento = 1990;
    pessoa.altura = 1.60f;

    //Possível graças ao Override na classe Pessoa
    System.out.println(pessoa);

    //Invocação dos métodos da classe Pessoa
    pessoa.imprimeDados();
    pessoa.calculaIdade();
  }

}