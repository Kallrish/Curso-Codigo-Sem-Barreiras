package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;

public class Pessoa {

  String nome;
  ValeAlimentacao cartao1 = new ValeAlimentacao();
  ValeRefeicao cartao2 = new ValeRefeicao();
  ValeTransporte cartao3 = new ValeTransporte();
  LocalDate dataDoCadastro;

  @Override
  public String toString() {
    return "Pessoa{" +
            "nome='" + nome + '\'' +
            ", cartao1=" + cartao1 +
            ", cartao2=" + cartao2 +
            ", cartao3=" + cartao3 +
            ", dataDoCadastro=" + dataDoCadastro +
            '}';
  }
}
