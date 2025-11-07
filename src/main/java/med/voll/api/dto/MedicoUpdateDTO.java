package med.voll.api.dto;

import med.voll.api.model.Medico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record MedicoUpdateDTO(
                @NotNull Long id,
                String nome,
                String telefone,

                @Valid EnderecoDTO endereco) {

        public MedicoUpdateDTO(Medico medico) {
                this(
                                medico.getId(),
                                medico.getNome(),
                                medico.getTelefone(),
                                new EnderecoDTO(medico.getEndereco()));
        }

};
