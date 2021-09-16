package projetoempresadecartaodebeneficios.Etapa02;

//Importa bibliotecas
import java.time.LocalDateTime;

/**
 * Projeto Empresa de Cartão de Benefícios.- Etapa 02
 * Trabalho em grupo - Grupo JavAlelo.
 * Curso Java - Share RH & Alelo".
 * Para mais detalhes, acesse o "Readme.txt" no GITHUB.
 *
 * @author Jonatas, Ana Paula Rodrigues,
 * @author Antônio Carlos, Natália, Karina, Giovanna, Cristovão, Sérgio.
 *
 * @version 2.5
 */

public class Transacao {

  //
  public Integer identificadorDaTransacao;
  public String beneficiario;
  public Integer identificadorDoCartao;
  public LocalDateTime dataHoraTransacao;
  public String identicadorDoEstabelecimento;
  public String localizacaoDoEstabelecimento;
  public String tipoDoEstabelecimento;
  public Double valorDaTransacao;

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
}