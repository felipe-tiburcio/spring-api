package med.voll.api.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.MedicoCreateDTO;
import med.voll.api.dto.MedicoResponseDTO;
import med.voll.api.dto.MedicoUpdateDTO;
import med.voll.api.service.MedicoService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @GetMapping
    public ResponseEntity<Page<MedicoResponseDTO>> listarMedicos(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok().body(this.medicoService.listarPaginado(pageable));
    }

    @PostMapping
    public ResponseEntity<MedicoCreateDTO> saveMedico(@RequestBody @Valid MedicoCreateDTO medicoDTO) {
        MedicoCreateDTO medicoSaved = medicoService.salvar(medicoDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(medicoSaved);
    }

    @PutMapping
    public ResponseEntity<MedicoUpdateDTO> updateMedico(@RequestBody @Valid MedicoUpdateDTO medicoDTO) {

        MedicoUpdateDTO medicoResponseDTO = this.medicoService.atualizar(medicoDTO);

        return ResponseEntity.ok(medicoResponseDTO);
    }

    @DeleteMapping("/fisico/{id}")
    public ResponseEntity<Void> deleteFisico(@PathVariable Long id) {

        this.medicoService.apagar(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/logico/{id}")
    public ResponseEntity<Void> deleteLogico(@PathVariable Long id) {

        this.medicoService.desativar(id);

        return ResponseEntity.noContent().build();
    }

}
