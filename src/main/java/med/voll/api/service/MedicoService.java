package med.voll.api.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import med.voll.api.dto.MedicoUpdateDTO;
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

    @Transactional
    public MedicoCreateDTO salvar(MedicoCreateDTO medicoDTO) {
        Medico medicoSaved = this.medicoRepository.save(new Medico(medicoDTO));
        return new MedicoCreateDTO(medicoSaved);
    }

    public Page<MedicoResponseDTO> listarPaginado(Pageable pageable) {
        return this.medicoRepository
                .findAll(pageable)
                .map(MedicoResponseDTO::new);
    }

    @Transactional
    public MedicoUpdateDTO atualizar(MedicoUpdateDTO medicoDTO) {
        Medico medicoSelected = this.medicoRepository.getReferenceById(medicoDTO.id());

        medicoSelected.atualizarDados(medicoDTO);

        this.medicoRepository.save(medicoSelected);

        return new MedicoUpdateDTO(medicoSelected);

    }

}
