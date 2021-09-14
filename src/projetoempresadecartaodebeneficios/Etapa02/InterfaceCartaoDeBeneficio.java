package projetoempresadecartaodebeneficios.Etapa02;

public interface InterfaceCartaoDeBeneficio {

  void adicionarTransacao(String nomeBeneficiario, Double valor, Integer identificadorEstabelecimento, String tipoDeEstabelecimento);

  public void mostrarSaldo(Double saldoAtual1) ;

  void criaDataDeCadastro();

  void criaDataDeValidade();

}
