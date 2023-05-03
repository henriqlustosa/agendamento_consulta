package hspm.sp.api.domain.services;

import hspm.sp.api.application.dtos.form.MedicoFormDto;
import hspm.sp.api.application.dtos.request.MedicoResponseDto;
import hspm.sp.api.domain.entities.Medico;
import hspm.sp.api.domain.exceptions.DomainException;
import hspm.sp.api.infra.repositories.MedicoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
@Service
@RequiredArgsConstructor

public class MedicoService {
    private final MedicoRepository medicoRepository;

    private final ModelMapper modelMapper;

    @Transactional
    public MedicoResponseDto create(MedicoFormDto medicoFormDto) {
        try {
            var medico = modelMapper.map(medicoFormDto, Medico.class);

            medicoRepository.save(medico);

            return modelMapper.map(medico, MedicoResponseDto.class);
        } catch (DataIntegrityViolationException e) {
            throw new DomainException("Autor inválido");
        }
    }
}
