package parte02_02classeseobjetos.Exercicio02;

import parte02_02classeseobjetos.Exercicio01.Pessoa;

/**
 * Classe com a implementação da "parte 02" do "exercício02" do material "02classeseobjetos".
 * Curso Java - Share RH & Alelo"
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas "Kallrish" Ribeiro
 * @version 1.0
 */
public class Agenda {

  //Importa a classe Pessoa do Exercício 01
  Pessoa[] pessoas = new Pessoa[10];

  //Variável que recebe o nome da agenda
  String nomeDaAgenda;

  public Agenda(String nomeDaAgenda) {
    this.nomeDaAgenda = nomeDaAgenda;
  }

  //Método que busca o próximo índice vazio para executar o armazenamento
  private int buscarProximoIndiceVazio() {
    for (int i = 0; i < this.pessoas.length; i++) {
      if (this.pessoas[i] == null) {
        return i;
      }
    }
    return -1;
  }

  //Método para adicionar pessoas
  public void armazenaPessoa(String nome, int anoNascimento, float altura) {

    var indiceParaGravarNovaPessoa = this.buscarProximoIndiceVazio();

    if (indiceParaGravarNovaPessoa == -1) {
      System.out.printf("Você não pode armazenar mais do que 10 pessoas. A pessoa %s não foi adicionada.%n", nome );
      return;
    }

    var pessoa = new Pessoa();
    pessoa.nome = nome;
    pessoa.anoDeNascimento = anoNascimento;
    pessoa.altura = altura;
    this.pessoas[indiceParaGravarNovaPessoa] = pessoa;

  }

  //Método para remover pessoas
  public void removePessoa(String nome) {

    var indicePessoaRemover = this.buscaPessoa(nome);

    if (indicePessoaRemover > -1) {
      this.pessoas[indicePessoaRemover] = null;
      System.out.printf("A pessoa %s foi removida com sucesso. %n", nome);
    } else {
      System.out.printf("Pessoa %s não encontrada. %n", nome);
    }
  }

  public int buscaPessoa(String nome) {
    for (int i = 0; i < this.pessoas.length; i++) {
      if (nome.equals(this.pessoas[i].nome)) {
        return i;
      }
    }

    return -1;
  }

  void imprimeAgenda() {
    for (int i = 0; i < this.pessoas.length; i++) {
      this.imprimePessoa(i);
    }
  }

  void imprimePessoa(int indice) {
    System.out.println(this.pessoas[indice]);
  }

}
