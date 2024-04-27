import batch.ImportarClientesCsv;
import batch.DTO.UsuarioDTO;
import enums.ClassificacaoEnum;
import services.CreditoService;
import services.DebitoService;
import services.InvestimentoService;
import services.UsuarioService;
import usuario.Usuario;

import java.io.IOException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        testarImportacao();
    }

    static void testarImportacao(){
        ImportarClientesCsv novaImportacao = new ImportarClientesCsv();
        try {
            List<UsuarioDTO> listaDTO = novaImportacao.listarClientes();
            List<Usuario> usuariosCriados = novaImportacao.criarClientes(listaDTO);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void teste1(){
        //Cria usuario e Conta Corrente conforme regra de negocio
        Usuario usuario = UsuarioService.criarUsuario(BigInteger.valueOf(81970418000120L), ClassificacaoEnum.PJ,"Mateus LTDA");
        Usuario usuario2 = UsuarioService.criarUsuario(BigInteger.valueOf(12345678911L), ClassificacaoEnum.PF,"Marcio Greyck");

        //Checa saldo da Conta Criada para o novo usuario
        System.out.println("Saldo da nova Conta do novo Usuario: "+ UsuarioService.retornaContaDeUsuarioPorId(usuario,1).saldo());

        //Realiza deposito na conta do usuario
        CreditoService.realizarCredito(UsuarioService.retornaContaDeUsuarioPorId(usuario,1),1000.00,usuario,usuario,"Deposito");
        CreditoService.realizarCredito(UsuarioService.retornaContaDeUsuarioPorId(usuario,1),2000.00,usuario2,usuario,"Deposito");

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

        //Realizar Investimentos
        DebitoService.realizarDebitoInvestimento(UsuarioService.retornaContaDeUsuarioPorId(usuario,1),1000.00,usuario,usuario);
        DebitoService.realizarDebitoInvestimento(UsuarioService.retornaContaDeUsuarioPorId(usuario2,1),1000.00,usuario2,usuario2);

        //Extratos Conta Investimento
        System.out.println("Saldo da nova Conta de Investimento do  "+ usuario.getNome() + ": "+ UsuarioService.retornaContaDeUsuarioPorId(usuario,2).getHistoricoDeAcoes());
        System.out.println("Saldo da nova Conta de Investimento do "+ usuario2.getNome() + ": "+ UsuarioService.retornaContaDeUsuarioPorId(usuario2,2).getHistoricoDeAcoes());

        //Gerar Rendimentos
        List<Usuario> listaUsuarios = new LinkedList<Usuario>();
        listaUsuarios.add(usuario);
        listaUsuarios.add(usuario2);
        InvestimentoService.gerarRendimento(listaUsuarios);

        //Saldos Conta Investimento
        System.out.println("Saldo da nova Conta do "+ usuario.getNome() + ": "+ UsuarioService.retornaContaDeUsuarioPorId(usuario,2).saldo());
        System.out.println("Saldo da nova Conta do "+ usuario2.getNome() + ": "+ UsuarioService.retornaContaDeUsuarioPorId(usuario2,2).saldo());
    }
}

