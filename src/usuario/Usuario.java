package usuario;

import conta.Conta;

import java.util.List;

public interface Usuario {
    void addConta(Conta conta);
    String getNome();
    List<Conta> getContas();
}
