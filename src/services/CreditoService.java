package services;

import conta.Conta;
import usuario.Usuario;

public class CreditoService {
    //TODO - criar classes ValueObject para diminuir a quantidade de parametros
    public static void realizarCredito(Conta contaDestino, Double valorCredito, Usuario usuarioOrigem, Usuario usuarioDestino){
        //TODO - Sera implementado um array de Validadores para garantir a consistencia do deposito (CONTA ATIVA, VALIDA, ETC)
        contaDestino.deposito(valorCredito,usuarioOrigem,usuarioDestino);
    }
}
