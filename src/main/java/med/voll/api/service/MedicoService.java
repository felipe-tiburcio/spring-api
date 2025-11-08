package med.voll.api.service;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import med.voll.api.dto.MedicoUpdateDTO;
import med.voll.api.exception.MedicoNotFoundException;
import med.voll.api.dto.MedicoCreateDTO;
import med.voll.api.dto.MedicoResponseDTO;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    private Medico getById(Long id) {
        return this.medicoRepository.findById(id).orElseThrow(
                () -> new MedicoNotFoundException("Médico de id " + id + " não foi localizado."));
    }

    public Page<MedicoResponseDTO> listarPaginado(Pageable pageable) {
        return this.medicoRepository
                .findByIsActiveTrue(pageable)
                .map(MedicoResponseDTO::new);
    }

    @Transactional
    public MedicoCreateDTO salvar(MedicoCreateDTO medicoDTO) {
        Medico medicoSaved = this.medicoRepository.save(new Medico(medicoDTO));
        return new MedicoCreateDTO(medicoSaved);
    }

    @Transactional
    public MedicoUpdateDTO atualizar(MedicoUpdateDTO medicoDTO) {
        Medico medicoSelected = this.getById(medicoDTO.id());

        medicoSelected.atualizarDados(medicoDTO);

        this.medicoRepository.save(medicoSelected);

        return new MedicoUpdateDTO(medicoSelected);

    }

    @Transactional
    public void apagar(Long id) {
        Medico medicoSelected = this.getById(id);

        this.medicoRepository.deleteById(medicoSelected.getId());
    }

    @Transactional
    public void desativar(Long id) {
        Medico medicoSelected = this.getById(id);

        medicoSelected.desativar();

        medicoRepository.save(medicoSelected);
    }

    @Transactional
    public void reativar(Long id) {
        Medico medicoSelected = this.getById(id);

        medicoSelected.reativar();

        medicoRepository.save(medicoSelected);
    }

}
