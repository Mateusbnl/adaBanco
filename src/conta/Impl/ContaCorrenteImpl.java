package conta.Impl;

import conta.ContaBase;
import conta.ContaCorrente;

public class ContaCorrenteImpl extends ContaBase implements ContaCorrente {
    @Override
    public boolean investimento() {
        return false;
    }
}
