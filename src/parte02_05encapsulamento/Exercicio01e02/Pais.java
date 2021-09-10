package parte02_05encapsulamento.Exercicio01e02;

public class Pais {

  String codigoIso;
  String nome;
  Integer populacao;
  Double dimensao;
  Pais[] vizinhos;
  Integer qtdVizinhos;

  public Pais(String codigoIso, String nome, Double dimensao) {

    this.setCodigoIso(codigoIso);
    this.setNome(nome);
    this.setDimensao(dimensao);
    this.vizinhos = new Pais[40];
    this.qtdVizinhos = 0;
  }

  public String getCodigoIso() {
    return codigoIso;
  }

  public void setCodigoIso(String codigoIso) {
    this.codigoIso = codigoIso;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getPopulacao() {
    return populacao;
  }

  public void setPopulacao(Integer populacao) {
    this.populacao = populacao;
  }

  public Double getDimensao() {
    return dimensao;
  }

  public void setDimensao(Double dimensao) {
    this.dimensao = dimensao;
  }

  public boolean verificaMesmoPais(Pais outro) {

    return (this.getCodigoIso().equals(outro.getCodigoIso()));
  }

  public void adicionaVizinhos(Pais vizinho) {
    this.vizinhos[qtdVizinhos] = vizinho;
    this.qtdVizinhos++;
  }

  public boolean verificaVizinho(Pais pais) {
    for (int cont = 0; cont < this.vizinhos.length; cont++) {
      if (this.vizinhos[cont] != null && this.vizinhos[cont].equals(pais)) {
        return true;
      }
    }
    return false;
  }

  public double getDensidadePopulacional(String nome) {

    return (this.getPopulacao() / this.getDimensao());
  }

  public Pais[] getPaisesVizinhosComum(Pais outro) {

    int qtdVizinhosComuns = 0;
    Pais[] vizinhosComuns = new Pais[40];
    for (int i = 0; i < this.vizinhos.length; i++) {
      if (this.vizinhos[i] != null && outro.verificaVizinho(this.vizinhos[i])) {

        vizinhosComuns[qtdVizinhosComuns++] = this.vizinhos[i];
      }
    }
    return vizinhosComuns;
  }
}
