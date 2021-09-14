package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDate;

public interface InterfaceCartaoDeBeneficio {

  void adicionarTransacao(String nomeBeneficiario, Double valor, Integer identificadorEstabelecimento, String tipoDeEstabelecimento);

  void mostrarSaldo(Double saldoAtual1) ;

  void criaDataDeCadastro();

  void criaDataDeValidade();

}
