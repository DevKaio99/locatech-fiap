package br.com.fiap.locatech.locatech.entities;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Pessoa {
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Pattern(regexp = "\\d{11}|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve conter 11 dígitos.")
    private String cpf;
    private String telefone;
    private String email;
}
