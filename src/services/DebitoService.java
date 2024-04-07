package services;

import conta.Conta;
import usuario.Usuario;
import validadores.conta.ValidadorSaldo;

public class DebitoService {
    //TODO - criar classes ValueObject para diminuir a quantidade de parametros
    public static boolean realizarDebitoTransferencia(Conta contaDestino, Conta contaOrigem, Double valorDebito, Usuario usuarioOrigem, Usuario usuarioDestino){
        if(ValidadorSaldo.validaSaldo(contaOrigem.saldo(), valorDebito)){
            contaOrigem.saque(valorDebito,usuarioOrigem,usuarioDestino);
            contaDestino.deposito(valorDebito,usuarioOrigem,usuarioDestino);
            return true;
        }
        return false;
    }
}