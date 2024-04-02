package conta;

import conta.records.Acao;
import enums.StatusContaEnum;
import usuario.Usuario;


import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class ContaBase implements Conta {
    private int id;
    protected List<Acao> historicoDeAcoes;
    private Date dataDeAtualizacao;
    private StatusContaEnum statusConta;
    private BigInteger idUsuario;

    public ContaBase(int id, BigInteger idUsuario){
        this.id= id;
        this.historicoDeAcoes = new LinkedList<>();
        this.dataDeAtualizacao = new Date();
        this.statusConta = StatusContaEnum.ATIVA;
        this.idUsuario = idUsuario;
    }

    public void saque(Double valorSaque, Usuario usuarioOrigem, Usuario usuarioDestino) {
        historicoDeAcoes.add(new Acao(new Date(),'D',valorSaque,valorSaque,usuarioOrigem,usuarioDestino,"Saque"));
    }

    public void deposito(Double valorSaque, Usuario usuarioOrigem, Usuario usuarioDestino) {
        historicoDeAcoes.add(new Acao(new Date(),'C',valorSaque,valorSaque,usuarioOrigem,usuarioDestino,"Deposito"));
    }

    public void transferir(Double valorSaque, Usuario usuarioOrigem, Usuario usuarioDestino) {
        historicoDeAcoes.add(new Acao(new Date(),'D',valorSaque,valorSaque,usuarioOrigem,usuarioDestino,"Debito para Transferencia"));
    }

    public Double saldo(){
        //TODO - verificar melhor maneira para realizar de forma mais performatica
        Double saldo = 0.0;
        for(Acao acao : historicoDeAcoes){
            if(acao.tipo().equals('C'))
                saldo += acao.valorReal();
            if(acao.tipo().equals('D'))
                saldo -= acao.valorReal();
        }

        return saldo;
    }
}
