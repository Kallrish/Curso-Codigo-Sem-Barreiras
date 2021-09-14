package projetoempresadecartaodebeneficios.Etapa02;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transacao {

  private Integer identificadorDaTransacao;
  private String beneficiario;
  //private Integer identificadorUsuario;
  private Integer identificadorDoCartao;
  private LocalDateTime dataHoraTransacao;
  private String identicadorDoEstabelecimento;
  private String localizacaoDoEstabelecimento;
  private String tipoDoEstabelecimento;
  private Double valorDaTransacao;

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

  //TODO implementar o método de cadastro (tipo o do beneficiario)

  //TODO método para tirar o extrato (pessoa seleciona extrato do dia ou extrato da semana, ou extrato do mês)

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
}