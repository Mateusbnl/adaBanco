package conta;

import usuario.Usuario;

public interface Conta {
    void saque(Double valorSaque, Usuario usuarioOrigem, Usuario usuarioDestino);
    void deposito(Double valorDeposito, Usuario usuarioOrigem, Usuario usuarioDestino);
    void transferir(Double valorTransferencia, Usuario usuarioOrigem, Usuario usuarioDestino);
    double saldo();
    int getId();
}
