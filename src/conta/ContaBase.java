package conta;

import conta.records.Acao;
import enums.StatusContaEnum;


import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public abstract class ContaBase implements Conta {
    int Id;
    List<Acao> historicoDeAcoes;
    Date dataDeAtuailizacao;
    StatusContaEnum statusConta;
    BigInteger idUsuario;

    public boolean saque() {
        return false;
    }

    public boolean deposito() {
        return false;
    }

    public boolean transferir() {
        return false;
    }
}
