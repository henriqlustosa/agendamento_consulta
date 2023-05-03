package hspm.sp.api.application.dtos.form;

import hspm.sp.api.domain.entities.Endereco;
import hspm.sp.api.domain.entities.Especialidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicoFormDto {


    private String nome;
    private String email;
    private String crm;


    private Especialidade especialidade;


    private Endereco endereco;

}
