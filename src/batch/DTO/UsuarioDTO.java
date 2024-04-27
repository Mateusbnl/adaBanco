package batch.DTO;

import java.math.BigInteger;
import java.time.LocalDate;

public record UsuarioDTO(String nome, LocalDate data, BigInteger documento, int tipo){}
