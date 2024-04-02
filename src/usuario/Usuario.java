package usuario;
import conta.Conta;
import enums.ClassificaoEnum;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public abstract class Usuario {
    BigInteger Id;
    ClassificaoEnum Classificacao;
    String nome;
    Date dataCadastro;
    List<Conta> contas;

}
