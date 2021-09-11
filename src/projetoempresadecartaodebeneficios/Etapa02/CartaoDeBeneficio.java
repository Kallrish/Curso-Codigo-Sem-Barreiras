package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public abstract class CartaoDeBeneficio {

//  protected String numeroDoCartao;
  protected Double saldo;
  protected String senha;
  protected LocalDate validade;
  protected ArrayList<Transacao> transacoes;

  public void mostrarSaldo() {

    System.out.printf("Seu saldo atual é: %.2f", this.saldo);
  }

}