package services;

import enums.ClassificaoEnum;
import usuario.Usuario;
import usuario.impl.UsuarioPF;
import usuario.impl.UsuarioPJ;

import java.math.BigInteger;

public class UsuarioService {
    //TODO - retirar id, provisorio para testes e na proxima evolucao retirar
    //TODO - TALVEZ criar factory para criacao de Usuarios
    static Usuario criarUsuarioPF(BigInteger idUsuario, ClassificaoEnum classificacao, String nome){
        return new UsuarioPF(idUsuario,classificacao,nome);
    }

    static Usuario criarUsuarioPJ(BigInteger idUsuario, ClassificaoEnum classificacao, String nome){
        return new UsuarioPJ(idUsuario,classificacao,nome);
    }
}
