package hspm.sp.api.application.dtos.form;

import hspm.sp.api.domain.entities.Endereco;
import hspm.sp.api.domain.entities.Especialidade;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicoFormDto {


    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    private String crm;
    @NotBlank
    private String telefone;
    @NotNull
    private Especialidade especialidade;

    @NotNull
    @Valid
    private EnderecoFormDto endereco;

}
