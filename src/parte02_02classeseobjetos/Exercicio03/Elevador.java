package parte02_02classeseobjetos.Exercicio03;

public class Elevador {

  Integer andaAtual = 0;
  Integer totalDeAndares;
  Integer capacidade;
  Integer ocupacaoAtual = 0;

  public Elevador(Integer totalDeAndares, Integer capacidade) {
    this.totalDeAndares = totalDeAndares;
    this.capacidade = capacidade;
  }

  public void entrar() {

    if(this.ocupacaoAtual < this.capacidade) {
      this.ocupacaoAtual++;
    } else {

      System.out.println("Elevador na capacidade máxima. Vá de escada!");
    }
  }

  public void sair() {

    if(this.ocupacaoAtual > 0) {
      this.ocupacaoAtual--;
    }
  }

  public void subir() {

    if(this.andaAtual < this.totalDeAndares) {
      this.andaAtual++;
    }
  }

  public void descer() {

    if(this.andaAtual > 0) {
      this.andaAtual--;
    }
  }

  @Override
  public String toString() {
    return "Elevador{" +
            "andaAtual=" + andaAtual +
            ", totalDeAndares=" + totalDeAndares +
            ", capacidade=" + capacidade +
            ", ocupacaoAtual=" + ocupacaoAtual +
            '}';
  }
}
