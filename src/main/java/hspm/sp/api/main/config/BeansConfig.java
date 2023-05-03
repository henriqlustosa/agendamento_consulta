package hspm.sp.api.main.config;

import hspm.sp.api.application.dtos.form.MedicoFormDto;
import hspm.sp.api.domain.entities.Medico;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean
    public ModelMapper modelMapper() {

        var modelMapper = new ModelMapper();
        modelMapper.createTypeMap(MedicoFormDto.class, Medico.class).addMappings(mapper -> mapper.skip(Medico::setId));
        return modelMapper;
    }
}
