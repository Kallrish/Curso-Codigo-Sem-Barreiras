package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;

public class Pessoa {

  String nome;
  ValeAlimentacao cartao1 = new ValeAlimentacao();
  ValeRefeicao cartao2 = new ValeRefeicao();
  ValeCombustivel cartao3 = new ValeCombustivel();
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
