package med.voll.api.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.MedicoListDTO;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.service.MedicoService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<MedicoDTO> saveMedico(@RequestBody @Valid MedicoDTO medicoDTO) {
        MedicoDTO medicoSaved = medicoService.salvar(medicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoSaved);
    }

    @GetMapping
    public ResponseEntity<Page<MedicoListDTO>> listarMedicos(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok().body(this.medicoService.listarPaginado(pageable));
    }

}
