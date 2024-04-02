package usuario.impl;

import enums.ClassificaoEnum;
import usuario.Usuario;
import usuario.UsuarioBase;

import java.math.BigInteger;

public class UsuarioPJ extends UsuarioBase implements Usuario {
    public UsuarioPJ(BigInteger id, ClassificaoEnum classificacao, String nome) {
        super(id, classificacao, nome);
    }
}
