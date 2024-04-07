package services;

import conta.Conta;
import conta.impl.ContaCorrenteImpl;
import conta.impl.ContaInvestimentoImpl;
import conta.impl.ContaPoupancaImpl;

import java.math.BigInteger;

public class ContaService {
    //TODO - id provisorio para retirarda em proximas evolucoes
    public static Conta criarContaCorrente(int id, BigInteger idUsuario){
        return new ContaCorrenteImpl(id,idUsuario);
    }

    public static Conta criarContaPoupanca(int id, BigInteger idUsuario){
        return new ContaPoupancaImpl(id,idUsuario);
    }

    public static Conta criarContaInvestimento(int id, BigInteger idUsuario){ return new ContaInvestimentoImpl(id,idUsuario); }

    public static Double consultaSaldo(Conta conta){
        return conta.saldo();
    }
}
