package projetoempresadecartaodebeneficios.Etapa02;

public class Estabelecimento {

  //Cria as variáveis necessárias para classe
  private Integer identificadorEstabelecimento;
  private String nomeEstabelecimento;
  private String tipoEstabelecimento;
  private String localizacaoEstabelecimento;

  //Método para cadastrar estabelecimentos
  public void cadastrarEstabelecimento(Integer identificadorEstabelecimento,String nomeEstabelecimento,
                                       String tipoEstabelecimento, String localizacaoEstabelecimento) {

    this.identificadorEstabelecimento = identificadorEstabelecimento;
    this.nomeEstabelecimento = nomeEstabelecimento;
    this.tipoEstabelecimento = tipoEstabelecimento;
    this.localizacaoEstabelecimento = localizacaoEstabelecimento;
  }

  public Integer getIdentificadorEstabelecimento() {
    return identificadorEstabelecimento;
  }

  public String getNomeEstabelecimento() {
    return nomeEstabelecimento;
  }

  public String getTipoEstabelecimento() {
    return tipoEstabelecimento;
  }

  public String getLocalizacaoEstabelecimento() {
    return localizacaoEstabelecimento;
  }

  @Override
  public String toString() {
    return "Estabelecimento: " + nomeEstabelecimento;
  }
}
