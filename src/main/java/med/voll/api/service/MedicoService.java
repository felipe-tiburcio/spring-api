package med.voll.api.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import med.voll.api.dto.MedicoListDTO;
import med.voll.api.dto.MedicoDTO;
import med.voll.api.model.Medico;
import med.voll.api.repository.MedicoRepository;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Transactional
    public MedicoDTO salvar(MedicoDTO medicoDTO) {
        Medico medicoSaved = this.medicoRepository.save(new Medico(medicoDTO));
        return new MedicoDTO(medicoSaved);
    }

    public Page<MedicoListDTO> listarPaginado(Pageable pageable) {
        return this.medicoRepository
                .findAll(pageable)
                .map(MedicoListDTO::new);
    }

}
