package conta.impl;

import conta.ContaBase;
import conta.ContaCorrente;
import conta.records.Acao;
import usuario.Usuario;

import java.math.BigInteger;
import java.util.Date;

public class ContaCorrenteImpl extends ContaBase implements ContaCorrente {
    public ContaCorrenteImpl(int id, BigInteger idUsuario) {
        super(id, idUsuario);
    }

    @Override
    public void investimento(Double valorInvestimento, Usuario usuarioOrigem, Usuario usuarioDestino) {
        historicoDeAcoes.add(new Acao(new Date(),'D',valorInvestimento,valorInvestimento,usuarioOrigem,usuarioDestino,"Debito para Investimento"));
    }
}
