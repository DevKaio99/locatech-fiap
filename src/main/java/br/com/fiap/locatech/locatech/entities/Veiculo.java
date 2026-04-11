package br.com.fiap.locatech.locatech.entities;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Veiculo {
    private Long id;
    @NotBlank(message = "Campo obrigatório")
    private String marca;
    @NotBlank(message = "Campo obrigatório")
    private String modelo;
    @NotBlank(message = "Campo obrigatório")
    private String placa;
    private int ano;
    private String cor;
    @Digits(integer = 10, fraction = 2, message = "Valor inválido (ex: 199.90)")
    @DecimalMin(value = "0.01", message = "Valor deve ser maior que zero")
    private BigDecimal valorDiaria;
}


