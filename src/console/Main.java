package console;

import enums.ClassificacaoEnum;
import services.CreditoService;
import services.DebitoService;
import services.UsuarioService;
import usuario.Usuario;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args){
        //Cria usuario e Conta Corrente conforme regra de negocio
        Usuario usuario = UsuarioService.criarUsuario(BigInteger.valueOf(6081970418L), ClassificacaoEnum.PJ,"Mateus Lucena");
        Usuario usuario2 = UsuarioService.criarUsuario(BigInteger.valueOf(12345678911L), ClassificacaoEnum.PF,"Marcio Greyck");

        //Checa saldo da Conta Criada para o novo usuario
        System.out.println("Saldo da nova Conta do novo Usuario: "+ UsuarioService.retornaContaDeUsuarioPorId(usuario,1).saldo());

        //Realiza deposito na conta do usuario
        CreditoService.realizarCredito(UsuarioService.retornaContaDeUsuarioPorId(usuario,1),1000.00,usuario,usuario);
        CreditoService.realizarCredito(UsuarioService.retornaContaDeUsuarioPorId(usuario,1),2000.00,usuario2,usuario);

        //Checa Novo saldo
        System.out.println("Saldo da nova Conta do "+ usuario.getNome() + ": "+ UsuarioService.retornaContaDeUsuarioPorId(usuario,1).saldo());
        System.out.println("Saldo da nova Conta do "+ usuario2.getNome() + ": "+ UsuarioService.retornaContaDeUsuarioPorId(usuario2,1).saldo());

        //Tenta realizar transferencia maior do que Saldo
        System.out.println(DebitoService.realizarDebitoTransferencia(usuario2.getContas().get(0),usuario.getContas().get(0), 3500.00,usuario,usuario2));

        //Tenta realizar transferencia menor do que Saldo
        System.out.println(DebitoService.realizarDebitoTransferencia(usuario2.getContas().get(0),usuario.getContas().get(0), 1500.00,usuario,usuario2));

        //Checa Novo saldo
        System.out.println("Saldo da nova Conta do "+ usuario.getNome() + ": "+ UsuarioService.retornaContaDeUsuarioPorId(usuario,1).saldo());
        System.out.println("Saldo da nova Conta do "+ usuario2.getNome() + ": "+ UsuarioService.retornaContaDeUsuarioPorId(usuario2,1).saldo());

        //Extratos
        System.out.println("Saldo da nova Conta do "+ usuario.getNome() + ": "+ UsuarioService.retornaContaDeUsuarioPorId(usuario,1).getHistoricoDeAcoes());
        System.out.println("Saldo da nova Conta do "+ usuario2.getNome() + ": "+ UsuarioService.retornaContaDeUsuarioPorId(usuario2,1).getHistoricoDeAcoes());


        System.out.println("executando codigo"); }
}
