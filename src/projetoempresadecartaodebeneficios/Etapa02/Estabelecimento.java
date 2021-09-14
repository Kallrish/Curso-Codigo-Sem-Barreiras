package projetoempresadecartaodebeneficios.Etapa02;

import java.util.ArrayList;
import java.util.List;

public class Estabelecimento {

  //Cria as variáveis necessárias para classe
  private final String identificadorEstabelecimento;
  private String nomeEstabelecimento;
  private String tipoEstabelecimento;
  private String localizacaoEstabelecimento;

  //Cria uma lista de dados inicializada com os estabelecimentos
  public static List<Estabelecimento> listaEstabelecimentos = new ArrayList<>();

  //Método para cadastrar estabelecimentos
  public Estabelecimento(String identificadorEstabelecimento,String nomeEstabelecimento,
                         String tipoEstabelecimento, String localizacaoEstabelecimento) {

    this.identificadorEstabelecimento = identificadorEstabelecimento;
    this.nomeEstabelecimento = nomeEstabelecimento;
    this.tipoEstabelecimento = tipoEstabelecimento;
    this.localizacaoEstabelecimento = localizacaoEstabelecimento;
  }

  public static void inicializaEstabelecimentos () {

    //Posto de gasolina
    listaEstabelecimentos.add(new Estabelecimento("PO01", "Posto Delta",
            "combustivel", "São Paulo/SP"));
    //Mercearia
    listaEstabelecimentos.add(new Estabelecimento("ME01", "Mercearia São José",
            "mercearia", "Blumenau/SC"));
    //Supermercado
    listaEstabelecimentos.add(new Estabelecimento("SU01", "Supermercado ABC",
            "supermercado", "Divinópolis/MG"));
    //Padaria
    listaEstabelecimentos.add(new Estabelecimento("PA01", "Padaria Sonhos",
            "padaria", "Rio de Janeiro/RJ"));
    //Restaurante
    listaEstabelecimentos.add(new Estabelecimento("RE01", "Restaurante La Marmita",
            "restaurante", "Lauro de Freitas/BA"));
  }

  public static String buscaEstabelecimento(String codigoEstabelecimento) {
    for (int i = 0; i < listaEstabelecimentos.size(); i++) {
      if (listaEstabelecimentos.get(i).getIdentificadorEstabelecimento().contains(codigoEstabelecimento)) {
        return listaEstabelecimentos.get(i).nomeEstabelecimento;
      } else {
        System.out.println("O código digitado está errado");
      }
    }
    return "";
  }

  public static String buscaLocalizacaoEstabelecimento(String codigoEstabelecimento) {
    for (int i = 0; i < listaEstabelecimentos.size(); i++) {
      if (listaEstabelecimentos.get(i).getIdentificadorEstabelecimento().contains(codigoEstabelecimento)) {
        return listaEstabelecimentos.get(i).localizacaoEstabelecimento;
      } else {
        System.out.println("O código digitado está errado");
      }
    }
    return "";
  }

  public String getIdentificadorEstabelecimento() {
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
}