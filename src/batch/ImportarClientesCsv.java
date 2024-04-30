package batch;



import enums.ClassificacaoEnum;
import services.CreditoService;
import services.DebitoService;
import services.UsuarioService;
import usuario.Usuario;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.YEARS;

public class ImportarClientesCsv {
    final Path path = Paths.get("/home/mateusbnl/Documentos/pessoas.csv");
    final Path pathCriados = Paths.get("/home/mateusbnl/Documentos/resultado"+LocalDate.now()+".csv");
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void importarClientes() throws IOException{
        Stream<String> lines = Files.lines(path);
        List<String> clientes = lines.skip(1)
                .map(line -> line.split(","))
                .filter(line -> verificaMaiorIdade(line))
                .map(line -> UsuarioService.criarUsuario(new BigInteger(line[2]),defineClassificacao(line[3]),line[0]))
                .map(usuario -> realizarDepositoMarketing(usuario))
                .map(usuario -> {
                    return usuario.getNome()+","+usuario.getId()+","+usuario.getClassificacao().toString()+","
                    +usuario.getContas().get(0).getId()+","+usuario.getContas().get(0).saldo();
                }).toList();

        Files.write(pathCriados,clientes);
    }

    public ClassificacaoEnum defineClassificacao(String valor){
        if(valor == "1"){
            return ClassificacaoEnum.PJ;
        } else {
            return ClassificacaoEnum.PF;
        }
    }

    public boolean verificaMaiorIdade(String[] usuario){
        if(YEARS.between(LocalDate.parse(usuario[1],formatter),LocalDate.now()) < 18 && usuario[3] == "2"){
            return false;
        } else {
            return true;
        }
    }

    public Usuario realizarDepositoMarketing(Usuario usuario){
        Usuario usuarioMarketing = UsuarioService.criarUsuario(new BigInteger("99999999999999"),ClassificacaoEnum.PJ,"Conta do Marketing");
        CreditoService.realizarCredito(usuarioMarketing.getContas().get(0),99999999999.00,usuarioMarketing,usuarioMarketing,"Campanha");
        DebitoService.realizarDebitoTransferencia(usuario.getContas().get(0),usuarioMarketing.getContas().get(0),50.00,usuarioMarketing,usuario);
        return usuario;
    }
}

