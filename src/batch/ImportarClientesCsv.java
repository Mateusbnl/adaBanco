package batch;

import batch.DTO.UsuarioDTO;
import conta.Conta;
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
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.time.temporal.ChronoUnit.YEARS;

public class ImportarClientesCsv {
    final Path path = Paths.get("C:\\docs\\pessoas.csv");
    final Pattern pattern = Pattern.compile(",");
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public List<UsuarioDTO> listarClientes() throws IOException {
        List<UsuarioDTO> usuarios = new ArrayList<>();
        try (Stream<String> lines = Files.lines(path)){
            usuarios = lines.skip(1).map(line -> {
                String[] arr = pattern.split(line);
                return new UsuarioDTO(
                        arr[0],
                        LocalDate.parse(arr[1],formatter),
                        new BigInteger(arr[2]),
                        Integer.parseInt(arr[3]));
            }).toList();
        }
        return usuarios;
    }

    public List<Usuario> criarClientes(List<UsuarioDTO> usuariosDTO, Usuario usuarioMarketing) throws IOException {
        List<Usuario> listaCriados = new ArrayList<>();
        usuariosDTO.
                stream().
                forEach(n -> {
            if(n.tipo() == 2 && (YEARS.between(n.data(),LocalDate.now()) >= 18)){
                Usuario u = UsuarioService.criarUsuario(n.documento(),ClassificacaoEnum.PF,n.nome());
                DebitoService.realizarDebitoTransferencia(u.getContas().get(0),usuarioMarketing.getContas().get(0),50.00,usuarioMarketing,u);
                listaCriados.add(u);
            } else {
                Usuario u = UsuarioService.criarUsuario(n.documento(),ClassificacaoEnum.PF,n.nome());
                DebitoService.realizarDebitoTransferencia(u.getContas().get(0),usuarioMarketing.getContas().get(0),50.00,usuarioMarketing,u);
                listaCriados.add(u);
            }
        });
        return listaCriados;
    }

    public void gerarCsvContasCriadas(List<Usuario> usuariosComContas){

    }

}

