package services;

import conta.Conta;
import enums.ClassificacaoEnum;
import usuario.Usuario;
import usuario.impl.UsuarioPF;
import usuario.impl.UsuarioPJ;

import java.math.BigInteger;
import java.util.Random;

public class UsuarioService {
    //TODO - retirar id, provisorio para testes e na proxima evolucao retirar
    //TODO - TALVEZ criar factory para criacao de Usuarios
    public static Usuario criarUsuario(BigInteger idUsuario, ClassificacaoEnum classificacao, String nome){
        Usuario novoUsuario;
        Conta contaCorrente;
        Random random = new Random();

        if(classificacao.equals(ClassificacaoEnum.PF)){
            contaCorrente = ContaService.criarContaCorrente(random.nextInt(),idUsuario);
            novoUsuario = new UsuarioPF(idUsuario,classificacao,nome);
            novoUsuario.addConta(contaCorrente);
            return novoUsuario;
        }
        if(classificacao.equals(ClassificacaoEnum.PJ)){
            contaCorrente = ContaService.criarContaCorrente(random.nextInt(),idUsuario);
            novoUsuario = new UsuarioPJ(idUsuario,classificacao,nome);
            novoUsuario.addConta(contaCorrente);
            return novoUsuario;
        }
        return null;
    }

    public static Conta retornaContaDeUsuarioPorId(Usuario usuario, int idConta){
        for(Conta conta: usuario.getContas()){
            if(conta.getId() == idConta){
                return conta;
            }
        };
        return null;
    }
}
