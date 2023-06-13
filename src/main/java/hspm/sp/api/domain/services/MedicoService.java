package hspm.sp.api.domain.services;

import hspm.sp.api.application.dtos.form.MedicoFormDto;
import hspm.sp.api.application.dtos.request.MedicoResponseDto;
import hspm.sp.api.domain.entities.Medico;
import hspm.sp.api.domain.exceptions.DomainException;
import hspm.sp.api.infra.repositories.MedicoRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    @Transactional(readOnly = true)
    public Page<MedicoResponseDto> listar(Pageable paginacao) {
        var medicos = medicoRepository.findAllByAtivoTrue(paginacao);

        return medicos.map(t -> modelMapper.map(t, MedicoResponseDto.class));
    }
}
