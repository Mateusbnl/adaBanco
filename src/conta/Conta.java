package conta;

import conta.records.Acao;
import usuario.Usuario;

import java.util.List;

public interface Conta {
    void saque(Double valorSaque, Usuario usuarioOrigem, Usuario usuarioDestino, String obs);
    void deposito(Double valorDeposito, Usuario usuarioOrigem, Usuario usuarioDestino, String obs);
    void transferir(Double valorTransferencia, Usuario usuarioOrigem, Usuario usuarioDestino);

    List<Acao> getHistoricoDeAcoes();
    double saldo();
    int getId();
}
