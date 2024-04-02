package conta.impl;

import conta.Conta;
import conta.ContaBase;

import java.math.BigInteger;

public class ContaInvestimentoImpl extends ContaBase implements Conta {

    public ContaInvestimentoImpl(int id, BigInteger idUsuario) {
        super(id, idUsuario);
    }
}
