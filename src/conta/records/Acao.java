package conta.records;

import usuario.Usuario;
import java.util.Date;

public record Acao(Date data, Character tipo, Double valorPretendido, Double valorReal, Usuario usuarioOrigem, Usuario usuarioDestine, String observacao) {
}
