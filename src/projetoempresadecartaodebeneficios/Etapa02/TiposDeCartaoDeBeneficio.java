package projetoempresadecartaodebeneficios.Etapa02;

public enum TiposDeCartaoDeBeneficio {

  VA {
    @Override
    public ICartaoDeBeneficio fabricar() {
      return new ValeAlimentacao();
    }
  },
  VR {
    @Override
    public ICartaoDeBeneficio fabricar() {
      return new ValeRefeicao();
    }
  },
  VT {
    @Override
    public ICartaoDeBeneficio fabricar() {
      return new ValeTransporte();
    }
  };

  abstract ICartaoDeBeneficio fabricar();

}
