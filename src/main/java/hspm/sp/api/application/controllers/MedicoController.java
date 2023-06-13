package hspm.sp.api.application.controllers;

import hspm.sp.api.application.dtos.form.MedicoFormDto;
import hspm.sp.api.application.dtos.request.MedicoResponseDto;
import hspm.sp.api.domain.services.MedicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("medicos")
@RequiredArgsConstructor
public class MedicoController {

    private final MedicoService medicoService;


    @Transactional
    @PostMapping
    public ResponseEntity<MedicoResponseDto> create(@RequestBody @Valid MedicoFormDto medicoFormDto,
                                                    UriComponentsBuilder uriComponentsBuilder) {
        MedicoResponseDto medico = medicoService.create(medicoFormDto);

        URI location = uriComponentsBuilder.path("/medico/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(location).body(medico);
    }
    @GetMapping
    public Page<MedicoResponseDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return medicoService.listar(paginacao);
    }

}
