package med.voll.api.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.MedicoListDTO;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.service.MedicoService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @PostMapping
    public MedicoDTO saveMedico(@RequestBody @Valid MedicoDTO medicoDTO) {
        return this.medicoService.salvar(medicoDTO);
    }

    @GetMapping
    public Page<MedicoListDTO> getListMedicosPaginada(@PageableDefault(size = 10) Pageable pageable) {
        return this.medicoService.listarPaginado(pageable);
    }

}
