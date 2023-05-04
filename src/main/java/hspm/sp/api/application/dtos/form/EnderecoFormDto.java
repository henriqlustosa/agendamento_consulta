package hspm.sp.api.application.dtos.form;


import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoFormDto {

    @NotBlank
    private String logradouro;

    @NotBlank
    private String bairro;

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private String cep;

    private String numero;

    private String complemento;

    @NotBlank
    private String cidade;

    @NotBlank
    private String uf;
}
