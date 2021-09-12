package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class CartaoDeBeneficio {

  //Crias as variáveis necessárias para classe
  public String identificadorCartao;
  protected Double saldoCartao = 1000.0;
  public LocalDate dataDoCadastro;
  public LocalDate validadeCartao;
  public ArrayList<Transacao> transacoesCartao = new ArrayList<>();
  public String nomeBeneficiario;

  public void mostrarSaldo() {

    System.out.printf("%s, seu saldo atual é: %.2f.%n", this.nomeBeneficiario, saldoCartao);
  }

  void adicionarTransacao (Double valor) {

  }

}