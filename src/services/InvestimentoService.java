package services;

import conta.impl.ContaInvestimentoImpl;
import usuario.Usuario;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InvestimentoService {
    public static void gerarRendimento(List<Usuario> usuarios){
        for(Usuario usuario : usuarios){
            if(usuario.getContaInvestimento() != null){
                int tam = usuario.getContaInvestimento().getHistoricoDeAcoes().size();
                long diffEmMiliSegundos = Math.abs(new Date().getTime() - usuario.getContaInvestimento().getHistoricoDeAcoes().get(tam-1).data().getTime());
                long diff = TimeUnit.DAYS.convert(diffEmMiliSegundos, TimeUnit.MILLISECONDS);

                //Periodo para verificar por dia, normalmente utilizasse 30 dias, mas para testes, setei como 0 dias)
                if(diff >= 0 && diff <=1){
                    CreditoService.realizarCredito(usuario.getContaInvestimento(), usuario.getContaInvestimento().saldo() * usuario.getClassificacao().taxaRendimento(),usuario,usuario,"Rendimentos");
                };
            }
        }
    }

}
