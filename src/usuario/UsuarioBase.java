package usuario;
import conta.Conta;
import enums.ClassificacaoEnum;
import enums.StatusUsuarioEnum;

import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class UsuarioBase implements Usuario {
    protected BigInteger id;
    protected ClassificacaoEnum classificacao;
    protected String nome;
    protected Date dataCadastro;
    protected List<Conta> contas;
    protected StatusUsuarioEnum statusUsuario;

    public UsuarioBase(BigInteger id, ClassificacaoEnum classificacao, String nome){
        this.id = id;
        this.classificacao = classificacao;
        this.nome = nome;
        this.dataCadastro = new Date();
        this.contas = new LinkedList<>();
        this.statusUsuario = StatusUsuarioEnum.ATIVO;
    }

    public void addConta(Conta conta){
        this.contas.add(conta);
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public ClassificacaoEnum getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassificacaoEnum classificacao) {
        this.classificacao = classificacao;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public StatusUsuarioEnum getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(StatusUsuarioEnum statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public Conta getContaInvestimento(){
        for(Conta conta : this.getContas()){
            if(conta.getClass().getCanonicalName().endsWith("ContaInvestimentoImpl"))
                return conta;
        }
        return null;
    }

}
