package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transacao {

  private Long identificadorDaTransacao;
  private String identificadorDoCartao;
  private LocalDateTime dataHoraTransacao;
  private String identicadorDoEstabelecimento;
  private String localizacaoDoEstabelecimento;
  private String tipoDoEstabelecimento;
  private Double valorDaTransacao;

  //Cria uma lista para armazenar as transações do VA
  public static List<Transacao> listaTransacoesVA = new ArrayList<>();
  //Cria uma lista para armazenar as transações do VR
  public static List<Transacao> listaTransacoesVR = new ArrayList<>();
  //Cria uma lista para armazenar as transações do VC
  public static List<Transacao> listaTransacoesVC = new ArrayList<>();


  public Transacao(Long identificadorDaTransacao, String identificadorDoCartao, LocalDateTime dataHoraTransacao,
                   String identicadorDoEstabelecimento, String localizacaoDoEstabelecimento,
                   String tipoDoEstabelecimento, Double valorDaTransacao) {
    this.identificadorDaTransacao = identificadorDaTransacao;
    this.identificadorDoCartao = identificadorDoCartao;
    this.dataHoraTransacao = dataHoraTransacao;
    this.identicadorDoEstabelecimento = identicadorDoEstabelecimento;
    this.localizacaoDoEstabelecimento = localizacaoDoEstabelecimento;
    this.tipoDoEstabelecimento = tipoDoEstabelecimento;
    this.valorDaTransacao = valorDaTransacao;
  }

  public Long getIdentificadorDaTransacao() {
    return identificadorDaTransacao;
  }

  public void setIdentificadorDaTransacao(Long identificadorDaTransacao) {
    this.identificadorDaTransacao = identificadorDaTransacao;
  }

  public String getIdentificadorDoCartao() {
    return identificadorDoCartao;
  }

  public void setIdentificadorDoCartao(String identificadorDoCartao) {
    this.identificadorDoCartao = identificadorDoCartao;
  }

  public LocalDateTime getDataHoraTransacao() {
    return dataHoraTransacao;
  }

  public void setDataHoraTransacao(LocalDateTime dataHoraTransacao) {
    this.dataHoraTransacao = dataHoraTransacao;
  }

  public String getIdenticadorDoEstabelecimento() {
    return identicadorDoEstabelecimento;
  }

  public void setIdenticadorDoEstabelecimento(String identicadorDoEstabelecimento) {
    this.identicadorDoEstabelecimento = identicadorDoEstabelecimento;
  }

  public String getLocalizacaoDoEstabelecimento() {
    return localizacaoDoEstabelecimento;
  }

  public void setLocalizacaoDoEstabelecimento(String localizacaoDoEstabelecimento) {
    this.localizacaoDoEstabelecimento = localizacaoDoEstabelecimento;
  }

  public String getTipoDoEstabelecimento() {
    return tipoDoEstabelecimento;
  }

  public void setTipoDoEstabelecimento(String tipoDoEstabelecimento) {
    this.tipoDoEstabelecimento = tipoDoEstabelecimento;
  }

  public Double getValorDaTransacao() {
    return valorDaTransacao;
  }

  public void setValorDaTransacao(Double valorDaTransacao) {
    this.valorDaTransacao = valorDaTransacao;
  }
}
