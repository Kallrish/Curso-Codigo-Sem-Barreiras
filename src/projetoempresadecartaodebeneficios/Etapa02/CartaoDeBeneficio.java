package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class CartaoDeBeneficio {

  //Crias as variáveis necessárias para classe
  protected Double saldoCartao;
  protected String senhaCartao;
  public LocalDate validadeCartao;
  public ArrayList<Transacao> transacoesCartao = new ArrayList<>();
  public String nomeBeneficiario;

  public void mostrarSaldo() {

    System.out.printf("%s, seu saldo atual é: %.2f.%n", this.nomeBeneficiario, saldoCartao);
  }

  void adicionarTransacao (Double valor) {

  }

}