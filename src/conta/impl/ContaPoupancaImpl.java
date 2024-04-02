package conta.impl;

import conta.Conta;
import conta.ContaBase;

import java.math.BigInteger;

public class ContaPoupancaImpl extends ContaBase implements Conta {

    public ContaPoupancaImpl(int id, BigInteger idUsuario) {
        super(id, idUsuario);
    }
}
