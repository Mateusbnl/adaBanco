package usuario;
import conta.Conta;
import enums.ClassificaoEnum;
import enums.StatusUsuarioEnum;

import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public abstract class UsuarioBase implements Usuario {
    BigInteger id;
    ClassificaoEnum classificacao;
    String nome;
    Date dataCadastro;
    List<Conta> contas;
    StatusUsuarioEnum statusUsuario;

    public UsuarioBase(BigInteger id, ClassificaoEnum classificacao, String nome){
        this.id = id;
        this.classificacao = classificacao;
        this.nome = nome;
        this.dataCadastro = new Date();
        this.contas = new LinkedList<>();
        this.statusUsuario = StatusUsuarioEnum.ATIVO;
    }

}
