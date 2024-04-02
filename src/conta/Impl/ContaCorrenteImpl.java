package conta.Impl;

import conta.ContaBase;
import conta.ContaCorrente;
import conta.records.Acao;
import usuario.Usuario;

import java.util.Date;

public class ContaCorrenteImpl extends ContaBase implements ContaCorrente {
    @Override
    public void investimento(Double valorInvestimento, Usuario usuarioOrigem, Usuario usuarioDestino) {
        historicoDeAcoes.add(new Acao(new Date(),'D',valorInvestimento,valorInvestimento,usuarioOrigem,usuarioDestino,"Debito para Investimento"));
    }
}
