package projetoempresadecartaodebeneficios.Etapa02;

//Importa bibliotecas
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

public abstract class CartaoDeBeneficio {

  //Crias as variáveis necessárias para classe
  public Integer identificadorCartao;
  public String nomeBeneficiario;
  public String senhaCartao;
  public Double saldoCartao;
  public LocalDate dataDoCadastro;
  public LocalDate validadeCartao;
  public static int index =0;
}