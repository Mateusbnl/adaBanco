package usuario.impl;

import enums.ClassificaoEnum;
import usuario.Usuario;
import usuario.UsuarioBase;

import java.math.BigInteger;

public class UsuarioPF extends UsuarioBase implements Usuario {
    public UsuarioPF(BigInteger id, ClassificaoEnum classificacao, String nome) {
        super(id, classificacao, nome);
    }
}
