package hspm.sp.api.application.dtos.request;

import hspm.sp.api.application.dtos.form.EnderecoFormDto;
import hspm.sp.api.domain.entities.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicoResponseDto {


    private Long id;
    private String nome;
    private String email;
    private String crm;


    private Especialidade especialidade;


    private EnderecoFormDto endereco;




}
