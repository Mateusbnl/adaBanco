package services;

import conta.Conta;
import usuario.Usuario;

public class DebitoService {
    //TODO - criar classes ValueObject para diminuir a quantidade de parametros
    public static boolean realizarDebito(Conta contaDestino, Double valorCredito, Usuario usuarioOrigem, Usuario usuarioDestino){
        //TODO - Sera implementado um array de Validadores para garantir a consistencia do DEBITO (CONTA ATIVA, VALIDA, COM SALDO, ETC)
        contaDestino.saque(valorCredito,usuarioOrigem,usuarioDestino);
        return true;
    }
}