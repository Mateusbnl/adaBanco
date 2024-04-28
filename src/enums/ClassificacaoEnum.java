package enums;

public enum ClassificacaoEnum {
    PF("Pessoa Fisica",0.00,0.01),
    PJ("Pessoa Juridica", 0.05,0.02);

    double taxaTarifaDebito;
    double taxaRendimento;
    ClassificacaoEnum(String tipoDePessoa, double taxaTarifaDebito, double taxaRendimento) {
        this.taxaTarifaDebito = taxaTarifaDebito;
        this.taxaRendimento = taxaRendimento;
    }

    public double taxaRendimento(){
        return this.taxaRendimento;
    }

    public double getTaxaTarifaDebito(){
        return this.taxaTarifaDebito;
    }


}
