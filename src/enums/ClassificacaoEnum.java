package enums;

public enum ClassificacaoEnum {
    PF("Pessoa Fisica",0.00,1.00),
    PJ("Pessoa Juridica", 0.05,2.00);

    double taxaTarifaDebito;
    double taxaRendimento;
    ClassificacaoEnum(String tipoDePessoa, double taxaTarifaDebito, double taxaRendimento) {
        this.taxaTarifaDebito = taxaTarifaDebito;
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaTarifaDebito(){
        return this.taxaTarifaDebito;
    }
   public double taxaRendimento(){
        return this.taxaRendimento;
    }

}
