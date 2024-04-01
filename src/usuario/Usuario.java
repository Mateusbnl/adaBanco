package usuario;
import enums.ClassificaoEnum;

import java.math.BigInteger;
import java.util.Date;

public abstract class Usuario {
    BigInteger Id;
    ClassificaoEnum Classificacao;
    String nome;
    Date dataCadastro;

}
