package conta;

import usuario.Usuario;

public interface ContaCorrente extends Conta{

    void investimento(Double valor, Usuario usuarioOrigem, Usuario usuarioDestino);
}
