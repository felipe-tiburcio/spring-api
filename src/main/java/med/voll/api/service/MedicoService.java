package med.voll.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<MedicoDTO> listar() {
        return this.medicoRepository
                .findAll()
                .stream()
                .map(MedicoDTO::new)
                .collect(Collectors.toList());
    }

}
