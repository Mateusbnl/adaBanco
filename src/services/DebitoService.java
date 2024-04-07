package services;

import conta.Conta;
import enums.ClassificacaoEnum;
import usuario.Usuario;
import validadores.conta.ValidadorSaldo;

public class DebitoService {
    //TODO - criar classes ValueObject para diminuir a quantidade de parametros
    public static boolean realizarDebitoTransferencia(Conta contaDestino, Conta contaOrigem, Double valorDebito, Usuario usuarioOrigem, Usuario usuarioDestino){
        Double tarifa = valorDebito * usuarioOrigem.getClassificacao().getTaxaTarifaDebito();
        if(ValidadorSaldo.validaSaldo(contaOrigem.saldo(), valorDebito + tarifa)){
            contaOrigem.saque(valorDebito,usuarioOrigem,usuarioDestino,"Valor Transferencia");
            contaOrigem.saque(tarifa,usuarioOrigem,usuarioDestino,"Valor Tarifa");
            contaDestino.deposito(valorDebito,usuarioOrigem,usuarioDestino,"Credito Transferencia");
            return true;
        }
        return false;
    }

    public static boolean realizarDebitoInvestimento(Conta contaOrigem, Double valorDebito, Usuario usuarioOrigem, Usuario usuarioDestino){
        if(ValidadorSaldo.validaSaldo(contaOrigem.saldo(), valorDebito)){
            if(usuarioDestino.getContaInvestimento() == null){
                usuarioDestino.addConta(ContaService.criarContaInvestimento(2,usuarioDestino.getId()));
            }
            System.out.println(usuarioDestino.getContaInvestimento());
            contaOrigem.saque(valorDebito,usuarioOrigem,usuarioDestino,"Debito Investimento");
            usuarioDestino.getContaInvestimento().deposito(valorDebito,usuarioOrigem,usuarioDestino,"Credito Investimento");
            return true;
        }
        return false;
    }
}