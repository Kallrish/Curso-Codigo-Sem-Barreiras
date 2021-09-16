package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDateTime;

public class Transacao {

  protected Integer identificadorDaTransacao;
  protected String beneficiario;
  protected Integer identificadorDoCartao;
  protected LocalDateTime dataHoraTransacao;
  protected String identicadorDoEstabelecimento;
  protected String localizacaoDoEstabelecimento;
  protected String tipoDoEstabelecimento;
  protected Double valorDaTransacao;

  public Transacao() {

  }

  public Transacao(Integer identificadorDaTransacao, String beneficiario, Integer identificadorDoCartao,
                   LocalDateTime dataHoraTransacao, String identicadorDoEstabelecimento, String localizacaoDoEstabelecimento,
                   String tipoDoEstabelecimento, Double valorDaTransacao) {
    this.identificadorDaTransacao = identificadorDaTransacao;
    this.beneficiario = beneficiario;
    this.identificadorDoCartao = identificadorDoCartao;
    this.dataHoraTransacao = dataHoraTransacao;
    this.identicadorDoEstabelecimento = identicadorDoEstabelecimento;
    this.localizacaoDoEstabelecimento = localizacaoDoEstabelecimento;
    this.tipoDoEstabelecimento = tipoDoEstabelecimento;
    this.valorDaTransacao = valorDaTransacao;
  }

  public Integer getIdentificadorDaTransacao() {
    return identificadorDaTransacao;
  }

  public void setIdentificadorDaTransacao(Integer identificadorDaTransacao) {
    this.identificadorDaTransacao = identificadorDaTransacao;
  }

  public Integer getIdentificadorDoCartao() {
    return identificadorDoCartao;
  }

  public void setIdentificadorDoCartao(Integer identificadorDoCartao) {
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

//  @Override
//  public boolean equals(Object obj) {
//    if (obj == null)
//      return false;
//
//    if (!(obj instanceof Transacao))
//      return false;
//
//    if (obj == this)
//      return true;
//
//    Transacao p = (Transacao) obj;
//
//    // Aqui você implementa como deve se feita a comparação.
//    // Verifica se os nomes dos produtos são iguais, ids e etc.
//
//    if (p.identificadorDaTransacao == this.identificadorDaTransacao) {
//      return true;
//    } else {
//      return false;
//    }
//  }
}