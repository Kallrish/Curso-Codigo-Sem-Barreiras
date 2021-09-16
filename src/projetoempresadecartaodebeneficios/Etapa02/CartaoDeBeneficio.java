package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class CartaoDeBeneficio {

  //Crias as variáveis necessárias para classe
  public Integer identificadorCartao;
  public String nomeBeneficiario;
  protected String senhaCartao;
  protected Double saldoCartao;
  public LocalDate dataDoCadastro;
  public LocalDate validadeCartao;
  public static int index =0;
  public static List<Transacao> listaTransacoes = new ArrayList<>();

}