package usuario;

import conta.Conta;
import enums.ClassificacaoEnum;

import java.math.BigInteger;
import java.util.List;

public interface Usuario {
    void addConta(Conta conta);
    String getNome();
    List<Conta> getContas();
    Conta getContaInvestimento();
    ClassificacaoEnum getClassificacao();
    BigInteger getId();
}
