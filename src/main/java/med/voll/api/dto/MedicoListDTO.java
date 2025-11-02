package med.voll.api.dto;

import med.voll.api.model.Medico;
import med.voll.api.model.enums.Especialidade;

public record MedicoListDTO(
        String nome,
        String email,
        String crm,
        Especialidade especialidade

) {
    public MedicoListDTO(Medico medico) {
        this(
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(), 
                medico.getEspecialidade()
            );
    }

}
